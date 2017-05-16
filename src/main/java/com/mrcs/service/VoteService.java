package com.mrcs.service;


import com.mrcs.domain.Discovery;
import com.mrcs.domain.User;
import com.mrcs.domain.Vote;
import com.mrcs.domain.VoteType;
import com.mrcs.repository.DiscoveryRepository;
import com.mrcs.repository.VoteRepository;

import javax.inject.Inject;
import java.util.Date;

public class VoteService {

	private VoteRepository voteRepository;
	private DiscoveryRepository discoveryRepository;

	@Inject
	VoteService(VoteRepository voteRepository, DiscoveryRepository discoveryRepository) {
		this.voteRepository = voteRepository;
		this.discoveryRepository = discoveryRepository;
	}

	public void processVote(User authenticatedUser, long discoveryId, String voteType) {

		long userId = authenticatedUser.getId();
		Vote vote = voteRepository.getVoteByUserAndDiscovery(userId, discoveryId);
		if (vote == null) {
			vote = new Vote();
			Discovery discovery = discoveryRepository.getDiscoveryById(discoveryId);
			vote.setDiscovery(discovery);
			vote.setUser(authenticatedUser);
			vote.setVoteType(VoteType.valueOf(voteType));
			vote.setTimestamp(new Date());
			voteRepository.save(vote);
		} else {
			vote.setVoteType(VoteType.valueOf(voteType));
			voteRepository.update(vote);
		}
	}


}
