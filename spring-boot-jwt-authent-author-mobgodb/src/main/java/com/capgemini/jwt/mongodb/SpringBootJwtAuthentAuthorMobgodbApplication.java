package com.capgemini.jwt.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = "com.capgemini.jwt.mongodb.controllers")
@OpenAPIDefinition(info=@Info(title="AUTH API" , version = "2.0", description = "AUTH-SERVICE"))
public class SpringBootJwtAuthentAuthorMobgodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJwtAuthentAuthorMobgodbApplication.class, args);
	}
}