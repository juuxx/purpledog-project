package com.purpledog.project.controller;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.purpledog.project.error.UserNotFoundException;
import com.purpledog.project.service.UserService;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	UserService userService;


	@Test
	@DisplayName("가입되지 않은 아이디일 경우 error 리턴")
	void errorTest() throws Exception {
		String id = "1234";

		given(userService.findById(anyString()))
			.willThrow(UserNotFoundException.class);

		mvc.perform(get("/api/v1/user/" + id)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(status().is4xxClientError());
	}
}