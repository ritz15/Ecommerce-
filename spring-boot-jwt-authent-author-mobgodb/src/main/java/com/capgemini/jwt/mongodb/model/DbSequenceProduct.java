package com.capgemini.jwt.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "db_sequence_product")

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DbSequenceProduct {

	  	@Id
	    private String  id;
	    private int seq;
		public DbSequenceProduct(String id, int seq) {
			super();
			this.id = id;
			this.seq = seq;
		}
		public DbSequenceProduct() {
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
