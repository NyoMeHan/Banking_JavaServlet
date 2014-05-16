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

public class JointBankAccountHandler implements Handler {
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
									 GotoList(request,response);
							break;
							
			case "Clear": 	ListDataBind(request,response);	
							result = "show";
							break;
//			case "New Account"	 : 	ListDataBind(request,response);	
//									result = "show";
//									break;
			case "Exit":  	GotoList(request,response);
							result = "exit";
							break;
			
			default		 : 	ListDataBind(request,response);	
							result = "show";
							break;
			}
		
		
		return result;
	}
	private String CheckAction(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String para =  request.getParameter("AccountID");
		if(para == null || para==""){
			result = SaveData(request,response);
		}
	return result;
		
	}
	private String SaveData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//String result = null;
		CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
		if(ValidEntry(request,response)==true)
				{ ListDataBind(request,response);result = validmsg;}
		else{
			
				CustomerBankAccount jointcheck = new CustomerBankAccount();
				 String accnumber = request.getParameter("AccountNumber");
				
					try {
						jointcheck = customerBankAccountbl.jointCheck(accnumber);
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//For joint Account, AcType,BranchName, should be the same except customerid.
					
					CustomerBankAccount detail = new CustomerBankAccount();
					detail.setAccountNumber(jointcheck.getAccountNumber());
					
					detail.setBalance(jointcheck.getBalance());
					detail.setAccountTypeId(jointcheck.getAccountTypeId());
					detail.setCustomerid( Integer.parseInt(request.getParameter("customer")));
					detail.setBranchDetailsId(jointcheck.getBranchDetailsId());
																
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
	
/*	private String UpdateData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if(ValidEntry(request,response)==true)
			{ListDataBind(request,response);result = validmsg;}
		else{
			CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
			CustomerBankAccount detail = new CustomerBankAccount();
			
			
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
	}*/

	private String DeleteData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		//String result = null;
		CustomerBankAccountBL customerBankAccountbl = new CustomerBankAccountBL();
		CustomerBankAccount detail = new CustomerBankAccount();
		String acid = request.getParameter("accountID");
		if(acid != null){
			detail.setAccountid(Integer.parseInt(acid));
			result = customerBankAccountbl.deleteBankAccount(detail);
		}
		else{
			
			result="Please insert the Account Number that you want to delete";
			ListDataBind(request,response);
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
		CustomerBankAccount jointcheck = new CustomerBankAccount();
		String s = (String) request.getParameter("AccountNumber");
		String customerid = request.getParameter("customer");
		int cusid= Integer.parseInt(customerid);
		
		if(s.length() == 0)
			{validmsg = "Please Enter your Account Number"; flag = true; return flag;}
		else if (request.getParameter("Balance").length()==0 )
			{validmsg = "Please Enter the Balance Amount"; flag = true;return flag;}
		
		int count = customerBankAccountbl.CheckbyAccountNumber(s);
		if(count>0){
			
				CustomerBankAccountBL cusbl = new CustomerBankAccountBL();
			
					try {
						jointcheck = cusbl.jointCheck(s);
						if(cusid == jointcheck.getCustomerid()){
							validmsg = "Please select the new customer which you want to joint your account!";
							flag = true;
						}
						
					} catch (NotFoundException e) {
						
						e.printStackTrace();
					}				
			}
		else if(count ==0)
		{
			validmsg = "Account Number Invalid!Please enter the correct Account Number which you want to join!";
			flag = true;
		}
		
		return flag;		
	}
}
//Ended by ZarniMMM