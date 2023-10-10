package com.capgemini.jwt.mongodb.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user-service")
public class Customer {
	@Transient
	public  static final String SEQUENCE_NAME="user_sequence";
	
	
	@Id

	private int id;
	@NotEmpty
	@Size(min=4,message="user name must be minimum of 4 characters")
	private String name;
	private String gender;
	@NotNull(message="please enter your age")
	private int age;
	@Email
//	@Pattern(regexp ="^[a-zA-Z0-9_\-\.]+[@][a-z]+[\.][a-z]{2,3}$")
	private String email;
	@NotEmpty
	@Size(min=4,message="please enter your address")
	private String address;
	@NotNull
	private String role;
	
	@NotEmpty
	@Size(min=3,max=10,message ="Password must be min of 3 chars and max of 10 chars")
	//@Pattern(regexp = "^[A-Z]{1,8}$", message = "character limit exceeded")
	private String password;
	
	
	
	public Customer(int id, String name, String gender, int age, String address, String role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.email=email;
		this.address = address;
		this.role = role;
		this.password = password;
	}
	public Customer() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
