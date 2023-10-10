package com.cg.opna.order.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Document(collection="order")
	public class Order {
		
		public static final String SEQUENCE_NAME = "order_sequence";
		@Id
	    private int bookingOrderId;
		
	   private LocalDate orderDate;
	   @NotBlank(message="enter valid transactionMode")
	    private String transactionMode;
	   @NotBlank(message="enter valid quantity")
		private int quantity;
	   @NotBlank(message="enter valid totalCost")
		double totalCost;
	   
	   
	   
	public Order(int bookingOrderId, LocalDate orderDate,
			@NotBlank(message = "enter valid transactionMode") String transactionMode,
			@NotBlank(message = "enter valid quantity") int quantity,
			@NotBlank(message = "enter valid totalCost") double totalCost) {
		super();
		this.bookingOrderId = bookingOrderId;
		this.orderDate = orderDate;
		this.transactionMode = transactionMode;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookingOrderId() {
		return bookingOrderId;
	}
	public void setBookingOrderId(int bookingOrderId) {
		this.bookingOrderId = bookingOrderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	   
	   
}
