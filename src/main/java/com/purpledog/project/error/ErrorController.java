package com.purpledog.project.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ErrorController {
	private static final String MESSAGE_NOT_FOUND_USER_INFO = "와 일치하는 회원정보가 없습니다.";

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> UserNotFoundException(UserNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
			.body(new ErrorResponse(e.getMessage() + MESSAGE_NOT_FOUND_USER_INFO));
	}
}
