package com.saifiahmada.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Kategori;
import com.saifiahmada.spring.domain.Mahasiswa;
import com.saifiahmada.spring.repository.MahasiswaRepositroy;

@Service
public class MahasiswaService {
	
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private MahasiswaRepositroy mahasiswaRepositroy;
	
	public void save(Mahasiswa mahasiswa){
		mahasiswaRepositroy.save(mahasiswa);
	}
	
	public Page<Mahasiswa> findByNamaContaining(String nama){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return mahasiswaRepositroy.findByNamaContaining(nama, request) ;
	}
	
	public Page<Mahasiswa> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return mahasiswaRepositroy.findAll(request);
    }
	
	public Page<Mahasiswa> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return mahasiswaRepositroy.findAll(request);
	}

}
