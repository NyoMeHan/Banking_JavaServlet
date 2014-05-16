package handler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businesslogic.CustomerBL;
import dto.CurrentUser;
import dto.Customer;

public class NewCustomerHandler implements Handler {
	
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		
		String result = "fail";
		if(method.equals("Save")){
				Customer c=new Customer();
				
				//c.setCustomerID(Integer.parseInt(request.getParameter("id")));//Commented by ZarniMMM
				c.setFirstName(request.getParameter("firstName"));
				c.setLastName(request.getParameter("lastName"));
				c.setPassport(request.getParameter("passport"));
				c.setNationality(request.getParameter("nationality"));
				c.setGender(request.getParameter("gender"));
				
				String dobString = request.getParameter("dob");
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				java.util.Date dobutilDate;
				try {
					dobutilDate = format.parse(dobString);
					java.sql.Date dobsqlDate = new java.sql.Date(dobutilDate.getTime());
									
					c.setDob(dobsqlDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
				c.setPhone(Integer.parseInt((String)request.getParameter("phone").trim()));
				c.setEmail(request.getParameter("email"));
				c.setAddress(request.getParameter("address"));
				c.setLoginName(request.getParameter("loginname"));

				c.setPassword(request.getParameter("password"));//Created by Sapphira in jun 13
				String encry= new CustomerBL().EncryptorPassword((String)request.getParameter("password").trim());//encrypt the password		
				c.setPassword(encry);
				
				c.setCreated_By(request.getParameter("created_by"));
				
				java.util.Date todayDate = new java.util.Date();//set todayDate
				c.setCreated_On(new java.sql.Date(todayDate.getTime()));
				
				new CustomerBL().getNewCustomer(c);
				request.setAttribute("newcustomer", c);
				result= "Save";
				request.setAttribute("message", "customer is saved successfully.");
		}
		else if(method.equals("Exit")){
			ArrayList<Customer> customers =new CustomerBL().getAllCustomers();
			request.setAttribute("customers",customers);
			result="exit";
		}
		else{
			//default set the current date
				java.util.Date todayDate = new java.util.Date();
				request.setAttribute("created_on", new java.sql.Date(todayDate.getTime()));	
				
				//get user name 
				HttpSession session = request.getSession();
				CurrentUser cUser = (CurrentUser)session.getAttribute("currentUser");
				String userName = cUser.getUsername();
				request.setAttribute("created_by",userName);
				result = "";
		}

		return result;

	}
	}
	
	
	
	
	
	
	
	
	
	
//	if(id.equals("exit")){
//		int cid = Integer.parseInt(request.getParameter("cid"));
//		//show new page with customer detail using cid
//		Customer cus=new CustomerBL().getCustomerByID(cid);
//	request.setAttribute("cus", cus);
//	result = "success";
//	
//	}
//	 if(id.equals("exit")){
//		 int cid = Integer.parseInt(request.getParameter("cid"));
//		 Customer c = new Customer();
//		 c.setCustomerID(cid);
//		 try {
//			new CustomerBL().delCustomer(c);
//			result= "delete";
//			ArrayList<Customer> customers =new CustomerBL().getAllCustomers();
//			request.setAttribute("customers",customers);
//			request.setAttribute("message", "customer is deleted successfully.");
//		} catch (Exception e) {
//			System.out.println("exception occured");
//			e.printStackTrace();
//		}
//		// just perform the delete opertion using cid 
//		//and redirect to the same page
//	}
//	
//	return result;
//
//	
//	}


