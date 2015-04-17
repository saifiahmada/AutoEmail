package com.saifiahmada.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Role;
import com.saifiahmada.spring.domain.User;
import com.saifiahmada.spring.repository.RoleRepository;
import com.saifiahmada.spring.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			return null;
		}
		/*List<GrantedAuthority> auth = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		if (username.equals("admin")) {
			auth = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
		}*/
		//String password = user.getPassword();
		//System.out.println("user " + user.getUsername());
		//System.out.println("password " + user.getPassword());
		//System.out.println("auth = " + auth.get(0).getAuthority()); 
		//boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
		
		for (Role role : user.getRoles()){
			grantedAuths.add(new GrantedAuthorityImpl(role.getName())); 
		}
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
				user.getPassword(),
				user.getEnabled(),
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,grantedAuths
				);
	}
	
	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public List<User> findAll() {  
		return userRepository.findAll();
	}

}
