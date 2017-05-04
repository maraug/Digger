package com.mrcs.service;

import com.mrcs.domain.User;
import com.mrcs.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class UserServiceTest {

	private UserService sut;
	private UserRepository repository;
	private User user;

	@Before
	public void setUp() {
		repository = mock(UserRepository.class);
		user = mock(User.class);
		sut = new UserService(repository);
	}

	@Test
	public void shouldSaveUser() {
		sut.addUser("a","b","c");

		verify(repository).save(user);

	}


}