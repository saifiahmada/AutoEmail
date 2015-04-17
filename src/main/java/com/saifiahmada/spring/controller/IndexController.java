package com.saifiahmada.spring.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	
	@ModelAttribute("page")
	public String getPage(){
		return "home";
	}
	
	@RequestMapping(value = "/form-admin", method=RequestMethod.GET)
	@Secured("ROLE_ADMIN")
	public String formAdmin(){
		return "form-admin";
	}
	
	@RequestMapping(value = "/form-user", method=RequestMethod.GET)
	@Secured("ROLE_USER")
	public String formUser(){
		return "form-user";
	}
	
	@RequestMapping(value = {"/","/index"}, method=RequestMethod.GET)
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public String index(){
		return "index";
	}
	
}
