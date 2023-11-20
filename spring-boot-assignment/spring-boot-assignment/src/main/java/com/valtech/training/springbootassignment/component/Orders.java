package com.valtech.training.springbootassignment.component;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Orders {

	private int orderId;
	private int customerId;
	@Basic @Temporal(TemporalType.DATE)
	private Date orderDate;
	public Orders() {
		super();
	}
	public Orders(int orderId, int customerId, Date orderDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
	}
	public Orders(int customerId, java.util.Date date) {
		super();
		this.customerId = customerId;
		this.orderDate = (Date) date;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date date) {
		this.orderDate = date;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + "]";
	}
	
}
