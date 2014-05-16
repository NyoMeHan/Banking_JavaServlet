package handler;

import handler.Handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.CustomerBL;

import dto.CurrentUser;
import dto.Customer;

public class CustomerChangePasswordHandler implements Handler {
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		String result = "fail";
		
		String curpassword = new CustomerBL().EncryptorPassword((String)request.getParameter("curpassword"));
		String newpassword = request.getParameter("newpassword");
		String conpassword = request.getParameter("conpassword");		
		CurrentUser cu = (CurrentUser)request.getSession().getAttribute("currentUser");
		int customerId = cu.getId();
		
		
		String newEncrypedPassword = new CustomerBL().EncryptorPassword(newpassword);
		
		
		if(newpassword.equals(conpassword)){
			if(curpassword.equals(new CustomerBL().getPasswordByCustomerId(customerId))){
				result = 	new CustomerBL().changePasswordById(customerId,newEncrypedPassword);
			}
			else{
				result = "OldPasswordIsWrong";
			}
		}else{
			result = "NewConfirmPasswordMismatch";		
		}
		
		return result;
		}
}
		
		
	
