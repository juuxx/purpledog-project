package com.purpledog.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.purpledog.project.controller.dto.UserDto;
import com.purpledog.project.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	@PostMapping("/api/v1/user")
	public ResponseEntity<String> joinUser(@RequestBody UserDto userDto){
		String userId = userService.save(userDto);
		return ResponseEntity.ok(userId);
	}

	@GetMapping("/api/v1/user/{id}")
	public ResponseEntity<UserDto> findUserById(@PathVariable String id){
		UserDto userDto = userService.findById(id);
		return ResponseEntity.ok(userDto);
	}

	@PutMapping("/api/v1/user/{id}")
	public void updateUserById(@PathVariable String id, @RequestBody UserDto userDto){
		userService.update(id, userDto);
	}

	@DeleteMapping("/api/v1/user/{id}")
	public void deleteUserById(@PathVariable String id){
		userService.delete(id);
	}

}
