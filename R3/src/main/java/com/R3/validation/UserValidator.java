package com.R3.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.R3.beans.UserBean;

public class UserValidator implements Validator {

	public boolean supports(Class<?> myClass) {
		return UserBean.class.equals(myClass);
	}

	public void validate(Object user, Errors errors) {
		UserBean myUser = (UserBean) user;
		
		// myUser.getRole().equalsIgnoreCase("ADMIN")
		if(!(myUser.getRole().equalsIgnoreCase("OWNER") || myUser.getRole().equalsIgnoreCase("USER") )) {
			errors.rejectValue("role", "No such role");	
		}
		
		

	}

}
