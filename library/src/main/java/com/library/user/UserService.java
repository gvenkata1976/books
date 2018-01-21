package com.library.user;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.common.ResourceNotFoundException;
import com.library.domain.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Transactional(readOnly = true)
	public List<User> list() {
		List<User> target = new ArrayList<User>();
		repo.findAll().forEach(target::add);
		return target;
	}

	@Transactional(readOnly = true)
	public User findOne(String id) {
		User user = repo.findOne(new BigInteger(id));
		if (user == null) {
			throw new ResourceNotFoundException(id);
		}
		return user;
	}

	@Transactional(rollbackFor = { Exception.class }, readOnly = false)
	public void save(User user) {
		repo.save(user);
	}

	public void update(String id, User user) {
		if (repo.exists(new BigInteger(id))) {
			user.setModifiedDate(new Date());
			repo.save(user);
		}
	}

	public void delete(String id) {
		BigInteger key = new BigInteger(id);
		if (repo.exists(key)) {
			repo.delete(key);
		}
	}

	private static List<User> userList = new ArrayList<User>();

	public void initAdminUser() {
		userList = list();
		if (userList.size() == 0) { 
			ObjectMapper mapper = new ObjectMapper();
			User user = null;
			try {
				user = mapper.readValue("user.json", User.class);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			save(user);
		}

	}

}
