package com.saifiahmada.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.saifiahmada.spring.domain.Tutorial;
import com.saifiahmada.spring.repository.TutorialRepository;

@Service
public class TutorialService {
	
	private static final int PAGE_SIZE = 10;
	
	@Autowired
	private TutorialRepository tutorialRepository;
	
	public void save(Tutorial tutorial){
		tutorialRepository.save(tutorial);
	}
	
	public Page<Tutorial> findAll(){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "judul");
		return tutorialRepository.findAll(request); 
	}
	
	public Page<Tutorial> findByJudulContaining(String judul){
		PageRequest request = new PageRequest(0 , PAGE_SIZE, Sort.Direction.ASC, "judul");
		return tutorialRepository.findByJudulContaining(judul, request); 
	}
	
    public Page<Tutorial> findAll(Integer pageNumber) {
        PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "judul");
        return tutorialRepository.findAll(request);
    }
	
}
