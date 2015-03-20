package com.saifiahmada.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.User;
import com.saifiahmada.spring.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			return null;
		}
		List<GrantedAuthority> auth = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		if (username.equals("admin")) {
			auth = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
		}
		String password = user.getPassword();
		System.out.println("user " + user.getUsername());
		System.out.println("password " + user.getPassword());
		System.out.println("auth = " + auth.get(0).getAuthority()); 
		return new org.springframework.security.core.userdetails.User(username, password,
				auth);
	}

}
