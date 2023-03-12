package com.bootjpa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bootjpa.demo.dao.AlienRepo;
import com.bootjpa.demo.model.Alien;

@Controller
public class AlienController {
	@Autowired
	AlienRepo repo;
	@RequestMapping("/")
	public String home(){
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien); // saves the object in the database
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("showAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		System.out.println(repo.findByTech("Java"));
		mv.addObject(alien);
		return mv;
	}
} 


//@RequestParam is used to fetch the values from the client