package com.capg.CartService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dBSequence")
public class DbSequence {
    @Id
    private String cartId;
    private int seq;
	public String getcartId() {
		return cartId;
	}
	public void setcartId(String cartId) {
		this.cartId = cartId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
    
}
