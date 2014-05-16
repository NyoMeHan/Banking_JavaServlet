package handler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BranchDetailDAOimpl;
import dto.BranchDetails;

public class BranchUpdateHandler implements Handler {
	@Override
	public String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String result = "";
		BranchDetails updateb = new BranchDetails();

			updateb.setBranchName(request.getParameter("branchName"));
			updateb.setAddress((request.getParameter("address")));
			updateb.setPhone(Integer.parseInt(request.getParameter("phone")));
			updateb.setEmail((request.getParameter("email")));
			
			updateb.setId(Integer.parseInt(request.getParameter("ID")));
				
			BranchDetailDAOimpl BDAOImpl = new BranchDetailDAOimpl();
			
			try {
				result = BDAOImpl.updateBranchDetails(updateb);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.setAttribute("message", "Bank Branch is updated successfully.");
		
			return result;
		
	}
}
