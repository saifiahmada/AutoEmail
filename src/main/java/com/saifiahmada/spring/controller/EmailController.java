package com.saifiahmada.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {
	
	@ModelAttribute("page")
	public String getPage(){
		return "email";
	}
	
	@RequestMapping(value = "/email", method=RequestMethod.GET)
	public String email(){
		return "email";
	}

}
