package com.R3.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.R3.beans.ReviewBean;

public class ReviewValidator implements Validator {

	public boolean supports(Class<?> myClass) {
		return ReviewBean.class.equals(myClass);
	}

	public void validate(Object user, Errors errors) {
		ReviewBean myUser = (ReviewBean) user;
		
		if(myUser.getRating() < 0 || myUser.getRating() > 10){
			errors.rejectValue("rating", "name[null name]");
			
		}

	}

}
