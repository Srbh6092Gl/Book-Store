package com.globallogic.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bookstore.entity.Address;
import com.globallogic.bookstore.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {


	@Autowired
	AddressService addressService;
	
	//GET requests
	
	//GET request for fetching all Address
	@GetMapping
	public List<Address> getAllAddresss(){
		return addressService.getAllAddresss();
	}
	
	//GET request for fetching a Address by ID
	@GetMapping("/{id}")
	public Address getAddressById(@PathVariable int id) throws Exception {
		return addressService.getAddressById(id);
	}
	
	
	//POST requests
	
	//POST request to add a Address
	@PostMapping
	public Address addAddress( @RequestBody Address address) {
		return addressService.addAddress(address);
	}
	
	
	//DELETE requests
	
	//DELETE request to delete a Address by id
	@DeleteMapping("/{id}")
	public String deleteAddressById(@PathVariable int id) {
		return addressService.deleteAddressById(id);
	}
	
	//PUT requests
	
	//PUT request to update a Address
	//If any field is missing, it will take default value for the respective field
	@PutMapping
	public Address updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}
	
	//PUT request to update a Address by id
	//If any field is missing, it will take default value for the respective field
	@PutMapping("/{id}")
	public Address updateAddressById(@RequestBody Address changes,@PathVariable int id) throws Exception {
		return addressService.updateAddressById(changes,id);
	}
}
