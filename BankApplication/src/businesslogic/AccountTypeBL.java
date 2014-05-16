package businesslogic;

import java.sql.SQLException;

import java.util.List;

import dao.AccountTypeDAO;
import dao.DAOFactory;
import dto.AccountType;


public class AccountTypeBL {
	//Created by ZarniMMM
	DAOFactory factory = new DAOFactory();
public List<AccountType> getAcountTypeList() {
		
		AccountTypeDAO dao = factory.getAccountTypeDAO();
		try {
			List<AccountType> list = dao.getAccoutType();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
}
