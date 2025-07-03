package br.com.itads.conference.domain;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false, unique = false)
	private String password;

	public User() {
		super();
	}
	
	public User(Long id, String username, String password, String email) {
		super();
		this.username = username;
		this.password = cypher(password);
		this.email = email;
	}

	private String cypher(String password) {
		return Base64.getEncoder().encode(password.getBytes()).toString();
	}

	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}

}
