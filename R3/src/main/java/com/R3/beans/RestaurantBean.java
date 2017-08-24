package com.R3.beans;

import java.time.LocalDate;
import java.util.List;

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
	
	private List<ReviewBean> allReviews;

	
	public RestaurantBean(){
		super();
	}
	
	public RestaurantBean(int restaurantId, int ownerId, int typeId, int addressId, int phoneNumber,
			String description) {
		super();
		this.restaurantId = restaurantId;
		this.ownerId = ownerId;
		this.typeId = typeId;
		this.addressId = addressId;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ReviewBean> getAllReviews() {
		return allReviews;
	}

	public void setAllReviews(List<ReviewBean> allReviews) {
		this.allReviews = allReviews;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ownerId;
		result = prime * result + phoneNumber;
		result = prime * result + restaurantId;
		result = prime * result + typeId;
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
		RestaurantBean other = (RestaurantBean) obj;
		if (addressId != other.addressId)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (ownerId != other.ownerId)
			return false;
		if (phoneNumber != other.phoneNumber)
			return false;
		if (restaurantId != other.restaurantId)
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RestaurantBean [restaurantId=" + restaurantId + ", ownerId=" + ownerId + ", typeId=" + typeId
				+ ", addressId=" + addressId + ", phoneNumber=" + phoneNumber + ", description=" + description + "]";
	}
	
	
	
	
}
