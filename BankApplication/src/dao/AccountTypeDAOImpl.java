package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionManager;

import dto.AccountType;

public class AccountTypeDAOImpl implements AccountTypeDAO{

	@Override
	public double getMinimumBalanceByAccountTypeId(int accountTypeId) {
		double minimumBalance = 0;
		try{
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select minimum_balance from account_type where accountType_id = ?");
			ps.setInt(1, accountTypeId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				minimumBalance = rs.getDouble(1);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return minimumBalance;
	}
//Created by ZarniMMM
Statement st;
	
	public List<AccountType> getAccoutType() throws SQLException {
		
		List<AccountType> list = new ArrayList<AccountType>();
		Connection conn = ConnectionManager.getConnection();
		String sql = "select AccountType_ID,AccountType_Name from account_type";
		st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			AccountType actype = new AccountType(rs.getInt("AccountType_ID"),rs.getString("AccountType_Name"));
			list.add(actype);
			
		}
		
		return list;
		
	}
	
//Ended by ZarniMMM
}
