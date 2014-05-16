package dto;

public class AccountSummary {
	private int accountId;
	private String accountNumber,branchName;
	private java.sql.Date createdOn;
	private double balance;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public java.sql.Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(java.sql.Date createdOn) {
		this.createdOn = createdOn;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
