package com.pine.documents;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Member")
public class Member {
  @Id
  private BigInteger uniqueId;
  private String memberId;
  private String name;
  private String idType;
  private String idNumber;
  private Address address;
  private List<String> interests;
  private String email;
  private String phone;
  private String bloodGroup;
  private String membershipTypeId;
  private String memberType;
  private String rating;

  /**
   * @return the uniqueId
   */
  public BigInteger getUniqueId() {
    return uniqueId;
  }

  /**
   * @param uniqueId
   *          the uniqueId to set
   */
  public void setUniqueId(BigInteger uniqueId) {
    this.uniqueId = uniqueId;
  }

  /**
   * @return the memberId
   */
  public String getMemberId() {
    return memberId;
  }

  /**
   * @param memberId
   *          the memberId to set
   */
  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name
   *          the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the idType
   */
  public String getIdType() {
    return idType;
  }

  /**
   * @param idType
   *          the idType to set
   */
  public void setIdType(String idType) {
    this.idType = idType;
  }

  /**
   * @return the idNumber
   */
  public String getIdNumber() {
    return idNumber;
  }

  /**
   * @param idNumber
   *          the idNumber to set
   */
  public void setIdNumber(String idNumber) {
    this.idNumber = idNumber;
  }

  /**
   * @return the address
   */
  public Address getAddress() {
    return address;
  }

  /**
   * @param address
   *          the address to set
   */
  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * @return the interests
   */
  public List<String> getInterests() {
    return interests;
  }

  /**
   * @param interests
   *          the interests to set
   */
  public void setInterests(List<String> interests) {
    this.interests = interests;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email
   *          the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @param phone
   *          the phone to set
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * @return the bloodGroup
   */
  public String getBloodGroup() {
    return bloodGroup;
  }

  /**
   * @param bloodGroup
   *          the bloodGroup to set
   */
  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  /**
   * @return the membershipTypeId
   */
  public String getMembershipTypeId() {
    return membershipTypeId;
  }

  /**
   * @param membershipTypeId
   *          the membershipTypeId to set
   */
  public void setMembershipTypeId(String membershipTypeId) {
    this.membershipTypeId = membershipTypeId;
  }

  public String getMemberType() {
    return memberType;
  }

  public void setMemberType(String memberType) {
    this.memberType = memberType;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((bloodGroup == null) ? 0 : bloodGroup.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((idNumber == null) ? 0 : idNumber.hashCode());
    result = prime * result + ((idType == null) ? 0 : idType.hashCode());
    result = prime * result + ((interests == null) ? 0 : interests.hashCode());
    result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
    result = prime * result + ((memberType == null) ? 0 : memberType.hashCode());
    result = prime * result + ((membershipTypeId == null) ? 0 : membershipTypeId.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    result = prime * result + ((rating == null) ? 0 : rating.hashCode());
    result = prime * result + ((uniqueId == null) ? 0 : uniqueId.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
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
    if (!(obj instanceof Member)) {
      return false;
    }
    Member other = (Member) obj;
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
    if (email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!email.equals(other.email)) {
      return false;
    }
    if (idNumber == null) {
      if (other.idNumber != null) {
        return false;
      }
    } else if (!idNumber.equals(other.idNumber)) {
      return false;
    }
    if (idType == null) {
      if (other.idType != null) {
        return false;
      }
    } else if (!idType.equals(other.idType)) {
      return false;
    }
    if (interests == null) {
      if (other.interests != null) {
        return false;
      }
    } else if (!interests.equals(other.interests)) {
      return false;
    }
    if (memberId == null) {
      if (other.memberId != null) {
        return false;
      }
    } else if (!memberId.equals(other.memberId)) {
      return false;
    }
    if (memberType == null) {
      if (other.memberType != null) {
        return false;
      }
    } else if (!memberType.equals(other.memberType)) {
      return false;
    }
    if (membershipTypeId == null) {
      if (other.membershipTypeId != null) {
        return false;
      }
    } else if (!membershipTypeId.equals(other.membershipTypeId)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (phone == null) {
      if (other.phone != null) {
        return false;
      }
    } else if (!phone.equals(other.phone)) {
      return false;
    }
    if (rating == null) {
      if (other.rating != null) {
        return false;
      }
    } else if (!rating.equals(other.rating)) {
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

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Member [uniqueId=" + uniqueId + ", memberId=" + memberId + ", name=" + name + ", idType=" + idType
        + ", idNumber=" + idNumber + ", address=" + address + ", interests=" + interests + ", email=" + email
        + ", phone=" + phone + ", bloodGroup=" + bloodGroup + ", membershipTypeId=" + membershipTypeId + ", memberType="
        + memberType + ", rating=" + rating + "]";
  }

}
