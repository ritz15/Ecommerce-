package com.capgemini.jwt.mongodb.util;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.capgemini.jwt.mongodb.model.Customer;

@FeignClient( value = "UserMicroservice"  , url = "http://localhost:8081/api/v1"  )
public interface FeignClientUtilCustomer {

	
	@PostMapping("/user")
	public ResponseEntity<Customer> saveUser( @RequestBody @Valid Customer user);
	
	@GetMapping("/getUsers")
	public ResponseEntity< List<Customer> >getAllUsers(@RequestHeader("Authorization") String token);
	
	@GetMapping ("/user/{id}")
	public ResponseEntity<Customer> getUserById(@RequestHeader("Authorization") String token, @PathVariable int id);
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Void> update( @Valid @RequestBody Customer user,@PathVariable Customer id);
	
	@DeleteMapping("delete/{id}")
	public  ResponseEntity<String> delete (@RequestHeader("Authorization") String token,@PathVariable ("id") int id);
}
