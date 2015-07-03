package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Mahasiswa;
import com.saifiahmada.spring.domain.MataKuliah;

public interface MataKuliahRepository extends JpaRepository<MataKuliah, String> {
	Page<MataKuliah> findByNamaContaining(String nama, Pageable pageable );
}
