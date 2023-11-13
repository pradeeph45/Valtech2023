package com.valtech.training.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItems {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;
	private int productQuantity;
	private Product product;
	private ProductOrder productOrder;
	
	
	public OrderItems(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public OrderItems() {
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	

}
