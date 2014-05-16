package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.CustomerBankAccount;
import dto.TransactionBankAccountDetails;
import exception.NotFoundException;

public interface CustomerBankAccountDAO {
	 
	
	 public String withdraw(TransactionBankAccountDetails transactionBankAccountDetails);
	 public String deposit(TransactionBankAccountDetails transactionBankAccountDetails);
	 
	 public int getAccountIdByAccountNumber(String accountNumber);
	 
	 public int getBranchIdByAccountId(int accountId);
	 public String saveCustomerBankAccount(CustomerBankAccount customerBankAccount) throws SQLException;
	 public String updateCustomerBankAccount(CustomerBankAccount customerBankAccount) throws SQLException;
	 public String deleteCustomerBankAccount(CustomerBankAccount customerBankAccount) throws NotFoundException, SQLException;	 
	 public ArrayList<CustomerBankAccount> getAllCustomerBankAccounts() throws SQLException;
	 public CustomerBankAccount getCustomerBankAccountByAccountNumber(String accountNumber);
	 public CustomerBankAccount getCustomerBankAccountByCustomerId(String customerId) throws SQLException;
	 public java.sql.Date getAccountCreationDateByAccountId(int accountId);
	 public double getBalanceByAccountId(int accountId);
	 public double getBalanceByAccountNumber(String accountNumber);
	 public int getAccountTypeIdByAccountId(int accountId);
	 public int getAccountTypeIdByAccountNumber(String accountNumber); 
	 public boolean isAccountNumber(String accountNumber);
	 public CustomerBankAccount getAccount(Integer accountid) throws NotFoundException, SQLException;
	 public int CheckbyAccountNumber(String accountNumber);
	 public CustomerBankAccount CheckJointAccountbyAccountNumber(String accountNumber) throws NotFoundException, SQLException;
}
