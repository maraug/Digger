package com.mrcs.service;


import com.mrcs.domain.User;
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
		String hasedPass = PasswordUtils.digestPassword(password);
		User user = new User(username, hasedPass, email, "user");
		repository.save(user);
	}

	public void saveUserInSession(String username, HttpSession session) {
		User user = repository.getUserByUsername(username);
		session.setAttribute("user", user);
	}

	public User getUserByUsername(String username) {
		return repository.getUserByUsername(username);
	}

	public User getUserByUuid(String uuid) {
		return repository.getUserByUuid(uuid);
	}


	public Cookie createUserCookie(String username) {
		String uuid = UUID.randomUUID().toString();
		Cookie cookie = new Cookie("DiggerCookie", uuid);
		cookie.setPath("/login");
		cookie.setMaxAge(60*60*7);
		repository.setUserUuid(username, uuid);
		return cookie;
	}
}
