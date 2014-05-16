package handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

import businesslogic.BranchBL;

import dto.BranchDetails;

public class BranchListHandler implements Handler{

	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<BranchDetails> branch =new BranchBL().getAllBranchDetails();
		request.setAttribute("branchdetails",branch);
		
		return "show";

	}

	
	
}
