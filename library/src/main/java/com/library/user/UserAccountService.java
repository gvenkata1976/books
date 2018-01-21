package com.library.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.common.validations.Validations;
import com.library.domain.User;

@Service
public class UserAccountService  implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		User user = repo.findByUsername(username);
		Validations.notNull(user); 
		return user;
	}

}
