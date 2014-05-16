package businesslogic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BranchDetailDAO;
import dao.BranchDetailDAOimpl;
import dto.BranchDetails;
import dao.DAOFactory;


public class BranchBL {
	String result = "";
	
	//Created by ZarniMMM
	DAOFactory factory = new DAOFactory();
	private BranchDetailDAO dao;
	public BranchBL() {
		dao = factory.getBranchDetailsDAO();
	}
public List<BranchDetails> getBranchName() {
		
	BranchDetailDAO dao = factory.getBranchDetailsDAO();
		try {
			List<BranchDetails> list =dao.getBranchinfo();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
//Created by ZarniMMM

public ArrayList<BranchDetails> getAllBranchDetails(){
	ArrayList<BranchDetails> details = null;
	 try {
		 details = new BranchDetailDAOimpl().getAllBranchDetails();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return details;
	
}

public BranchDetails getBranchDetailsByID(int bid) {
	BranchDetails br=null;
	try {
		br=new BranchDetailDAOimpl().getBranchDetailsByID(bid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return br;
}

public String UpdateBranchDetails(BranchDetails b) throws SQLException {
	
	String result = "";
		
	try {
		result= dao.updateBranchDetails(b);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}


public String createNewBranchDetails(BranchDetails b) {
	
	String result = "";
	try {
		result = dao.saveBranchDetails(b);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return result;
}

public String deleteBranchDetails(BranchDetails br) throws Exception {
	String result = "";
	 try {
		 result = dao.deleteBranchDetails(br);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return result;
}

}
