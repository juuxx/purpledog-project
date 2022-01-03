package com.purpledog.project.error;

public class UserNotFoundException extends RuntimeException {

	private static final String MESSAGE_NOT_FOUND_USER_INFO = "와 일치하는 회원정보가 없습니다.";

	public UserNotFoundException(String userId) {
		super(userId + MESSAGE_NOT_FOUND_USER_INFO);
	}
}
