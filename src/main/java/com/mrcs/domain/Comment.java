package com.mrcs.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@NamedQueries({
		@NamedQuery(name = Comment.FIND_BY_DISCOVERY_ID, query = "SELECT c FROM Comment c JOIN FETCH c.author WHERE c.discovery.id = :discoveryId")
})
public class Comment extends BaseEntity {

	public static final String FIND_BY_DISCOVERY_ID = "Comment.findByDiscoveryId";

	@Column(nullable = false)
	private String content;

	private Date timestamp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User author;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "discovery_id")
	private Discovery discovery;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Discovery getDiscovery() {
		return discovery;
	}

	public void setDiscovery(Discovery discovery) {
		this.discovery = discovery;
	}
}
