package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Pembayaran;
import com.saifiahmada.spring.repository.PembayaranRepository;

@Service
public class PembayaranService {
	
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private PembayaranRepository pembayaranRepository;
	
	public void save(Pembayaran pembayaran){
		pembayaranRepository.save(pembayaran);
	}
	
	public Page<Pembayaran> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "nama");
        return pembayaranRepository.findAll(request);
    }

}
