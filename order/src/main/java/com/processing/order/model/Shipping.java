package com.processing.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="shipping")
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Column
	String productName;
	@Column
	String status;
	public Shipping(String productName, String status) {
		this.productName = productName;
		this.status = status;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
}
