package com.library.book;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.common.Endpoints;
import com.library.domain.Book;

@RestController
@RequestMapping(Endpoints.Book.REQUEST_URL)
public class BookEndpoint {

	@Autowired
	private BookService service;

	@GetMapping
	public ResponseEntity<List<Book>> list() {
		List<Book> list = service.list();
		ResponseEntity<List<Book>> response = new ResponseEntity<List<Book>>(list, HttpStatus.OK);
		return response;
	}

	@GetMapping(value = Endpoints.Book.MAPPING_BOOK_ID)
	public ResponseEntity<Book> get(@PathParam(value = Endpoints.Book.PARAM_BOOK_ID) String bookId) {
		Book book = service.findOne(bookId);
		ResponseEntity<Book> response = new ResponseEntity<Book>(book, HttpStatus.OK);
		return response;
	}

	@PostMapping
	public ResponseEntity<Book> save(@RequestBody Book book) {
		service.save(book);
		ResponseEntity<Book> response = new ResponseEntity<Book>(book, HttpStatus.OK);
		return response;
	}

	@PutMapping(value = Endpoints.Book.MAPPING_BOOK_ID)
	public ResponseEntity<Void> update(@PathParam(value = Endpoints.Book.PARAM_BOOK_ID) String id,
			@RequestBody Book book) {
		service.update(id, book);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = Endpoints.Book.MAPPING_BOOK_ID)
	public ResponseEntity<Void> delete(@PathParam(value = Endpoints.Book.PARAM_BOOK_ID) String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	
}
