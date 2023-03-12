package com.bootjpa.demo.dao;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

import com.bootjpa.demo.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
	
	
//	List<Alien> findByTech(String tech);
}
