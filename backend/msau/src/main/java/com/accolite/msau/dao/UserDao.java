package com.accolite.msau.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accolite.msau.models.User;
import com.accolite.msau.queries.Queries;
import com.accolite.msau.rowmapper.UserRowMapper;

@Repository
public class UserDao implements IUserDao {
	
	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User getUserByEmail(String userEmail) {
		User u = null;
		try {
			u = jdbcTemplate.queryForObject(Queries.GET_USER_BY_EMAIL, UserRowMapper.UserRowMapperLambda, userEmail);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return u;
	}

	@Override
	public List<User> getAllTrainers() {
		List<User> u = null;
		try {
			u = jdbcTemplate.query(Queries.GET_ALL_TRAINERS, UserRowMapper.UserRowMapperLambda);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return u;
	}

	@Override
	public List<User> getAllCreators() {
		List<User> u = null;
		try {
			u = jdbcTemplate.query(Queries.GET_ALL_CREATORS, UserRowMapper.UserRowMapperLambda);
		}catch(Exception e) {
			log.error("{}", e);
		}
		return u;
	}

}
