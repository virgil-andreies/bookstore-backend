package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.security.Role;

public interface IRoleRepository extends CrudRepository<Role, Long> {

}
