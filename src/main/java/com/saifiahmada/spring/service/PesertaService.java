package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Peserta;
import com.saifiahmada.spring.repository.PesertaRepository;

@Service
public class PesertaService {
	
private static final int PAGE_SIZE = 10;
	
	@Autowired
	private PesertaRepository pesertaRepository;
	
	public void save(Peserta peserta){
		pesertaRepository.save(peserta);
	}
	
	public Page<Peserta> findByNamaContaining(String nama){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return pesertaRepository.findByNamaContaining(nama, request) ;
	}
	
	public Page<Peserta> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return pesertaRepository.findAll(request);
    }
	
	public Page<Peserta> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return pesertaRepository.findAll(request);
	}


}
