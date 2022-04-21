package com.codingdojo.luciano.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luciano.modelos.Ninjas;

@Repository
public interface NinjasRepository extends CrudRepository<Ninjas, Long> {
	List<Ninjas> findAll(); //SELECT * FROM users
	List<Ninjas> findById(long id); //SELECT * FROM users WHERE id = <ID>
	
}
