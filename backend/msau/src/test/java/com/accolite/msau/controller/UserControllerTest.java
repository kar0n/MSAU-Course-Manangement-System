package com.accolite.msau.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.accolite.msau.controllers.UserController;
import com.accolite.msau.models.User;
import com.accolite.msau.services.UserService;

@SpringBootTest()
@AutoConfigureMockMvc
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	User user1 = new User();
	User user2 = new User();
	List<User> list = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		user1.setUserId(1);
		user1.setName("Karan");
		user1.setEmail("karan.shah@accolitedigital.com");
		user1.setLocation("Mumbai");
		user1.setDesignation("Data Scientist");
		user1.setType("super");
		
		user2.setUserId(2);
		user2.setName("Karon");
		user2.setEmail("karon.shah@accolitedigital.com");
		user2.setLocation("Banglore");
		user2.setDesignation("Data Science");
		user2.setType("super");
		
		list.add(user1);
		list.add(user2);
	}
	
	@Test
	public void getUserByEmail() {
		Mockito.when(userService.getUserByEmail("karan.shah@accolitedigital.com")).thenReturn(user1);
		assertEquals(user1, userController.getUserByEmail("karan.shah@accolitedigital.com"));
	}

	
	@Test
	public void getAllTrainers() throws Exception{
		Mockito.when(userService.getAllTrainers()).thenReturn(list);
		assertEquals(list, userController.getAllTrainers());
		mockMvc.perform(get("/api/user/trainers")).andDo(print())
	    .andExpect(status().isOk());
	}
	
	
	
	@Test
	public void getAllCreators() {
		Mockito.when(userService.getAllCreators()).thenReturn(list);
		assertEquals(list, userController.getAllCreators());
	}
	
	
}
