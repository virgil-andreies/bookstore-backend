package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.UserShipping;

public interface IUserShippingRepository extends CrudRepository<UserShipping, Long> {

}
