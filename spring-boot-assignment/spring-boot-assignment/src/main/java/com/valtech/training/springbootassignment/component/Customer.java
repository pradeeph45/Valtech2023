package com.valtech.training.springbootassignment.component;

public class Customer {

	private int customerId;
	private String customerName;
	private String customerPhone;
	private String customerAdddress;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customerName, String customerPhone, String customerAdddress) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAdddress = customerAdddress;
	}
	public Customer(String customerName, String customerPhone, String customerAdddress) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAdddress = customerAdddress;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerAdddress() {
		return customerAdddress;
	}
	public void setCustomerAdddress(String customerAdddress) {
		this.customerAdddress = customerAdddress;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerAdddress=" + customerAdddress + "]";
	}
	
}
