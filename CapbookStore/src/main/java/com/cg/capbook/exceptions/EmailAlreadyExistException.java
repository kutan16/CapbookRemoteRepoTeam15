package com.cg.capbook.exceptions;

@SuppressWarnings("serial")
public class EmailAlreadyExistException extends Exception{

	public EmailAlreadyExistException() {
		super("Email already exists");
		// TODO Auto-generated constructor stub
	}

	public EmailAlreadyExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public EmailAlreadyExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public EmailAlreadyExistException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public EmailAlreadyExistException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
