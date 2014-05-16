	package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ConnectionManager;

import dto.CustomerBankAccount;
import dto.TransactionBankAccountDetails;

import exception.NotFoundException; 

public class CustomerBankAccountDAOImpl implements CustomerBankAccountDAO{	
		
	//Created by ZarniMMM
	Statement st;
	public CustomerBankAccountDAOImpl(){
		super();
	}
	public CustomerBankAccount createAccount() {
		return new CustomerBankAccount();
	}

	public CustomerBankAccount getAccount(Integer accountid)
			throws NotFoundException, SQLException {
		CustomerBankAccount accountDetail = createAccount();
		accountDetail.setAccountid(accountid);
		getDetail(accountDetail);
		return accountDetail;
	}
	
	public void getDetail(CustomerBankAccount accountDetail) throws NotFoundException,
	SQLException {
		Connection conn = ConnectionManager.getConnection();
		
		if ( accountDetail.getAccountid() == 0) {
			throw new NotFoundException("Can not select without Account Number!");
		}

		String sql1 = "SELECT * FROM customer_bankaccount WHERE (AccountID = ? ) ";
		String sql2 = "SELECT CustomerID,LoginName from customer WHERE (CustomerID = ?)";
		String sql3 = "SELECT BranchDetail_ID,BranchName from branch_details  WHERE (BranchDetail_ID = ?)";
		String sql4 = "SELECT AccountType_ID,AccountType_Name from account_type WHERE (AccountType_ID = ?)";
		
		PreparedStatement stmt1 = null,stmt2=null,stmt3=null,stmt4=null;
		
			//for Detail
			try {
				stmt1 = (PreparedStatement) conn.prepareStatement(sql1);
				stmt1.setInt(1,accountDetail.getAccountid());
			
				singleAccountQuery(stmt1, accountDetail);
			
			} finally {
				if (stmt1 != null)
					stmt1.close();
			}
			
			//for AccountType Name according to AccountType_ID
			try {
				stmt4 = (PreparedStatement) conn.prepareStatement(sql4);
				stmt4.setInt(1,accountDetail.getAccountTypeId());
			
				ResultSet result = stmt4.executeQuery();
				if(result.next()){
					accountDetail.setAccountType_Name(result.getString("AccountType_Name"));
					
				}
			
			} finally {
				if (stmt4 != null)
					stmt4.close();
			}
			
			
			//for BranchName according to BranchDetailID
			try {
				stmt3 = (PreparedStatement) conn.prepareStatement(sql3);
				stmt3.setInt(1,accountDetail.getBranchDetailsId());
			
				ResultSet result = stmt3.executeQuery();
				if(result.next()){
					accountDetail.setBranchName(result.getString("BranchName"));
					
				}
			
			} finally {
				if (stmt3 != null)
					stmt3.close();
			}
			

			//for Customer LoginName according to customerid
			try {
				stmt2 = (PreparedStatement) conn.prepareStatement(sql2);
				stmt2.setInt(1,accountDetail.getCustomerid());
			
				ResultSet result = stmt2.executeQuery();
				if(result.next()){
					accountDetail.setLoginName(result.getString("LoginName"));
					
				}
			
			} finally {
				if (stmt2 != null)
					stmt2.close();
			}
			
		 
	}
	
	@Override
	public String saveCustomerBankAccount(CustomerBankAccount customerBankAccount) throws SQLException{
			String sql = "", result = "";
	        PreparedStatement stmt = null;
	       	        
	        //ResultSet result = null;
	        Connection conn = ConnectionManager.getConnection();
	        try {
	             sql = "INSERT INTO customer_bankaccount (AccountNumber, "
	             + " Balance, BranchDetail_ID, AccountType_ID,CustomerID,Created_By,Created_On) "
	             + " VALUES (?, ?, ?, ?, ?, ?, ?) ";
	             stmt = (PreparedStatement) conn.prepareStatement(sql);

	             stmt.setString(1, customerBankAccount.getAccountNumber()); 
	             stmt.setBigDecimal(2, customerBankAccount.getBalance()); 
	             stmt.setInt(3, customerBankAccount.getBranchDetailsId()); 
	             stmt.setInt(4, customerBankAccount.getAccountTypeId());      
	             stmt.setInt(5, customerBankAccount.getCustomerid()); 
	             stmt.setString(6, customerBankAccount.getCreatedBy()); 
	             stmt.setDate(7,customerBankAccount.getCreatedOn());

	             int rowcount = stmt.executeUpdate();
	             if (rowcount != 1) {
	                 
	                  throw new SQLException("Inserting Error!");
	             }
	             else{
	                 result = "Save Success";
	                 
	             }
	            	 

	        } finally {
	            if (stmt != null)
	                stmt.close();
	        }
		return result;
	}


	@Override
	public String updateCustomerBankAccount (CustomerBankAccount customerBankAccount )throws SQLException {
		String Sql = "", result = "";
        PreparedStatement stmt = null;
       	        
        Connection conn = ConnectionManager.getConnection();
        try {
        	 Sql = "UPDATE customer_bankaccount SET AccountNumber = ?, Balance = ?, BranchDetail_ID = ?, "
                     + " AccountType_ID = ?, CustomerID = ?"
                     + " WHERE AccountID = ?";
             stmt = (PreparedStatement) conn.prepareStatement(Sql);

             stmt.setString(1, customerBankAccount.getAccountNumber()); 
             stmt.setBigDecimal(2, customerBankAccount.getBalance()); 
             stmt.setInt(3, customerBankAccount.getBranchDetailsId()); 
             stmt.setInt(4, customerBankAccount.getAccountTypeId());      
             stmt.setInt(5, customerBankAccount.getCustomerid()); 
             stmt.setInt(6, customerBankAccount.getAccountid()); 
             int rowcount = stmt.executeUpdate();
             if (rowcount != 1) {
                 
                  throw new SQLException("Updating Error!");
             }
             else{
                 result = "Update Success";
             }
       	 

        } finally {
            if (stmt != null)
                stmt.close();
        }
	return result;
	}

	@Override
	public String deleteCustomerBankAccount(CustomerBankAccount customerBankAccount) throws NotFoundException, SQLException {
		String result = "";
		if  (String.valueOf(customerBankAccount.getAccountid() )== null) {
               throw new NotFoundException("Can not delete without Primary-Key!");
       }
		else{
				
				String sql = "DELETE FROM customer_bankaccount WHERE AccountID = ?  ";
				
		        PreparedStatement stmt = null;
		        Connection conn = ConnectionManager.getConnection();
		        try {
		        	 
		             stmt = (PreparedStatement) conn.prepareStatement(sql);
		 
		             stmt.setInt(1, customerBankAccount.getAccountid()); 
		             int rowcount = stmt.executeUpdate();
		             if (rowcount != 1) {
		                 
		                  throw new SQLException("Deleting Error!");
		             }
		             else{
		                 result = "Delete Success";
		             }
		       	 
		
		        } finally {
		            if (stmt != null)
		                stmt.close();
		        }
		}
	return result;
	}

	@Override
	public ArrayList<CustomerBankAccount> getAllCustomerBankAccounts() throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		ArrayList<CustomerBankAccount> list = new ArrayList<CustomerBankAccount>();
		
		String sql = "select BA.*,AT.AccountType_Name,BD.BranchName,Cus.LoginName from customer_bankaccount BA"+ 
				" left outer join account_type AT on BA.AccountType_ID = AT.AccountType_ID" +
				" left outer join branch_details BD on BD.BranchDetail_ID = BA.BranchDetail_ID"+
				" left outer join customer Cus on Cus.CustomerID = BA.CustomerID;";
		st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			CustomerBankAccount s = new CustomerBankAccount(rs.getInt("AccountID"),rs.getString("AccountNumber"),rs.getBigDecimal("Balance"),rs.getInt("BranchDetail_ID"),rs.getInt("AccountType_ID"),rs.getInt("CustomerID"),rs.getString("Created_By"),rs.getDate("Created_On"),rs.getString("LoginName"),rs.getString("BranchName"),rs.getString("AccountType_Name"));
			list.add(s);
		}
		
		return list;
		
	}
	
	protected void singleAccountQuery(PreparedStatement stmt,CustomerBankAccount detail) throws NotFoundException, SQLException {

		ResultSet result = null;

		try {
			result = stmt.executeQuery();

			if (result.next()) {

				detail.setAccountid(result.getInt("AccountID"));
				detail.setAccountNumber(result.getString("AccountNumber"));
				detail.setBalance(result.getBigDecimal("Balance"));
				detail.setBranchDetailsId(result.getInt("BranchDetail_ID"));
				detail.setAccountTypeId(result.getInt("AccountType_ID"));
				detail.setCustomerid(result.getInt("CustomerID"));
				detail.setCreatedBy(result.getString("Created_By"));
				detail.setCreatedOn(result.getDate("Created_On"));

			} else {
				// System.out.println("User Object Not Found!");
				return;
			}
		} finally {
			if (result != null)
				result.close();
			if (stmt != null)
				stmt.close();
		}
	}
	
	
	@Override
	public int CheckbyAccountNumber(String accountNumber) {
		Connection con = ConnectionManager.getConnection();
		int count = 0;
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select count(*) from customer_bankaccount where AccountNumber = '"+accountNumber+"'");
			if (rs.next()) {
				 count = rs.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	public CustomerBankAccount CheckJointAccountbyAccountNumber(String accountNumber) throws NotFoundException, SQLException {
		CustomerBankAccount accountDetail = createAccount();
		accountDetail.setAccountNumber(accountNumber);
		Connection conn = ConnectionManager.getConnection();
		
		String sql1 = "SELECT * FROM customer_bankaccount WHERE (AccountNumber = ? ) ";
		
		
		PreparedStatement stmt1 = null;
		
			//for Detail
			try {
				stmt1 = (PreparedStatement) conn.prepareStatement(sql1);
				stmt1.setInt(1,accountDetail.getAccountid());
			
				singleAccountQuery(stmt1, accountDetail);
			
			} finally {
				if (stmt1 != null)
					stmt1.close();
			}
		return accountDetail;
	}
	
 //Ended by ZarniMMM
	@Override
	public CustomerBankAccount getCustomerBankAccountByAccountNumber(
			String accountNumber) {
		
		return null;
	}

	@Override
	public CustomerBankAccount getCustomerBankAccountByCustomerId(
			String customerId) {
		
		return null;
	}

	@Override
	public String deposit(
			TransactionBankAccountDetails transaction) {
		String result = "fail";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try{
			ps1 = con.prepareStatement("UPDATE customer_bankaccount SET Balance = Balance + ? WHERE accountnumber = ?");
			ps1.setDouble(1, transaction.getAmount());
			ps1.setString(2,transaction.getFromAccountNumber());			
				
			int fromAccountId = getAccountIdByAccountNumber(transaction.getFromAccountNumber());
			int toAccountId = getAccountIdByAccountNumber(transaction.getToAccountNumber());
			transaction.setFrom_id(fromAccountId);
			transaction.setTo_id(toAccountId);
			
			int result1 = ps1.executeUpdate();			
			ps2 = con.prepareStatement("INSERT INTO transaction (Amount,Transaction_Time,From_CustomerAccount_ID,To_Customer_Account_ID,Status,Customer_AccountID)VALUES(?,?,?,?,?,?)");
			ps2.setDouble(1, transaction.getAmount());
			ps2.setDate(2, transaction.getTransactionDate());
			ps2.setInt(3, transaction.getFrom_id());
			
			ps2.setInt(4, transaction.getTo_id());
			ps2.setString(5, transaction.getStatus());
			ps2.setInt(6, transaction.getCustomerId());			
			int result2 = ps2.executeUpdate();			
			if(result1>0&&result2==1){
				result = "success";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getAccountIdByAccountNumber(String accountNumber) {
		Connection con = ConnectionManager.getConnection();
		int accountId = -1;
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select accountid from customer_bankaccount where accountnumber ='"+accountNumber+"'");
			if(rs.next()){
				accountId = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return accountId;
	}
	
	
	public String getAccountNumberByAccountId(int accountId){
		Connection con = ConnectionManager.getConnection();
		String accountNumber= null;
		try{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select accountnumber from customer_bankaccount where accountid ="+accountId+"");
			if(rs.next()){
				accountNumber = rs.getString(1);
			}
			
		}catch(Exception ex){
			
		}
		return accountNumber;
	}

	public String fundTransfer(TransactionBankAccountDetails transaction) {
		String result = "fail";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try{
			//from -decrease the  balance //from_accountId
			ps1 = con.prepareStatement("UPDATE customer_bankaccount SET Balance = Balance - ? WHERE accountid = ?");
			ps1.setDouble(1, transaction.getAmount());
			ps1.setInt(2,transaction.getAccountId());			
			
			int result1 = ps1.executeUpdate();	
			//to + increase the balance //to_accountId
			ps3 = con.prepareStatement("UPDATE customer_bankaccount SET Balance = Balance + ? WHERE accountid = ?");
			ps3.setDouble(1, transaction.getAmount());
			ps3.setInt(2,transaction.getTo_id());
			int result3 = ps3.executeUpdate();	
			
			
			ps2 = con.prepareStatement("INSERT INTO transaction (Amount,Transaction_Time,From_CustomerAccount_ID,To_Customer_Account_ID,Status,Customer_AccountID)VALUES(?,?,?,?,?,?)");
			ps2.setDouble(1, transaction.getAmount());
			ps2.setDate(2, transaction.getTransactionDate());
			ps2.setInt(3, transaction.getFrom_id());
			
			ps2.setInt(4, transaction.getTo_id());
			ps2.setString(5, transaction.getStatus());
			ps2.setInt(6, transaction.getAccountId());			
			int result2 = ps2.executeUpdate();			
			if(result1>0&&result2==1&&result3==1){
				result = "success";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int getBranchIdByAccountId(int accountId) {
		int branchId = -1;
	Connection con = ConnectionManager.getConnection();
	try{
		PreparedStatement ps = con.prepareStatement("select BranchDetail_id from customer_bankaccount where accountId = ?");
		ps.setInt(1, accountId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			branchId = rs.getInt(1);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		return branchId;
	}

	@Override
	public double getBalanceByAccountId(int accountId) {
		double balance=0.0;
		Connection con = ConnectionManager.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("select balance from customer_bankaccount where accountId = ?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				balance = rs.getDouble(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return balance;
	}//getBalanceByAccountId()

	@Override
	public Date getAccountCreationDateByAccountId(int accountId) {
		java.sql.Date accountCreatedOn = null;
		Connection con = ConnectionManager.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("select created_on from customer_bankaccount where accountId = ?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				accountCreatedOn = rs.getDate(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return accountCreatedOn;
	}

	@Override
	public int getAccountTypeIdByAccountId(int accountId) {
		int accountTypeId =0;
	try{
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps = con.prepareStatement("select accounttype_id from customer_bankaccount where accountid = ?");
		ps.setInt(1, accountId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			accountTypeId = rs.getInt(1);
		}
	}catch(Exception e){
		
	}
		return accountTypeId;
	}//getAccountTypeIdByAccountId()

	@Override
	public String withdraw(TransactionBankAccountDetails transaction) {
		String result = "fail";
		Connection con = ConnectionManager.getConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try{
			ps1 = con.prepareStatement("UPDATE customer_bankaccount SET Balance = Balance-? WHERE accountnumber = ?");
			ps1.setDouble(1, transaction.getAmount());
			ps1.setString(2,transaction.getFromAccountNumber());						
			transaction.setFrom_id(getAccountIdByAccountNumber(transaction.getFromAccountNumber()));
			transaction.setTo_id(getAccountIdByAccountNumber(transaction.getToAccountNumber()));			
			System.out.println(" WD from bank act id:"+transaction.getFrom_id()+ " cust id:"+transaction.getCustomerId());					
			int result1 = ps1.executeUpdate();			
			ps2 = con.prepareStatement("INSERT INTO transaction (Amount,Transaction_Time,From_CustomerAccount_ID,To_Customer_Account_ID,Status,Customer_AccountID)VALUES(?,?,?,?,?,?)");
			ps2.setDouble(1, transaction.getAmount());
			ps2.setDate(2, transaction.getTransactionDate());
			ps2.setInt(3, transaction.getFrom_id());
			ps2.setInt(4, transaction.getTo_id());
			ps2.setString(5, transaction.getStatus());
			ps2.setInt(6, transaction.getCustomerId());			
			int result2 = ps2.executeUpdate();		
			
			System.out.println("Result 1:"+result1+" result2:"+result2);
			if(result1>0 && result2==1){
				result = "success";
			}
		}catch(Exception e){
			
		}
		return result;
	}
	public int getAccountTypeIdByAccountNumber(String accountNumber) {
		int accountTypeId=0;
		try{
			Connection con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("select accounttype_id from customer_bankaccount where accountnumber = ?");
			ps.setString(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				accountTypeId = rs.getInt(1);
			}
		}catch(Exception e){
			
		}
			return accountTypeId;
	}

	@Override
	public double getBalanceByAccountNumber(String accountNumber) {
		double balance=0.0;
		Connection con = ConnectionManager.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement("select balance from customer_bankaccount where accountnumber = ?");
			ps.setString(1, accountNumber);
			System.out.println("accountNumber:"+accountNumber);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				balance = rs.getDouble(1);
				System.out.println("balance:"+balance);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public boolean isAccountNumber(String accountNumber) {
		//System.out.println("Account number in DAO:"+accountNumber);
		boolean result = false;
		Connection con = ConnectionManager.getConnection();		
		try{
			PreparedStatement ps = con.prepareStatement("select * from customer_bankaccount where accountNumber = ?");
			ps.setString(1, accountNumber);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			//	System.out.println("accnt check:"+rs.getInt(1));
				result = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}//isAccountNumber()


}
