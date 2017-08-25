package com.R3.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="R3_USER")
public class UserBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	@ManyToOne
	private int userId;
	@NotBlank
	@Size(max=20)
	@Column(name="USER_USERNAME")
	private String username;
	@NotBlank
	@Size(max=20)
	@Column(name="USER_PASSWORD")
	private String password;
	@Column(name="ROLE_ID")
	private int roleId;
	@Column(name="REVIEW_ID")
	@OneToMany(mappedBy="id") //In ReviewBean
	private int reviewId;
	
	private List<ReviewBean> listOfReviews;
	
	public UserBean(){
		super();
	}
	
	
	public UserBean(int userId, String username, String password, int roleId, int reviewId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.reviewId = reviewId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + reviewId;
		result = prime * result + roleId;
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserBean other = (UserBean) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (reviewId != other.reviewId)
			return false;
		if (roleId != other.roleId)
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", username=" + username + ", password=" + password + ", roleId=" + roleId
				+ ", reviewId=" + reviewId + "]";
	} 
	
	

}
