package com.web.movie.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.web.movie.services.MovieServiceImpl;

@Controller
public class MovieController {
	@Autowired
	private MovieServiceImpl msi;
	@RequestMapping("/homepage")
	public String homepage(Model model) {	
		
		
		model.addAttribute("ml",msi.getAllMovies());
		return "homepage";
	}
	
	

}
