package com.pine.documents;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class SecuredUserDetails implements UserDetails {

  private static final long serialVersionUID = 3972645848104927491L;
  private User user;

  public SecuredUserDetails(User user) {
    this.setUser(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return AuthorityUtils.createAuthorityList(this.user.getRoles());
  }

  @Override
  public String getPassword() {
    return this.user.getPassword();
  }

  @Override
  public String getUsername() {
    return this.user.getUserName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.user.isAccountNonExpired();
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.user.isAccountNonLocked();
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.user.isCredentialsNonExpired();
  }

  @Override
  public boolean isEnabled() {
    return this.user.isEnabled();
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
