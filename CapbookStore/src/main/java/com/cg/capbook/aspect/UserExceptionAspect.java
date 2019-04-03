package com.cg.capbook.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.EmptyStatusException;
import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.PhoneNumberAlreadyLinkedException;
import com.cg.capbook.exceptions.UserNotFoundException;

@ControllerAdvice
public class UserExceptionAspect {
	@ExceptionHandler(UserNotFoundException.class)
	public ModelAndView handelUserNotFoundException(Exception e) {
		return new ModelAndView("errorPage","errorMessage",e.getMessage());
	}


@ExceptionHandler(InvalidPasswordException.class)
public ModelAndView handelInvalidPasswordException(Exception e) {
	return new ModelAndView("errorPage","errorMessage",e.getMessage());
}

@ExceptionHandler(EmptyStatusException.class)
public ModelAndView handelEmptyStatusException(Exception e) {
	return new ModelAndView("errorPage","errorMessage",e.getMessage());
}

@ExceptionHandler(InvalidEmailException.class)
public ModelAndView handelInvalidEmailException(Exception e) {
	return new ModelAndView("errorPage","errorMessage",e.getMessage());
}

@ExceptionHandler(PhoneNumberAlreadyLinkedException.class)
public ModelAndView handelPhoneNumberAlreadylinkedException(Exception e) {
	return new ModelAndView("errorPage","errorMessage",e.getMessage());
}

@ExceptionHandler(EmailAlreadyExistException.class)
public ModelAndView handelEmailAlreadyExistException(Exception e) {
	return new ModelAndView("errorPage","errorMessage",e.getMessage());
}


}

