package com.shopping.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.model.Product;

public interface ProductRepository extends MongoRepository<Product,Integer> {

//	List<Product> findAllById(String productName);

	}
