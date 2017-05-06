package com.mrcs.domain;


import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "discoveries")
@NamedQueries({
		@NamedQuery(name = Discovery.FIND_ALL, query = "SELECT d FROM Discovery d")
})
public class Discovery {

	public static final String FIND_ALL = "Discovery.findAll";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long discoveryId;

	private String name;
	private String description;
	private String url;

	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;

	private LocalDateTime timestamp;

	private int upVote;
	private int downVote;

	public Discovery() {}

	public Discovery(Discovery discovery) {
		this.discoveryId = discovery.discoveryId;
		this.name = discovery.name;
		this.description = discovery.description;
		this.url = discovery.url;
		this.user = discovery.user;

		this.timestamp = discovery.timestamp;

		this.upVote = discovery.upVote;
		this.downVote = discovery.downVote;
	}

	public long getDiscoveryId() {
		return discoveryId;
	}

	public void setDiscoveryId(long discoveryId) {
		this.discoveryId = discoveryId;
	}

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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getUpVote() {
		return upVote;
	}

	public void setUpVote(int upVote) {
		this.upVote = upVote;
	}

	public int getDownVote() {
		return downVote;
	}

	public void setDownVote(int downVote) {
		this.downVote = downVote;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Discovery discovery = (Discovery) o;

		if (discoveryId != discovery.discoveryId) return false;
		if (!name.equals(discovery.name)) return false;
		if (!description.equals(discovery.description)) return false;
		if (!url.equals(discovery.url)) return false;
		if (!user.equals(discovery.user)) return false;
		return timestamp != null ? timestamp.equals(discovery.timestamp) : discovery.timestamp == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (discoveryId ^ (discoveryId >>> 32));
		result = 31 * result + name.hashCode();
		result = 31 * result + description.hashCode();
		result = 31 * result + url.hashCode();
		result = 31 * result + user.hashCode();
		result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
		return result;
	}
}
