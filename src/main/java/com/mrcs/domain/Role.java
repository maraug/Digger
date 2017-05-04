package com.mrcs.domain;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@Access(AccessType.FIELD)
public class Role implements Serializable {

	@Id
	private String username;

	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
