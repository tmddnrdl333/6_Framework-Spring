package com.ssafy.myapp.model.dto;

public class User {

	private String id;
	private String pass;
	private String name;
	private String email;

	public User(String id, String pass, String name, String email) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
	}

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + "]";
	}

}
