package dao;

import java.util.ArrayList;

import dto.Transaction;
import dto.TransactionBankAccountDetails;

public interface TransactionDAO {
	
	public String saveTransaction(TransactionBankAccountDetails transaction);
	public ArrayList<Transaction> getAllTransactionsByAccountNumber(int  customerId);
	public ArrayList<Transaction> getAllTransactionsByCustomerId(int customerId);
	public ArrayList<Transaction> getAllTransactionsByAccountId(int accountId);	
	
}
