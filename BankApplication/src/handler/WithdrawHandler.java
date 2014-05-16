package handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.CustomerBankAccountBL;
import dto.CurrentUser;
import dto.TransactionBankAccountDetails;

import java.util.Date;
public class WithdrawHandler implements Handler{
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		    String result = "fail";	
		    
		    String accountNumber = (String)request.getParameter("accountNumber");
		    
		    
		    
		    
		    
			//int accountId = Integer.parseInt((String)request.getParameter("accountId"));
			double amount = Double.parseDouble(request.getParameter("amount"));
			CurrentUser cu = (CurrentUser)request.getSession().getAttribute("currentUser");
			int customerId = cu.getId();
			String status = request.getParameter("status");
			java.sql.Date transactionDate = new java.sql.Date(new java.util.Date().getTime());

			String fromCustomerNumber = accountNumber;
			String toCustomerNumber = accountNumber;
			//int  fromCustomerId = accountId;
//			int toCustomerId = accountId;			
			TransactionBankAccountDetails transaction = new TransactionBankAccountDetails();
			transaction.setFromAccountNumber(accountNumber);
			transaction.setToAccountNumber(accountNumber);
			transaction.setAmount(amount);
			transaction.setCustomerId(customerId);
			transaction.setTransactionDate(transactionDate);
			transaction.setStatus(status);		
			
//			transaction.setFrom_id(fromCustomerId);
//			transaction.setTo_id(toCustomerId);
			
			
			
			result = new CustomerBankAccountBL().withdrawAmount(transaction);
		return result;
	}

}
