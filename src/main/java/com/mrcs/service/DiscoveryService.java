package com.mrcs.service;


import com.mrcs.domain.Discovery;
import com.mrcs.domain.User;
import com.mrcs.repository.DiscoveryRepository;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class DiscoveryService {

	@Inject
	DiscoveryRepository repository;

	public void addDiscovery(String name, String url, String description, User authenticatedUser) {

		Discovery discovery = new Discovery();
		discovery.setName(name);
		discovery.setUrl(url);
		discovery.setDescription(description);
		discovery.setUser(authenticatedUser);
		discovery.setTimestamp(LocalDateTime.now());

		repository.save(discovery);


	}

	public Set<Discovery> getAllDiscoveries() {
		Set<Discovery> discoveries = repository.getAllDiscoveries();

		return discoveries;

	}
}
