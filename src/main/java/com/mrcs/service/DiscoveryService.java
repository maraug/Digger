package com.mrcs.service;


import com.mrcs.domain.Discovery;
import com.mrcs.domain.User;
import com.mrcs.domain.Vote;
import com.mrcs.domain.VoteType;
import com.mrcs.repository.DiscoveryRepository;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


public class DiscoveryService {

	@Inject
	private DiscoveryRepository repository;

	public void addDiscovery(String name, String url, String description, User authenticatedUser) {

		Discovery discovery = new Discovery();
		discovery.setName(name);
		discovery.setUrl(url);
		discovery.setDescription(description);
		discovery.setUser(authenticatedUser);
		discovery.setTimestamp(new Date());

		repository.save(discovery);
	}

	public List<Discovery> getAllDiscoveries() {
		List<Discovery> discoveries = repository.getAllDiscoveries();
		discoveries.forEach(this::countVotes);

		Comparator<Discovery> dateComparator = Comparator.comparing(Discovery::getTimestamp, Comparator.reverseOrder());
		discoveries.sort(dateComparator);

		return discoveries;
	}

	public Discovery getDiscoveryById(long discoveryId) {
		Discovery discovery = repository.getDiscoveryById(discoveryId);
		countVotes(discovery);
		return discovery;
	}

	private void countVotes(Discovery discovery) {
		Map<VoteType, Long> votesCount = discovery.getVotes().stream()
				.collect(Collectors.groupingBy(Vote::getVoteType, Collectors.counting()));
		System.out.println(votesCount);
		if (votesCount.containsKey(VoteType.UP_VOTE)) {
			discovery.setUpVote(votesCount.get(VoteType.UP_VOTE));
		}
		if (votesCount.containsKey(VoteType.DOWN_VOTE)) {
			discovery.setDownVote(votesCount.get(VoteType.DOWN_VOTE));
		}
	}
}
