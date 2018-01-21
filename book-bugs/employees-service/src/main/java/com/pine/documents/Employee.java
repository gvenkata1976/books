package com.pine.documents;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
public class Employee {

  @Id
  private BigInteger uniqueId;
  private String firstName;
  private String lastName;
  private Date dateOfJoin;
  private Address address; 
  private String bloodGroup;
  private String designation;
  private String location;
  private String branch;
  /**
   * @return the uniqueId
   */
  public BigInteger getUniqueId() {
    return uniqueId;
  }
  /**
   * @param uniqueId the uniqueId to set
   */
  public void setUniqueId(BigInteger uniqueId) {
    this.uniqueId = uniqueId;
  }
  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }
  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }
  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  /**
   * @return the dateOfJoin
   */
  public Date getDateOfJoin() {
    return dateOfJoin;
  }
  /**
   * @param dateOfJoin the dateOfJoin to set
   */
  public void setDateOfJoin(Date dateOfJoin) {
    this.dateOfJoin = dateOfJoin;
  }
  /**
   * @return the address
   */
  public Address getAddress() {
    return address;
  }
  /**
   * @param address the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }
  /**
   * @return the bloodGroup
   */
  public String getBloodGroup() {
    return bloodGroup;
  }
  /**
   * @param bloodGroup the bloodGroup to set
   */
  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }
  /**
   * @return the designation
   */
  public String getDesignation() {
    return designation;
  }
  /**
   * @param designation the designation to set
   */
  public void setDesignation(String designation) {
    this.designation = designation;
  }
  /**
   * @return the location
   */
  public String getLocation() {
    return location;
  }
  /**
   * @param location the location to set
   */
  public void setLocation(String location) {
    this.location = location;
  }
  /**
   * @return the branch
   */
  public String getBranch() {
    return branch;
  }
  /**
   * @param branch the branch to set
   */
  public void setBranch(String branch) {
    this.branch = branch;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Employee [uniqueId=" + uniqueId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfJoin="
        + dateOfJoin + ", address=" + address + ", bloodGroup=" + bloodGroup + ", designation=" + designation
        + ", location=" + location + ", branch=" + branch + "]";
  }
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((bloodGroup == null) ? 0 : bloodGroup.hashCode());
    result = prime * result + ((branch == null) ? 0 : branch.hashCode());
    result = prime * result + ((dateOfJoin == null) ? 0 : dateOfJoin.hashCode());
    result = prime * result + ((designation == null) ? 0 : designation.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + ((uniqueId == null) ? 0 : uniqueId.hashCode());
    return result;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Employee)) {
      return false;
    }
    Employee other = (Employee) obj;
    if (address == null) {
      if (other.address != null) {
        return false;
      }
    } else if (!address.equals(other.address)) {
      return false;
    }
    if (bloodGroup == null) {
      if (other.bloodGroup != null) {
        return false;
      }
    } else if (!bloodGroup.equals(other.bloodGroup)) {
      return false;
    }
    if (branch == null) {
      if (other.branch != null) {
        return false;
      }
    } else if (!branch.equals(other.branch)) {
      return false;
    }
    if (dateOfJoin == null) {
      if (other.dateOfJoin != null) {
        return false;
      }
    } else if (!dateOfJoin.equals(other.dateOfJoin)) {
      return false;
    }
    if (designation == null) {
      if (other.designation != null) {
        return false;
      }
    } else if (!designation.equals(other.designation)) {
      return false;
    }
    if (firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!firstName.equals(other.firstName)) {
      return false;
    }
    if (lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!lastName.equals(other.lastName)) {
      return false;
    }
    if (location == null) {
      if (other.location != null) {
        return false;
      }
    } else if (!location.equals(other.location)) {
      return false;
    }
    if (uniqueId == null) {
      if (other.uniqueId != null) {
        return false;
      }
    } else if (!uniqueId.equals(other.uniqueId)) {
      return false;
    }
    return true;
  }
  
  
 }
