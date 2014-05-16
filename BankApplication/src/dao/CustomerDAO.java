package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AccountNumberIdPair;
import dto.CurrentUser;
import dto.Customer;

public interface CustomerDAO {
	public CurrentUser authenticate(CurrentUser currentUser,String userType) ;
	public String saveCustomer(Customer customer);
	public String updateCustomer(Customer customer) throws SQLException;
	public void deleteCustomer(Customer customer) throws Exception;
	public ArrayList<Customer> getAllCustomers() throws SQLException;
	public Customer getCustomerByAccountNumber(String accountNumber);
	public String getCustomerAccountNumber(int id);	
	public String deposit(double amount);
	public String withdraw(double amount,String accountNumber);
	public ArrayList<AccountNumberIdPair> getAllAccountInfo(int customerId);
	public List<Customer> getCustLoginName() throws SQLException; //Created by ZarniMMM

	public String getPasswordByCustomerId(int customerId) throws SQLException;//Created by Sapphira in jun 13
	public String changePassword(int customerId,String password)throws SQLException;//Created by Sapphira in jun 13
}
