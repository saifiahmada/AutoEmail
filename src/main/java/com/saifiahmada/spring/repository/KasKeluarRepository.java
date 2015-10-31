package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.KasKeluar;

public interface KasKeluarRepository extends JpaRepository<KasKeluar, String> { 
	Page<KasKeluar> findByPenerimaContaining(String penerima, Pageable pageable );
}
