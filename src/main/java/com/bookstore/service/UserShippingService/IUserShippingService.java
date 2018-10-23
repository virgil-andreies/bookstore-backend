package com.bookstore.service.UserShippingService;

import com.bookstore.domain.UserShipping;

public interface IUserShippingService {
	
	UserShipping findById(Long id);
	
	void removeById(Long id);
}
