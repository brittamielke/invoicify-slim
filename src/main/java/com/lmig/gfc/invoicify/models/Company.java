package com.lmig.gfc.invoicify.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

// This needs to be an entity
@Entity
public class Company {

	// This needs an id
	// This needs a name
	// This needs a list of invoice objects named invoices as one-to-many
	// relationship mapped by "company"

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "company")
	private List<Invoice> invoices;

	public Company() {
	}

	public Company(String name) {
		this.name = name;
	}

	// Lots of getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

}
