package businesslogic;

import java.sql.SQLException;
import java.util.List;

import dao.CustomerDAO;
import dao.DAOFactory;
import dto.AccountNumberIdPair;
import dto.CurrentUser;
import dto.Customer;
import dao.CustomerDAOImpl;
import java.util.ArrayList;

import util.Encryptor;

public class CustomerBL {
	//Created by ZarniMMM
	DAOFactory factory = new DAOFactory();
	
	public List<Customer> getCustLoginName() {
			
		CustomerDAO dao = factory.getCustomerLoginName();
			try {
				List<Customer> list =dao.getCustLoginName();
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return null;
		}
	//Created by ZarniMMM 
	
	public ArrayList<Customer> getAllCustomers(){
		ArrayList<Customer> customers = null;
		 try {
			customers = new CustomerDAOImpl().getAllCustomers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
		
	}

	public Customer getCustomerByID(int cid) {
		Customer cus=null;
		try {
			cus=new CustomerDAOImpl().getCustomerByID(cid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cus;
	}
	

	public Customer getUpdateCustomers() throws SQLException {
		Customer custm=null;
		try {
			custm=new CustomerDAOImpl().getUpdateCustomer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custm;
	}


	public void getNewCustomer(Customer c) {
		
		try {
			new CustomerDAOImpl().createNewCustomer(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return newcus;
	}

	public void delCustomer(Customer cus) throws Exception {
		 try {
			new CustomerDAOImpl().deleteCustomer(cus);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public CurrentUser authenticate(CurrentUser cUser,String loginType) {
		CurrentUser cu = null;
	
			cu=  DAOFactory.getCustomerDAO().authenticate(cUser,loginType);
		
		return cu;
	}
	//Below is finished by sapphira in jun 13
	public String  EncryptorPassword(String password){

		String encryptor = null;
		try {
			 encryptor = new Encryptor().encryptMyPssword(password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return encryptor;
	}

	public String  getPasswordByCustomerId(int customerId) {		

		String cc = null;
			try {
				cc = new CustomerDAOImpl().getPasswordByCustomerId(customerId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		return cc;
	}

	public String  changePasswordById(int customerId,String password) {
		
		System.out.println("in BL: "+customerId+" pwd:"+password);
		String result=null;
		try {
			result = new CustomerDAOImpl().changePassword(customerId, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return result;	
	}
	public ArrayList<AccountNumberIdPair> getAllAccountInfo(int customerId){
		return DAOFactory.getCustomerDAO().getAllAccountInfo(customerId);
	}

}
