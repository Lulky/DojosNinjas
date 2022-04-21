package com.codingdojo.luciano.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.luciano.modelos.Dojos;
import com.codingdojo.luciano.modelos.Ninjas;
import com.codingdojo.luciano.repositorios.DojosRepository;
import com.codingdojo.luciano.repositorios.NinjasRepository;

@Service
public class NinjasService {
	
	@Autowired
	private  NinjasRepository repositorio_ninja;
	
	@Autowired
	private  DojosRepository repositorio_dojo;
	
	
	
	
	
	public List<Ninjas> get_all() {
		return repositorio_ninja.findAll();
	}
	public List<Dojos> get_dojos(){
		return repositorio_dojo.findAll();
	}
	
	public Dojos find_dojo(Long id) {
		Optional<Dojos> optionalDojo = repositorio_dojo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public Dojos save_dojo(Dojos dojo) {
		return repositorio_dojo.save(dojo);
	}
	
	public Ninjas save_ninja(Ninjas ninja) {
		return repositorio_ninja.save(ninja);
	}
	

}
