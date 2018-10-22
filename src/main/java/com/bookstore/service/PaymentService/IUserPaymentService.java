package com.bookstore.service.PaymentService;

import com.bookstore.domain.UserPayment;

public interface IUserPaymentService {
	UserPayment findById(Long id);
	void removeById(Long id);
}
