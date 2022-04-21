package com.codingdojo.luciano.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.luciano.modelos.Dojos;

@Repository
public interface DojosRepository extends CrudRepository<Dojos, Long> {
	List<Dojos> findAll();
	List<Dojos> findById(long id);
}
