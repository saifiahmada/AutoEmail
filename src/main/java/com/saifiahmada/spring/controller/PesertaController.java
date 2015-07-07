package com.saifiahmada.spring.controller;

import java.sql.SQLException;

import java.util.Locale;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.saifiahmada.spring.domain.Peserta;
import com.saifiahmada.spring.service.PesertaService;

@Controller
@RequestMapping("/peserta")
public class PesertaController {
	
	@Autowired
	private DataSource datasource;

	@Autowired
	private PesertaService pesertaService;

	@ModelAttribute("page")
	public String getPage() {
		return "peserta";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Peserta());
		return "peserta-form";
	}

	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<Peserta> page = pesertaService.findAll(pageNumber);
		model.addAttribute("dataModel", page);
		return "peserta-list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,
			Model model) {
		Page<Peserta> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = pesertaService.findAll();
		} else {
			page = pesertaService.findByNamaContaining(searchText);
		}

		model.addAttribute("dataModel", page);
		return "peserta-list";
	}

	@ModelAttribute("entity")
	public Peserta getPeserta() {
		return new Peserta();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("entity") Peserta peserta,Model model) {
		if (peserta.getNama() == null || peserta.getNama().length() < 1) {
			model.addAttribute("pesan", "nama belum diisi");
			return "peserta-form";
		}

		pesertaService.save(peserta);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "peserta-form";
	}
	

}
