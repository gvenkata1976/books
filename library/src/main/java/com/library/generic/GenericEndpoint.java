package com.library.generic;

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

public abstract class GenericEndpoint<T> {

	private GenericService<T> service;
	private static final String PATH = "/{id}";
	private static final String PATH_PARAM = "id";
	@Autowired
	public GenericEndpoint(GenericService<T> service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<T>> list() {
		List<T> list = service.findAll();
		ResponseEntity<List<T>> response = new ResponseEntity<List<T>>(list, HttpStatus.OK);
		return response;
	}

	@GetMapping(value = PATH)
	public ResponseEntity<T> get(@PathParam(value = PATH_PARAM) String id) {
		T t = service.findOne(id);
		ResponseEntity<T> response = new ResponseEntity<T>(t, HttpStatus.OK);
		return response;
	}

	@PostMapping
	public ResponseEntity<T> save(@RequestBody T t) {
		service.save(t);
		ResponseEntity<T> response = new ResponseEntity<T>(t, HttpStatus.OK);
		return response;
	}

	@PutMapping(value = PATH)
	public ResponseEntity<Void> update(@PathParam(value = PATH_PARAM) String id, @RequestBody T t) {
		service.update(id, t);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = PATH)
	public ResponseEntity<Void> delete(@PathParam(value = PATH_PARAM) String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
