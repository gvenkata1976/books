package com.pine.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pine.documents.Book;

public interface BooksRepository extends MongoRepository<Book, BigInteger> {
  
  public Book findByName(String name);

  public Book findById(String id);

  public List<Book> findByAuthor(String author);
 
}