package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Kategori;
import com.saifiahmada.spring.domain.Mahasiswa;

public interface MahasiswaRepositroy extends JpaRepository<Mahasiswa, String> {
	Page<Mahasiswa> findByNamaContaining(String nama, Pageable pageable );
}
