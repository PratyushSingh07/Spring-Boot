package com.bootjpa.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("showAlien.jsp");
//		Alien alien=repo.findById(aid).orElse(new Alien());
////		System.out.println(repo.findByTech("Java"));
//		mv.addObject(alien);
////		Map<String,Object> map = mv.getModel();
//////		for(String i : map.keySet()) {
//////			System.out.println(i+" ");
//////		}
////		System.out.println(map.values().toString());
//		return mv;
//	}
	
	
	@RequestMapping("/getAliens")
	@ResponseBody
	public List<Alien> getAliens() {
		return repo.findAll(); //return data in json format
	}
	@RequestMapping("/getAliens/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid")int aid) {
		return repo.findById(aid); //returns data in json format
	} 
} 


//@RequestParam is used to fetch the values from the client