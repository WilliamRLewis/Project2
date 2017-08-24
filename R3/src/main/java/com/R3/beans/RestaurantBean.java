package com.R3.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="R3_RESTAURANT")
public class RestaurantBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@ManyToOne
	@Column(name="RESTAURANT_ID")
	private int restaurantId;
	@Column(name="OWNER_ID")
	private int ownerId;
	@Column(name="TYPE_ID")
	private int typeId;
	@Column(name="ADDRESS_ID")
	private int addressId;
	@Column(name="RESTAURANT_HOURS")
	private String restaurantHours; //Later will be OperatingWeek
	@Column(name="RESTAURANT_PHONE_NUMBER")
	private int phoneNumber;
	@Column(name="RESTAURANT_DATE_ESTABLISHED")
	private LocalDate foundingDate;
	@ManyToOne
	@Column(name="RESTAURANT_DESCRIPTION")
	private String description;
}
