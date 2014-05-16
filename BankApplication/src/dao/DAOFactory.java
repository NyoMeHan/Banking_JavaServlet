package dao;

public class DAOFactory {
	
	public static CustomerBankAccountDAO getCustomerBankDAO() {
		return new CustomerBankAccountDAOImpl();
	}
	public static AccountTypeDAO getAccountTypeDAO() {
		return new AccountTypeDAOImpl();
	}
	public static BranchDetailDAO getBranchDetail() {
		return new BranchDetailDAOimpl();
	}
	public static CustomerDAO getCustomerLoginName() {
		return new CustomerDAOImpl();
	}
	public static BranchDetailDAO getBranchDetailsDAO() {
		return new BranchDetailDAOimpl();
	}
	public static CustomerDAO getCustomerDAO(){
		return new CustomerDAOImpl(); 
	}
	
	public static BankerDAO getBankerDAO(){
		return new BankerDAOImpl();
	}
	public static BranchDetailDAO geBranchDetailDAO(){
		return new BranchDetailDAOimpl();
	}
	public static CustomerBankAccountDAO getCustomerBankAccountDAO(){
		return new CustomerBankAccountDAOImpl();
	}
	public static TransactionDAO getTransactionDAO(){
		return new TransactionDAOImpl();
	}
}
