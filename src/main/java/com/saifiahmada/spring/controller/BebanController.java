package com.saifiahmada.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.Locale;

import javax.sql.DataSource;

import org.apache.commons.io.FilenameUtils;
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

import com.saifiahmada.spring.domain.Beban;
import com.saifiahmada.spring.domain.Beban;
import com.saifiahmada.spring.service.BebanService;
import com.saifiahmada.spring.service.BebanService;

@Controller
@RequestMapping("/beban")
public class BebanController {
	
	@Autowired
	private DataSource datasource;

	@Autowired
	private BebanService bebanService;

	@ModelAttribute("page")
	public String getPage() {
		return "beban";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Beban());
		return "beban-form";
	}

	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<Beban> page = bebanService.findAll(pageNumber);
		model.addAttribute("dataModel", page);
		
		Double totalTeoriBeban = getTotalTeoriBeban(page, "teoriBeban");
		Double totalPraktikBeban = getTotalTeoriBeban(page, "praktikBeban");
		Double totalPraktikLapanganBeban = getTotalTeoriBeban(page, "praktikLapanganBeban");
		
		model.addAttribute("totalTeoriBeban", totalTeoriBeban);
		model.addAttribute("totalPraktikBeban", totalPraktikBeban);
		model.addAttribute("totalPraktikLapanganBeban", totalPraktikLapanganBeban);
		
		return "beban-list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,
			Model model) {
		Page<Beban> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = bebanService.findAll();
		} else {
			page = bebanService.findByDosenPengampuContaining(searchText);
		}
		model.addAttribute("dataModel", page);
		
		Double totalTeoriBeban = getTotalTeoriBeban(page, "teoriBeban");
		Double totalPraktikBeban = getTotalTeoriBeban(page, "praktikBeban");
		Double totalPraktikLapanganBeban = getTotalTeoriBeban(page, "praktikLapanganBeban");
		
		model.addAttribute("totalTeoriBeban", totalTeoriBeban);
		model.addAttribute("totalPraktikBeban", totalPraktikBeban);
		model.addAttribute("totalPraktikLapanganBeban", totalPraktikLapanganBeban);
		
		return "beban-list";
	}

	@ModelAttribute("entity")
	public Beban getBeban() {
		return new Beban();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("entity") Beban beban, Model model) {

		bebanService.save(beban);
		model.addAttribute("pesan", "Data [ "+ beban.getKodeProdi() + ", " + beban.getMataKuliah() + ", " + beban.getDosenPengampu() +" ] berhasil disimpan");
		return "beban-form";
	}
	
	private Double getTotalTeoriBeban(Page<Beban> page, String tipe){
		Double totalBeban = new Double(0);
		for (Beban b : page) {
			if (tipe.equalsIgnoreCase("teoriBeban")) {
				totalBeban = totalBeban + b.getTeoriBeban();
			} else if (tipe.equalsIgnoreCase("praktikBeban")) {
				totalBeban = totalBeban + b.getPraktikBeban();
			} else if (tipe.equalsIgnoreCase("praktikLapanganBeban")) {
				totalBeban = totalBeban + b.getPraktikLapanganBeban();
			}
			
		}
		return totalBeban; 
	}
	
	@RequestMapping(value = "/cetak", method = RequestMethod.POST)
	public ModelAndView getReport(ModelMap modelMap, ModelAndView modelAndView) throws SQLException {
		
		Locale locale = new Locale("in", "ID");
		
		modelMap.put("format", "pdf");
		modelMap.put("REPORT_CONNECTION", datasource.getConnection());
		modelMap.put("REPORT_LOCALE", locale);

		modelAndView = new ModelAndView("rpt_total_beban", modelMap);
		
		return modelAndView;
	}


}
