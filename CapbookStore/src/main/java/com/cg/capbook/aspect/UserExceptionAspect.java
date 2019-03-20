package com.cg.capbook.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionAspect {
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handelCustomerDetailsNotFoundException(Exception e) {
		return new ModelAndView("findUserDetailsPage","errorMessage",e.getMessage());
	}
}
