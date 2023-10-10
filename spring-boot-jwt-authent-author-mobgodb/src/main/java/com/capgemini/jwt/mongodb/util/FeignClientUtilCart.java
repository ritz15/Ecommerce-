package com.capgemini.jwt.mongodb.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.jwt.mongodb.model.Cart;



//@RequestMapping("/cart-service")
@FeignClient(value = "Cart-Service" ,url = "http://localhost:7071/api/v4")
public interface FeignClientUtilCart {
	
	@PostMapping("/add")
    public ResponseEntity<Cart> addCart(@RequestBody Cart cart);

	@GetMapping("/getAllCarts")
    public ResponseEntity<List<Cart>> getallcarts();

    @GetMapping("/cartbyId/{cartId}")
    public ResponseEntity<Object> getcartById(@PathVariable int cartId);
	  
    @PutMapping("/update/{cartId}")
    public ResponseEntity<Object> updateCart(@RequestBody Cart cart,@PathVariable int cartId);
	
}
