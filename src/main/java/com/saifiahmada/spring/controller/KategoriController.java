package com.saifiahmada.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saifiahmada.spring.domain.Kategori;
import com.saifiahmada.spring.domain.Tutorial;
import com.saifiahmada.spring.service.KategoriService;

@Controller
@RequestMapping("/kategori")
public class KategoriController {
	
	@Autowired
	private KategoriService kategoriService;
	
	@ModelAttribute("page")
	public String getPage(){
		return "kategori";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Tutorial());
		return "kategori-form";
	}
	
	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<Kategori> page = kategoriService.findAll(pageNumber);
	    model.addAttribute("dataModel", page);
	    return "kategori-list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,  Model model){
		Page<Kategori> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = kategoriService.findAll();
		} else {
			page = kategoriService.findByKategoriContaining(searchText);
		}
		 
		model.addAttribute("dataModel", page);
		return "kategori-list";
	}
	
	@ModelAttribute("entity")
	public Kategori getKategori(){
		return new Kategori();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("entity") Kategori kategori, Model model){
		if (kategori.getKategori() == null || kategori.getKategori().length() < 1) {
			model.addAttribute("pesan", "kategori belum diisi");
			return "kategori-form";
		}
		kategoriService.save(kategori);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "kategori-form";
	}

}
