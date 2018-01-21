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
@Table(name = "COUNTRY")
public class Country implements IBaseEntity, Serializable {
  /**
  	 * 
  	 */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "COUNTRY_ID")
  private String countryId;
  @Column(name = "COUNTRY_NAME")
  private String countryName;
  @ManyToOne(targetEntity = Region.class)
  @JoinColumn(name = "REGION_ID")
  private Region regionId;

  public String getCountryId() {
    return countryId;
  }

  public void setCountryId(String countryId) {
    this.countryId = countryId;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public Region getRegionId() {
    return regionId;
  }

  public void setRegionId(Region regionId) {
    this.regionId = regionId;
  }

}
