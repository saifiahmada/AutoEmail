package com.saifiahmada.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saifiahmada.spring.domain.Mahasiswa;
import com.saifiahmada.spring.domain.MataKuliah;
import com.saifiahmada.spring.service.MataKuliahService;

@Controller
@RequestMapping("/matakuliah")
public class MataKuliahController {
	
	@Autowired
	private MataKuliahService mataKuliahService;
		
	@ModelAttribute("page")
	public String getPage(){
		return "matakuliah";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new MataKuliah());
		return "matakuliah-form";
	}
	
	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<MataKuliah> page = mataKuliahService.findAll(pageNumber);
	    model.addAttribute("dataModel", page);
	    return "matakuliah-list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,  Model model){
		Page<MataKuliah> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = mataKuliahService.findAll();
		} else {
			page = mataKuliahService.findByNamaContaining(searchText); 
		}
		 
		model.addAttribute("dataModel", page);
		return "matakuliah-list";
	}
	
	@ModelAttribute("entity")
	public MataKuliah getMataKuliah(){
		return new MataKuliah();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("entity") MataKuliah mataKuliah, Model model){
		if (mataKuliah.getNama() == null || mataKuliah.getNama().length() < 1) {
			model.addAttribute("pesan", "nama belum diisi");
			return "matakuliah-form";
		}
		mataKuliahService.save(mataKuliah);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "matakuliah-form";
	}

}
