package com.pine.repo;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pine.documents.Member;

public interface MemberRepository extends MongoRepository<Member, BigInteger> {
  public Member findByName(String name);

  public Member findById(String id);
}