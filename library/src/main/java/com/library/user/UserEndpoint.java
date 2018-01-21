package com.library.user;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.domain.User;

@RestController
@RequestMapping("/users")
public class UserEndpoint {
	private static final Logger logger = LoggerFactory.getLogger(UserEndpoint.class);
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> list() {
		List<User> list = service.list();
		ResponseEntity<List<User>> response = new ResponseEntity<List<User>>(list, HttpStatus.OK);
		return response;
	}

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> get(@PathParam(value = "id") String id) {
		User user = service.findOne(id);
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		return response;
	}

	@PostMapping
	public ResponseEntity<User> save(@RequestBody User user) {
		service.save(user);
		ResponseEntity<User> response = new ResponseEntity<User>(user, HttpStatus.OK);
		return response;
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathParam(value = "id") String id, @RequestBody User user) {
		service.update(id, user);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathParam(value = "id") String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		logger.error("Exception occured:", ex);
		return new ResponseEntity<String>("Error occured. Contact Admin.", HttpStatus.NOT_FOUND);
	}
}
