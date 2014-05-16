package dto;

import java.io.Serializable;

public class AccountNumberIdPair implements Serializable{

	private int id;
	private String accountNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
}
