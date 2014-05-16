package dto;

public class Transaction {
	private int transactionId,fromCustomerId,toCustomerId,customerAccountId;
	private double amount;
	private java.sql.Date transactionDate;
	private String status,fromCustomerAccountNumber,toCustomerAccountNumber;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getFromCustomerId() {
		return fromCustomerId;
	}
	public void setFromCustomerId(int fromCustomerId) {
		this.fromCustomerId = fromCustomerId;
	}
	public int getToCustomerId() {
		return toCustomerId;
	}
	public void setToCustomerId(int toCustomerId) {
		this.toCustomerId = toCustomerId;
	}
	public int getCustomerAccountId() {
		return customerAccountId;
	}
	public void setCustomerAccountId(int customerAccountId) {
		this.customerAccountId = customerAccountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public java.sql.Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(java.sql.Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFromCustomerAccountNumber() {
		return fromCustomerAccountNumber;
	}
	public void setFromCustomerAccountNumber(String fromCustomerAccountNumber) {
		this.fromCustomerAccountNumber = fromCustomerAccountNumber;
	}
	public String getToCustomerAccountNumber() {
		return toCustomerAccountNumber;
	}
	public void setToCustomerAccountNumber(String toCustomerAccountNumber) {
		this.toCustomerAccountNumber = toCustomerAccountNumber;
	}
	
	
}
