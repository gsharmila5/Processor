package com.processing.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "membership")
public class MemberShip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Column
	String name;

	@Column
	String status;
	@Column
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberShip(String name, String status,String email) {
		this.name = name;
		this.status = status;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
