package com.mrcs.repository;


import com.mrcs.domain.Discovery;
import com.mrcs.domain.VoteType;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Stateless
public class DiscoveryRepository {

	private EntityManager em;

	@Inject
	public DiscoveryRepository(EntityManager em) {
		this.em = em;
	}

	DiscoveryRepository() {}

	public void save(Discovery discovery) {
		em.persist(discovery);
	}

	public List<Discovery> getAllDiscoveries() {
		TypedQuery<Discovery> query = em.createNamedQuery(Discovery.FIND_ALL, Discovery.class);
		return query.getResultList();
	}

	public Discovery getDiscoveryById(long discoveryId) {
		TypedQuery<Discovery> query = em.createNamedQuery(Discovery.FIND_BY_ID, Discovery.class);
		query.setParameter("discoveryId", discoveryId);
		return query.getSingleResult();
	}

}
