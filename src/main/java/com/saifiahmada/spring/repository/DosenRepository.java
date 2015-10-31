package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Dosen;

public interface DosenRepository extends JpaRepository<Dosen, String> { 
	Page<Dosen> findByNamaContaining(String nama, Pageable pageable );
}
