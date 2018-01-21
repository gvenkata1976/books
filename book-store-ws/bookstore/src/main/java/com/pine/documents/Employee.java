package com.pine.documents;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

@Document(collection = "employees")
public class Employee {
  @Id
  private BigInteger id;
  private String firstName;
  private String lastName;
  private Date dateOfJoin;
  private Address address;
  private String bloodGroup;
  private String designation;
  private String location;
  private String branch;

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Date getDateOfJoin() {
    return dateOfJoin;
  }

  public void setDateOfJoin(Date dateOfJoin) {
    this.dateOfJoin = dateOfJoin;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  @Override
  public boolean equals(Object obj) {
    if (StringUtils.isEmpty(id))
      return super.equals(obj);

    return getClass().isInstance(obj) && id.equals(((Employee) obj).getId());
  }

  @Override
  public int hashCode() {
    return StringUtils.isEmpty(id) ? super.hashCode()
        : String.format("%s/%s", getClass().getSimpleName(), getId()).hashCode();
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfJoin=" + dateOfJoin
        + ", address=" + address + ", bloodGroup=" + bloodGroup + ", designation=" + designation + ", location="
        + location + ", branch=" + branch + "]";
  }

}
