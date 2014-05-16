package handler;

import java.io.IOException;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.CustomerBL;


import dto.Customer;


public class CustomerDetailHandler implements Handler {
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	//int cid = Integer.parseInt(request.getParameter("cid"));

	
	String method = request.getParameter("method");
	String result = "fail";
	
		
	if(method.equals("viewdetail")){
		int cid = Integer.parseInt(request.getParameter("cid"));
		//show new page with customer detail using cid
		Customer cus=new CustomerBL().getCustomerByID(cid);
	request.setAttribute("cus", cus);
	
	result = "success";
	
	}
	 if(method.equals("delete")){
		 int cid = Integer.parseInt(request.getParameter("cid"));
		 Customer c = new Customer();
		 c.setCustomerID(cid);
		 try {
			new CustomerBL().delCustomer(c);
			result= "delete";
			ArrayList<Customer> customers =new CustomerBL().getAllCustomers();
			request.setAttribute("customers",customers);
			request.setAttribute("message", "customer is deleted successfully.");
		} catch (Exception e) {
			System.out.println("exception occured");
			e.printStackTrace();
		}
		// just perform the delete opertion using cid 
		//and redirect to the same page
	}
	
	return result;

	
	}
	
}

