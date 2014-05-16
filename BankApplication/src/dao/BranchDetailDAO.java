package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AccountType;
import dto.BranchDetails;

public interface BranchDetailDAO {
	public List<BranchDetails> getBranchinfo() throws SQLException;

	public String getBranchNameByBranchId(int branchId); //Created by ZarniMMM
	
	public String authenticate(BranchDetails branchdetails);
	
	public String saveBranchDetails(BranchDetails branchdetails) throws SQLException;
	
	public String updateBranchDetails(BranchDetails branchdetails) throws SQLException;
	
	public String deleteBranchDetails(BranchDetails branchdetails) throws  SQLException, Exception;	 
	
	public ArrayList<BranchDetails> getAllBranchDetails() throws SQLException;
	
	
	

}
