package com.cg.opna.order.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "db_sequence")
	
		public class DbSequenceOrder {
		    @Id
		    private String  id;
		    private int seq;
			public DbSequenceOrder(String id, int seq) {
				super();
				this.id = id;
				this.seq = seq;
			}
			public DbSequenceOrder() {
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


