package com.purpledog.project.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.purpledog.project.controller.dto.UserDto;
import com.purpledog.project.domain.user.User;
import com.purpledog.project.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private static final String MESSAGE_NOT_FOUND_USER_INFO = "와 일치하는 회원정보가 없습니다.";

	private final UserRepository userRepository;

	@Transactional
	public String save(UserDto userDto) {
		User user = userDto.toEntity();
		return userRepository.save(user).userId();
	}

	@Transactional
	public UserDto findById(String id) {
		return findByUser(id).toUserDto();
	}

	@Transactional
	public void update(String id, UserDto userDto) {
		User user = findByUser(id);
		user.updatePassword(userDto.getPassword());
	}

	@Transactional
	public void delete(String id) {
		User user = findByUser(id);
		userRepository.delete(user);
	}

	private User findByUser(String id) {
		return userRepository.findById(id)
							.orElseThrow(() -> new NullPointerException(id + MESSAGE_NOT_FOUND_USER_INFO));
	}


}
