package com.R3.daos;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.R3.beans.RestaurantBean;
import com.R3.beans.UserBean;

public class RestaurantDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void create(RestaurantBean restaurant){
		sessionFactory.getCurrentSession().save(restaurant);
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void delete(RestaurantBean restaurant){
		sessionFactory.getCurrentSession().delete(restaurant);
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void update(RestaurantBean restaurant){
		sessionFactory.getCurrentSession().saveOrUpdateCopy(restaurant);
	}
	@SuppressWarnings("unchecked")
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public List<RestaurantBean> findAllRestaurants(){
		return (List<RestaurantBean>) sessionFactory.getCurrentSession().createQuery("FROM R3_RESTAURANTS");
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public RestaurantBean findByRestaurant(RestaurantBean restaurant){
		return (RestaurantBean) sessionFactory.getCurrentSession().createCriteria(RestaurantBean.class).add(Restrictions.eq("restaurantId", restaurant.getRestaurantId()))
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void findOne(RestaurantBean restaurant){
		throw new UnexpectedTypeException();
	}

}
