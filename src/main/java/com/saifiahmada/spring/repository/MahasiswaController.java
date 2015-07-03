package com.saifiahmada.spring.repository;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.saifiahmada.spring.domain.Kategori;
import com.saifiahmada.spring.domain.Mahasiswa;
import com.saifiahmada.spring.domain.Tutorial;
import com.saifiahmada.spring.service.KategoriService;
import com.saifiahmada.spring.service.MahasiswaService;
import com.saifiahmada.spring.service.TutorialService;

@Controller
@RequestMapping("/mahasiswa")
public class MahasiswaController {
	
	@Autowired
	private MahasiswaService mahasiswaService;
		
	@ModelAttribute("page")
	public String getPage(){
		return "mahasiswa";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Mahasiswa());
		return "mahasiswa-form";
	}
	
	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<Mahasiswa> page = mahasiswaService.findAll(pageNumber);
	    model.addAttribute("dataModel", page);
	    return "mahasiswa-list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,  Model model){
		Page<Mahasiswa> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = mahasiswaService.findAll();
		} else {
			page = mahasiswaService.findByNamaContaining(searchText); 
		}
		 
		model.addAttribute("dataModel", page);
		return "mahasiswa-list";
	}
	
	@ModelAttribute("entity")
	public Mahasiswa getMahasiswa(){
		return new Mahasiswa();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("entity") Mahasiswa mahasiswa, Model model){
		if (mahasiswa.getNama() == null || mahasiswa.getNama().length() < 1) {
			model.addAttribute("pesan", "nama belum diisi");
			return "mahasiswa-form";
		}
		mahasiswaService.save(mahasiswa);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "mahasiswa-form";
	}

}
