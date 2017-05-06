package com.mrcs.service;


import com.mrcs.domain.User;
import com.mrcs.domain.UserRole;
import com.mrcs.repository.UserRepository;
import com.mrcs.util.PasswordUtils;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.UUID;


public class UserService {

	private UserRepository repository;

	@Inject
	UserService(UserRepository repository) {
		this.repository = repository;
	}

	public void addUser(String username, String email, String password) {
		String hashedPass = PasswordUtils.digestPassword(password);
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(hashedPass);
		user.setRole(UserRole.USER);

		repository.save(user);
	}

	public void saveUserInSession(String username, HttpSession session) {
		User user = repository.getUserByUsername(username);
		session.setAttribute("user", user);
	}

	public User getUserByUsername(String username) {
		return repository.getUserByUsername(username);
	}

}
