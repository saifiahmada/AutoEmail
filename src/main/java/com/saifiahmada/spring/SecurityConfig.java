package com.saifiahmada.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.saifiahmada.spring.service.UserService;

@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
        .authorizeRequests()
            .antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();*/
		http.authorizeRequests().antMatchers("/login").permitAll().anyRequest()
		.fullyAuthenticated().and().formLogin().loginPage("/login")
		.failureUrl("/login?error").and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
		.exceptionHandling().accessDeniedPage("/access?error");
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		
		/*auth.inMemoryAuthentication().withUser("saifi").password("saifi").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");*/
		
		auth.userDetailsService(userService);

	}

}
