package com.demo.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.user.entity.User;

public interface UserRepository  extends MongoRepository<User,Integer>{

}
