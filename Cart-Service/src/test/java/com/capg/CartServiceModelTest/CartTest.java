package com.capg.CartServiceModelTest;
//package com.cognizant.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.capg.CartService.model.Cart;


class CartTest {

	Cart p1;
	Cart p2;
	@BeforeEach
	public void before() {
		p1=new Cart(101,"pen",10,1,10);
	}
	
	
	@AfterEach
	public void after() {
		p1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(101, p1.getCartId());
	}
	
//	@Test
//	void testGetProductId() {
//		Items i1=new Items("abc",100,2);
//		Items i2=new Items("xyz",200,1);
//		List<Items> items=new ArrayList<>();
//		items.add(i1);
//		items.add(i2);
//		p2=new Cart(104,items);
//		assertEquals(items,p2.getProductId());
//	}



	@Test
	void testSetId() {
		p1.setCartId(1);
		assertEquals(1, p1.getCartId());
	}
	
	
//	
//	@Test
//	void testSetProductId() {
//		Items i1=new Items("abc",100,2);
//		Items i2=new Items("xyz",200,1);
//		List<Items> items=new ArrayList<>();
//		items.add(i1);
//		items.add(i2);
//		p1.setProductId(items);
//		assertEquals(items,p1.getProductId());
//	}

	@Test
	void testGetName() {
		assertEquals("pen", p1.getProductName());
	}


	@Test
	void testGetPrice() {
		assertEquals(10, p1.getPrice());
	}
	
	@Test
	void testGetQuantity() {
		assertEquals(1,p1.getQuantity());
	}



	@Test
	void testSetName() {
		p1.setProductName("xyz");
		assertEquals("xyz", p1.getProductName());
	}



	@Test
	void testSetPrice() {
		p1.setPrice(100);
		assertEquals(100, p1.getPrice());
	}
	
	@Test
	void testsetQuantity() {
		p1.setQuantity(2);
		assertEquals(2,p1.getQuantity());
	}
	
	@Test
	void testTotalPrice()
	{
		assertEquals(10, p1.getTotalPrice());
	}

	
	@Test
	void testSetTotal() {
		p1.setTotalPrice(100);
		assertEquals(100,p1.getTotalPrice());
	}
}
