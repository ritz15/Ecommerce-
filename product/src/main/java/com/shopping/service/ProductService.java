package com.shopping.service;

import java.util.List;
import java.util.Optional;

import com.shopping.exception.ProductAlreadyExistsException;
import com.shopping.model.Product;


	public interface ProductService {
	    public Product addProducts(Product product) throws ProductAlreadyExistsException;
	    public List<Product> getAllProducts();
   public Product getProductById(int productId);
	    public List<Product> getAllProductsByName(String name);
	    public Product updateProducts(Product product, int productId);
//	    public void deleteProductsById(Long id);
		public void deleteProductsById(Integer productId);
		//public static Optional<Product> getProductById(int productId) {
//			return null;
//		}
//		void deleteProductsById(int productId);
	
	}

