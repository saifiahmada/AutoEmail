package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Barang;
import com.saifiahmada.spring.domain.Barang;
import com.saifiahmada.spring.repository.BarangRepository;

@Service
public class BarangService {
	
private static final int PAGE_SIZE = 10;
	
	@Autowired
	private BarangRepository barangRepository;
	
	public void save(Barang mahasiswa){
		barangRepository.save(mahasiswa);
	}
	
	public Page<Barang> findByNamaContaining(String nama){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return barangRepository.findByNamaContaining(nama, request) ;
	}
	
	public Page<Barang> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return barangRepository.findAll(request);
    }
	
	public Page<Barang> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "nama");
		return barangRepository.findAll(request);
	}


}
