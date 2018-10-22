package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.security.Role;
import com.bookstore.domain.User;
import com.bookstore.domain.security.UserRole;
import com.bookstore.service.UserService.UserService;

@SpringBootApplication
public class BookstoreBackendApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
		User user1 = new User();
		user1.setFirstName("Virgil");
		user1.setLastName("Andreies");
		user1.setUsername("virgil.andreies");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("andreiev"));
		user1.setEmail("w1r6h1l@gmail.com");

		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		userRoles.clear();
		
		User user2 = new User();
		user2.setFirstName("Admin");
		user2.setLastName("Admin");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user2.setEmail("bookstore.admin@gmail.com");

		Role role2 = new Role();
		role1.setRoleId(0);
		role1.setName("ROLE_ADMIN");
		
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);		
		userRoles.clear();
	}
}
