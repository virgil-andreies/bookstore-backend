package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.UserPayment;

public interface IUserPaymentRepository extends CrudRepository<UserPayment, Long> {

}
