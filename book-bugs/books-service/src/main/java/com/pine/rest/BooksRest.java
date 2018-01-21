package com.pine.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pine.documents.Book;
import com.pine.repo.BooksRepository;
import com.pine.util.LoggerUtil;

@RestController
public class BooksRest {

  @Autowired
  private BooksRepository repo;

  @RequestMapping(method = RequestMethod.GET, value = "/list")
  public List<Book> list() {
    return repo.findAll();
  }
  @RequestMapping(method = RequestMethod.POST, value = "/search")
  public List<Book> search(@RequestBody Book book) {
    return repo.findAll(Example.of(book));
  }
  @RequestMapping(method = RequestMethod.POST, value = "/save")
  public @ResponseBody Book add(@RequestBody Book book) {
    return repo.save(book);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/update")
  public @ResponseBody Book update(@RequestBody Book book) {
    return repo.save(book);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
  public void delete(@RequestBody Book book) { 
    repo.delete(book);
  }

  @ExceptionHandler
  public void handleException(Exception ex) {
    LoggerUtil.error("Exception: ", ex);
  }
}
