package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Prodi;
import com.saifiahmada.spring.domain.Prodi;
import com.saifiahmada.spring.repository.ProdiRepository;
import com.saifiahmada.spring.repository.ProdiRepository;

@Service
public class ProdiService {
	
private static final int PAGE_SIZE = 10;
	
	@Autowired
	private ProdiRepository prodiRepository;
	
	public void save(Prodi mahasiswa){
		prodiRepository.save(mahasiswa);
	}
	
	public Page<Prodi> findByNamaContaining(String nama){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return prodiRepository.findByNamaContaining(nama, request) ;
	}
	
	public Page<Prodi> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return prodiRepository.findAll(request);
    }
	
	public Page<Prodi> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return prodiRepository.findAll(request);
	}


}
