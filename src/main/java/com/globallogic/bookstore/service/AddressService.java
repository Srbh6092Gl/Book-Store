package com.globallogic.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.globallogic.bookstore.entity.Address;

@Repository
public interface AddressService {

	public List<Address> getAllAddresss();
	public Address getAddressById(int id) throws Exception;
	public Address addAddress(Address address);
	public String deleteAddressById(int id);
	public Address updateAddress(Address address);
	public Address updateAddressById(Address changes,int id) throws Exception;
}