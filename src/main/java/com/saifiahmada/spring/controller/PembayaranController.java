package com.saifiahmada.spring.controller;

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
import com.saifiahmada.spring.domain.Pembayaran;
import com.saifiahmada.spring.domain.Tutorial;
import com.saifiahmada.spring.service.KategoriService;
import com.saifiahmada.spring.service.PembayaranService;

@Controller
@RequestMapping("/pembayaran")
public class PembayaranController {
	
	@Autowired
	private PembayaranService pembayaranService;
	
	@ModelAttribute("page")
	public String getPage(){
		return "pembayaran";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Pembayaran());
		return "pembayaran-form";
	}
	
	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getPembayaranPage(@PathVariable Integer pageNumber, Model model) {
		Page<Pembayaran> page = pembayaranService.findAll(pageNumber);
	    model.addAttribute("dataModel", page);
	    return "pembayaran-list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,  Model model){
		/*Page<Kategori> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = kategoriService.findAll();
		} else {
			page = kategoriService.findByKategoriContaining(searchText);
		}*/
		 
		//model.addAttribute("dataModel", page);
		return "kategori-list";
	}
	
	@ModelAttribute("entity")
	public Pembayaran getPembayaran(){
		return new Pembayaran();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("entity") Pembayaran pembayaran, Model model){
		
		pembayaranService.save(pembayaran);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "pembayaran-form";
	}


}
