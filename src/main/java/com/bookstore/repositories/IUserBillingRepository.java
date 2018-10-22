package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.UserBilling;

public interface IUserBillingRepository extends CrudRepository<UserBilling, Long>{

}
