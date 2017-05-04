package com.mrcs.repository;


import com.mrcs.domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserRepository {

	@PersistenceContext
	private EntityManager em;

	public void save(User user) {
		em.persist(user);
	}

	public User getUserByUsername(String username) {
		System.out.println(" IN REPO USERNAME:" + username);
		TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_USERNAME, User.class);
		query.setParameter("username", username);
		User user =  query.getSingleResult();

		return user;
	}
}
