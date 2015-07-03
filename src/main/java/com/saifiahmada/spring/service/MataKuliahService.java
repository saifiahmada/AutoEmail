package com.saifiahmada.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.MataKuliah;
import com.saifiahmada.spring.domain.MataKuliah;
import com.saifiahmada.spring.repository.MataKuliahRepository;

@Service
public class MataKuliahService {
	
private static final int PAGE_SIZE = 10;
	
	@Autowired
	private MataKuliahRepository mataKuliahRepository;
	
	public void save(MataKuliah mataKuliah){
		mataKuliahRepository.save(mataKuliah);
	}
	
	public Page<MataKuliah> findByNamaContaining(String nama){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return mataKuliahRepository.findByNamaContaining(nama, request) ;
	}
	
	public Page<MataKuliah> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return mataKuliahRepository.findAll(request);
    }
	
	public Page<MataKuliah> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return mataKuliahRepository.findAll(request);
	}

}
