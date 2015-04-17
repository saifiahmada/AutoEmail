package com.saifiahmada.spring.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saifiahmada.spring.domain.Role;
import com.saifiahmada.spring.domain.User;

import com.saifiahmada.spring.service.RoleService;
import com.saifiahmada.spring.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserContorller {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute("page")
	public String getPage(){
		return "user";
	}
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}

	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String form(){
		return "user-form";
	}
	
	@RequestMapping(value="/simpan", method=RequestMethod.POST)
	public String simpan(
			@Valid @ModelAttribute("user") User user,
			BindingResult bindingResult,
			Model model,
			@RequestParam(value = "cekAdmin",required=false)boolean cekAdmin,
			@RequestParam(value = "cekUser",required=false)boolean cekUser
			){
		
		model.addAttribute("user", user);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			return "redirect:/user/form.html?error";
		}
		
		List<Role> roles = new ArrayList<Role>();
		
		if (cekAdmin) {
			roles.add(roleService.findByName("ROLE_ADMIN"));
		} 
		
		if (cekUser) {
			roles.add(roleService.findByName("ROLE_USER"));
		} 
		user.setRoles(roles); 
		userService.save(user); 
		return "redirect:/user/form.html?success";
	}
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("users", userService.findAll());
		return "user-list";
	}
}
