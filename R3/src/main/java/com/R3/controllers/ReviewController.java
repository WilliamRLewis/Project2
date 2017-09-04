package com.R3.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.R3.beans.RestaurantBean;
import com.R3.beans.ReviewBean;
import com.R3.daos.ImpReviewDAO;
import com.R3.daos.RestaurantDAO;
import com.R3.daos.ReviewDAO;

@Controller
@RequestMapping(value="/review/")
public class ReviewController {
	@Autowired
	private ImpReviewDAO dao;
	
	public void setDao(ImpReviewDAO dao)
	{
		this.dao = dao;
	}
	
	@RequestMapping(value="create", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody //BindingResult bind .hasErrors()
	public ResponseEntity<ReviewBean> create(@Valid @RequestBody ReviewBean review){ 
		return new ResponseEntity<ReviewBean>(this.dao.create(review), HttpStatus.CREATED);
	}
	@RequestMapping(value="update", method=RequestMethod.PUT,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<ReviewBean> update(@Valid @RequestBody ReviewBean review){
		review.setUser(dao.getOwner(review));
		return new ResponseEntity<ReviewBean>(this.dao.update(review), HttpStatus.OK);
	}
	
	@RequestMapping(value="delete", method=RequestMethod.DELETE,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void delete(@Valid @RequestBody ReviewBean review){
		dao.delete(review);
	}
	
	@RequestMapping(value="all", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<ReviewBean>> findAll(){
		System.out.println("Made it to ReviewController/findAll");
		return new ResponseEntity<List<ReviewBean>>(this.dao.findAll(), HttpStatus.OK);
	}
}
