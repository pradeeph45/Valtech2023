package com.valtech.training.hibernate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ctx")
public class ChequeTx extends Tx {
	private int chequeName;
	private int micr;

	public ChequeTx(float amount, int chequeName, int micr) {
		super(amount);
		this.chequeName = chequeName;
		this.micr = micr;
	}

	public ChequeTx() {
		super();
	}

	public ChequeTx(float amount) {
		super(amount);
	}

	public int getChequeName() {
		return chequeName;
	}

	public void setChequeName(int chequeName) {
		this.chequeName = chequeName;
	}

	public int getMicr() {
		return micr;
	}

	public void setMicr(int micr) {
		this.micr = micr;
	}
}
