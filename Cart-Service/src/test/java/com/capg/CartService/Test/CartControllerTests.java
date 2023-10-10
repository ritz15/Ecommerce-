package com.capg.CartService.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.capg.CartService.model.Cart;
import com.capg.CartService.service.CartServiceImpl;
//import com.cognizant.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerTests {

	@MockBean
	private CartServiceImpl service;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	

	@Test
	void testShowProducts() throws Exception {
		Cart p1=new Cart(101,"pen",10,1,10);
		Cart p2=new Cart(102,"pencil",10,1,10);
		List<Cart> productList=new ArrayList<Cart>();
		productList.add(p1);
		productList.add(p2);
		when(service.getallcarts()).thenReturn(productList);
	mockMvc.perform(get("/api/v4/getAllCarts"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
	.andExpect(jsonPath("$[*]", hasSize(2)))
	.andExpect(jsonPath("$[0].cartId").value(101))
	.andExpect(jsonPath("$[0].productName").value("pen"))
	.andExpect(jsonPath("$[0].price").value(10))
	.andExpect(jsonPath("$[0].quantity").value(1));
		
	}
	
	@Test
	void testShowProductById() throws Exception {
		Cart p1=new Cart(101,"pen",10,1,10);
	when(service.getcartById(101)).thenReturn(p1);
	mockMvc.perform(get("/api/v4/cartbyId/101"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
	.andExpect(jsonPath("$.cartId").value(101))
	.andExpect(jsonPath("$.productName").value("pen"))
	.andExpect(jsonPath("$.price").value(10))
	.andExpect(jsonPath("$.quantity").value(1));
		
	}
	
	@Test
	void testShowProductInvalidId() throws Exception {
		Cart p1=new Cart(101,"pen",10,1,10);
	when(service.getcartById(101)).thenReturn(p1);
	MvcResult result=mockMvc.perform(get("/api/v4/cartbyId/1"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Cart with the id 1 doesn't exist");
		
	}

	
//	@Test
//	void testAddProduct() throws Exception {
//		Cart p1=new Cart(101,"pen",10,1,10);
//		String s="added successfully....";
////		when(service.addCart(p1)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(post("/add/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk());
////	.andExpect(content().string(s));
//	}
	
	@Test
	void testadd() throws Exception {
		Cart p1=new Cart(101,"pen",10,1,10);
		Cart p2=new Cart(2,"pencil",10,2,10);
	when(service.addCart(p2)).thenReturn(p2);
	mockMvc.perform(put("/api/v4/add"));
	//.andExpect(status().isOk());
//		
	}
	
	@Test
	void testUpdateProduct() throws Exception {
		Cart p1=new Cart(101,"pen",10,1,10);
//		String s="updated successfully....";
		when(service.updateCart(101,p1)).thenReturn(p1);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
	mockMvc.perform(put("/api/v4/update/101")
			.contentType("application/json")
			.content(reqstr))
	.andExpect(status().isOk());
//	.andExpect(content().string(s));
		
	}
	
//	
//	@Test
//	void testupdate() throws Exception {
//		Cart p1=new Cart(101,"pen",10,1,10);
//		Cart p2=new Cart(2,"pencil",10,2,10);
//	when(service.updateCart(2,p2)).thenReturn(p2);
//	mockMvc.perform(put("/api/v4/update/2"));
//	//.andExpect(status().isOk());
////		
//	}

}





