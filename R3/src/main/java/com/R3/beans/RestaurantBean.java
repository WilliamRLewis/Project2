package com.R3.beans;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity		 
@Table(name="R3_RESTAURANT")
public class RestaurantBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESTAURANT_ID")
	private int restaurantId;
	@Pattern(regexp="^[A-Za-z0-9 '!?@_&$#:]+$")
	@Column(name="RESTAURANT_NAME")
	private String restaurantName;
	@Pattern(regexp="^[A-Za-z ]+$")
	@Column(name="RESTAURANT_TYPE")
	private String type;
	@Pattern(regexp="^[A-Za-z0-9 :/()-_]+$")
	@Column(name="RESTAURANT_ADDRESS")
	private String address;
	@Column(name="RESTAURANT_HOURS")
	private String restaurantHours; //Later will be OperatingWeek
	@Pattern(regexp="^[0-9 -]+$")
	@Column(name="RESTAURANT_PHONE_NUMBER")
	private int phoneNumber;
	@Column(name="RESTAURANT_DATE_ESTABLISHED")
	@JsonFormat(pattern = "dd:MM:yyyy")
	private LocalDate foundingDate;
	@Pattern(regexp="^[A-Za-z0-9 '!?@_&$#:]+$")
	@Size(min=5, max=500)
	@Column(name="RESTAURANT_DESCRIPTION")
	private String description;
	@OneToOne
	@JoinColumn(name="USER_ID",
	nullable=false)
	private UserBean owner;
	@OneToMany(mappedBy="restaurant",fetch = FetchType.EAGER)
	private List<ReviewBean> allReviews;

	
	public RestaurantBean(){
		super();
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRestaurantHours() {
		return restaurantHours;
	}


	public void setRestaurantHours(String restaurantHours) {
		this.restaurantHours = restaurantHours;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public LocalDate getFoundingDate() {
		return foundingDate;
	}


	public void setFoundingDate(LocalDate foundingDate) {
		this.foundingDate = foundingDate;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public UserBean getOwner() {
		return owner;
	}


	public void setOwner(UserBean owner) {
		this.owner = owner;
	}


	public List<ReviewBean> getAllReviews() {
		return allReviews;
	}


	public void setAllReviews(List<ReviewBean> allReviews) {
		this.allReviews = allReviews;
	}


	public RestaurantBean(int id, String restaurantName, String type, String address, String restaurantHours,
			int phoneNumber, LocalDate foundingDate, String description) {
		super();
		this.restaurantId = id;
		this.restaurantName = restaurantName;
		this.type = type;
		this.address = address;
		this.restaurantHours = restaurantHours;
		this.phoneNumber = phoneNumber;
		this.foundingDate = foundingDate;
		this.description = description;
		//this.owner = owner;
	}
	public RestaurantBean(int restaurantId, String restaurantName, String type, String address, String restaurantHours,
			int phoneNumber, LocalDate foundingDate, String description, UserBean owner) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.type = type;
		this.address = address;
		this.restaurantHours = restaurantHours;
		this.phoneNumber = phoneNumber;
		this.foundingDate = foundingDate;
		this.description = description;
		this.owner = owner;
		this.allReviews = null;
	}


	@Override
	public String toString() {
		return "RestaurantBean [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", type=" + type
				+ ", address=" + address + ", restaurantHours=" + restaurantHours + ", phoneNumber=" + phoneNumber
				+ ", foundingDate=" + foundingDate + ", description=" + description + ", owner=" + owner
				+ ", allReviews=" + allReviews + "]";
	}


	
	
}
