package com.capgemini.jwt.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "db_cart_sequence")
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DbSequenceCart {

	  	@Id
	    private String  id;
	    private int seq;
		public DbSequenceCart(String id, int seq) {
			super();
			this.id = id;
			this.seq = seq;
		}
		public DbSequenceCart() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
		}
	    
	    
}
