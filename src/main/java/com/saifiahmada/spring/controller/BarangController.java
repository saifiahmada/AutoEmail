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
import com.saifiahmada.spring.service.BarangService;
import com.saifiahmada.spring.service.BarangService;

@Controller
@RequestMapping("/barang")
public class BarangController {

	@Autowired
	private BarangService barangService;

	@ModelAttribute("page")
	public String getPage() {
		return "barang";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("pesan", null);
		model.addAttribute("entity", new Barang());
		return "barang-form";
	}

	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getKategoriPage(@PathVariable Integer pageNumber, Model model) {
		Page<Barang> page = barangService.findAll(pageNumber);
		model.addAttribute("dataModel", page);
		return "barang-list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,
			Model model) {
		Page<Barang> page = null;
		if (searchText == null || searchText.length() < 1) {
			page = barangService.findAll();
		} else {
			page = barangService.findByNamaContaining(searchText);
		}

		model.addAttribute("dataModel", page);
		return "barang-list";
	}

	@ModelAttribute("entity")
	public Barang getBarang() {
		return new Barang();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("entity") Barang barang,
			@RequestParam("file") MultipartFile file, Model model) {
		if (barang.getNama() == null || barang.getNama().length() < 1) {
			model.addAttribute("pesan", "nama belum diisi");
			return "barang-form";
		}

		if (file.isEmpty()) {
			model.addAttribute("message", "Gambar belum dipilih");
			return "barang-form";
		}

		try {

			if (file != null) {

				try {
					String extenstion = FilenameUtils.getExtension(file
							.getOriginalFilename());
					String fileName = barang.getNama() + "."+ extenstion;
					barang.setGambar(fileName);
					byte[] bytes = file.getBytes();
					// BufferedOutputStream buffStream = new
					// BufferedOutputStream(new FileOutputStream(new
					// File("/home/saifi/Desktop/foto/" + fileName)));
					BufferedOutputStream buffStream = new BufferedOutputStream(
							new FileOutputStream(new File("/home/saifi/Desktop/foto/"
									+ fileName)));
					buffStream.write(bytes);
					buffStream.close();
				} catch (Exception e) {
					model.addAttribute("message", "Error Upload Foto");
				}

			}

			barangService.save(barang);
			model.addAttribute("pesan", "Data berhasil disimpan");
			
		} catch (Exception e) {
			model.addAttribute("message", "Data  Error Disimpan");
			
		}

		barangService.save(barang);
		model.addAttribute("pesan", "Data berhasil disimpan");
		return "barang-form";
	}


}
