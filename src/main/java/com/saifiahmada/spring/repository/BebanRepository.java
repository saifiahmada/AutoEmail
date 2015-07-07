package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Barang;
import com.saifiahmada.spring.domain.Beban;
import com.saifiahmada.spring.domain.Mahasiswa;

public interface BebanRepository extends JpaRepository<Beban, String> { 
	Page<Beban> findByNamaContaining(String nama, Pageable pageable );
	Page<Beban> findByDosenPengampuContaining(String dosenPengampu, Pageable pageable );
}
