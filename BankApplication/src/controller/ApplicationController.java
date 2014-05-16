package controller;

import handler.AccountSummaryHandler;
import handler.BankAccountHandler;
import handler.BranchDetailHandler;
import handler.BranchListHandler;
import handler.BranchUpdateHandler;
import handler.CustomerChangePasswordHandler;
import handler.CustomerDetailHandler;
import handler.CustomerHandler;
import handler.DepositHandler;
import handler.FundsTransferHandler;
import handler.JointBankAccountHandler;
import handler.LoginHandler;
import handler.LogoutHandler;
import handler.NewBranchHandler;
import handler.NewCustomerHandler;
import handler.PerformUpdateHandler;
import handler.TransactionHandler;
import handler.WithdrawHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import handler.BankAccountMaintainenceHandler;
import handler.CustomerBankAccountHandler;

public class ApplicationController {
	public void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String path = request.getServletPath();
		String message = null;
		Object o = map.get(path);
		RequestDispatcher requestDispatcher = null;
		
		if (o instanceof LoginHandler) {
			LoginHandler loginHandler = (LoginHandler) o;			
			result = loginHandler.handleRequest(request, response);
			
			switch(result){			
			case "customer":{
							message = "Welcome to Bank";
							requestDispatcher = request.getRequestDispatcher("/customerHome.jsp");				
							}break;
			case "banker":{
							message = "Welcome to Bank";
							requestDispatcher = request.getRequestDispatcher("/bankerHome.jsp");
							}break;
			default:		{	
							message = "Invalid login";
							requestDispatcher = request.getRequestDispatcher("/login.jsp");
							}
			}			
			request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// LoginHandler
		
		if (o instanceof LogoutHandler) {
			LogoutHandler logoutHandler = (LogoutHandler) o;			
			result = logoutHandler.handleRequest(request, response);
			
			if (result.equals("success")) {
				message = "Thank you for using BANK. you are successfully logged out.";
				requestDispatcher = request.getRequestDispatcher("/login.jsp");
			}			
			request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// LoginHandler
		
		if (o instanceof BankAccountHandler) {
			BankAccountHandler bankAccountHandler = (BankAccountHandler) o;			
			result = bankAccountHandler.handleRequest(request, response);
			
			if (result.equals("success")) {
				
				requestDispatcher = request.getRequestDispatcher("/login.jsp");
			}			
			request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// BankAccountHandler

		
		
		if (o instanceof WithdrawHandler) {
			WithdrawHandler withdrawHandler = (WithdrawHandler) o;			
			
				result = withdrawHandler.handleRequest(request, response);
			
			
			switch(result){
			case "success":{
							message = "Balance is successfully withdrawn.";
							}break;
			case "amountExceeded":{
							message = "You are exceeding the maximum amount of withdrawl";
							}break;
			default:		{message = "Some problems occured while withdrawing money. Please try again.";}
							}
			request.setAttribute("message",message);
			requestDispatcher = request.getRequestDispatcher("/customerWithdrawDeposit.jsp");
			requestDispatcher.forward(request, response);
			
		}// withdrawHandler
		
		if (o instanceof DepositHandler) {
			DepositHandler depositHandler = (DepositHandler) o;			
			result = depositHandler.handleRequest(request, response);
			
			if (result.equals("success")) {
				message = "Balance is successfully Deposited.";
				requestDispatcher = request.getRequestDispatcher("/customerWithdrawDeposit.jsp");
			}
			else{
				message = "Some problems occured while depositing money. Please try again.";
				requestDispatcher = request.getRequestDispatcher("/customerWithdrawDeposit.jsp");
			}
			request.setAttribute("message",message);
			requestDispatcher.forward(request, response);		
		}// depositHandler	
		
		
		
		if(o instanceof FundsTransferHandler){
			FundsTransferHandler fundsTransferHandler = (FundsTransferHandler)o;
			
				result = fundsTransferHandler.handleRequest(request, response);
			
			System.out.println("Result fT:"+result);
			
			if(result.equals("success")){
				message="Balance is successfully transfered";
				requestDispatcher = request.getRequestDispatcher("/customerFundsTransfer.jsp");
			}else if(result.equals("amountExceeded")){
				message="You don't have enough balance in your account, please check balance.";
				requestDispatcher = request.getRequestDispatcher("/customerFundsTransfer.jsp");
			}else if(result.equals("invalidAccount")){
				message="Account Number doesn't exists, please enter again.";
				requestDispatcher = request.getRequestDispatcher("/customerFundsTransfer.jsp");
			}
			else {
				message="Some problems occured while transfering the funds. Please try again.";
				requestDispatcher = request.getRequestDispatcher("/customerFundsTransfer.jsp");
			}
			request.setAttribute("message",message);
			requestDispatcher.include(request, response);	
			
		}//fundsTansferHandler()
			
		if(o instanceof TransactionHandler){
			TransactionHandler transactionHandler = (TransactionHandler)o;
			result = transactionHandler.handleRequest(request, response);
			if(result.equals("success")){
				//request.setAttribute("transactions", request.getAttribute("transactions"));
				requestDispatcher = request.getRequestDispatcher("/customerTransaction.jsp");
			}else{
			//	message="Some problems occured while fetching  the funds. Please try again.";
				requestDispatcher = request.getRequestDispatcher("/customerHome.jsp");
			}
			//request.setAttribute("message",message);
			requestDispatcher.forward(request, response);	
			
		}//fundsTansferHandler()
		
		
		if(o instanceof AccountSummaryHandler){
			AccountSummaryHandler accountSummaryHandler = (AccountSummaryHandler)o;
			result = accountSummaryHandler.handleRequest(request, response);
			if(result.equals("success")){				
				requestDispatcher = request.getRequestDispatcher("/customerAccountSummary.jsp");
			}else{			
				requestDispatcher = request.getRequestDispatcher("/customerHome.jsp");
			}		
			requestDispatcher.forward(request, response);				
		}//AccountSummaryHandler()
		
		
		//Created by ZarniMMM

		if (o instanceof CustomerBankAccountHandler) {
			CustomerBankAccountHandler customerBankAccountHandler = (CustomerBankAccountHandler) o;			
			result = customerBankAccountHandler.handleRequest(request, response);
			if(result.equals("show")){
				//requestDispatcher = request.getRequestDispatcher("/pages/body/CustomerBankAccountListing_body.jsp");
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}

			requestDispatcher.forward(request, response);
		}// CustomerBankAccountHandler
		
		if (o instanceof BankAccountMaintainenceHandler) {
			BankAccountMaintainenceHandler accountmaintainencehandler = (BankAccountMaintainenceHandler) o;			
			result = accountmaintainencehandler.handleRequest(request, response);
			if(result.equals("show")){
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountMaintainence.jsp");
			}else if(result.equals("Save Success")){
				message = "Save Successful. Please check your new account in the List!";
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}else if(result.equals("Update Success")){
				message = "Update Successful";
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}else if(result.equals("Delete Success")){
				message = "Delete Successful";
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}
			else if ( result.equals("exit")){
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}
			else{
				message = result;
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountMaintainence.jsp");
			}
			request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// BankAccountMaintainenceHandler
		
		
		if (o instanceof JointBankAccountHandler) {
			JointBankAccountHandler jointAccountHandler = (JointBankAccountHandler) o;			
			result = jointAccountHandler.handleRequest(request, response);
			if(result.equals("show")){
				requestDispatcher = request.getRequestDispatcher("/JointBankAccount.jsp");
			}else if(result.equals("Save Success")){
				message = "Save Successful. Please check your new account in the List!";
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}else if(result.equals("Update Success")){
				message = "Update Successful";
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}else if(result.equals("Delete Success")){
				message = "Delete Successful";
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}
			else if ( result.equals("exit")){
				requestDispatcher = request.getRequestDispatcher("/CustomerBankAccountListing.jsp");
			}
			else{
				message = result;
				requestDispatcher = request.getRequestDispatcher("/JointBankAccount.jsp");
			}
			request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// BankAccountMaintainenceHandler
		
		if (o instanceof BranchListHandler) {
			BranchListHandler Handler = (BranchListHandler) o;			
			result = Handler.handleRequest(request, response);
			if(result.equals("show")){
				
				requestDispatcher = request.getRequestDispatcher("/branchlist.jsp");
			}

			requestDispatcher.forward(request, response);
		}// BranchListHandler
		
		if (o instanceof NewBranchHandler) {
			NewBranchHandler newbranchhandler = (NewBranchHandler) o;	
			
			result = newbranchhandler.handleRequest(request, response);

			System.out.println(result);
			if (result.equals("Save")) {
				
				requestDispatcher = request.getRequestDispatcher("/NewBranch.jsp");
			}
			if (result.equals("exit")) {
			
				requestDispatcher = request.getRequestDispatcher("/branchlist.jsp");
			}
			else if (result.equals("fail")) {
				
				requestDispatcher = request.getRequestDispatcher("/branchlist.jsp");
			}
			else
			{
				requestDispatcher = request.getRequestDispatcher("/NewBranch.jsp");
			}
			
			//request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// NewBranchHandler
		
		
		if (o instanceof BranchDetailHandler) {
			BranchDetailHandler branchdetailhandler = (BranchDetailHandler) o;			
			result = branchdetailhandler.handleRequest(request, response);
			
			if (result.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("/maintainBankBranch.jsp");
			}
			if (result.equals("delete")) {
				requestDispatcher = request.getRequestDispatcher("/branchlist.jsp");
			}
			
			else if (result.equals("fail")) {
				requestDispatcher = request.getRequestDispatcher("/branchlist.jsp");
			}
			
			requestDispatcher.forward(request, response);
		}// BranchDetailHandler
		
		if (o instanceof BranchUpdateHandler) {
			BranchUpdateHandler UpdateHandler = (BranchUpdateHandler) o;
			
			result = UpdateHandler.handleRequest(request, response);
		
			System.out.println(result);
			if (result.equals("success")) {
				
				requestDispatcher = request.getRequestDispatcher("/maintainBankBranch.jsp");
			}
			else if (result.equals("fail")) {
				
				requestDispatcher = request.getRequestDispatcher("/branchlist.jsp");
			}
			else if (result.equals("exit")) {
			
				requestDispatcher = request.getRequestDispatcher("/branchlist.jsp");
			}
			
			requestDispatcher.forward(request, response);
		}// BranchUpdateHandler
		
		
		//Ended by ZarniMMM
		
		if (o instanceof CustomerHandler) {
			CustomerHandler customerhandler = (CustomerHandler) o;			
			result = customerhandler.handleRequest(request, response);
			
			if (result.equals("success")) {
				//message = "You are successfully point";
				requestDispatcher = request.getRequestDispatcher("/customerlist.jsp");
			}
//			
			 if (result.equals("fail")) {
				message = "invalid username and  password,please try again";
				requestDispatcher = request.getRequestDispatcher("/pages/home.jsp");
			}
			
			//request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// CustomerHandler
		
		if (o instanceof CustomerDetailHandler) {
			CustomerDetailHandler customerdetailhandler = (CustomerDetailHandler) o;			
			result = customerdetailhandler.handleRequest(request, response);
			
			if (result.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("/maintainCustomer.jsp");
			}
			if (result.equals("delete")) {
				requestDispatcher = request.getRequestDispatcher("/customerlist.jsp");
			}
			
			else if (result.equals("fail")) {
				requestDispatcher = request.getRequestDispatcher("/customerlist.jsp");
			}
			
			requestDispatcher.forward(request, response);
		}// CustomerDetailHandler
		
		
		if (o instanceof NewCustomerHandler) {
			NewCustomerHandler newcustomerhandler = (NewCustomerHandler) o;	
			
			result = newcustomerhandler.handleRequest(request, response);
			//result = request.getAttribute("newcustomer");
			System.out.println(result);
			if (result.equals("Save")) {
				//message = "You are successfully jump";
				requestDispatcher = request.getRequestDispatcher("/NewCustomer.jsp");
			}
			if (result.equals("exit")) {
				//message = "You are successfully jump";
				requestDispatcher = request.getRequestDispatcher("/customerlist.jsp");
			}
			else if (result.equals("fail")) {
				//message = "invalid username and  password,please try again";
				requestDispatcher = request.getRequestDispatcher("/customerlist.jsp");
			}
			else
			{
				requestDispatcher = request.getRequestDispatcher("/NewCustomer.jsp");
			}
			
			//request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// NewCustomerHandler
		
		if (o instanceof PerformUpdateHandler) {
			PerformUpdateHandler performUpdateHandler = (PerformUpdateHandler) o;	
			
			result = performUpdateHandler.handleRequest(request, response);
			//result = request.getAttribute("newcustomer");
			System.out.println(result);
			if (result.equals("Update")) {
				//message = "You are successfully jump";
				requestDispatcher = request.getRequestDispatcher("/maintainCustomer.jsp");
			}
			else if (result.equals("fail")) {
				
				requestDispatcher = request.getRequestDispatcher("/maintainCustomer.jsp");
			}
			else if (result.equals("exit")) {
				//message = "You are successfully jump";
				requestDispatcher = request.getRequestDispatcher("/customerlist.jsp");
			}
			
			//request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// NewCustomerHandler

		

		
		//Created by Sapphira in jun 13
		if (o instanceof CustomerChangePasswordHandler) {
			CustomerChangePasswordHandler customerchangepasswordhandler = (CustomerChangePasswordHandler) o;			
			result = customerchangepasswordhandler.handleRequest(request, response);
			
			if (result.equals("success")) {
				message = "You are successfully changing password";
				requestDispatcher = request.getRequestDispatcher("/customerChangePassword.jsp");
			}
		
			else if (result.equals("OldPasswordIsWrong")) {
				message = "Password entered by you is  wrong,please try again";
				requestDispatcher = request.getRequestDispatcher("/customerChangePassword.jsp");
			}
			else if(result.equals("NewConfirmPasswordMismatch")){
				message = "your new password is diffrent from the confim password,please try again";
			requestDispatcher = request.getRequestDispatcher("/customerChangePassword.jsp");
			}
			else if (result.equals("fail")) {
				
				requestDispatcher = request.getRequestDispatcher("/pages/home.jsp");
			}
				
			request.setAttribute("message",message);
			requestDispatcher.forward(request, response);
		}// ChangePasswordHandler
		
	}

	public void init() {
		map = new HashMap();	
		map.put("/login.iss", new LoginHandler());
		map.put("/logout.iss", new LogoutHandler());
		map.put("/bankAccountHandler.iss", new BankAccountHandler());
        map.put("/withdraw.iss", new WithdrawHandler());
        map.put("/deposit.iss", new DepositHandler());
        map.put("/fundsTransfer.iss", new FundsTransferHandler());
        map.put("/transaction.iss", new TransactionHandler());
        map.put("/accountSummary.iss", new AccountSummaryHandler());
        
        map.put("/BankAccountListing.iss", new CustomerBankAccountHandler());
		map.put("/BankAccount.iss", new BankAccountMaintainenceHandler());
		map.put("/JointBankAccount.iss", new JointBankAccountHandler());
		
		map.put("/BranchListing.iss", new BranchListHandler());
		
		map.put("/BranchDetail.iss", new BranchDetailHandler());
		map.put("/NewBranch.iss", new NewBranchHandler());
		map.put("/BranchUpdate.iss", new BranchUpdateHandler());
		
		map.put("/CustomerListing.iss", new CustomerHandler());
		map.put("/customerDetail.iss", new CustomerDetailHandler());
		map.put("/Newcustomer.iss", new NewCustomerHandler());
		map.put("/performUpdate.iss", new PerformUpdateHandler());
		map.put("/ChangePassword.iss", new CustomerChangePasswordHandler());//Created by Sapphira in jun 13
	}

	Map map;
	String result;
	RequestDispatcher requestDispatcher = null;

}
