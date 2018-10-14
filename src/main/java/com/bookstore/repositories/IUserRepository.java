package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.security.User;

public interface IUserRepository extends CrudRepository<User, Long>{
	User findByUsername(String username);
	User findByEmail(String email);
//	User findById(Long id);
	List<User> findAll();
}
