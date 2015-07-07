package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Beban;
import com.saifiahmada.spring.repository.BebanRepository;

@Service
public class BebanService {
	
private static final int PAGE_SIZE = 10;
	
	@Autowired
	private BebanRepository bebanRepository;
	
	public void save(Beban mahasiswa){
		bebanRepository.save(mahasiswa);
	}
	
	public Page<Beban> findByNamaContaining(String nama){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return bebanRepository.findByNamaContaining(nama, request) ;
	}
	
	public Page<Beban> findByDosenPengampuContaining(String dosenPengampu){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "dosenPengampu");
		return bebanRepository.findByDosenPengampuContaining(dosenPengampu, request) ;
	}
	
	public Page<Beban> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return bebanRepository.findAll(request);
    }
	
	public Page<Beban> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return bebanRepository.findAll(request);
	}


}
