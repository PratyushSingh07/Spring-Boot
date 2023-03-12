package com.bootjpa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootjpa.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {
	
	
//	List<Alien> findByTech(String tech);
}
