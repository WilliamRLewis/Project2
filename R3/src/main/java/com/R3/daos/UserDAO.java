package com.R3.daos;

import java.util.List;

import javax.validation.UnexpectedTypeException;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.R3.beans.ReviewBean;
import com.R3.beans.UserBean;

public class UserDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED,
					propagation = Propagation.REQUIRED,
					rollbackFor = Exception.class)
	public void create(UserBean user){
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRED,
			rollbackFor = Exception.class)
	
	public void delete(UserBean user){
		sessionFactory.getCurrentSession().delete(user);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRED,
			rollbackFor = Exception.class)
	public void update(UserBean user){
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Transactional(isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRED,
			rollbackFor = Exception.class)
	public void findOne(UserBean user){
		sessionFactory.getCurrentSession().createCriteria(UserBean.class)
			.add(Restrictions.eq("userId", user.getUserId()));
	}
	@SuppressWarnings("unchecked")
	@Transactional(isolation = Isolation.READ_COMMITTED,
			propagation = Propagation.REQUIRED,
			rollbackFor = Exception.class)
	public List<UserBean> findAllUsers(){
																// .createQuery("FROM R3_USER"); same effect
			return (List<UserBean>) sessionFactory.getCurrentSession().createCriteria(UserBean.class).list(); 
	}
}
