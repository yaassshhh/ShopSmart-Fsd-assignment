package com.spring.shopsmart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shopsmart.exception.InvalidCredentialsException;
import com.spring.shopsmart.model.User;
import com.spring.shopsmart.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User verifyLogin(String username, String password) throws InvalidCredentialsException {
		
		return userRepository.verifyLogin(username,password);
	}

}
