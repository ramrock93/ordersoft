package com.example.models;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private int phone;

	@Column(name = "email")
	private String email;

	@OneToOne
	private Address currentAddress;

	@OneToMany
	private List<Order> orders;

	public String getName() {
		return name;
	}

	public Customer(String name, int phone, String email, Address address) {
		super();

		this.orders = new LinkedList<Order>();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.currentAddress = address;
	}

	protected Customer() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean addOrder(Order order) {
		boolean added = false;

		if (order.getId() != 0) {
			added = this.orders.add(order);
		}
		return added;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}
}