package com.saifiahmada.spring.controller;

import java.sql.SQLException;
import java.util.Locale;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cetak")
public class CetakController {
	
	@Autowired
	private DataSource datasource;
	
	@ModelAttribute("page")
	public String getPage(){
		return "cetak";
	}
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String cetakForm(Model model) {
		return "kartu-tes-form";
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public ModelAndView getReport(@RequestParam("pilih") String pilih, @RequestParam("prodi") String prodi, ModelMap modelMap, ModelAndView modelAndView) throws SQLException {
		
		System.out.println("Pilih = " + pilih);
		System.out.println("Prodi = " + prodi);
		
		Locale locale = new Locale("in", "ID");
		
		modelMap.put("format", "pdf");
		modelMap.put("REPORT_CONNECTION", datasource.getConnection());
		modelMap.put("REPORT_LOCALE", locale);
	    
		if (pilih.equalsIgnoreCase("1")) {
			modelAndView = new ModelAndView("rpt_kartu_tes", modelMap);
		} else if (pilih.equalsIgnoreCase("2")) {
			modelAndView = new ModelAndView("rpt_wawancara", modelMap);
		} else if (pilih.equalsIgnoreCase("3")) {
			modelAndView = new ModelAndView("rpt_form_dokter", modelMap);
		} else if (pilih.equalsIgnoreCase("4")) {
			modelAndView = new ModelAndView("rpt_tes_urine", modelMap);
		} else if (pilih.equalsIgnoreCase("5")) {
			modelAndView = new ModelAndView("rpt_total_beban", modelMap);
		} else if (pilih.equalsIgnoreCase("6")) {
			modelMap.put("PRODI", prodi);
			modelAndView = new ModelAndView("rpt_beban_sks_prodi", modelMap);
		} else if (pilih.equalsIgnoreCase("7")) {
			modelAndView = new ModelAndView("rpt_interview_ortu", modelMap);
		}
		
		return modelAndView;
	}

}
