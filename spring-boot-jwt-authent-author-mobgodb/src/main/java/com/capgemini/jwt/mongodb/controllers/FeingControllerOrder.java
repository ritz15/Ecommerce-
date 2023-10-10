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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.util.FeingClientUtilOrder;
import com.capgemini.jwt.mongodb.exception.OrderNotFoundException;
import com.capgemini.jwt.mongodb.model.Order;

@RestController
@RequestMapping("/order-service")
public class FeingControllerOrder {
		
		@Autowired
		private FeingClientUtilOrder feignclientutilorder;
		
		@Autowired
		private SequenceGeneratorService service;
		
		
		@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
		@GetMapping("/allorders") 
		public ResponseEntity<List<Order>> getAllOrders() throws OrderNotFoundException {
			return feignclientutilorder.getAllOrders();
		}

		 //only user
		@PostMapping("/addOrders") 
		@PreAuthorize("hasAuthority('ROLE_USER')")
		public ResponseEntity<Order> addOrders(@RequestBody Order odto) {
			return feignclientutilorder.addOrders(odto);
		}

	  
		  
		@DeleteMapping(path="/orders/{id}")
		@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
		public ResponseEntity<String> deleteOrder(@PathVariable int id) throws OrderNotFoundException {
			return feignclientutilorder.deleteOrder( id); 
		}
	}



