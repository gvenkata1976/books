package com.pine.rest.resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pine.documents.Book;
import com.pine.repo.BooksRepository;

@RestController
@RequestMapping("/admin/books")
public class BooksResource extends BaseResource {

  @Autowired
  private BooksRepository repo;

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public Book get(@PathParam(value = "id") String id) {
    return repo.findById(id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public @ResponseBody Book add(@RequestBody @Valid Book book) {
    return repo.save(book);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public @ResponseBody Book update(@PathParam(value = "id") String id, @RequestBody @Valid Book book) {
    return repo.save(book);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public void delete(@PathParam(value = "id") String id, @RequestBody  @Valid Book book) {
    repo.delete(book);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Book> list() {
    return repo.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/search")
  public List<Book> search(@RequestBody  @Valid Book book) {
    return repo.findAll(Example.of(book));
  }

  @RequestMapping(method = RequestMethod.POST, value = "/upload")
  public void saveBooks(@RequestParam("file") MultipartFile file) {
    readFileAndSaveBooks(file);
  }

  private void readFileAndSaveBooks(MultipartFile file) {
    CSVParser parser = null;
    try {
      List<Book> books = new ArrayList<Book>();
      CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
      parser = new CSVParser(new InputStreamReader(file.getInputStream()), format);
      Book book = null;
      for (CSVRecord record : parser) {
        try {
          book = new Book();
          book.setAuthor(record.get("author"));
          book.setBarcode(record.get("barcode"));
          book.setCategory(record.get("category"));
          book.setInStock(Boolean.valueOf(record.get("inStock")));
          book.setLanguage(record.get("language"));
          book.setName(record.get("name"));
          book.setPages(new BigInteger(record.get("pages")));
          book.setPrice(Double.valueOf(record.get("price")));
          book.setPublisher(record.get("publisher"));
          books.add(book);
        } catch (NumberFormatException e) {
          //e.printStackTrace();
        }
      }
      repo.save(books);
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      try {
        parser.close();
      } catch (IOException e) { 
      }
    }

  }
}
