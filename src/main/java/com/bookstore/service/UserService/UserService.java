package com.bookstore.service.UserService;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookstore.domain.security.User;
import com.bookstore.domain.security.UserRole;
import com.bookstore.repositories.IRoleRepository;
import com.bookstore.repositories.IUserRepository;

@Service
public class UserService implements IUserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private IRoleRepository roleRepository;

	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByUsername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exists. Nothing will be done. ", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			localUser = userRepository.save(user);
			
		}
		
		return localUser;
	}
	
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

}
