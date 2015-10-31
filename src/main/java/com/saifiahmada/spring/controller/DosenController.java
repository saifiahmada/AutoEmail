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

import com.saifiahmada.spring.domain.Dosen;
import com.saifiahmada.spring.service.DosenService;

@Controller
@RequestMapping("/dosen")
public class DosenController {

	@Autowired
	private DosenService dosenService;

	@ModelAttribute("page")
	public String getPage() {
		return "dosen";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Dosen());
		return "dosen-form";
	}

	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<Dosen> page = dosenService.findAll(pageNumber);
		model.addAttribute("dataModel", page);
		return "dosen-list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,
			Model model) {
		Page<Dosen> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = dosenService.findAll();
		} else {
			page = dosenService.findByNamaContaining(searchText);
		}

		model.addAttribute("dataModel", page);
		return "dosen-list";
	}

	@ModelAttribute("entity")
	public Dosen getDosen() {
		return new Dosen();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("entity") Dosen dosen, Model model) {

		dosenService.save(dosen);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "dosen-form";
	}


}
