package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.BillingAddress;

public interface IBillingAddressRepository extends CrudRepository<BillingAddress, Long> {

}
