package com.capg.CartService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cartss")
public class Cart {

    @Transient
    public static final String SEQUENCE_NAME = "cart_sequence";

  
	@Id
    
    private int cartId;
   
    private String productName;
    private int price;
    private int quantity ;
    private double totalPrice;




   

    public int getCartId() {
        return cartId;
    }

    public Cart(int cartId,String productName, int price, int quantity,
		double totalPrice) {
	super();
	this.cartId = cartId;
	this.productName = productName;
	this.price = price;
	this.quantity = quantity;
	this.totalPrice = totalPrice;
}

	public void setCartId(int cartId) {
        this.cartId = cartId;
    }
	



    public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productName=" + productName +
                ",price=" + price +
                ",quantity=" + quantity +
                ", cartId=" + cartId +
                ", totalPrice=" + totalPrice +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Cart)) return false;
//        Cart cart = (Cart) o;
//        return getCartId() == cart.getCartId() && Double.compare(cart.getTotalPrice(), getTotalPrice()) == 0 && getProductId().equals(cart.getProductId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getProductId(), getCartId(), getTotalPrice());
//    }
}
