package com.shopping.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.ProductAlreadyExistsException;
import com.shopping.model.Product;
import com.shopping.service.ProductService;
@CrossOrigin("*")
	@RequestMapping("/api/v2")
	@RestController
	public class ProductController {


	    //@Autowired
	    //RestTemplate restTemplate;

	    @Autowired
	    ProductService productService;
	   

	    @PostMapping(value = "/products")
	    public ResponseEntity<Product> addProducts(@RequestBody Product product, HttpServletRequest request) throws ProductAlreadyExistsException{
	    	if(product != null) {
	    		try {
	    			productService.addProducts(product);
	    	        return new ResponseEntity<Product>(
	    	        		product,
	    	        		HttpStatus.CREATED);
	    		}catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<Product>(
							HttpStatus.INTERNAL_SERVER_ERROR);
				}
	    	}
	    	return new ResponseEntity<Product>(
	    			HttpStatus.BAD_REQUEST);       
	    }

	   /*@RequestMapping("/uId")
	    public List<User> getUser(@PathVariable("uId") int profileId){

	        User user = restTemplate.getForObject("http://localhost:5050/profile/show", Profile.class);
	        return (List<User>) new User();
	    }*/


	    @GetMapping ("/Product")
	    public ResponseEntity<List<Product>> getAllProducts(){
	        List<Product> products =  productService.getAllProducts();
	        if(!products.isEmpty()) {
	        	return new ResponseEntity<>(products,HttpStatus.OK);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);       
	    }
	    
	   @GetMapping ("/products/{productId}")
	    public Product getProductById(@PathVariable int productId) throws ProductAlreadyExistsException{
	      return  productService.getProductById(productId);
	       
	    }
	    
	 


	   
	    
	    @PutMapping("/update/{id}")
		public ResponseEntity<Void> updateProducts(@RequestBody Product product, @PathVariable("id") int productId){
			if (product != null){
				productService.updateProducts(product, productId);
				 return new ResponseEntity<>(HttpStatus.OK);
	        } else {
	        	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        }
		}

	   @DeleteMapping("/delete/{productId}")
	    public void deleteProduct(@PathVariable Integer productId){
//	    	Product product = productService.getProductById(productId);
		  productService.deleteProductsById(productId);
		   
	   }
	}

