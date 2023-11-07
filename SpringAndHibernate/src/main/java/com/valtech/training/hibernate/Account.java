package com.valtech.training.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Account {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private double balance;
   private String accountType;
   @OneToMany(targetEntity = Tx.class,cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch = FetchType.LAZY,mappedBy = "account")
   private Set<Tx> txs;
   
   @ManyToMany(targetEntity = Tx.class,fetch = FetchType.LAZY)
   @JoinTable(name="customer_account",joinColumns = @JoinColumn(name="account_id",referencedColumnName = "id"),//This table to join table
   inverseJoinColumns = @JoinColumn(name="customer_id",referencedColumnName = "id"))//Other Table to Join Table
   private Set<Customer> customers;
   
public Account() {
}


public void addTx(Tx tx) {
	if(getTxs()==null) {
		setTxs(new HashSet<Tx>());
	}
	getTxs().add(tx);
}
public void setTxs(Set<Tx> txs) {
	this.txs = txs;
}

public Set<Tx> getTxs() {
	return txs;
}

public Account(double balance, String accountType) {
	this.balance = balance;
	this.accountType = accountType;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

public String getAccountType() {
	return accountType;
}

public void setAccountType(String accountType) {
	this.accountType = accountType;
}


   
}
