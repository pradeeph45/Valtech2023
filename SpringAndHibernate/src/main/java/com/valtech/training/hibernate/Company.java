package com.valtech.training.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Company {
	
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private long companyId;
private String companyName;
private String companyAddr;
@OneToMany(targetEntity = Product.class,mappedBy = "company",fetch=FetchType.EAGER)
private Set<Product> product;



public Company(String companyName, String companyAddr) {
	this.companyName = companyName;
	this.companyAddr = companyAddr;
}
public Company() {
}
public long getCompanyId() {
	return companyId;
}
public void setCompanyId() {
	this.companyId = companyId;
}
public String getCompanyName() {
	return companyName;
}
public void setCompanyName(String company_name) {
	this.companyName = companyName;
}
public String getCompanyAddr() {
	return companyAddr;
}
public void setCompanyAddr(String company_adddr) {
	this.companyAddr = companyAddr;
}
public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> hashSet) {
	this.product = hashSet;
}
public void setCompanyId(long companyId) {
	this.companyId = companyId;
}

public void addProduct(Product product) {
	if(getProduct()==null) {
		setProduct(new HashSet<Product>());
	}
	getProduct().add(product);
	product.setCompany(this);
	
	
}
@Override
public String toString() {
	return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyAddr=" + companyAddr
			+ ", product=" + product.size() + "]";
}


}
