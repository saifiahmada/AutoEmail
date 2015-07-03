package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Peserta;

public interface PesertaRepository extends JpaRepository<Peserta, String> { 
	Page<Peserta> findByNamaContaining(String nama, Pageable pageable );
}
