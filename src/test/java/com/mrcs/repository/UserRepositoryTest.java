package com.mrcs.repository;

import com.mrcs.domain.User;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class UserRepositoryTest {

	private UserRepository sut;
	private EntityManager em;
	private User user;
	private TypedQuery query;
	private static String ANY_NAME = "name";

	@Before
	public void setUp() {
		em = mock(EntityManager.class);
		query = mock(TypedQuery.class);
		sut = new UserRepository(em);
		user = mock(User.class);
	}

	@Test
	public void savingUserShouldCallPersist() {
		sut.save(user);

		verify(em).persist(user);
	}

	@Test
	public void shouldReturnUserByUsernameIfExists() {
//		when(user.getUsername()).thenReturn(ANY_NAME);

		when(em.createNamedQuery(anyString(), any())).thenReturn(query);
		when(query.getSingleResult()).thenReturn(user);

		assertEquals(user, sut.getUserByUsername(ANY_NAME));
		verify(query).getSingleResult();
	}




}