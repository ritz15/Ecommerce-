package com.capgemini.jwt.mongodb.controllers;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import
org.springframework.beans.factory.annotation.Autowired; import
org.springframework.http.ResponseEntity; import
org.springframework.security.access.prepost.PreAuthorize; import
org.springframework.web.bind.annotation.DeleteMapping; import
org.springframework.web.bind.annotation.GetMapping; import
org.springframework.web.bind.annotation.PathVariable; import
org.springframework.web.bind.annotation.PostMapping; import
org.springframework.web.bind.annotation.PutMapping; import
org.springframework.web.bind.annotation.RequestBody; import
org.springframework.web.bind.annotation.RequestMapping; import
org.springframework.web.bind.annotation.RequestParam; import
org.springframework.web.bind.annotation.RestController; import
com.capgemini.jwt.mongodb.controllers.security.services.
SequenceGeneratorService; import
com.capgemini.jwt.mongodb.exception.NoProperDataException; import
com.capgemini.jwt.mongodb.exception.ProductNotFoundException; import
com.capgemini.jwt.mongodb.exception.ProductsNotFoundException; import
com.capgemini.jwt.mongodb.model.Cart; import
com.capgemini.jwt.mongodb.model.Product; import
com.capgemini.jwt.mongodb.util.FeignClientUtilProduct;


//changed in line no.47


@RestController

@RequestMapping("/product-service") //same url has this particular project
public class FeignControllerProduct {

@Autowired private FeignClientUtilProduct feignclientutil;

@Autowired private SequenceGeneratorService service;

@GetMapping("/Product")

@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
public ResponseEntity<List<Product>>
getAllProducts()  { return
feignclientutil.getAllProducts(); }

@GetMapping("/products/{id}")
@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
public Optional<Product> getProductById(@PathVariable int productId)
throws ProductNotFoundException { 
	
	return feignclientutil.getProductById(productId);
	}

@PostMapping("/products")

@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public ResponseEntity<Product> addProducts(@RequestBody Product product) throws ProductNotFoundException {
return feignclientutil.addProducts(product); }

@PutMapping("/update/{id}")

@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')") 
public ResponseEntity<Void>
updateProducts(@RequestBody Product product ,@PathVariable int id) 
{ return feignclientutil.updateProducts(product, id);
}

@DeleteMapping("/products/{id}")

@PreAuthorize("hasAuthority('ROLE_USER') or hasAuthority('ROLE_ADMIN')")
public void
deleteProduct(@PathVariable  int productId)  { 
	 feignclientutil.deleteProduct(productId); 
	}

}
