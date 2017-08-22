package com.R3.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="R3_RESTAURANT")
public class RestaurantBean {
	@Column(name="RESTAURANT_ID")
	
	@Column(name="OWNER_ID")
	@Column(name="TYPE_ID")
	@Column(name="ADDRESS_ID")
	@Column(name="RESTAURANT_HOURS")
	@Column(name="RESTAURANT_PHONE_NUMBER")
	@Column(name="RESTAURANT_DATE_ESTABLISHED")
	@Column(name="RESTAURANT_DESCRIPTION")
	
}
