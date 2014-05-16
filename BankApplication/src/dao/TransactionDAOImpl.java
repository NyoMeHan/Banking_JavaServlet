package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connection.ConnectionManager;

import dto.Transaction;
import dto.TransactionBankAccountDetails;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public String saveTransaction(TransactionBankAccountDetails transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Transaction> getAllTransactionsByAccountNumber(
			int customerId) {
		
		return null;
	}

	@Override
	public ArrayList<Transaction> getAllTransactionsByCustomerId(int customerId) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		Connection con = ConnectionManager.getConnection();
		CustomerBankAccountDAOImpl cbaDAO = new CustomerBankAccountDAOImpl();
		try{
			PreparedStatement ps = con.prepareStatement("select * from transaction where customer_accountid= ?");
			ps.setInt(1, customerId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Transaction transaction = new Transaction();
				transaction.setFromCustomerAccountNumber(cbaDAO.getAccountNumberByAccountId(rs.getInt(4)));
				transaction.setToCustomerAccountNumber(cbaDAO.getAccountNumberByAccountId(rs.getInt(5)));
				transaction.setStatus(rs.getString(6));
				transaction.setTransactionDate(rs.getDate(3));
				transaction.setAmount(rs.getDouble(2));
				transactions.add(transaction);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return transactions;
	}

	@Override
	public ArrayList<Transaction> getAllTransactionsByAccountId(int accountId) {
		
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		Connection con = ConnectionManager.getConnection();
		CustomerBankAccountDAOImpl cbaDAO = new CustomerBankAccountDAOImpl();
		try{
			PreparedStatement ps = con.prepareStatement("select * from transaction where from_customeraccount_id = ?");
			ps.setInt(1, accountId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Transaction transaction = new Transaction();
				transaction.setFromCustomerAccountNumber(cbaDAO.getAccountNumberByAccountId(rs.getInt(4)));
				transaction.setToCustomerAccountNumber(cbaDAO.getAccountNumberByAccountId(rs.getInt(5)));
				transaction.setStatus(rs.getString(6));
				transaction.setTransactionDate(rs.getDate(3));
				transaction.setAmount(rs.getDouble(2));
				transactions.add(transaction);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return transactions;
	}

}
