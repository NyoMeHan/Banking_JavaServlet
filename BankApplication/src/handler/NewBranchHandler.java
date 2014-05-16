package handler;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businesslogic.BranchBL;

import dto.BranchDetails;
import dto.CurrentUser;


public class NewBranchHandler implements Handler {
	
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
				BranchDetails b = new BranchDetails();				
				BranchBL branchbl = new BranchBL();
				String method = request.getParameter("method");
				
				String result = "fail";
				if(method.equals("Save")){
					//b.setId(Integer.parseInt(request.getParameter("ID")));
					b.setBranchName(request.getParameter("branchName"));
					b.setAddress((request.getParameter("address")));
					b.setPhone(Integer.parseInt(request.getParameter("phone")));
					b.setEmail((request.getParameter("email")));
					b.setCreatedBy(request.getParameter("createdBy"));
					
					java.util.Date todayDate = new java.util.Date();//set todayDate
					b.setCreatedOn(new java.sql.Date(todayDate.getTime()));
					
						result = branchbl.createNewBranchDetails(b);
						request.setAttribute("newbranch",b);
						java.util.Date todayDate1 = new java.util.Date();
						request.setAttribute("createdon", new java.sql.Date(todayDate1.getTime()));	
						
						//get user name 
						HttpSession session = request.getSession();
						CurrentUser cUser = (CurrentUser)session.getAttribute("currentUser");
						String userName = cUser.getUsername();
						request.setAttribute("createdBy",userName);
						
						request.setAttribute("message", "Bank Branch is saved successfully.");
				}
				else if(method.equals("Exit")){
					ArrayList<BranchDetails> branch =new BranchBL().getAllBranchDetails();
					request.setAttribute("branchdetails",branch);
					result="exit";
				}
				else{
					//default set the current date
						java.util.Date todayDate = new java.util.Date();
						request.setAttribute("createdon", new java.sql.Date(todayDate.getTime()));	
						
						//get user name 
						HttpSession session = request.getSession();
						CurrentUser cUser = (CurrentUser)session.getAttribute("currentUser");
						String userName = cUser.getUsername();
						request.setAttribute("createdBy",userName);
						result = "";
				}

				return result;

			}
	}
	

