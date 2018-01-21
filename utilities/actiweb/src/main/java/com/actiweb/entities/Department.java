package com.actiweb.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements IBaseEntity, Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "DEPARTMENT_ID")
  private Long departmentId;
  @Column(name = "DEPARTMENT_NAME")
  private String departmentName;
  @ManyToOne(targetEntity = Location.class)
  @JoinColumn(name = "LOCATION_ID")
  private Location locationId;

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public Location getLocationId() {
    return locationId;
  }

  public void setLocationId(Location locationId) {
    this.locationId = locationId;
  }

}
