package com.R3.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.R3.beans.UserBean;
import com.R3.daos.UserDAO;

@Controller
public class LoginController {
	@Autowired
	private UserDAO dao;
	
	public void setDao(UserDAO dao)
	{
		this.dao = dao;
	}
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("home");
		return model;
	}

	
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout) {
		System.out.println("Made it to login!");
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}

		if (logout != null) {
			model.addObject("message", "Logged out from JournalDEV successfully.");
		}

		model.setViewName("home");
		return model;
	}
	@RequestMapping(value="login2", method=RequestMethod.POST,
					consumes=MediaType.APPLICATION_JSON_VALUE,
					produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<UserBean> login2(@RequestBody UserBean user){
		user.setRole("user");
		return new ResponseEntity<UserBean>(this.dao.authenticateUser(user),HttpStatus.OK);
	}

}

