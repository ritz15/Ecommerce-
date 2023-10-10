
  package com.capgemini.jwt.mongodb.util;
  
  import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import
  org.springframework.cloud.openfeign.FeignClient; import
  org.springframework.http.ResponseEntity; import
  org.springframework.web.bind.annotation.DeleteMapping; import
  org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import
  com.capgemini.jwt.mongodb.model.Product;
  
  
  @FeignClient(value = "Product",url="http://localhost:8086/api/v2")
  public interface FeignClientUtilProduct {
  
	  @PostMapping(value = "/products")
	    public ResponseEntity<Product> addProducts(@RequestBody Product product);
  
	  @GetMapping ("/products/{productId}")
	    public Optional<Product> getProductById(@PathVariable int productId);
	  @GetMapping ("/Product")
	    public ResponseEntity<List<Product>> getAllProducts();
	  @GetMapping (value = "/products", params = "name")
	   public ResponseEntity<List<Product>> getAllProductsByName(@RequestParam ("name") String name);
  
	  @PutMapping("/update/{id}")
		public ResponseEntity<Void> updateProducts(@RequestBody Product product, @PathVariable("id") int productId);
  
	  @DeleteMapping("/delete/{productId}")
	    public void deleteProduct(@PathVariable int productId);
  
  }
  
