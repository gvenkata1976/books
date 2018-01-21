package com.library.generic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.common.ResourceNotFoundException;

@Service
public class GenericService<T>   {
	
	GenericRepository<T> repo;

	public List<T> findAll() {
		List<T> target = new ArrayList<T>();
		repo.findAll().forEach(target::add);
		return target;
	}

	public T findOne(String tId) {
		T t = repo.findOne(new BigInteger(tId));
		if (t == null) {
			throw new ResourceNotFoundException(tId);
		}
		return t;
	}

	@Transactional(rollbackFor = { Exception.class }, readOnly = false)
	public void save(T t) {
		repo.save(t);
	}

	public void update(String id, T t) {
		if (repo.exists(new BigInteger(id))) {
			repo.save(t);
		}

	}

	public void delete(String id) {
		BigInteger key = new BigInteger(id);
		if (repo.exists(key)) {
			repo.delete(key);
		}
	}
 
}
