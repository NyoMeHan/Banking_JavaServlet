package handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.CustomerBankAccountBL;
import dao.CustomerBankAccountDAOImpl;
import dto.CurrentUser;
import dto.TransactionBankAccountDetails;

public class FundsTransferHandler implements Handler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = (String)request.getParameter("accountNumber");
		double amount = Double.parseDouble(request.getParameter("amount"));
		CurrentUser cu = (CurrentUser)request.getSession().getAttribute("currentUser");
		// user id of the one  who is transfering  money 
		int customerId = cu.getId();
		
		
		String status = request.getParameter("status");
		java.sql.Date transactionDate = new java.sql.Date(new java.util.Date().getTime());
	
		String  fromCustomerAccountNumber = accountNumber;
		String toCustomerAccountNumber = request.getParameter("to_accountNumber").trim();
		
		System.out.println("from:"+fromCustomerAccountNumber+" to:"+toCustomerAccountNumber);
		
		if(new CustomerBankAccountDAOImpl().isAccountNumber(toCustomerAccountNumber)){
		TransactionBankAccountDetails transaction = new TransactionBankAccountDetails();
		
		transaction.setAmount(amount);
		transaction.setCustomerId(customerId);
		transaction.setTransactionDate(transactionDate);
		transaction.setStatus(status);
		transaction.setFromAccountNumber(fromCustomerAccountNumber);
		transaction.setToAccountNumber(toCustomerAccountNumber);
		
		return new CustomerBankAccountBL().fundTransfer(transaction);}
		else
			return "invalidAccount";
	}


}
