package com.pine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pine.documents.SecuredUserDetails;
import com.pine.documents.User;
import com.pine.repo.UserRepository;
@Component
public class MongoSecurityService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    System.out.println(username);
    User user = userRepository.findByUserName(username);
    System.out.println(user);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    } else { 
      return new SecuredUserDetails(user);
    }
  } 
}
