package com.project.SportyShoesPhase3.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.SportyShoesPhase3.entity.ChangePassword;
import com.project.SportyShoesPhase3.entity.Login;
import com.project.SportyShoesPhase3.entity.Signup;
import com.project.SportyShoesPhase3.service.LoginService;


@Controller
public class LoginController {

	@Autowired
	private LoginService ls;

	@GetMapping("/")
	public ModelAndView login() {
		
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user", new Login());
		return mav;
	}
	@GetMapping("/signup")
	public ModelAndView signin() {
		
		ModelAndView mav = new ModelAndView("signup");
		mav.addObject("user", new Signup());
		return mav;
	}
	@PostMapping("/signup")
	public ModelAndView signedin(@ModelAttribute("user") Signup signupUser) {
		if(signupUser.getPassword().equals(signupUser.getConfirmPassword())) {
			Login user = new Login(signupUser);
			ls.signUp(user);
			return new ModelAndView("login");
		}
		return new ModelAndView("invalid_credentials");
	}


	@PostMapping("/adminlogin")
	public ModelAndView signUp(@ModelAttribute("user") Login user, HttpSession session) {
		Login loginUser = null;
		System.out.println("from login"+ user);
		
		if(user.getPassword() != "" ) {
			System.out.println("logging in");	
			loginUser = ls.signgin(user.getUsername(), user.getPassword());
			if(loginUser != null)
			{
				ModelAndView menu = new ModelAndView("menu");
				session.setAttribute("user", loginUser);
				menu.addObject("username", loginUser.getUsername());
				return menu;
			}
			
		} 
		 
		return new ModelAndView("invalid_credentials");
	}
	@GetMapping("/changepassword")
	public ModelAndView changePassword(HttpSession session) {
		
		ModelAndView cpwd = new ModelAndView("changepassword");
		Login user = (Login)session.getAttribute("user");
		ChangePassword cp = new ChangePassword(user.getId(), user.getUsername());
		cpwd.addObject("user",cp);
		return cpwd;
	}
	@PostMapping("/changepassword")
	public ModelAndView passwordchanged(@ModelAttribute("user") ChangePassword changePassword) {
		if(!changePassword.getPassword().equals(changePassword.getNewPassword())) {
			Login user = new Login(changePassword);
			ls.signUp(user);
			return new ModelAndView("confirm_logout");
		}
		return new ModelAndView("invalid_credentials");
	}


	@RequestMapping("/logout")
	public String logoutDo()
	{
		return "confirm_logout";
	}
	
	
}

