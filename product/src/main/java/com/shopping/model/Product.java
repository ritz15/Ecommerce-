package com.shopping.model;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

   @Transient
   public static final String SEQUENCE_NAME = "product_sequence";

    @Id
    private int productId;
    private String productType;
    @NotNull(message="Product name shouldn't be empty")
    private String productName;
    @NotNull(message="Product category shouldn't be empty")
    private String category;
    @Min(1)
    @Max(5)
    private int rating;
    private String review;
    private String image;
    @NotNull(message="Product price shouldn't be empty")
    private double price;
    @NotNull(message="Product description shouldn't be empty")
    private String description;
    private String specification;
	public int getProductId() {
		return productId;
	}
	public Product(int productId, String productType, String productName, String category, int rating,
			String review, String image, double price, String description,
			String specification) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	
}
