package com.mrcs.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "discoveries")
@NamedQueries({
		@NamedQuery(name = Discovery.FIND_ALL, query = "SELECT d FROM Discovery d JOIN FETCH d.user"),
		@NamedQuery(name = Discovery.FIND_BY_ID, query = "SELECT d FROM Discovery d JOIN FETCH d.user WHERE d.id = :discoveryId")
})
public class Discovery extends BaseEntity {

	public static final String FIND_ALL = "Discovery.findAll";
	public static final String FIND_BY_ID = "Discovery.findById";

	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String url;

	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	private Date timestamp;

	@OneToMany(mappedBy = "discovery", fetch = FetchType.EAGER)
	private Set<Vote> votes;

	@Transient
	private long upVote;

	@Transient
	private long downVote;

	@OneToMany(mappedBy = "discovery", fetch = FetchType.EAGER)
	private Set<Comment> comments;

	public Discovery() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public long getUpVote() {
		return upVote;
	}

	public void setUpVote(long upVote) {
		this.upVote = upVote;
	}

	public long getDownVote() {
		return downVote;
	}

	public void setDownVote(long downVote) {
		this.downVote = downVote;
	}

	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

}
