package com.capgemini.jwt.mongodb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.CustomerNotFoundException;
import com.capgemini.jwt.mongodb.exception.NoProperDataException;
import com.capgemini.jwt.mongodb.model.Customer;
import com.capgemini.jwt.mongodb.util.FeignClientUtilCustomer;

@RestController
@RequestMapping("/userController")
public class FeignControllerCustomer {
	

	@Autowired
	private FeignClientUtilCustomer feigncustomer;
	
	
	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/allcustomers") 
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Customer>> getAllUsers(@RequestHeader("Authorization") String token) throws CustomerNotFoundException
	{
		
		return feigncustomer.getAllUsers(token);
		
	}
	
	@GetMapping("/customers/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_USER') ")
	public ResponseEntity<Customer> getCustomerById(@Valid @RequestHeader("Authorization") String token,@PathVariable  Integer id)
	throws CustomerNotFoundException{
		return feigncustomer.getUserById(token,id);
	}
	
	@PostMapping("/addCustomers") 
	@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_USER')")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)  throws NoProperDataException
	{
		return feigncustomer.saveUser(customer);
	}


	@DeleteMapping(path="/customers/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<String> deleteCustomer(@Valid @RequestHeader("Authorization") String token,@PathVariable int id) throws CustomerNotFoundException {
			return feigncustomer.delete(token,id);
	}

}