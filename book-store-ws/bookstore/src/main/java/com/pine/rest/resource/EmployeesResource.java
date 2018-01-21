package com.pine.rest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pine.util.LoggerUtil;
import com.pine.documents.Employee;
import com.pine.repo.EmployeesRepository;

@RestController
@RequestMapping("/admin/employees")
public class EmployeesResource {

  @Autowired
  private EmployeesRepository repo;

  @RequestMapping(method = RequestMethod.GET, value = "/list")
  public List<Employee> list() {
    return repo.findAll();
  }
  @RequestMapping(method = RequestMethod.POST, value = "/search")
  public List<Employee> search(@RequestBody Employee emp) {
    return repo.findAll(Example.of(emp));
  }
  @RequestMapping(method = RequestMethod.POST, value = "/save")
  public @ResponseBody Employee add(@RequestBody Employee emp) {
    return repo.save(emp);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/update")
  public @ResponseBody Employee update(@RequestBody Employee emp) {
    return repo.save(emp);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
  public void delete(@RequestBody Employee emp) { 
    repo.delete(emp);
  }

  @ExceptionHandler
  public void handleException(Exception ex) {
    LoggerUtil.error("Exception: ", ex);
  }
}
