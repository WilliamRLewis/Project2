package com.R3.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.R3.beans.ReviewBean;
import com.R3.beans.UserBean;
import com.R3.daos.UserDAO;

@Controller
@RequestMapping(value="/user/")
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
		public ResponseEntity<UserBean> create(@RequestBody UserBean user){ 
							//look in request body and find UserBean
			return new ResponseEntity<UserBean>(this.dao.save(user), HttpStatus.OK);
		}// automagically converted JSON->object
		
		@RequestMapping(value="update", method=RequestMethod.PUT,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<UserBean> update(@Valid @RequestBody UserBean user){
			return new ResponseEntity<UserBean>(this.dao.save(user), HttpStatus.OK);
		}
		
		@RequestMapping(value="delete", method=RequestMethod.DELETE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public void delete(@Valid @RequestBody UserBean user){
			dao.delete(user);
		}
		
		@RequestMapping(value="all", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<List<UserBean>> findAll(){
			return new ResponseEntity<List<UserBean>>(this.dao.findAllUsers(), HttpStatus.OK);
		}// automagically converted object->JSON
		
		//You need to figure out how to send the userId with the get request!
		@RequestMapping(value="reviews", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<List<ReviewBean>> getReviews(@RequestHeader Integer userId){
			return new ResponseEntity<List<ReviewBean>>(this.dao.getAllReviewsByUserId(userId), HttpStatus.OK);
		}
}
