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
import com.saifiahmada.spring.domain.KasKeluar;
import com.saifiahmada.spring.service.BarangService;
import com.saifiahmada.spring.service.BarangService;
import com.saifiahmada.spring.service.KasKeluarService;

@Controller
@RequestMapping("/kaskeluar")
public class KasKeluarController {

	@Autowired
	private KasKeluarService kasKeluarService;

	@ModelAttribute("page")
	public String getPage() {
		return "kaskeluar";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new KasKeluar());
		return "kaskeluar-form";
	}

	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<KasKeluar> page = kasKeluarService.findAll(pageNumber);
		model.addAttribute("dataModel", page);
		return "kaskeluar-list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,
			Model model) {
		Page<KasKeluar> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = kasKeluarService.findAll();
		} else {
			page = kasKeluarService.findByPenerimaContaining(searchText);
		}

		model.addAttribute("dataModel", page);
		return "kaskeluar-list";
	}

	@ModelAttribute("entity")
	public KasKeluar getKasKeluar() {
		return new KasKeluar();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("entity") KasKeluar kasKeluar, Model model) {
		System.out.println("method save");
		kasKeluarService.save(kasKeluar);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "kaskeluar-form";
	}

}
