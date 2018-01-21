package com.library;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.common.ResourceNotFoundException;
import com.library.domain.ResponseError;

@ControllerAdvice
public class GlobalControllerAdvice {

	private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);

	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<ResponseError> handleException(ResourceNotFoundException ex) {
		logger.error(ex.getCode(), ex);
		ResponseError error = new ResponseError();
		error.setCode(ex.getCode());
		error.setMessage(HttpStatus.NOT_FOUND.name());
		ResponseEntity<ResponseError> response = new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
		return response;

	}
	

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ResponseError> handleException(Exception ex) {
		logger.error("Exception occured:", ex);
		ResponseError error = new ResponseError();
		error.setCode(HttpStatus.BAD_REQUEST.name());
		error.setMessage("Error occured. Contact Admin.");
		ResponseEntity<ResponseError> response = new ResponseEntity<ResponseError>(error, HttpStatus.BAD_REQUEST);
		return response;
	}

}
