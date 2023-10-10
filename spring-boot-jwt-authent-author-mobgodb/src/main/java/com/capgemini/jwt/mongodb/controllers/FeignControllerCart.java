package com.capgemini.jwt.mongodb.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jwt.mongodb.controllers.security.services.SequenceGeneratorService;
import com.capgemini.jwt.mongodb.exception.CartNotFoundException;
import com.capgemini.jwt.mongodb.exception.RecordAlreadyExistsException;
import com.capgemini.jwt.mongodb.model.Cart;
import com.capgemini.jwt.mongodb.util.FeignClientUtilCart;



@RestController
@RequestMapping("/cartController")
public class FeignControllerCart {
	
	@Autowired
	private FeignClientUtilCart feignclientutilcart;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@GetMapping("/getAllCarts")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<List<Cart>> showAllDataInCarts() throws CartNotFoundException {//changed here on 12/07/22 ->11:27pm
		return feignclientutilcart.getallcarts();
	}

	 //only user
	@PostMapping("/add") 
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Cart> addCart(@Valid @RequestBody Cart cart) throws RecordAlreadyExistsException {
		//cart.setId(service.getSequenceNumberForCart(Cart.SEQUENCE_NAME));
		return feignclientutilcart.addCart(cart);
	}

  
	@PutMapping("/update/{cartId}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity<Object> updateCart(@Valid @RequestBody Cart cart ,@PathVariable int cartId ) throws CartNotFoundException {
		return feignclientutilcart.updateCart(cart, cartId );
	}

	  
	 @GetMapping("/cartbyId/{cartId}")
	 @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	 public ResponseEntity<Object> getcartById(@PathVariable int cartId) throws CartNotFoundException {
		return feignclientutilcart.getcartById( cartId); 
	}
}
