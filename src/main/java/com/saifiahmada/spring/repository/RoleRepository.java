package com.saifiahmada.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
