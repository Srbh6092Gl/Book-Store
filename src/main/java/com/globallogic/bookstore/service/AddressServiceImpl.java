package com.globallogic.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bookstore.entity.Address;
import com.globallogic.bookstore.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	AddressRepository addRepo;

	@Override
	public List<Address> getAllAddresss() {
		return addRepo.findAll();
	}

	@Override
	public Address getAddressById(int id) throws Exception {
		Optional<Address> response = addRepo.findById(id);
		if(response.isEmpty())
			throw new Exception("Address not found");
		return response.get();
	}

	@Override
	public Address addAddress(Address address) {
		return addRepo.save(address);
	}

	@Override
	public String deleteAddressById(int id) {
		addRepo.deleteById(id);
		return "Delete ID="+id+": SUCCESS";
	}

	@Override
	public Address updateAddress(Address address) {
		return addRepo.save(address);
	}

	@Override
	public Address updateAddressById(Address changes, int id) throws Exception {
		Address Address = getAddressById(id);
		return addRepo.save(Address);
	}
}
