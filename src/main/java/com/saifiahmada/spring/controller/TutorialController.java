package com.saifiahmada.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.saifiahmada.spring.domain.Kategori;
import com.saifiahmada.spring.domain.Tutorial;
import com.saifiahmada.spring.service.KategoriService;
import com.saifiahmada.spring.service.TutorialService;

@Controller
@RequestMapping(value="/tutorial")
public class TutorialController {
	
	@Value("${com.saifiahmada.spring.path}")
    private String path;
	
	@Autowired
	private TutorialService tutorialService;
	@Autowired
	private KategoriService kategoriService;
	
	@ModelAttribute("page")
	public String getPage(){
		return "tutorial";
	}
	
	@ModelAttribute("kategoris")
	public Page<Kategori> getKategoris(){
		return kategoriService.findAllForDropdown();
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form(Model model){
		model.addAttribute("pesan", null);
		model.addAttribute("tutorial", new Tutorial());
		return "tutorial-form";
	}
	
	@RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
	public String getTutorialPage(@PathVariable Integer pageNumber, Model model) {
		Page<Tutorial> page = tutorialService.findAll(pageNumber);
	    model.addAttribute("tutorials", page);
	    return "tutorial-list";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("judulText") String judul,  Model model){
		Page<Tutorial> page = null;
		if (judul == null || judul.length() < 1) {
			page = tutorialService.findAll();
		} else {
			//page = tutorialService.findByJudulContaining(judul);
			Kategori kategori = new Kategori("006added-281e-41e8-8681-f7776783ce4e");
			page = tutorialService.findByJudulOrKategoriContaining(judul, kategori);
		}
		System.out.println("judul = " + judul); 
		model.addAttribute("tutorials", page);
		return "tutorial-list";
	}
	
	@ModelAttribute("tutorial")
	public Tutorial getTutorial(){
		return new Tutorial();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("tutorial") Tutorial tutorial, @RequestParam("file") MultipartFile file, Model model){
		
		System.out.println("judul " + tutorial.getJudul());
		System.out.println("namaFIle " + tutorial.getNamaFile());
		System.out.println("id kategori " + tutorial.getKategori());
		
		String fileName = "awal.pdf";
		
		if (tutorial.getJudul() == null) {
			model.addAttribute("pesan", "data belum lengkap");
			return "tutorial-form";
		}
		
		if (file.isEmpty()) {
			model.addAttribute("pesan", "File belum diisi");
			return "tutorial-form";
		}
		
		if (file != null) {
			
			try {
				String extenstion = FilenameUtils.getExtension(file.getOriginalFilename());
				fileName = spaceToDash(tutorial.getJudul())+"."+extenstion;
                tutorial.setNamaFile(fileName); 
                byte[] bytes = file.getBytes();
        
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(path+fileName)));
                buffStream.write(bytes);
                buffStream.close();
            } catch (Exception e) {
            	model.addAttribute("pesan", "Error Upload File");
            }
			
		}
		
		tutorialService.save(tutorial);
		model.addAttribute("pesan", "Simpan data dan upload file [ "+ fileName +" ] sukses");
		model.addAttribute("tutorial", new Tutorial());
		System.out.println("Path = " + path); 
		return "tutorial-form";
	}
	
	private String spaceToDash(String text){
		String newText = text.replace(" ", "-");
		return newText == null ? "kosong" : newText;
	}
	
}
