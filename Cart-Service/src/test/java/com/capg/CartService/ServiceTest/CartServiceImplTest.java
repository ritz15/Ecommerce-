package com.capg.CartService.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.CartService.exception.CartException;
import com.capg.CartService.model.Cart;
import com.capg.CartService.repository.CartRepository;
import com.capg.CartService.service.CartServiceImpl;
//import com.cognizant.exception.ProductNotFoundException;
//import com.cognizant.model.Product;
//import com.cognizant.repository.ProductRepository;
//import com.cognizant.service.ProductServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class CartServiceImplTest {

	
	@InjectMocks
	private CartServiceImpl service;
	
	@Mock
	private CartRepository repository;
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	void testGetAllProducts() throws CartException {
		Cart p1=new Cart(101,null,100,1,1);
		Cart p2=new Cart(102,null,200,1,1);
		List<Cart> productList=new ArrayList<Cart>();
		productList.add(p1);
		productList.add(p2);
		when(repository.findAll()).thenReturn(productList);
		assertEquals(productList,service.getallcarts());
		
	}
	
	@Test
	void testGetCartById() throws CartException {
		Cart p1=new Cart(101,null,100,1,1);
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		assertEquals(p1,service.getcartById(101));
	}
	
	@Test
	void testGetProductByInvalidId()  {
		Cart p1=new Cart(101,null,100,1,1);
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(service.getcartById(1)).as("Cart with the id 1 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	
//	@Test
//	void testAddProduct() throws CartException {
//		Cart p1=new Cart(101,null,100,1,1);
//		assertThat(service.addCart(p1));
//	}
	
	
//	@Test
//	void testAddProductAlreadyExists()  {
//		Cart p1=new Cart(101,null);
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//	
//		assertThat(service.addCart(p1));
//		.contains("Product with the id "+p1.getCartId()+" already exist");
//	
//	}
//	
	@Test
	void testupdateProduct() throws CartException  {
		Cart p1=new Cart(101,null,100,1,1);
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		assertThat(service.updateCart(101,p1));
//		.contains("updated successfully....");
	
	}
	
//	@Test
//	void testupdateProductDoesnotExists() throws CartException {
//		Cart p1=new Cart(101,null,100,1,1);
//		when(repository.findById(10)).thenReturn(Optional.of(p1));
//	try {
//		((List<Cart>) assertThat(service.updateCart(101,p1)))
//		.contains("Product with the id "+p1.getCartId()+" doesn't exist for update");
//	}catch(Exception e) {
//		
//	}
//	}
	

	
	
	}