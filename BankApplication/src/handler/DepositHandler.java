package handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businesslogic.CustomerBankAccountBL;
import dto.CurrentUser;
import dto.TransactionBankAccountDetails;

public class DepositHandler implements Handler {

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String accountNumber = (String)request.getParameter("accountNumber");
		double amount = Double.parseDouble(request.getParameter("amount"));
		CurrentUser cu = (CurrentUser)request.getSession().getAttribute("currentUser");
		int customerId = cu.getId();
		String status = request.getParameter("status");
		java.sql.Date transactionDate = new java.sql.Date(new java.util.Date().getTime());
		String  fromCustomerAccountNumber = accountNumber;
		String toCustomerAccountNumber = accountNumber;		
		TransactionBankAccountDetails transaction = new TransactionBankAccountDetails();
		//transaction.setAccountId(accountId);
		transaction.setAmount(amount);
		transaction.setCustomerId(customerId);
		transaction.setTransactionDate(transactionDate);
		transaction.setStatus(status);
		transaction.setFromAccountNumber(fromCustomerAccountNumber);
		transaction.setToAccountNumber(toCustomerAccountNumber);
		return new CustomerBankAccountBL().depositAmount(transaction);
	}

}
