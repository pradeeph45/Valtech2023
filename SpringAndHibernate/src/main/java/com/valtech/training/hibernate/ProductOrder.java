package com.valtech.training.hibernate;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "orderId")})
public class ProductOrder {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long OrderId;
   
   private Date date;
   @ManyToOne
   @JoinColumn(name = "Customer_ID",referencedColumnName = "customerId")
   private ProductCustomer productCustomer;
   
   @Id
   @ManyToOne(optional = false)
   @JoinColumns(value= {
		   @JoinColumn(name="ORDER_ID",referencedColumnName = "orderId"),
		   @JoinColumn(name="PRODUCT_ID",referencedColumnName = "productId")})
   private OrderItems orderItems;
   
public ProductOrder( Date date2) {
	
	this.date = date2;
}
public ProductOrder() {
}
public long getOrderId() {
	return OrderId;
}
public void setOrderId(long orderId) {
	OrderId = orderId;
}

public Date getDate() {
	
	return date;
}
public void setDate(DateFormat date) {
	date = date;
}
public ProductCustomer getProductCustomer() {
	return productCustomer;
}
public void setProductCustomer(ProductCustomer productCustomer) {
	this.productCustomer = productCustomer;
}
@Override
public String toString() {
	return "ProductOrder [OrderId=" + OrderId + ", date=" + date + ", productCustomer=" + productCustomer.getCustomerName() + "]";
}

  
}
