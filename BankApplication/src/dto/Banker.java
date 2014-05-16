package dto;

import java.util.Date;

public class Banker {
	private int id;
	private String firstName,lastName,userId,password;
	private Date dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Banker(int id, String firstName, String lastName, String userId,
			String password, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.password = password;
		this.dob = dob;
	}
	
	
}
