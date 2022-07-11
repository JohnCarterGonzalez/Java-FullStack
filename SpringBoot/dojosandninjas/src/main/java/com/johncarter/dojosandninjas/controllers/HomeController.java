package com.johncarter.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.johncarter.dojoandninjas.services.DojoService;
import com.johncarter.dojoandninjas.services.NinjaService;
import com.johncarter.dojosandninjas.models.Dojo;
import com.johncarter.dojosandninjas.models.Ninja;

@Controller
public class HomeController {
	
	//Service
	@Autowired
	private NinjaService ninjas;
	@Autowired 
	private DojoService dojos;
	
	/*
	 * GET Routes for App
	 */
	
	@GetMapping("dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model m) {
		m.addAttribute("dojos", dojos.all());
		return "newNinja.jsp";
	}
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojos.find(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
	/*
	 * POST Routes for App
	 */
	
	@PostMapping("/dojos")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		Dojo newDojo = dojos.create(dojo);
		return String.format("redirect:/dojos/%s", newDojo.getId());
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja) {
		ninja = ninjas.create(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
}
	
