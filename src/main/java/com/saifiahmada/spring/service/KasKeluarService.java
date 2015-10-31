package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.KasKeluar;
import com.saifiahmada.spring.repository.KasKeluarRepository;

@Service
public class KasKeluarService {
	
private static final int PAGE_SIZE = 10;
	
	@Autowired
	private KasKeluarRepository kasKeluarRepository;
	
	public void save(KasKeluar kasKeluar){
		kasKeluarRepository.save(kasKeluar);
	}
	
	public Page<KasKeluar> findByPenerimaContaining(String penerima){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "penerima");
		return kasKeluarRepository.findByPenerimaContaining(penerima, request) ;
	}
	
	public Page<KasKeluar> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "penerima");
        return kasKeluarRepository.findAll(request);
    }
	
	public Page<KasKeluar> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "penerima");
		return kasKeluarRepository.findAll(request);
	}


}
