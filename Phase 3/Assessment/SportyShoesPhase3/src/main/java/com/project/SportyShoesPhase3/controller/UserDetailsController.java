package com.project.SportyShoesPhase3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.SportyShoesPhase3.entity.UserDetails;
import com.project.SportyShoesPhase3.service.UserDetailsService;

@Controller
public class UserDetailsController {
	@Autowired
	UserDetailsService userservice;
	
	
	@GetMapping("/index")
	public String viewUserDetails(Model model)
	{
		List<UserDetails> listUsers= userservice.listAll();
		System.out.println("listUsers" + listUsers);
		model.addAttribute("listUsers",listUsers);
		return "/index";
	}
	
	
	
	
	@GetMapping("/find")
	public ModelAndView findusername()
	{
		ModelAndView mav = new ModelAndView("finduser");
		mav.addObject("userdetail", new UserDetails());
		return mav;
	}
	
	
	@PostMapping("/find")
	public ModelAndView findUserName(@ModelAttribute("userdetail") UserDetails userdetails)
	{	
		List<UserDetails> users = userservice.get(userdetails.getUsername());
		if(users == null || users.isEmpty()) {
			return new ModelAndView("usernotfound");
		}
		ModelAndView mav = new ModelAndView("finduser");
		mav.addObject("listUsers", users);
		return mav;
	}
	
	
	
	

}
