package com.R3.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.R3.beans.RestaurantBean;
import com.R3.daos.RestaurantDAO;

@Controller
@RequestMapping(value="restaurant")
public class RestaurantController {

		@Autowired
		private RestaurantDAO dao;
		
		public void setDao(RestaurantDAO dao)
		{
			this.dao = dao;
		}
		
		@RequestMapping(value="create", method=RequestMethod.POST,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody 
		public ResponseEntity<RestaurantBean> create(@RequestBody RestaurantBean restaurant){ 
							//look in request body and find RestaurantBean
			return new ResponseEntity<RestaurantBean>(this.dao.save(restaurant), HttpStatus.OK);
		}// automagically converted JSON->object
		
		@RequestMapping(value="update", method=RequestMethod.PUT,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public ResponseEntity<RestaurantBean> update(@Valid @RequestBody RestaurantBean restaurant){
			return new ResponseEntity<RestaurantBean>(this.dao.save(restaurant), HttpStatus.OK);
		}
		
		@RequestMapping(value="delete", method=RequestMethod.DELETE,
				consumes=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public void delete(@Valid @RequestBody RestaurantBean restaurant){
			dao.delete(restaurant);
		}
		
		@RequestMapping(value="all", method=RequestMethod.GET,
				produces=MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public List<RestaurantBean> findAll(){
			System.out.println("Made it to ReasturantDAO/findALL");
			return dao.findAllRestaurants();
		}// automagically converted object->JSON
		
}