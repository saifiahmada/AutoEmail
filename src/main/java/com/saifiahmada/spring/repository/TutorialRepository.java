package com.saifiahmada.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.saifiahmada.spring.domain.Kategori;
import com.saifiahmada.spring.domain.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, String> {
	
	Page<Tutorial> findByJudulContaining(String judul, Pageable pageable);
	Page<Tutorial> findByJudulOrKategoriContaining(String judul, Kategori kategori, Pageable pageable);
	
	public final static String FIND_BY_ADDRESS_QUERY = "SELECT t " + 
            "FROM Tutorial t JOIN t.addresses a " +
            "WHERE a.address = :address";
	
}
