package com.bookstore.service.UserService;

import java.util.Set;

import com.bookstore.domain.security.User;
import com.bookstore.domain.security.UserRole;

public interface IUserService {
	
	User createUser(User user, Set<UserRole> userRoles);

}
