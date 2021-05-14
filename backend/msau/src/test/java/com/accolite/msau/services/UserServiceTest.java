package com.accolite.msau.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.accolite.msau.dao.UserDao;
import com.accolite.msau.models.User;

@SpringBootTest()
public class UserServiceTest {
	
	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserDao userDao;
	
	User user = new User();
	List<User> list = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		user.setUserId(1);
		user.setType("super");
		user.setName("Karan");
		user.setEmail("karan.shah@accolitedigital.com");
		user.setLocation("Mumbai");
		user.setDesignation("Data Scientist");
		
		
		list.add(user);
		list.add(user);
	}
	
	@Test
	public void getUserByEmail() {
		Mockito.when(userDao.getUserByEmail("karan.shah@accolitedigital.com")).thenReturn(user);
		assertEquals(user, userService.getUserByEmail("karan.shah@accolitedigital.com"));
	}
	
	@Test
	public void getAllTrainers() {
		Mockito.when(userDao.getAllTrainers()).thenReturn(list);
		assertEquals(list, userDao.getAllTrainers());
	}
	
	@Test
	public void getAllCreators() {
		Mockito.when(userDao.getAllCreators()).thenReturn(list);
		assertEquals(list, userDao.getAllCreators());
	}

}
