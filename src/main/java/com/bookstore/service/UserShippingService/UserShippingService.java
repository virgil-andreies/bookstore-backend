package com.bookstore.service.UserShippingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.UserShipping;
import com.bookstore.repositories.IUserShippingRepository;

@Service
public class UserShippingService implements IUserShippingService{

	@Autowired
	private IUserShippingRepository userShippingRepository;
	
	@Override
	public UserShipping findById(Long id) {
		return userShippingRepository.findOne(id);
	}

	@Override
	public void removeById(Long id) {
		userShippingRepository.delete(id);
	}

}
