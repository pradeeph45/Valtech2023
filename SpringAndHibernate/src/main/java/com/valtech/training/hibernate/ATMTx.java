package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("atx")
public class ATMTx extends Tx {
	private int atm;

	public ATMTx(float amount, int atm) {
		super(amount);
		this.atm = atm;
	}

	public ATMTx() {
		super();
	}

	public int getAtm() {
		return atm;
	}

	public void setAtm(int atm) {
		this.atm = atm;
	}

}
