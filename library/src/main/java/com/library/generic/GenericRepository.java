package com.library.generic;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface GenericRepository<T> extends PagingAndSortingRepository<T,BigInteger> {
	
}
