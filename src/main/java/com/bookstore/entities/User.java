package com.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *Représente un utilisateur et réalise le binding relationnel avec la base de données.
 * 
 * @author RGAT
 *
 */
@Entity
@Table(name="USERS")
public class User {

	@Id
	private String login;
	
	private String email;
	
	@Column(name="pwd")
	private String password;
	
	public User(){
		super();
	}

	/* GETTERS AND SETTERS */
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
