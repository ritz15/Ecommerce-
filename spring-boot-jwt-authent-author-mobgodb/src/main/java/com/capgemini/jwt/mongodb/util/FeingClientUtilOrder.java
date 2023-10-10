package com.capgemini.jwt.mongodb.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capgemini.jwt.mongodb.model.Order;

@FeignClient(value = "Order-MicroService",url="http://localhost:8084/api/v3")
   public interface FeingClientUtilOrder {

	@GetMapping("/allorders") 
	public ResponseEntity<List<Order>> getAllOrders();
	
	
	@GetMapping("orders/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable  int id);
	
	@PostMapping("/addOrders") 
	public ResponseEntity<Order> addOrders(@RequestBody Order odto);
	
	@DeleteMapping(path="/orders/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable int id);
	
	
}
