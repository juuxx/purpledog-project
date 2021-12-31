package com.purpledog.project.controller.dto;

import com.purpledog.project.domain.user.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserDto {

	private String id;
	private String password;

	@Builder
	public UserDto(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public User toEntity() {
		return User.builder()
			.id(id).password(password)
			.build();
	}
}
