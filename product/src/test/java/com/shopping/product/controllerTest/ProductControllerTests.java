package com.shopping.product.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.shopping.model.Product;
import com.shopping.service.ProductServiceImpl;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTests {

	
	@MockBean
	private ProductServiceImpl service;
	
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
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		Product p2=new Product(102,"abcd","defg","ghij",4,"jklm","mnop",100,"pqrs","stuv");
		List<Product> productList=new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		when(service.getAllProducts()).thenReturn(productList);
	mockMvc.perform(get("/api/v2/Product/"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
	.andExpect(jsonPath("$[*]", hasSize(2)))
	.andExpect(jsonPath("$[0].productId").value(101))
	.andExpect(jsonPath("$[0].productName").value("def"))
	.andExpect(jsonPath("$[0].category").value("ghi"))
	.andExpect(jsonPath("$[0].price").value(100));
		
	}
	
	@Test
	void testShowProductById() throws Exception {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
	when(service.getProductById(101)).thenReturn(p1);
	mockMvc.perform(get("/api/v2/products/101"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
	.andExpect(jsonPath("$.productId").value(101))
	.andExpect(jsonPath("$.productName").value("def"))
	.andExpect(jsonPath("$.category").value("ghi"))
	.andExpect(jsonPath("$.price").value(100));
		
	}
	
	
	@Test
	void testShowProductInvalidId() throws Exception {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
	when(service.getProductById(101)).thenReturn(p1);
	MvcResult result=mockMvc.perform(get("/api/v2/products/1"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Product with the id 1 doesn't exist");
		
	}
	
//	@Test
//	void testDeleteProductById() throws Exception {
//		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
//		String s="deleted successfully....";
//	when(service.deleteProductsById(101)).thenReturn(s);
//	mockMvc.perform(delete("/products/101"))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));	
//	}
	
	
//
//	@Test
//	void testdeleteProductInvalidId() throws Exception {
//		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
//		String s="deleted successfully....";
//		when(service.deleteProductsById(101)).thenReturn(s);
//	MvcResult result=mockMvc.perform(delete("/products/11"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Product with the id 1 doesn't exist");
//		
//	}
	
//	@Test
//	void testAddProduct() throws Exception {
//		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
//		String s="added successfully....";
//		//when(service.addProducts(p1)).thenReturn(p1);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(post("/api/v2/products")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk());
////	.andExpect(content().string(s));
//		
//	}
//	
	@Test
	void testUpdateProduct() throws Exception {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		String s="updated successfully....";
		when(service.updateProducts(p1,101)).thenReturn(p1);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(p1);
	mockMvc.perform(put("/api/v2/update/101")
			.contentType("application/json")
			.content(reqstr))
	.andExpect(status().isOk());
//	.andExpect(content().string(s));
		
	}
}


