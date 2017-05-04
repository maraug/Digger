package com.mrcs.service;


import com.mrcs.domain.User;
import com.mrcs.repository.UserRepository;
import com.mrcs.util.PasswordUtils;

import javax.inject.Inject;

public class UserService {

	@Inject
	private UserRepository repository;

	public void addUser(String username, String email, String password) {
		String hasedPass = PasswordUtils.digestPassword(password);
		User user = new User(username, hasedPass, email, "user");
		repository.save(user);
	}



}
