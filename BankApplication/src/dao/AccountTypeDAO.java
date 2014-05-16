package dao;

import java.sql.SQLException;
import java.util.List;

import dto.AccountType;

public interface AccountTypeDAO {
	public double getMinimumBalanceByAccountTypeId(int acountTypeId);
	public List<AccountType> getAccoutType() throws SQLException; //Created by ZarniMMM
}
