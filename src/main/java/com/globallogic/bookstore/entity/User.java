package com.globallogic.bookstore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	private String email;
	
	private String password;
	private String name;
	private long phone;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Book> cart;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Book> order;
	
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public List<Book> getCart() {
		return cart;
	}

	public void setCart(List<Book> cart) {
		this.cart = cart;
	}

	public List<Book> getOrder() {
		return order;
	}

	public void setOrder(List<Book> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + ", cart=" + cart + ", order=" + order + "]";
	}
	
}