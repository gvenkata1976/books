package com.pine.repo;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pine.documents.User;

public interface UserRepository extends MongoRepository<User, BigInteger> {
  public User findByUserName(String name);
}