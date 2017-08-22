package com.R3.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="R3_USER")
public class UserBean {
	@Column(name="USER_ID")
	@Column(name="USER_USERNAME")
	@Column(name="USER_PASSWORD")
	@Column(name="ROLE_ID")

}
