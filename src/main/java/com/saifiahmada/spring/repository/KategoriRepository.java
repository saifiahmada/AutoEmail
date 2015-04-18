package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Kategori;

public interface KategoriRepository extends JpaRepository<Kategori, String> { 
	Page<Kategori> findByKategoriContaining(String kategori, Pageable pageable );
}
