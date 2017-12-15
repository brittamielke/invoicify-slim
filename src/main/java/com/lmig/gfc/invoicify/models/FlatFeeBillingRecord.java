package com.lmig.gfc.invoicify.models;

import javax.persistence.Entity;

@Entity
public class FlatFeeBillingRecord extends BillingRecord {

	// This does NOT need an id because it inherits it from the BillingRecord class
	// This needs a double field named amount
	private double amount;

	public FlatFeeBillingRecord(User createdBy, String description, Company client, double amount) {
		super(createdBy, description, client);
		this.amount = amount;
	}

	public FlatFeeBillingRecord(double amount) {
		super();
		this.amount = amount;
	}

	public FlatFeeBillingRecord() {
	}

	// This needs to override the getTotal() method and return the amount
	// This needs getters and setters

	@Override
	public double getTotal() {
		double total = amount;
		return total;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
