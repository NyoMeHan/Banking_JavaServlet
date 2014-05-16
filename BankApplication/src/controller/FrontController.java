package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.ApplicationController;

public class FrontController extends HttpServlet {

	public FrontController() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
process(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
process(request,response);
	
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		applicationController.process(request, response);
}

	public void init() throws ServletException {
		applicationController = new ApplicationController();
		applicationController.init();		
		
	}
	
	
	
	ApplicationController applicationController;
}
