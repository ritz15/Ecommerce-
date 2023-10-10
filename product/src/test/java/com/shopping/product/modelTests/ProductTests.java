package com.shopping.product.modelTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shopping.model.Product;



public class ProductTests {
	

	Product p1;
	@BeforeEach
	public void before() {
		p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
	}
	
	
	@AfterEach
	public void after() {
		p1=null;
	}
	
	@Test
	void testGetId() {
		assertEquals(101, p1.getProductId());
	}

	@Test
	void testGetName() {
		assertEquals("def", p1.getProductName());
	}

	@Test
	void testGetCategory() {
		assertEquals("ghi", p1.getCategory());
	}

	@Test
	void testGetPrice() {
		assertEquals(100, p1.getPrice());
	}

	@Test
	void testSetId() {
		p1.setProductId(111);
		assertEquals(111, p1.getProductId());
	}

	@Test
	void testSetName() {
		p1.setProductName("oppo");
		assertEquals("oppo", p1.getProductName());
	}

	@Test
	void testSetCategory() {
		p1.setCategory("tv");
		assertEquals("tv", p1.getCategory());
	}

	@Test
	void testSetPrice() {
		p1.setPrice(100);
		assertEquals(100, p1.getPrice());
	}
	
	@Test
	void testGetSpec() {
		assertEquals("stu", p1.getSpecification());
	}
	
	@Test
	void testSetSpec() {
		p1.setSpecification("aaa");
		assertEquals("aaa", p1.getSpecification());
	}
	
	@Test
	void testGetDes() {
		assertEquals("pqr", p1.getDescription());
	}
	
	@Test
	void testSetDes() {
		p1.setDescription("bbb");
		assertEquals("bbb", p1.getDescription());
	}
	
	@Test
	void testGetRating() {
		assertEquals(4, p1.getRating());
	}
	
	@Test
	void testSetRating() {
		p1.setRating(111);
		assertEquals(111, p1.getRating());
	}
	
	


}
