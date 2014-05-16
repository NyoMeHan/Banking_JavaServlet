package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManager;

import dto.AccountNumberIdPair;
import dto.CurrentUser;
import dto.Customer;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public CurrentUser authenticate(CurrentUser cUser,String userType) {
		Connection con = ConnectionManager.getConnection();
	
		String query = null;
		if(userType.equals("customer")){
			query = "select * from customer where loginname =? and password =?";
		}
		else query = "select * from banker where username =? and password =?";
		
		CurrentUser currentUser = null;
		try{
		PreparedStatement ps = con.prepareStatement(query);
	ps.setString(1, cUser.getUsername());
		ps.setString(2, cUser.getPassword());
		ResultSet rs = ps.executeQuery();
		
		
		if(rs!=null){
		while(rs.next()){
			currentUser = new CurrentUser();
			currentUser.setId(rs.getInt(1));
			if(userType.equals("customer")){
			currentUser.setFirstName(rs.getString(2));
			currentUser.setLastName(rs.getString(3));
			currentUser.setUsername(rs.getString(11));
			}
			else{
				currentUser.setFirstName(rs.getString(2));
				currentUser.setLastName(rs.getString(3));
				currentUser.setUsername(rs.getString(6));
			}
			currentUser.setUserType(userType);
		}
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return currentUser;
	}

	@Override
	public String saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Customer getCustomerByAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCustomerAccountNumber(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deposit(double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String withdraw(double amount, String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AccountNumberIdPair> getAllAccountInfo(int customerId) {
		Connection con = ConnectionManager.getConnection();
		ArrayList<AccountNumberIdPair> accountIdPairs = new ArrayList<AccountNumberIdPair>();
		try{
		PreparedStatement ps = con.prepareStatement("select * from customer_bankaccount where customerid = ?");
		ps.setInt(1, customerId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			AccountNumberIdPair accountNumberIdPair = new AccountNumberIdPair();
			accountNumberIdPair.setId(rs.getInt(1));
			System.out.println("check DAO:"+rs.getString(6));
			accountNumberIdPair.setAccountNumber(rs.getString(6));
			accountIdPairs.add(accountNumberIdPair);			
		}	
		}catch(Exception e){
			e.printStackTrace();
		}
		return accountIdPairs;
	}//getAllAccountInfo
	
	//Created by ZarniMMM
		
		Statement st;
		
		public List<Customer> getCustLoginName() throws SQLException {
			Connection conn = ConnectionManager.getConnection();
			List<Customer> list = new ArrayList<Customer>();
			
			String sql = "select CustomerID,LoginName from Customer";
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Customer cus = new Customer(rs.getInt("CustomerID"),rs.getString("LoginName"));
				list.add(cus);
				
			}
			
			return list;
			
		}
		//Ended by ZarniMMM
		
		@Override
		public ArrayList<Customer> getAllCustomers() throws SQLException   {
			ArrayList<Customer> list = new ArrayList<Customer>();
			Connection conn = ConnectionManager.getConnection();

			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from customer;");
			while (rs.next()) {
			
				Customer customer = new Customer();
				customer.setCustomerID(rs.getInt(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setPassport(rs.getString(4));
				customer.setNationality(rs.getString(5));
				customer.setGender(rs.getString(6));
				customer.setPhone(rs.getInt(8));
				
				list.add(customer);
			}
		
			return list;
		}
		
		public Customer getCustomerByID(int cid) throws SQLException {
			//System.out.println("check point 2");
		Customer c = new Customer();
	try{
		Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String sql="select * from customer where CustomerID = ?" ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cid);
			//System.out.println("check point 1");
			rs=pstmt.executeQuery();
			
		    //System.out.println("check point 2");
			//System.out.println("check point 3"+rs.toString());	
			
			if(rs.next()){
			
				 c.setCustomerID(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setPassport(rs.getString(4));
				c.setNationality(rs.getString(5));
				c.setGender(rs.getString(6));
				c.setDob(rs.getDate(7));
				c.setPhone(rs.getInt(8));
	            c.setEmail(rs.getString(9));
	            c.setAddress(rs.getString(10));
				c.setLoginName(rs.getString(11));
				c.setPassword(rs.getString(12));
				c.setCreated_By(rs.getString(13));
				c.setCreated_On(rs.getDate(14));
			}
				
	}catch(Exception e){
		e.printStackTrace();
	}
			return c;
			
			

		}
		public String updateCustomer(Customer c ) throws SQLException {
		    
			  
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement stmt=null;
			ResultSet rs=null;
			String sql= "UPDATE customer SET Firstname = ? ,Lastname = ? , Passport=? ,  Nationality=? , Gender=? , dob=? , Phone=? ,  Email=? , LoginName=? ,  Address=? ,  Password=? , Created_By=? , Created_On=? WHERE CustomerID = ?";
			try{
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, c.getFirstName());
			
			System.out.println(c.getFirstName()+"First name");
			
			stmt.setString(2, c.getLastName());
			stmt.setString(3,c.getPassport());
			stmt.setString(4,c.getNationality());
			stmt.setString(5,c.getGender());
			
			
			
			
			stmt.setDate(6, c.getDob());
			stmt.setInt(7, c.getPhone());
			stmt.setString(8,c.getEmail());
			stmt.setString(9,c.getLoginName());
			stmt.setString(10,c.getAddress());
			stmt.setString(11,c.getPassword());
			stmt.setString(12,c.getCreated_By());
			
			stmt.setDate(13,c.getCreated_On());
			stmt.setInt(14,c.getCustomerID());
			
			int i = stmt.executeUpdate();
			
		   System.out.println("number of rows effected::"+i);
			
		} catch(Exception e){
			System.out.println("Exception from CustomerDAOImpl updateUser...");
			e.printStackTrace();
		}finally {
			if (stmt != null)
				stmt.close();
		}
				
	
			
	return "success";
}



public void createNewCustomer(Customer c)throws SQLException  {
	//Customer cu=new Customer();
	Connection conn = ConnectionManager.getConnection();
	String sql = "";
	PreparedStatement pstmt = null;
	//ResultSet rs=null;
   try{
		sql = "INSERT INTO customer(Firstname, Lastname, Passport, Nationality,"+
				" Gender, DOB, Phone, Email, Address, LoginName, Password, Created_By, Created_On)"+
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);"; //Modified by ZarniMMM
		
		/*sql = "INSERT INTO customer(CustomerID, Firstname, Lastname, Passport, Nationality,"+
				" Gender, DOB, Phone, Email, Address, LoginName, Password, Created_By, Created_On)"+
				"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";*/
		
		pstmt = conn.prepareStatement(sql);

		//pstmt.setInt(1,c.getCustomerID()); //commented by ZarniMMM
		pstmt.setString(1,c.getFirstName());
		pstmt.setString(2,c.getLastName());
		pstmt.setString(3,c.getPassword());
		pstmt.setString(4,c.getNationality());
		pstmt.setString(5,c.getGender());
		pstmt.setDate(6,c.getDob());
		pstmt.setInt(7,c.getPhone());
		pstmt.setString(8,c.getEmail());
		pstmt.setString(9,c.getAddress());
		pstmt.setString(10,c.getLoginName());
		pstmt.setString(11,c.getPassword());
		pstmt.setString(12,c.getCreated_By());
		pstmt.setDate(13,c.getCreated_On());
		pstmt.executeUpdate();

		//int rowcount = databaseUpdate(pstmt);
//		if (rowcount != 1) {
//			// System.out.println("PrimaryKey Error when updating DB!");
//			throw new SQLException("PrimaryKey Error when updating DB!");
//		}

	} finally {
		if (pstmt != null)
			pstmt.close();
	}

}

public void deleteCustomer(Customer cus) throws Exception  {

	Connection conn = ConnectionManager.getConnection();
//		if (cus.getCustomerID() == 0) {
//			// System.out.println("Can not delete without Primary-Key!");
//			throw new Exception("Can not delete without Primary-Key!");
//		}

		String sql = "DELETE FROM customer WHERE customerID = ?";
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, cus.getCustomerID());

			int rowcount = databaseUpdate(stmt);
//		if (rowcount != 1) {
//				
//				throw new Exception(
//						"Object could not be deleted! (PrimaryKey not found)");
//			}
			
		} finally {
			if (stmt != null)
				stmt.close();
		}
	}


public String changePassword(int customerId, String password)//Create by Sapphira in jun 13
	throws SQLException {
			
		System.out.println("to change password:"+password);
		 Connection conn = ConnectionManager.getConnection();
	     String sql="update customer set password = ? where CustomerID = ?" ;
	     PreparedStatement stmt=conn.prepareStatement(sql);
	     stmt.setString(1, password);
	     stmt.setInt(2, customerId);
	     
	     int i = stmt.executeUpdate();
	     System.out.println("number of rows effected:"+i);
	     if(i==1)
		return "success";
	     else
	    	 return "fail";
}
public String getPasswordByCustomerId(int customerId) throws SQLException {  //Create by Sapphira in jun 13
	
	String password = "";
	        Connection conn = ConnectionManager.getConnection();
	        String sql="select Password from customer where CustomerID = ?" ;
	        PreparedStatement stmt=conn.prepareStatement(sql);
	        ResultSet rs=null;
			
		
	        stmt.setInt(1,customerId);
	       rs = stmt.executeQuery();
	       while(rs.next()){
	    	   password = rs.getString("Password");
	       }
	       System.out.println("password:"+password);
	        		
	return password;
}		

protected int databaseUpdate(PreparedStatement stmt)
	throws SQLException {
    int result = stmt.executeUpdate();
    return result;
}

public Customer getUpdateCustomer() throws SQLException {
	// TODO Auto-generated method stub
	return null;
}
		
}
