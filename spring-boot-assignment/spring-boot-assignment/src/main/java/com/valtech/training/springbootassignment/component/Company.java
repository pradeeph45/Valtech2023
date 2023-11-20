package com.valtech.training.springbootassignment.component;


public class Company {

	private int companyId;
	private String companyName;
	private String companyAddr;
	public Company() {
	}
	public Company(int companyId, String companyName, String companyAddr) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddr = companyAddr;
	}
	public Company(String companyName, String companyAddr) {
		this.companyName = companyName;
		this.companyAddr = companyAddr;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAddr=" + companyAddr
				+ "]";
	}
	
}
