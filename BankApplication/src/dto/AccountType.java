package dto;

import java.math.BigDecimal;

public class AccountType {
	private int id;
	private String type,remark;
	private BigDecimal minimumBalance;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public BigDecimal getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(BigDecimal minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public AccountType(int id, String type, String remark,
			BigDecimal minimumBalance) {
		super();
		this.id = id;
		this.type = type;
		this.remark = remark;
		this.minimumBalance = minimumBalance;
	}
	//Created by ZarniMMM
	
		public AccountType(int id, String type) {
			super();
			this.id = id;
			this.type = type;
		}
	//Ended by ZarniMMM
}
