package com.processing.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="orders")
public class Order {
	@Column
	String type;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long orderNumber;
	@Column
	String owner;
	@Column
	double cost;
	public Order(String type, String owner, double cost) {
		this.type = type;
		this.owner = owner;
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public long getOrderNumber() {
		return orderNumber;
	}
	@Override
	public String toString() {
		return "Order [type=" + type + ", orderNumber=" + orderNumber + ", owner=" + owner + ", cost=" + cost + "]";
	}
}
