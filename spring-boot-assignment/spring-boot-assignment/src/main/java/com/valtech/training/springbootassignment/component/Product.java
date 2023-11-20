package com.valtech.training.springbootassignment.component;

public class Product {

	private int productId;
	private String productName;
	private int manufacturerId;
	private double productAmt;
	public Product() {
	}
	public Product(int productId, String productName, int manufacturerId, double productAmt) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.manufacturerId = manufacturerId;
		this.productAmt = productAmt;
	}
	public Product(String productName, int manufacturerId, double productAmt) {
		super();
		this.productName = productName;
		this.manufacturerId = manufacturerId;
		this.productAmt = productAmt;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public double getProductAmt() {
		return productAmt;
	}
	public void setProductAmt(double productAmt) {
		this.productAmt = productAmt;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", manufacturerId=" + manufacturerId
				+ ", productAmt=" + productAmt + "]";
	}
	
}
