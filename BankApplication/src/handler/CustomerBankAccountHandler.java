package handler;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.CustomerBankAccountBL;

import dto.CustomerBankAccount;

public class CustomerBankAccountHandler implements Handler {

	@Override
	public String handleRequest(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
				
		CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
		ArrayList<CustomerBankAccount> accountlist = customerBankAccountbl.getBankAccountList();
		request.setAttribute("slist", accountlist);
		String result = "show";
		return result;
	}

}
