package businesslogic;

import dao.AccountTypeDAOImpl;
import dao.CustomerBankAccountDAOImpl;
import dto.TransactionBankAccountDetails;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.CustomerBankAccountDAO;

import dto.CustomerBankAccount;
import exception.NotFoundException;

public class CustomerBankAccountBL {
	//Created by ZarniMMM
	private CustomerBankAccountDAO bankAccountDAO;
	DAOFactory factory = new DAOFactory();
    private Boolean ValidateFlag = true;
    
	public CustomerBankAccountBL() {
		bankAccountDAO = factory.getCustomerBankDAO();
	}
	public ArrayList<CustomerBankAccount> getBankAccountList() {
		
		CustomerBankAccountDAO dao = factory.getCustomerBankDAO();
		try {
			ArrayList<CustomerBankAccount> list = dao.getAllCustomerBankAccounts();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
	public CustomerBankAccount getDetailbyID(Integer accountID )throws NotFoundException{
		CustomerBankAccount detail = new CustomerBankAccount();
		try {
			detail=bankAccountDAO.getAccount(accountID);
		} finally {
			return detail;
		}
	}
	
	public String saveBankAccount(CustomerBankAccount cusBankaccount) {
		String result = "";
		try {
			result = bankAccountDAO.saveCustomerBankAccount(cusBankaccount);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String updateBankAccount(CustomerBankAccount cusBankaccount){
		String result = "";
		try {
		  result = bankAccountDAO.updateCustomerBankAccount(cusBankaccount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String deleteBankAccount(CustomerBankAccount cusBankaccount) {
		String result = "";
		try {
			result = bankAccountDAO.deleteCustomerBankAccount(cusBankaccount);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//Ended by ZarniMMM
	
	
	public String withdrawAmount(
			TransactionBankAccountDetails transactionBankAccountDetails)  {
		String result = "fail";
try{
		int accountTypeId = DAOFactory.getCustomerBankAccountDAO()
				.getAccountTypeIdByAccountNumber(
						transactionBankAccountDetails.getFromAccountNumber());
				
		double minBalAllowed = DAOFactory.getAccountTypeDAO()
				.getMinimumBalanceByAccountTypeId(accountTypeId);
				
		double balance = DAOFactory.getCustomerBankAccountDAO()
				.getBalanceByAccountNumber(
						transactionBankAccountDetails.getFromAccountNumber());		
		
		System.out.println(minBalAllowed +" < "+ balance+" - "+transactionBankAccountDetails.getAmount());
		if (minBalAllowed < balance - transactionBankAccountDetails.getAmount()) {
			result = DAOFactory.getCustomerBankAccountDAO().withdraw(
					transactionBankAccountDetails);
			
		} else
			result = "amountExceeded";
	
	}catch(Exception ex){
		ex.printStackTrace();
	}
	
		return result;
	}

	public String depositAmount(
			TransactionBankAccountDetails transactionBankAccountDetails) {
		String result = DAOFactory.getCustomerBankAccountDAO().deposit(
				transactionBankAccountDetails);
		return result;
	}

	public String fundTransfer(
			TransactionBankAccountDetails transactionBankAccountDetails)  {
		String result = "fail";
		try{ 
		int accountTypeId = DAOFactory.getCustomerBankAccountDAO()
				.getAccountTypeIdByAccountNumber(
						transactionBankAccountDetails.getFromAccountNumber());
		double minBalAllowed = DAOFactory.getAccountTypeDAO()
				.getMinimumBalanceByAccountTypeId(accountTypeId);

		System.out.println("from accountNumber :"+transactionBankAccountDetails.getFromAccountNumber());
		double balance = DAOFactory.getCustomerBankAccountDAO()
				.getBalanceByAccountNumber(
						transactionBankAccountDetails.getFromAccountNumber());
		
		
		System.out.println("0.0 < "+balance+" - "+transactionBankAccountDetails.getAmount());

		if (0.0 < balance - transactionBankAccountDetails.getAmount()) {
			result = DAOFactory.getCustomerBankAccountDAO().withdraw(transactionBankAccountDetails);
		} else
			result = "amountExceeded";
		}
		catch(Exception e){			
		}
		return result;
	}
	public int getBranchIdByAccountId(int accountId) {
		return DAOFactory.getCustomerBankAccountDAO().getBranchIdByAccountId(
				accountId);
	}

	public double getBalanceByAccountId(int accountId) {
		return DAOFactory.getCustomerBankAccountDAO().getBalanceByAccountId(
				accountId);
	}

	public java.sql.Date getAccountCreationDateByAccountId(int accountId) {
		return DAOFactory.getCustomerBankAccountDAO()
				.getAccountCreationDateByAccountId(accountId);
	}
	
	 public int getAccountIdByAccountNumber(String accountNumber){
		 return DAOFactory.getCustomerBankAccountDAO().getAccountIdByAccountNumber(accountNumber);
	 }
	public int CheckbyAccountNumber(String accountNumber){
		int count = 0;
		count = bankAccountDAO.CheckbyAccountNumber(accountNumber);
		return count;
		
	}
	public CustomerBankAccount jointCheck(String acnumber)throws NotFoundException{
		CustomerBankAccount detail = new CustomerBankAccount();
		try {
			detail=bankAccountDAO.CheckJointAccountbyAccountNumber(acnumber);
		} finally {
			return detail;
		}
	}
}
