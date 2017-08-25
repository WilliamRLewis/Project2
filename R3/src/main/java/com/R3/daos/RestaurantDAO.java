package com.R3.daos;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import com.R3.beans.RestaurantBean;
import com.R3.beans.UserBean;

public class RestaurantDAO {
	public void create(RestaurantBean restaurant){}
	public void delete(RestaurantBean restaurant){}
	public void update(RestaurantBean restaurant){}
	public List<RestaurantBean> findAllRestaurants(){
		throw new UnsupportedOperationException();
	}
	public RestaurantBean findByRestaurant(RestaurantBean restaurant){
		throw new UnexpectedTypeException();
	}
	public void findOne(RestaurantBean restaurant){
		throw new UnexpectedTypeException();
	}

}
