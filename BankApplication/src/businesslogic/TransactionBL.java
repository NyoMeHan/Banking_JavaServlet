package businesslogic;

import java.util.ArrayList;

import dao.DAOFactory;
import dto.Transaction;

public class TransactionBL {
	public ArrayList<Transaction> getAllTransactionsByCustomerId(int customerId){
		return DAOFactory.getTransactionDAO().getAllTransactionsByCustomerId(customerId);
	}
	public ArrayList<Transaction> getAllTransactionsByAccountId(int accountId){
		return DAOFactory.getTransactionDAO().getAllTransactionsByAccountId(accountId);
	}
}
