package com.mrcs.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "votes")
@NamedQueries({
		@NamedQuery(name = Vote.FIND_BY_USER_AND_DISCOVERY, query = "SELECT vote FROM Vote vote WHERE vote.user.id = :userId AND vote.discovery.id = :discoveryId")
})
public class Vote implements Serializable {

	public static final String FIND_BY_USER_AND_DISCOVERY = "Vote.findByUserAndDiscovery";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long voteId;

	@ManyToOne
	@JoinColumn(name = "discovery_id", referencedColumnName = "id")
	private Discovery discovery;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "userId")
	private User user;

	private Date timestamp;

	@Enumerated(EnumType.STRING)
	private VoteType voteType;


	public long getVoteId() {
		return voteId;
	}

	public void setVoteId(long voteId) {
		this.voteId = voteId;
	}

	public Discovery getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Discovery discovery) {
		this.discovery = discovery;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public VoteType getVoteType() {
		return voteType;
	}

	public void setVoteType(VoteType voteType) {
		this.voteType = voteType;
	}
}
