package com.web.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.movie.entities.User;
import com.web.movie.repository.UserRepo;
@Controller
public class UserContoller {
	@Autowired
	private UserRepo userrepo;
	@RequestMapping("/")
	public String home(){
		return "Userlogin";
	}
	@RequestMapping("/login")
	public String UserPage(@RequestParam("userName") String userName,@RequestParam("password") String password, Model model) {
		User u=null;
		try {
			u=userrepo.findByName(userName);
		}
		catch(Exception e){
			System.out.println("User Not found!!");
		}
		if(u!=null) {
		model.addAttribute("UserName",userName);
		return "welcome";
		}
		model.addAttribute("error","Error:UserNotfound");
		return "Userlogin";
	}

}
