package com.R3.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="R3_REVIEW")
public class ReviewBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REVIEW_ID")
	private int id;
	@Column(name="REVIEW_RATING")
	private int rating;
	@Column(name="REVIEW_DESCRIPTION")
	@OneToMany(mappedBy="ReviewBean")
	private String description;
	@Column(name="RESTAURANT_ID")
	@OneToMany(mappedBy="ReviewBean")
	private int restaurantId;
	@Column(name="USER_ID")
	private int userId;

}
