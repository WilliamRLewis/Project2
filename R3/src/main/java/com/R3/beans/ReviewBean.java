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
	@ManyToOne
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
	
	
	
	public ReviewBean(){
		super();
	}
	
	public ReviewBean(int id, int rating, String description, int restaurantId, int userId) {
		super();
		this.id = id;
		this.rating = rating;
		this.description = description;
		this.restaurantId = restaurantId;
		this.userId = userId;
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
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + rating;
		result = prime * result + restaurantId;
		result = prime * result + userId;
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
		if (restaurantId != other.restaurantId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReviewBean [id=" + id + ", rating=" + rating + ", description=" + description + ", restaurantId="
				+ restaurantId + ", userId=" + userId + "]";
	}

	
	
	
	
}
