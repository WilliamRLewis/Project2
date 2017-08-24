package com.R3.daos;

import java.util.List;

import com.R3.beans.RestaurantBean;
import com.R3.beans.ReviewBean;
import com.R3.beans.UserBean;

public interface ReviewDAO {
	
	public void create(ReviewBean review);
	public void update(ReviewBean review);
	public void delete(ReviewBean review);
	public ReviewBean find(ReviewBean review);
	public List<ReviewBean> findOnRestaurant(RestaurantBean restaurant);
	public List<ReviewBean> findOnUser(UserBean user);
	public List<ReviewBean>	findAll();

}
