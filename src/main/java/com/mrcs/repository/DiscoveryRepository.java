package com.mrcs.repository;


import com.mrcs.domain.Discovery;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Stateless
public class DiscoveryRepository {

	private EntityManager em;

	@Inject
	DiscoveryRepository(EntityManager em) {
		this.em = em;
	}

	DiscoveryRepository() {}

	public void save(Discovery discovery) {
		em.persist(discovery);
	}

	public Set<Discovery> getAllDiscoveries() {
		TypedQuery<Discovery> query = em.createNamedQuery(Discovery.FIND_ALL, Discovery.class);
		return new HashSet<>(query.getResultList());
	}
}
