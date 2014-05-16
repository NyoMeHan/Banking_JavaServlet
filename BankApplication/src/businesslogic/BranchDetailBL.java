package businesslogic;

import dao.DAOFactory;

public class BranchDetailBL {
	public String getBranchNameByBranchId(int branchId){
		return DAOFactory.geBranchDetailDAO().getBranchNameByBranchId(branchId);
	}
}
