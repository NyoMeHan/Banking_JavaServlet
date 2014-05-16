package handler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.BranchDetailBL;
import businesslogic.CustomerBankAccountBL;

import dao.BranchDetailDAOimpl;
import dao.CustomerBankAccountDAOImpl;
import dto.AccountNumberIdPair;
import dto.AccountSummary;
import dto.CurrentUser;

public class AccountSummaryHandler implements Handler{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AccountNumberIdPair> accounts = new ArrayList<AccountNumberIdPair>(); 
		accounts = (ArrayList<AccountNumberIdPair>) request.getSession().getAttribute("accounts");		
		ArrayList<AccountSummary> accountSummaries = new ArrayList<AccountSummary>();
		for(int i = 0;i<accounts.size();i++){
			AccountNumberIdPair accountNumberIdPair = accounts.get(i);
			AccountSummary accountSummary = new AccountSummary();
			accountSummary.setAccountId(i+1);
			accountSummary.setAccountNumber(accountNumberIdPair.getAccountNumber());
			accountSummary.setBranchName(new BranchDetailBL().getBranchNameByBranchId(new CustomerBankAccountBL().getBranchIdByAccountId(accountNumberIdPair.getId())));
			accountSummary.setBalance(new CustomerBankAccountBL().getBalanceByAccountId(accountNumberIdPair.getId()));
			accountSummary.setCreatedOn(new CustomerBankAccountBL().getAccountCreationDateByAccountId(accountNumberIdPair.getId()));
			accountSummaries.add(accountSummary);		
		}
		request.setAttribute("summaries", accountSummaries);
		 
		return "success";
	}

}
