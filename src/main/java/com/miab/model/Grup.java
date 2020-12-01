package com.miab.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int id;
	
	String name;
	
	public Grup(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@OneToMany(fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();
	
	
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grup() {
		super();
	}

	@Override
	public String toString() {
		return "Grup [id=" + id + ", name=" + name + ", users=" + users + "]";
	}
	
	
	
	

}
