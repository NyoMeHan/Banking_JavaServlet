package handler;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.CustomerBL;

import dao.CustomerDAOImpl;
import dto.Customer;

public class PerformUpdateHandler implements Handler{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		String result = "fail";
		if(method.equals("Update")){
			Customer updatec = new Customer();
			updatec.setCustomerID(Integer.parseInt(request.getParameter("id")));
			updatec.setFirstName(request.getParameter("firstName"));
			updatec.setLastName(request.getParameter("lastName"));
			updatec.setPassport(request.getParameter("passport"));
			updatec.setNationality(request.getParameter("nationality"));
			updatec.setGender(request.getParameter("gender"));
			
			String dobString = request.getParameter("dob");	
			//Added for test
			DateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			java.util.Date parsedUtilDate;
			try {
				parsedUtilDate = formater.parse(dobString);
				java.sql.Date sqltDate= new java.sql.Date(parsedUtilDate.getTime());
				updatec.setDob(sqltDate);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  			
		       
			/*SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd"); //Modified by ZarniMMM
			java.util.Date dobutilDate;
			try {
				dobutilDate = format.parse(dobString);
				java.sql.Date dobsqlDate = new java.sql.Date(dobutilDate.getTime());		
				updatec.setDob(dobsqlDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	*/
			
			updatec.setPhone(Integer.parseInt((String)request.getParameter("phone").trim()));
			updatec.setEmail(request.getParameter("email"));
			updatec.setAddress(request.getParameter("address"));
			updatec.setLoginName(request.getParameter("loginname"));
			updatec.setPassword(request.getParameter("password"));
			updatec.setCreated_By(request.getParameter("created_by"));
			
			java.util.Date todayDate = new java.util.Date();//set todayDate
			updatec.setCreated_On(new java.sql.Date(todayDate.getTime()));		
			CustomerDAOImpl cDAOImpl = new CustomerDAOImpl();
			try {
				cDAOImpl.updateCustomer(updatec);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("newcustomer", updatec);
			result= "Update";
			request.setAttribute("message", "customer is updated successfully.");
		}
		else if(method.equals("Exit")){
			ArrayList<Customer> customers =new CustomerBL().getAllCustomers();
			request.setAttribute("customers",customers);
			result="exit";
		}
		return result;
		
	}

}
