package com.user.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.user.login.entity.ResponseMessage;


@ControllerAdvice
public class UserNotFoundExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	private ResponseEntity<ResponseMessage> handleGenericException(Exception ex) {
		System.out.println("Error Message: " + ex.getMessage());

		ResponseMessage response = new ResponseMessage();
		response.setId(404);
		response.setStatus(HttpStatus.NOT_FOUND.name());
		response.setStatusCode(400);
		response.setMessage("User Not Found");
		return new ResponseEntity<ResponseMessage>(response,HttpStatus.NOT_FOUND);

	}
}
