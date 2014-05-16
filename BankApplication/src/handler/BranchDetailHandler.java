package handler;

import java.io.IOException;
//import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import businesslogic.BranchBL;
import dto.BranchDetails;


public class BranchDetailHandler implements Handler {
	
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		String method = request.getParameter("method");
		String result = "fail";
		String para = request.getParameter("ID");
		if(method.equals("viewdetail")){
			//int bid = Integer.parseInt(para);
				
				BranchDetails br=new BranchBL().getBranchDetailsByID(Integer.parseInt(para));
				request.setAttribute("br", br);
				
				result = "success";
				
			}
		 if(method.equals("delete")){
			// int bid = Integer.parseInt(para);
			 BranchDetails br = new BranchDetails();
			 br.setId(Integer.parseInt(para));
			 try {
				new BranchBL().deleteBranchDetails(br);
				result= "delete";
				ArrayList<BranchDetails> branchdetails =new BranchBL().getAllBranchDetails();
				request.setAttribute("branchdetails",branchdetails);
				request.setAttribute("message", "Branch List is deleted successfully.");
			} catch (Exception e) {
				System.out.println("exception occured");
				e.printStackTrace();
			}
			// just perform the delete opertion using cid 
			//and redirect to the same page
		}
	
	return result;

	
	}
	
}

