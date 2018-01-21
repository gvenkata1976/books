package com.pine.documents;

public class Address {
  private String addressLine1;
  private String addressLine2;
  private String city;
  private String state;
  private String zip;
  private String country;
  private String region;

  /**
   * @return the addressLine1
   */
  public String getAddressLine1() {
    return addressLine1;
  }

  /**
   * @param addressLine1
   *          the addressLine1 to set
   */
  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  /**
   * @return the addressLine2
   */
  public String getAddressLine2() {
    return addressLine2;
  }

  /**
   * @param addressLine2
   *          the addressLine2 to set
   */
  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city
   *          the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @param state
   *          the state to set
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @return the zip
   */
  public String getZip() {
    return zip;
  }

  /**
   * @param zip
   *          the zip to set
   */
  public void setZip(String zip) {
    this.zip = zip;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country
   *          the country to set
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * @return the region
   */
  public String getRegion() {
    return region;
  }

  /**
   * @param region
   *          the region to set
   */
  public void setRegion(String region) {
    this.region = region;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
        + state + ", zip=" + zip + ", country=" + country + ", region=" + region + "]";
  }

}
