package com.pine.rest.resource;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pine.util.LoggerUtil;

public class BaseResource {
  @ExceptionHandler
  public @ResponseBody ResponseEntity<Object> handleException(HttpServletRequest request, HttpServletResponse response,
      Exception ex) {
    Map<String, Object> error = new HashMap<String, Object>();
    LoggerUtil.error("Exception: ", ex);
    error.put("status", HttpStatus.BAD_REQUEST.value());
    error.put("statusText", ex.getLocalizedMessage());
    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
}
