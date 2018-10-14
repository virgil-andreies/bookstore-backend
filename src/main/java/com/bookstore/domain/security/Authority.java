package com.bookstore.domain.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;


/**
 * @author andreiev
 *	Class created for implementing the Spring GrantedAuthority interface.
 *  GrantedAuthority can be seen as a "permission" or "right" and are normally
 *  expressed as strings (with the getAuthority method). The strings let you identify
 *  permissions and let your voters decide if they grant access to something
 *  
 *  @see <a href="https://stackoverflow.com/questions/19525380/difference-between-role-and-grantedauthority-in-spring-security">
 *  https://stackoverflow.com/questions/19525380/difference-between-role-and-grantedauthority-in-spring-security</a>
 *  	
 */
public class Authority implements GrantedAuthority, Serializable {
	private static final long serialVersionUID = 43246546778L;
	
	private final String authority;
	
	public Authority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		return authority;
	}

}
