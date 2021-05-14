package com.accolite.msau.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.msau.dao.UserDao;
import com.accolite.msau.models.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	UserDao userdao;

	@Override
	public User getUserByEmail(String userEmail) {
		return userdao.getUserByEmail(userEmail);
	}


	@Override
	public List<User> getAllTrainers() {
		return userdao.getAllTrainers();
	}

	@Override
	public List<User> getAllCreators() {
		return userdao.getAllCreators();
	}

}
