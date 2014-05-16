package handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businesslogic.CustomerBL;

import dao.CustomerDAOImpl;
import dto.CurrentUser;
import dto.Customer;

public class LoginHandler implements Handler{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String result = "fail";	
		   String loginType = request.getParameter("loginType");
			String userName = request.getParameter("username");
			String loginpassword = request.getParameter("password");
			
		   //Created by Sapphira in jun 15
			String password= new CustomerBL().EncryptorPassword((String)request.getParameter("password").trim());//encrypt the password		
			//c.setPassword(encry);
			
			CurrentUser cUser = new CurrentUser();
			cUser.setUserType(request.getParameter("loginType"));
			cUser.setUsername(userName);
			
			if(loginType.equals("customer")){
				cUser.setPassword(password);
							
			}
			else{
				
				cUser.setPassword(loginpassword);
				
			}

			CurrentUser c  = new CustomerDAOImpl().authenticate(cUser,loginType);
			if(c!=null){
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", c);			
				session.setAttribute("accounts", new CustomerDAOImpl().getAllAccountInfo(c.getId()));				
				result = c.getUserType();
			}
			if(c==null){
				result = "fail";
			}
			
		return result;
	}

}
