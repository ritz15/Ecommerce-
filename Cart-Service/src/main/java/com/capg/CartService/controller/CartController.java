package com.capg.CartService.controller;

import com.capg.CartService.exception.CartException;
import com.capg.CartService.model.Cart;
import com.capg.CartService.service.CartService;
import com.capg.CartService.service.CartServiceImpl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//
//@CrossOrigin(origins="localhost:3000/")
@RestController
@RequestMapping("/api/v4")
@CrossOrigin("*")
public class CartController {

    @Autowired
    CartServiceImpl service;
//
//    @PostMapping("/save")
//    public Cart addCart(Cart cart){
//        return service.addCart(cart);
//    }
    
    //@RequestMapping(method=RequestMethod.POST ,value= "/add")
    
   
//    public void addTopic(@RequestBody Cart cart) throws CartException {
//    	 service.addCart(cart);
//    }
    
    @PostMapping("/add")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart) throws CartException{
    	if(cart != null) {
    		try {
    			service.addCart(cart);
    	        return new ResponseEntity<Cart>(
    	        		cart,
    	        		HttpStatus.CREATED);
    		}catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<Cart>(
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
    	}
    	return new ResponseEntity<Cart>(
    			HttpStatus.BAD_REQUEST);       
    }

    @GetMapping("/getAllCarts")
    public ResponseEntity<List<Cart>> getallcarts() throws CartException {
        List<Cart> resultCart = service.getallcarts();
        return new ResponseEntity<List<Cart>>(resultCart, HttpStatus.OK);
    }
    @GetMapping("/cartbyId/{cartId}")
    public ResponseEntity<Object> getcartById(@PathVariable int cartId) throws CartException
    {
        Cart resultCart;
        try {
            resultCart = service.getcartById(cartId);
            return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
        } catch (CartException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/update/{cartId}")
    public ResponseEntity<Object> updateCart(@RequestBody Cart cart,@PathVariable int cartId) throws CartException
    {
        Cart resultCart;
        try {
            resultCart = service.updateCart(cartId, cart);
           
            return new ResponseEntity<Object>(resultCart, HttpStatus.OK);
        } catch (CartException e) {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
   
    





}
