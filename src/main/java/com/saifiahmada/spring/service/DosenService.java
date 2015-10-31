package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Dosen;
import com.saifiahmada.spring.repository.DosenRepository;

@Service
public class DosenService {
	
private static final int PAGE_SIZE = 10;
	
	@Autowired
	private DosenRepository dosenRepository;
	
	public void save(Dosen dosen){
		dosenRepository.save(dosen);
	}
	
	public Page<Dosen> findByNamaContaining(String nama){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return dosenRepository.findByNamaContaining(nama, request) ;
	}
	
	public Page<Dosen> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return dosenRepository.findAll(request);
    }
	
	public Page<Dosen> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return dosenRepository.findAll(request);
	}
}
