package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Barang;
import com.saifiahmada.spring.domain.Prodi;

public interface ProdiRepository extends JpaRepository<Prodi, String> { 
	Page<Prodi> findByNamaContaining(String nama, Pageable pageable );
}
