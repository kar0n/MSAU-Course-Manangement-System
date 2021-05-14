package com.accolite.msau.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accolite.msau.models.User;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.TrainingRowMapper;
import com.accolite.msau.rowmapper.UserRowMapper;

@SpringBootTest()
public class UserDaoTest {

	@Mock
    private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private UserDao userDao;
	
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
		when(jdbcTemplate.queryForObject(Queries.GET_USER_BY_EMAIL,UserRowMapper.UserRowMapperLambda,  user1.getEmail())).thenReturn(user1);
		assertEquals(user1, userDao.getUserByEmail(user1.getEmail()));
	}


	@Test
	public void getAllTrainers() {
		when(jdbcTemplate.query(Queries.GET_ALL_TRAINERS, UserRowMapper.UserRowMapperLambda)).thenReturn(list);
		assertEquals(list, userDao.getAllTrainers());
	}

	@Test
	public void getAllCreators() {
		when(jdbcTemplate.query(Queries.GET_ALL_CREATORS, UserRowMapper.UserRowMapperLambda)).thenReturn(list);
		assertEquals(list, userDao.getAllCreators());
	}
}
