package com.miab.model;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	
	
	//fields
    private String username;
    
    private String password;
    
    private String name;
    
    private String email;
    
    
   
    
    
    //constructors

	public User() {
		super();
	}

	public User(String username, String password, String name, String email) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}
	
	
	
	
	//getters and setters

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	
	//methods
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
	
	
	
	
    
    
    
}
