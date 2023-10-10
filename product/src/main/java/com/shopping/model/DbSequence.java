package com.shopping.model;

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
    private String productId;
    private int seq;
	public String getproductId() {
		return productId;
	}
	public void setproductId(String productId) {
		this.productId = productId;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
    
}
