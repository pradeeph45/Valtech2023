package com.valtech.training.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private String productName;
	
	private int productAmount;
	@ManyToOne(targetEntity = Company.class,fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "PRODUCT_ID",referencedColumnName = "companyId")
	private Company company;
	
	public Product(String productName, int productAmount) {
		super();
		this.productName = productName;
		this.productAmount = productAmount;
	}
	public Product() {
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public int getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productAmount=" + productAmount
				+ ", company=" + company.getCompanyName() + "]";
	}
	
	
	
}
