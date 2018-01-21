package com.pine.documents;

import java.math.BigInteger;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

@Document(collection = "members")
public class Member { 
  @Id
  private BigInteger id;
  @NotNull(message = "Member Id is required")
  private String memberId;
  private String memberType;
  private String membershipTypeId;
  private String name;
  private String idProofType;
  private String idProofNumber;
  private Address address;
  private List<String> interests;
  private String email;
  private String phone;
  private String bloodGroup;
  private String rating;

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getMemberType() {
    return memberType;
  }

  public void setMemberType(String memberType) {
    this.memberType = memberType;
  }

  public String getMembershipTypeId() {
    return membershipTypeId;
  }

  public void setMembershipTypeId(String membershipTypeId) {
    this.membershipTypeId = membershipTypeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdProofType() {
    return idProofType;
  }

  public void setIdProofType(String idProofType) {
    this.idProofType = idProofType;
  }

  public String getIdProofNumber() {
    return idProofNumber;
  }

  public void setIdProofNumber(String idProofNumber) {
    this.idProofNumber = idProofNumber;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<String> getInterests() {
    return interests;
  }

  public void setInterests(List<String> interests) {
    this.interests = interests;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getBloodGroup() {
    return bloodGroup;
  }

  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  public String getRating() {
    return rating;
  }

  public void setRating(String rating) {
    this.rating = rating;
  }

  @Override
  public boolean equals(Object obj) {
    if (StringUtils.isEmpty(id))
      return super.equals(obj);

    return getClass().isInstance(obj) && id.equals(((Member) obj).getId());
  }

  @Override
  public int hashCode() {
    return StringUtils.isEmpty(id) ? super.hashCode()
        : String.format("%s/%s", getClass().getSimpleName(), getId()).hashCode();
  }

  @Override
  public String toString() {
    return "Member [id=" + id + ", memberId=" + memberId + ", memberType=" + memberType + ", membershipTypeId="
        + membershipTypeId + ", name=" + name + ", idProofType=" + idProofType + ", idProofNumber=" + idProofNumber
        + ", address=" + address + ", interests=" + interests + ", email=" + email + ", phone=" + phone
        + ", bloodGroup=" + bloodGroup + ", rating=" + rating + "]";
  } 
}
