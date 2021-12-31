package com.purpledog.project.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.purpledog.project.controller.dto.UserDto;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class User {

	@Id
	private String id;

	@Column
	private String password;

	@Builder
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String userId() {
		return id;
	}

	public UserDto toUserDto() {
		return UserDto.builder().id(id).password(password).build();
	}

	public void updatePassword(String password) {
		this.password = password;
	}
}
