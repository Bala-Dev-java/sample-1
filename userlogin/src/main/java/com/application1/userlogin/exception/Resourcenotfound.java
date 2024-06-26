package com.application1.userlogin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Resourcenotfound extends RuntimeException {
	
	public Resourcenotfound(String message)
	{
		super(message);
	}
	
	
	

}
