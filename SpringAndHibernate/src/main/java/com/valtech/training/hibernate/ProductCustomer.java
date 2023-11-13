package com.valtech.training.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class ProductCustomer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String customerName;
	private String customerPhone;
	private String customerAddr;
	@OneToMany(targetEntity = ProductOrder.class,mappedBy = "productCustomer")
	private List<ProductOrder> productOrder;
	public ProductCustomer(String customerName, String customerPhone, String customerAddr) {
		super();
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerAddr = customerAddr;
	}
	public ProductCustomer() {
	}
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
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
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	public List<ProductOrder> getOrder() {
		return productOrder;
	}
	public void setOrder(List<ProductOrder> productOrder) {
		this.productOrder = productOrder;
	}
	public void addProductOrder(ProductOrder p) {
		if(getOrder()==null) {
			setOrder(new ArrayList<ProductOrder>());
		}
		getOrder().add(p);
		p.setProductCustomer(this);
		
	}
	@Override
	public String toString() {
		return "ProductCustomer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerAddr=" + customerAddr + ", productOrder=" + productOrder.size() + "]";
	}
	
	
}
