package handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import businesslogic.CustomerBL;

import dto.Customer;

public class CustomerHandler implements Handler{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Customer> customers =new CustomerBL().getAllCustomers();
		request.setAttribute("customers",customers);
		
		return "success";

	}

	
	
}
