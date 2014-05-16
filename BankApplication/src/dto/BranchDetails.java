package dto;

import java.math.BigInteger;
import java.util.Date;

public class BranchDetails {
	private int id;
	private String branchName,address,email,createdBy;
	private int phone;
	
	private Date createdOn;
	
	public int getId() {
		return id;
	}
		
	

	public BranchDetails(int id, String branchName, String address,
			String email, String createdBy, int phone, Date createdOn) {
		super();
		this.id = id;
		this.branchName = branchName;
		this.address = address;
		this.email = email;
		this.createdBy = createdBy;
		this.phone = phone;
		this.createdOn = createdOn;
	}



	public void setId(int id) {
		this.id = id;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
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

		//Created by Zarni
		public BranchDetails(int id, String branchName) {
			super();
			this.id = id;
			this.branchName = branchName;
		}
				
		 public BranchDetails() {
			super();
		}

	//Ended by Zarni
}
