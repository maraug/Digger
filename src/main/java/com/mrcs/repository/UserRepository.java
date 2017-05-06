package com.mrcs.repository;


import com.mrcs.domain.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Stateless
public class UserRepository {

	private EntityManager em;

	UserRepository() {}

	@Inject
	UserRepository(EntityManager em) {
		this.em = em;
	}

	public void save(User user) {
		em.persist(user);
	}

	public User getUserByUsername(String username) {
		TypedQuery<User> query = em.createNamedQuery(User.FIND_BY_USERNAME, User.class);
		query.setParameter("username", username);
		return query.getSingleResult();
	}

}
