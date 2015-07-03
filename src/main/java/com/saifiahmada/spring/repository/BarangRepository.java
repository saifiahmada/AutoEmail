package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Barang;
import com.saifiahmada.spring.domain.Mahasiswa;

public interface BarangRepository extends JpaRepository<Barang, String> { 
	Page<Barang> findByNamaContaining(String nama, Pageable pageable );
}
