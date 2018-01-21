package com.pine.repo;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pine.documents.Employee;

public interface EmployeesRepository extends MongoRepository<Employee, BigInteger> {
  public Employee findByFirstName(String firstName);

  public List<Employee> findByLastName(String lastName);

}