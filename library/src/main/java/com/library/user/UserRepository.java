package com.library.user;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.library.domain.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, BigInteger> {
	User findByUsername(String username);
}
