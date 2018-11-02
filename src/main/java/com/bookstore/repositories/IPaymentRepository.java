package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.Payment;

public interface IPaymentRepository extends CrudRepository<Payment, Long> {

}
