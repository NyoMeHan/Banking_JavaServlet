package dto;

//import java.util.Date;
import java.sql.Date;

public class Customer {
	private int id,accountCreatedBy,accountModifiedBy;
	private String firstName,lastName,passport,nationality,gender,email,address,customerId,password,created_By;
	private String userName;
	private Date  created_On;
	private int customerID,phone;
	private Date dob,accountCreatedOn,accountModifiedOn;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAccountCreatedBy() {
		return accountCreatedBy;
	}
	public void setAccountCreatedBy(int accountCreatedBy) {
		this.accountCreatedBy = accountCreatedBy;
	}
	public int getAccountModifiedBy() {
		return accountModifiedBy;
	}
	public void setAccountModifiedBy(int accountModifiedBy) {
		this.accountModifiedBy = accountModifiedBy;
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
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public Date getAccountCreatedOn() {
		return accountCreatedOn;
	}
	public void setAccountCreatedOn(Date accountCreatedOn) {
		this.accountCreatedOn = accountCreatedOn;
	}
	public Date getAccountModifiedOn() {
		return accountModifiedOn;
	}
	public void setAccountModifiedOn(Date accountModifiedOn) {
		this.accountModifiedOn = accountModifiedOn;
	}
	
	public Date getCreated_On() {
		return created_On;
	}
	public void setCreated_On(Date created_On) {
		this.created_On = created_On;
	}

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getCreated_By() {
		return created_By;
	}
	public void setCreated_By(String created_By) {
		this.created_By = created_By;
	}
		
	public Customer(int customerID, int phone, String firstname,
			String lastname, String passport, String nationality,
			String gender, Date dob, String email, String address,
			String loginname, String password, Date created_On,
			String created_By) {
		super();
		this.customerID = customerID;
		this.phone = phone;
		this.firstName = firstname;
		this.lastName = lastname;
		this.passport = passport;
		this.nationality = nationality;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.LoginName = loginname;
		this.password = password;
		this.created_On = created_On;
		this.created_By = created_By;
	}

	//Created by ZarniMMM
	private String LoginName;
		public Customer(int id, String loginName) {
			super();
			this.id = id;
			LoginName = loginName;
		}
					
		public Customer() {
			super();
		}
		public String getLoginName() {
			return LoginName;
		}
		public void setLoginName(String loginName) {
			LoginName = loginName;
		}
		//Ended by ZarniMMM
}
