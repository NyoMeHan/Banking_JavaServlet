import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.ConnectionManager;
import dao.CustomerBankAccountDAOImpl;
import dto.TransactionBankAccountDetails;


public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		java.sql.Date transactionDate = new java.sql.Date(new java.util.Date().getTime());	
//		TransactionBankAccountDetails transaction = new TransactionBankAccountDetails();
//		transaction.setAccountId(2);
//		transaction.setAmount(100);
//		transaction.setCustomerId(1);
//		transaction.setTransactionDate(transactionDate);
//		transaction.setStatus("withdraw");
//		transaction.setFrom_id(1);
//		transaction.setTo_id(1);	
//		Connection con = ConnectionManager.getConnection();
//		PreparedStatement ps1 = null;
//		PreparedStatement ps2 = null;
//		try{
//			ps1 = con.prepareStatement("UPDATE customer_bankaccount SET Balance = Balance-? WHERE accountid = ? and customerid =?");
//			ps1.setDouble(1, transaction.getAmount());
//			ps1.setInt(2,transaction.getAccountId());			
//			ps1.setInt(3,transaction.getCustomerId());	
//			int result1 = ps1.executeUpdate();			
//			ps2 = con.prepareStatement("INSERT INTO transaction (Amount,Transaction_Time,From_CustomerAccount_ID,To_Customer_Account_ID,Status,Customer_AccountID)VALUES(?,?,?,?,?,?)");
//			ps2.setDouble(1, transaction.getAmount());
//			ps2.setDate(2, transaction.getTransactionDate());
//			ps2.setInt(3, transaction.getFrom_id());
//			ps2.setInt(3,transaction.getFrom_id());
//			ps2.setInt(4, transaction.getTo_id());
//			ps2.setString(5, transaction.getStatus());
//			ps2.setInt(6, transaction.getAccountId());			
//			int result2 = ps2.executeUpdate();						
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		
//		CustomerBankAccountDAOImpl cbaDAO = new CustomerBankAccountDAOImpl();
//		String  accountNumber = cbaDAO.getAccountNumberByAccountId(1);
//		System.out.println("accountId:"+accountNumber);
//		
		
		
		
		try{
			Connection con = ConnectionManager.getConnection();
			Statement st = con.createStatement();
			java.sql.Date  date = null;
			ResultSet rs = st.executeQuery("select transaction_time from transaction where transaction_id = 1;");
			
			if(rs.next()){
				  date= rs.getDate(1);
			}
			
			System.out.println("Date:"+date);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		

	}

}
