package com.R3.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.R3.beans.UserBean;
import com.R3.daos.UserDAO;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDAO dao;
	
	public void setDao(UserDAO dao)
	{
		this.dao = dao;
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		authenticationMgr.inMemoryAuthentication()
			.withUser("test").password("test").authorities("ROLE_USER")
			.and()
			.withUser("test2").password("test2").authorities("ROLE_USER","ROLE_WINNER");
		
		List<UserBean> myUsers = dao.findAllUsers();
		for(UserBean user: myUsers)
		{
			authenticationMgr.inMemoryAuthentication()
			.withUser(user.getUsername()).password(user.getPassword()).authorities("ROLE_" + user.getRole().toUpperCase());
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.httpBasic();
		
	}
}

