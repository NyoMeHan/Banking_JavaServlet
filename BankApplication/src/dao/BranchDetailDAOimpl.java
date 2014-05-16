package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import connection.ConnectionManager;

import dto.BranchDetails;
import exception.NotFoundException;

public class BranchDetailDAOimpl implements BranchDetailDAO{
	//Created by ZarniMMM
	Statement st;
	
	public List<BranchDetails> getBranchinfo() throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		List<BranchDetails> list = new ArrayList<BranchDetails>();
		
		String sql = "select BranchDetail_ID,BranchName from Branch_Details";
		st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			BranchDetails branch = new BranchDetails(rs.getInt("BranchDetail_ID"),rs.getString("BranchName"));
			list.add(branch);
			
		}
		
		return list;
		
	}
	//Ended by ZarniMMM
	
	@Override
	public String getBranchNameByBranchId(int branchId) {
		Connection con = ConnectionManager.getConnection();
		String branchName = null;
		try{
			Statement st = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select BranchName from branch_details where branchdetail_id = ?");
			ps.setInt(1, branchId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				branchName = rs.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return branchName;
	}

	@Override
	public String authenticate(BranchDetails branchdetails) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveBranchDetails(BranchDetails b)
			throws SQLException {
		String sql = "" ,result= "";
		PreparedStatement pstmt = null;
		Connection conn = ConnectionManager.getConnection();
	
       try{
			sql = "INSERT INTO branch_details (BranchName,"
		             + " Address,PhoneNumber,Email,Created_By,Created_On)"
		             + " VALUES (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getBranchName()); 
            pstmt.setString(2, b.getAddress()); 
            pstmt.setInt(3, b.getPhone()); 
            pstmt.setString(4, b.getEmail());      
            pstmt.setString(5, b.getCreatedBy()); 
            pstmt.setDate(6,(Date) b.getCreatedOn());


			pstmt.executeUpdate();
			result = "Save";
			

		} finally {
			if (pstmt != null)
				pstmt.close();
		}
       return result;
	}

	@Override
	public String updateBranchDetails(BranchDetails b)
			throws SQLException {

		Connection conn = ConnectionManager.getConnection();
	
		PreparedStatement stmt=null;
		
		String sql= "UPDATE branch_details SET BranchName = ?, Address = ?, PhoneNumber = ?, "
                 + "Email = ? "
                 + "WHERE (BranchDetail_ID = ? ) ";
		try{
			 stmt = (PreparedStatement) conn.prepareStatement(sql);
			 stmt.setString(1, b.getBranchName()); 
             stmt.setString(2, b.getAddress()); 
             stmt.setInt(3, b.getPhone()); 
             stmt.setString(4, b.getEmail());      
             stmt.setInt(5, b.getId());

             
		stmt.executeUpdate();
		
	   
		
	} finally {
		if (stmt != null)
			stmt.close();
	}
			
		
		return "success";
	}

	@Override
	public String deleteBranchDetails(BranchDetails br)
			throws SQLException, Exception {

		String sql = "DELETE FROM branch_details WHERE (BranchDetail_ID = ?) ";
		PreparedStatement stmt = null;
		Connection conn = ConnectionManager.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, br.getId());

			int rowcount = databaseUpdate(stmt);

			
		} finally {
			if (stmt != null)
				stmt.close();
		}
		return "delete";
	
	}

	@Override
	public ArrayList<BranchDetails> getAllBranchDetails() throws SQLException {
		ArrayList<BranchDetails> list = new ArrayList<BranchDetails>();
		Connection conn = ConnectionManager.getConnection();

		st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from branch_details;");
		while (rs.next()) 
		 {
			    BranchDetails branchdetails = new BranchDetails();
				//branchdetails.setBranchDetail_ID(rs.getInt(1));
				branchdetails.setId(rs.getInt(1));
				branchdetails.setBranchName(rs.getString(2));
				branchdetails.setAddress(rs.getString(3));
				branchdetails.setPhone(rs.getInt(4));
				branchdetails.setEmail(rs.getString(5));
				branchdetails.setCreatedBy(rs.getString(6));
				branchdetails.setCreatedOn(rs.getDate(7));
			
			list.add(branchdetails);
		}
				 	
		return list;
	}
	
	public BranchDetails getBranchDetailsByID(int bid) throws SQLException {
		BranchDetails b = new BranchDetails();	
		Connection conn = ConnectionManager.getConnection();	
		try{
			
				PreparedStatement pst=null;
				ResultSet rs=null;
				String sql="SELECT * FROM branch_details WHERE BranchDetail_ID=?";
				pst = (PreparedStatement) conn.prepareStatement(sql);
				pst.setInt(1, bid);
				rs=pst.executeQuery();
			
			if(rs.next()){
				b.setId(rs.getInt(1));
				//b.setBranchDetails_ID(rs.getInt(1));
				b.setBranchName(rs.getString(2));
				b.setAddress(rs.getString(3));
				b.setPhone(rs.getInt(4));
				b.setEmail(rs.getString(5));
				b.setCreatedBy(rs.getString(6));
				b.setCreatedOn(rs.getDate(7));
			}
			
				}			
				
		catch(Exception e){
		e.printStackTrace();
		}
			return b;
			
		
		}
	protected int databaseUpdate(PreparedStatement stmt)
			throws SQLException {
		    int result = stmt.executeUpdate();
		    return result;
	}
}
