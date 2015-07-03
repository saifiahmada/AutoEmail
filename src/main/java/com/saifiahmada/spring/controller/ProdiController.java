package com.saifiahmada.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FilenameUtils;
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

import com.saifiahmada.spring.domain.Barang;
import com.saifiahmada.spring.domain.Barang;
import com.saifiahmada.spring.domain.Prodi;
import com.saifiahmada.spring.service.BarangService;
import com.saifiahmada.spring.service.BarangService;
import com.saifiahmada.spring.service.ProdiService;

@Controller
@RequestMapping("/prodi")
public class ProdiController {

	@Autowired
	private ProdiService prodiService;

	@ModelAttribute("page")
	public String getPage() {
		return "prodi";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Prodi());
		return "prodi-form";
	}

	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<Prodi> page = prodiService.findAll(pageNumber);
		model.addAttribute("dataModel", page);
		return "prodi-list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,
			Model model) {
		Page<Prodi> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = prodiService.findAll();
		} else {
			page = prodiService.findByNamaContaining(searchText);
		}

		model.addAttribute("dataModel", page);
		return "prodi-list";
	}

	@ModelAttribute("entity")
	public Prodi getProdi() {
		return new Prodi();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("entity") Prodi prodi, Model model) {
		if (prodi.getNama() == null || prodi.getNama().length() < 1) {
			model.addAttribute("pesan", "nama belum diisi");
			return "prodi-form";
		}

		prodiService.save(prodi);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "prodi-form";
	}


}
