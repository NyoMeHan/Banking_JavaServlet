//Created by ZarniMMM

package handler;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businesslogic.CustomerBankAccountBL;
import businesslogic.CustomerBL;
import businesslogic.AccountTypeBL;
import businesslogic.BranchBL;

import dto.CurrentUser;
import dto.CustomerBankAccount;
import dto.Customer;
import dto.AccountType;
import dto.BranchDetails;

import exception.NotFoundException;

public class BankAccountMaintainenceHandler implements Handler {
	String result = null, validmsg = null;
	@Override
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String buttonvalue = request.getParameter("button");
		//String para =  request.getParameter("accountID");
		
		if(buttonvalue==null){ buttonvalue = "default";}
		
			switch(buttonvalue) 
			{
			case "Submit": result = CheckAction(request,response);
									GotoList(request,response);
							break;
			case "Delete":  result = DeleteData(request,response);
							if(result.equals("Delete Success"))
							{GotoList(request,response);}
									
							break;
			case "Clear":  ListDataBind(request,response);	
							result = "show";
							break;
			case "New Account"	 : 	ListDataBind(request,response);	
									result = "show";
									break;
			case "Exit":  	GotoList(request,response);
							result = "exit";
							break;
			
			default		 :  result = ShowData(request,response);
							break;
			}
		
		
		return result;
	}
	
	
	private String ShowData(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String para =  request.getParameter("accountID");
			
		if( para != null)
		{
			//for Bank Account data binding
			CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
			CustomerBankAccount detail = new CustomerBankAccount();
			try {
					detail = customerBankAccountbl.getDetailbyID(Integer.parseInt(para));
					ListDataBind(request,response);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("AccountID", detail.getAccountid());
			request.setAttribute("AccountNumber", detail.getAccountNumber());
			request.setAttribute("Balance", detail.getBalance());
			request.setAttribute("BindBranch", detail.getBranchDetailsId());
			
			request.setAttribute("BindAcType", detail.getAccountTypeId());
			
			request.setAttribute("BindCustomer",detail.getCustomerid());
			request.setAttribute("Created_By", detail.getCreatedBy());
			//java.util.Date todayDate = new java.util.Date();
			//request.setAttribute("Created_On", new java.sql.Date(todayDate.getTime()));
			request.setAttribute("Created_On",detail.getCreatedOn());
		}
							
		String result = "show";
		return result;
	}
	
	private String CheckAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String para =  request.getParameter("AccountID");
		if(para == null || para==""){
			result = SaveData(request,response);
		}else{
			result = UpdateData(request,response);
		}
	return result;
		
	}
	private String SaveData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//String result = null;
		
		if(ValidEntry(request,response)==true)
			{ ListDataBind(request,response);result = validmsg;}
		else{
			CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
			CustomerBankAccount detail = new CustomerBankAccount();
				
				detail.setAccountNumber(request.getParameter("AccountNumber"));
				BigDecimal balance = new BigDecimal(request.getParameter("Balance"));//cast string to bigdecimal
				detail.setBalance(balance);
				detail.setAccountTypeId( Integer.parseInt(request.getParameter("AcType")));
				detail.setCustomerid( Integer.parseInt(request.getParameter("customer")));
				detail.setBranchDetailsId( Integer.parseInt(request.getParameter("Branch")));
				//detail.setCreatedBy(request.getParameter("Created_By"));
								
				HttpSession session = request.getSession();
				CurrentUser cUser = (CurrentUser)session.getAttribute("currentUser");
				String userName = cUser.getUsername();
				detail.setCreatedBy(userName);
				
				
				java.util.Date todayDate = new java.util.Date();// get today date.
				
				detail.setCreatedOn(new java.sql.Date(todayDate.getTime()));
				
				result = customerBankAccountbl.saveBankAccount(detail);
			}
			return result;		
		
	}
	private String UpdateData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(ValidEntry(request,response)==true)
			{ListDataBind(request,response);result = validmsg;}
		else{
			CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
			CustomerBankAccount detail = new CustomerBankAccount();
			//Integer acid = Integer.parseInt((String) request.getAttribute("AccountID"));
			
			detail.setAccountid(Integer.parseInt(request.getParameter("AccountID")));
			detail.setAccountNumber(request.getParameter("AccountNumber"));
			BigDecimal balance = new BigDecimal(request.getParameter("Balance"));//cast string to bigdecimal
			detail.setBalance(balance);
			detail.setAccountTypeId( Integer.parseInt(request.getParameter("AcType")));
			detail.setCustomerid( Integer.parseInt(request.getParameter("customer")));
			detail.setBranchDetailsId( Integer.parseInt(request.getParameter("Branch")));
			
			
			result = customerBankAccountbl.updateBankAccount(detail);
		}
		return result;
	}

	private String DeleteData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//String result = null;
		CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
		CustomerBankAccount detail = new CustomerBankAccount();
		String acid = request.getParameter("accountID");
		if(acid != null){
			detail.setAccountid(Integer.parseInt(acid));
			result = customerBankAccountbl.deleteBankAccount(detail);
		}else{
			result = "No Account Number to delete!";ListDataBind(request,response);
		}
		return result;
	}
	

	private void GotoList(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
		ArrayList<CustomerBankAccount> accountlist = customerBankAccountbl.getBankAccountList();
		request.setAttribute("slist", accountlist);
	
		
	}
	
	private void ListDataBind(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		//for Customer list
		CustomerBL cusbl = new CustomerBL();
		List<Customer> cus = new ArrayList<Customer>();
		cus =  cusbl.getCustLoginName();
		request.setAttribute("scus", cus);
		
		//for Account Type list
		AccountTypeBL actypebl = new AccountTypeBL();
		List<AccountType> aclist = new ArrayList<AccountType>();
		aclist =  actypebl.getAcountTypeList();
		request.setAttribute("sAcType", aclist);
		
		//for Branch Name list
		BranchBL branchbl = new BranchBL();
		List<BranchDetails> branchlist = new ArrayList<BranchDetails>();
		branchlist =  branchbl.getBranchName();
		request.setAttribute("sBranch", branchlist);
		//get user name 
		HttpSession session = request.getSession();
		CurrentUser cUser = (CurrentUser)session.getAttribute("currentUser");
		String userName = cUser.getUsername();
		request.setAttribute("Created_By",userName);
		
		//default set the current date
		java.util.Date todayDate = new java.util.Date();
		request.setAttribute("Created_On", new java.sql.Date(todayDate.getTime()));	
	}
	private Boolean ValidEntry(HttpServletRequest request,HttpServletResponse response){
		Boolean flag = false;
		CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
		String s = (String) request.getParameter("AccountNumber");
		String para =  request.getParameter("AccountID");
		//int acid = Integer.parseInt(para);
		
		if(s.length() == 0)
			{validmsg = "Please Enter your Account Number"; flag = true; return flag;}
		else if (request.getParameter("Balance").length()==0 )
			{validmsg = "Please Enter the Balance Amount"; flag = true;return flag;}
		
		int count = customerBankAccountbl.CheckbyAccountNumber(s);
		if(count>0 && para=="" ){validmsg = "Account Number is existing.Please enter the new Account Number"; flag = true; return flag;}
		
		
		return flag;		
	}
}
//Ended by ZarniMMM