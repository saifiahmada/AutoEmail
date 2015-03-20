package com.saifiahmada.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saifiahmada.spring.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
