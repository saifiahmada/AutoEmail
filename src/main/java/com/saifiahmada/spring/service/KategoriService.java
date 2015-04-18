package com.saifiahmada.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Kategori;
import com.saifiahmada.spring.domain.Tutorial;
import com.saifiahmada.spring.repository.KategoriRepository;

@Service
public class KategoriService {
	
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private KategoriRepository kategoriRepository;
	
	public void save(Kategori kategori){
		kategoriRepository.save(kategori); 
	}
	
	public Page<Kategori> findByKategoriContaining(String kategori){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "kategori");
		return kategoriRepository.findByKategoriContaining(kategori, request); 
	}
	
	public Page<Kategori> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "kategori");
		return kategoriRepository.findAll(request);
	}
	
	public Page<Kategori> findAllForDropdown(){
		PageRequest request = new PageRequest(0 , 100, Sort.Direction.ASC, "kategori");
		return kategoriRepository.findAll(request);
	}
	
    public Page<Kategori> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "kategori");
        return kategoriRepository.findAll(request);
    }
    
    public List<Kategori> findListAll(){
    	return kategoriRepository.findAll();
    }

}
