package com.bookstore.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.UserPayment;
import com.bookstore.repositories.IUserPaymentRepository;

@Service
public class UserPaymentService implements IUserPaymentService{
	
	@Autowired
	private IUserPaymentRepository userPaymentRepository;

	@Override
	public UserPayment findById(Long id) {
		return userPaymentRepository.findOne(id);
	}

	@Override
	public void removeById(Long id) {
		userPaymentRepository.delete(id);
	}

}
