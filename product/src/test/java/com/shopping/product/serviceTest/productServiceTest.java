package com.shopping.product.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
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

import com.shopping.exception.ProductAlreadyExistsException;
import com.shopping.model.Product;
import com.shopping.repository.ProductRepository;
import com.shopping.service.ProductServiceImpl;


@SpringBootTest
@AutoConfigureMockMvc
public class productServiceTest {

	
	@InjectMocks
	private ProductServiceImpl service;
	
	@Mock
	private ProductRepository repository;
	
	@Test
	void testServiceNotNull() {
		assertThat(service).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(repository).isNotNull();
	}
	
	@Test
	void testGetAllProducts() {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		Product p2=new Product(102,"abcd","defg","ghij",4,"jklm","mnop",100,"pqrs","stuv");
		List<Product> productList=new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		when(repository.findAll()).thenReturn(productList);
		assertEquals(productList,service.getAllProducts());
		
	}
	
	@Test
	void testGetProductById()   {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		assertEquals(p1,service.getProductById(101));
	}
	
	@Test
	void testGetProductByInvalidId()  {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		try {
			assertThat(service.getProductById(1)).as("Product with the id 1 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAddProduct() throws ProductAlreadyExistsException {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		 assertThat(service.addProducts(p1));
		//.contains("added successfully....");
	
	}	
	
	@Test
	void testupdateProduct() {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		when(repository.findById(101)).thenReturn(Optional.of(p1));
		assertThat(service.updateProducts(p1,101));
//		.contains("updated successfully....");
	
	}
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	void testupdateProductDoesnotExists()  {
		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
		when(repository.findById(10)).thenReturn(Optional.of(p1));
	try {
		((List<Product>) assertThat(service.updateProducts(p1,101)))
		.contains("Product with the id "+p1.getProductId()+" doesn't exist for update");
	}catch(Exception e) {
		
	}
	}
//	@Test
//	void testDeleteProductById()  {
//		Product p1=new Product(101,"abc","def","ghi",4,"jkl","mno",100,"pqr","stu");
//		when(repository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(service.deleteProductsById(101));
////		.contains("deleted successfully....");
//	}
	
	
	
}
