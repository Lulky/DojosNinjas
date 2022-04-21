package com.codingdojo.luciano.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.luciano.modelos.Dojos;
import com.codingdojo.luciano.servicios.NinjasService;

@Controller
@RequestMapping("/dojos")
public class DojosController {
	
	@Autowired
	private final NinjasService servicio;
	
	public DojosController(NinjasService servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping("/new")
	public String Registro(@ModelAttribute("dojo") Dojos dojo) {
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String Creat(@ModelAttribute("dojo") Dojos dojo) {
		servicio.save_dojo(dojo);
		return "redirect:/ninjas/new";
	}
	
	/*@GetMapping("/{id}")
	public String Dojo (@PathVariable("id") Long id, Model model) {
		Dojos dojo = servicio.find_dojo(id);
		model.addAttribute("dojo", dojo);
		
		return "dashboard.jsp";
		
	}*/
	
	@GetMapping("/{id}")
	public String newNInjas(@PathVariable("id") Long id, Model model) {
		
		Dojos dojo = servicio.find_dojo(id);
		
		model.addAttribute("dojo", dojo);
		
		return "dashboard.jsp";
	}
	
	
}
