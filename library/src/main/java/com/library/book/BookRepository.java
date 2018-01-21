package com.library.book;

import java.math.BigInteger;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.library.domain.Book;

@Repository 
public interface BookRepository extends PagingAndSortingRepository<Book,BigInteger> {
	
}
