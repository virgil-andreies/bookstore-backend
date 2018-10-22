package com.bookstore.utility;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.bookstore.domain.User;

@Component
public class MailConstructor {
	
	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructNewUserEmail(User user, String password) {
		String message = "\n Please use the following credentials to log in and edit your personal information including your own password"
							+ "\n Username: " + user.getUsername() + "\n Password: " + password;
		
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Virgil's BookStore - New User");
		email.setText(message);
		email.setFrom(env.getProperty("support.email"));
		
		return email;
	}
}
