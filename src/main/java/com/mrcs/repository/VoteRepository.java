package com.mrcs.repository;


import com.mrcs.domain.Vote;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class VoteRepository {

	private EntityManager em;

	@Inject
	VoteRepository(EntityManager em) {
		this.em = em;
	}

	VoteRepository() {}

	public void save(Vote vote) {
		em.persist(vote);
	}

	public Vote getVoteByUserAndDiscovery(long userId, long discoveryId) {
		TypedQuery<Vote> query = em.createNamedQuery(Vote.FIND_BY_USER_AND_DISCOVERY, Vote.class);
		query.setParameter("userId", userId);
		query.setParameter("discoveryId", discoveryId);
		List<Vote> result = query.getResultList();
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	public void update(Vote vote) {
		em.merge(vote);
	}
}
