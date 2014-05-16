package dto;

import java.math.BigDecimal;
//import java.util.Date;
import java.sql.Date;

public class CustomerBankAccount {
	private int id;
	private BigDecimal balance;
	private int  branchDetailsId,accountTypeId;
	private String customerId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public int getBranchDetailsId() {
		return branchDetailsId;
	}
	public void setBranchDetailsId(int branchDetailsId) {
		this.branchDetailsId = branchDetailsId;
	}
	public int getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public CustomerBankAccount(int id, BigDecimal balance, int branchDetailsId,
			int accountTypeId, String customerId) {
		super();
		this.id = id;
		this.balance = balance;
		this.branchDetailsId = branchDetailsId;
		this.accountTypeId = accountTypeId;
		this.customerId = customerId;
	}
	
	//Created by ZarniMMM
	private int accountid,customerid;
	private String createdBy;
	private Date createdOn;
	private String loginName,branchName,accountType_Name,accountNumber;
	

	public int getAccountid() {
		return accountid;
	}
	
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAccountType_Name() {
		return accountType_Name;
	}
	public void setAccountType_Name(String accountType_Name) {
		this.accountType_Name = accountType_Name;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public CustomerBankAccount(int accountid,String accountNumber, BigDecimal balance,
			int branchDetailsId, int accountTypeId, int customerid,
			String createdBy, Date createdOn, String loginName,
			String branchName, String accountType_Name) {
		super();
		this.accountid = accountid;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.branchDetailsId = branchDetailsId;
		this.accountTypeId = accountTypeId;
		this.customerid = customerid;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.loginName = loginName;
		this.branchName = branchName;
		this.accountType_Name = accountType_Name;
	}
	
	public CustomerBankAccount(int accountid) {
		super();
		this.accountid = accountid;
	}
	public CustomerBankAccount() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerBankAccount other = (CustomerBankAccount) obj;
		if (accountid != other.accountid)
			return false;
		return true;
	}
	
	//Ended by ZarniMMM
}
