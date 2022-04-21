package com.codingdojo.luciano.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.luciano.modelos.Dojos;
import com.codingdojo.luciano.modelos.Ninjas;
import com.codingdojo.luciano.servicios.NinjasService;

@Controller
@RequestMapping("/ninjas")
public class NinjasController {
	
	@Autowired
	private  NinjasService servicio;
	
	
	
	@GetMapping("/new")
	public String ninjas(Model model, @ModelAttribute("ninja") Ninjas ninja) {
		
		List<Dojos> dojos= servicio.get_dojos();
		model.addAttribute("dojos", dojos);
		return "new.jsp";
	}
	
	@PostMapping("/crear")
	public String Creat(@ModelAttribute("ninja") Ninjas ninja) {
		Ninjas ninji = servicio.save_ninja(ninja);
		return "redirect:/dojos/"+ ninji.getDojo().getId();
	}
	
	
	
	
}
