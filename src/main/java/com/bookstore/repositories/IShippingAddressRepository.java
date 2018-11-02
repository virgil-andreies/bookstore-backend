package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.ShippingAddress;

public interface IShippingAddressRepository extends CrudRepository<ShippingAddress, Long> {

}
