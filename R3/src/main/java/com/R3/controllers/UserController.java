package com.R3.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.R3.beans.UserBean;
import com.R3.daos.UserDAO;

@Controller
//@RequestMapping(value="/user/")
public class UserController {

		@Autowired
		private UserDAO dao;
		
		public void setDao(UserDAO dao)
		{
			this.dao = dao;
		}
		
		@RequestMapping(value="create", method=RequestMethod.POST,
				consumes=MediaType.APPLICATION_JSON_VALUE)// Accept=application/json
		@ResponseBody // do not redirect/forward.. rather write to response
		public void create(@Valid @RequestBody UserBean user){ 
							//look in request body and find UserBean
			dao.create(user);
		}// automagically converted JSON->object
		
		@RequestMapping(value="update", method=RequestMethod.PUT,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public void update(@Valid @RequestBody UserBean user){
			dao.update(user);
		}
		
		@RequestMapping(value="delete", method=RequestMethod.DELETE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public void delete(@Valid @RequestBody UserBean user){
			dao.delete(user);
		}
		
		@RequestMapping(value="/user/all", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<UserBean> findAll(){
			System.out.println("Made it to create!");
			return dao.findAllUsers();
		}// automagically converted object->JSON
		
}
