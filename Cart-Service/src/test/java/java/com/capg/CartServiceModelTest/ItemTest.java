//package com.capg.CartServiceModelTest;
//
////package com.cognizant.model;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import com.capg.CartService.model.Items;
//
//class ItemTest {
//
//	Items p1;
//	@BeforeEach
//	public void before() {
//		p1=new Items("abc",200,1);
//	}
//	
//	
//	@AfterEach
//	public void after() {
//		p1=null;
//	}
//	
//	
//
//	@Test
//	void testGetName() {
//		assertEquals("abc", p1.getProductName());
//	}
//
//
//	@Test
//	void testGetPrice() {
//		assertEquals(200, p1.getPrice());
//	}
//	
//	@Test
//	void testGetQuantity() {
//		assertEquals(1,p1.getQuantity());
//	}
//
//
//
//	@Test
//	void testSetName() {
//		p1.setProductName("xyz");
//		assertEquals("xyz", p1.getProductName());
//	}
//
//
//
//	@Test
//	void testSetPrice() {
//		p1.setPrice(100);
//		assertEquals(100, p1.getPrice());
//	}
//	
//	@Test
//	void testsetQuantity() {
//		p1.setQuantity(2);
//		assertEquals(2,p1.getQuantity());
//	}
//
//}