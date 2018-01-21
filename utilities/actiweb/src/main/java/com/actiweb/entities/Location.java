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
@Table(name = "LOCATION")
public class Location implements IBaseEntity, Serializable {
  /**
  	 * 
  	 */
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "LOCATION_ID")
  private Long locationId;
  @Column(name = "STREET_ADDRESS")
  private String streetAddress;
  @Column(name = "POSTAL_CODE")
  private String postalCode;
  @Column(name = "CITY")
  private String city;
  @Column(name = "STATE_PROVINCE")
  private String stateProvince;
  @ManyToOne(targetEntity = Country.class)
  @JoinColumn(name = "COUNTRY_ID")
  private Country countryId;

  public Long getLocationId() {
    return locationId;
  }

  public void setLocationId(Long locationId) {
    this.locationId = locationId;
  }

  public String getStreetAddress() {
    return streetAddress;
  }

  public void setStreetAddress(String streetAddress) {
    this.streetAddress = streetAddress;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public void setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
  }

  public Country getCountryId() {
    return countryId;
  }

  public void setCountryId(Country countryId) {
    this.countryId = countryId;
  }

}
