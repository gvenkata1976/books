package com.pine.documents;

import java.math.BigInteger;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

@Document(collection = "users")
public class User {
  @Id
  private BigInteger id;
  private String userName;
  private String password;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;
  private boolean enabled;
  private String[] roles;

  public BigInteger getId() {
    return id;
  }

  public String getPassword() {
    return this.password;
  }

  public String[] getRoles() {
    return roles;
  }

  public String getUserName() {
    return this.userName;
  }

  public boolean isAccountNonLocked() {
    return this.accountNonLocked;
  }

  public boolean isCredentialsNonExpired() {
    return this.credentialsNonExpired;
  }

  public boolean isEnabled() {
    return this.enabled;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public boolean isAccountNonExpired() {
    return this.accountNonExpired;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  @Override
  public boolean equals(Object obj) {
    if (StringUtils.isEmpty(id))
      return super.equals(obj);
    return getClass().isInstance(obj) && id.equals(((User) obj).getId());
  }

  @Override
  public int hashCode() {
    return StringUtils.isEmpty(id) ? super.hashCode()
        : String.format("%s/%s", getClass().getSimpleName(), getId()).hashCode();
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", userName=" + userName + ", accountNonExpired=" + accountNonExpired
        + ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired + ", enabled="
        + enabled + ", roles=" + Arrays.toString(roles) + "]";
  }

}
