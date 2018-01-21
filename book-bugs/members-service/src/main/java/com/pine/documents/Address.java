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
   * @param addressLine1 the addressLine1 to set
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
   * @param addressLine2 the addressLine2 to set
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
   * @param city the city to set
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
   * @param state the state to set
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
   * @param zip the zip to set
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
   * @param country the country to set
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
   * @param region the region to set
   */
  public void setRegion(String region) {
    this.region = region;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Address [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state="
        + state + ", zip=" + zip + ", country=" + country + ", region=" + region + "]";
  }
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
    result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((region == null) ? 0 : region.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result + ((zip == null) ? 0 : zip.hashCode());
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
    if (!(obj instanceof Address)) {
      return false;
    }
    Address other = (Address) obj;
    if (addressLine1 == null) {
      if (other.addressLine1 != null) {
        return false;
      }
    } else if (!addressLine1.equals(other.addressLine1)) {
      return false;
    }
    if (addressLine2 == null) {
      if (other.addressLine2 != null) {
        return false;
      }
    } else if (!addressLine2.equals(other.addressLine2)) {
      return false;
    }
    if (city == null) {
      if (other.city != null) {
        return false;
      }
    } else if (!city.equals(other.city)) {
      return false;
    }
    if (country == null) {
      if (other.country != null) {
        return false;
      }
    } else if (!country.equals(other.country)) {
      return false;
    }
    if (region == null) {
      if (other.region != null) {
        return false;
      }
    } else if (!region.equals(other.region)) {
      return false;
    }
    if (state == null) {
      if (other.state != null) {
        return false;
      }
    } else if (!state.equals(other.state)) {
      return false;
    }
    if (zip == null) {
      if (other.zip != null) {
        return false;
      }
    } else if (!zip.equals(other.zip)) {
      return false;
    }
    return true;
  }
  
  
}
