package com.R3.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.R3.beans.RestaurantBean;
import com.R3.beans.ReviewBean;
import com.R3.beans.UserBean;

public class ImpReviewDAO implements ReviewDAO {
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void create(ReviewBean review) {
		sessionFactory.getCurrentSession().save(review);

	}
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void update(ReviewBean review) {
		sessionFactory.getCurrentSession().update(review);

	}
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void delete(ReviewBean review) {
		sessionFactory.getCurrentSession().delete(review);

	}
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ReviewBean find(ReviewBean review) {
		throw new UnsupportedOperationException(); 
	}

	public List<ReviewBean> findOnRestaurant(RestaurantBean restaurant) {
		throw new UnsupportedOperationException(); 
	}

	public List<ReviewBean> findOnUser(UserBean user) {
		throw new UnsupportedOperationException(); 
	}

	@SuppressWarnings("unchecked")
	public List<ReviewBean> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(ReviewBean.class).list();
	}

}
