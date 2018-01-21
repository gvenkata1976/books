package com.library.book;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.common.ResourceNotFoundException;
import com.library.domain.Book;
 

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	@Transactional(readOnly = true)
	public List<Book> list() {
		List<Book> target = new ArrayList<Book>();
		repo.findAll().forEach(target::add);
		return target;
	}

	@Transactional(readOnly = true)
	public Book findOne(String id) {
		Book book = repo.findOne(new BigInteger(id));
		if (book == null) {
			throw new ResourceNotFoundException(id);
		}
		return book;
	}

	@Transactional(rollbackFor = { Exception.class }, readOnly = false)
	public void save(Book book) {
		repo.save(book);
	}

	public void update(String id, Book book) {
		if (repo.exists(new BigInteger(id))) {
			book.setModifiedDate(new Date());
			repo.save(book);
		}
	}

	public void delete(String id) {
		BigInteger key = new BigInteger(id);
		if (repo.exists(key)) {
			repo.delete(key);
		}
	}

 
}
