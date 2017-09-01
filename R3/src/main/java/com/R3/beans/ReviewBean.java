package com.R3.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="R3_REVIEW")
public class ReviewBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REVIEW_ID")
	private int id;
	@NotNull
	@Min(value=0)
	@Max(value=10)
	@Column(name="REVIEW_RATING")
	private int rating;
	@Size(min=0, max=300)
	@Column(name="REVIEW_DESCRIPTION")
	private String description;
	@ManyToOne
	@JoinColumn(nullable = true, name="RESTAURANT_ID")
	@JsonIgnore
	private RestaurantBean restaurant;
	@ManyToOne
	@JoinColumn(nullable = true, name="USER_ID")
	@JsonIgnore
	private UserBean user;
	
	public ReviewBean(int id, int rating, String description, RestaurantBean restaurant, UserBean user) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
		this.restaurant = restaurant;
		this.user = user;
	}

	public ReviewBean(){
		super();
	}

	@Override
	public String toString() {
		return "ReviewBean [id=" + id + ", rating=" + rating + ", description=" + description + ", user=" + user + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RestaurantBean getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantBean restaurant) {
		this.restaurant = restaurant;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + rating;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewBean other = (ReviewBean) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}
	


	
	
	
	
}
