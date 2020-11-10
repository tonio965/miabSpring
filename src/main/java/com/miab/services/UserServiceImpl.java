package com.miab.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.miab.model.User;
import com.miab.repository.RepositoryFacadeImpl;

@Service
public class UserServiceImpl implements UserService, HashService {
	
	@Autowired
	RepositoryFacadeImpl database;

	@Override
	public User createUser(String username, String password, String name, String email)
			throws IllegalUsernameException, IncorrectEmailException {
		User u = new User(username,getHash(password),name,email);
		
		//check if creds are unique
		boolean uniqueEmail=true;
		boolean uniqueUsername=true;
		List<User> list = database.findAll(null);
		
		for(User user : list) {
			if(user.getUsername().equals(username)){
				uniqueUsername=false;
				throw new IllegalUsernameException();
			}
			
			if(user.getEmail().equals(email)){
				uniqueEmail = false;
				throw new IncorrectEmailException();
			}
			
		}
		if(uniqueEmail && uniqueUsername) {
			database.save(u);
			return u;
		}
		else {
			return null;
		}
	}

	@Override
	public User findUser(String username) {
		
		return database.findByUsername(username);
	}

	@Override
	public void deleteUser(String username) throws IllegalUsernameException {
		database.deleteByUsername(username);
	}

	@Override
	public boolean verifyUser(String username, String password) {
		boolean isVerified = false;
		List<User> users = database.findAll(null);
		for(User u : users) {
			if(u.getPassword().equals(getHash(password)) && u.getUsername().equals(username) ) {
				isVerified=true;
			}
		}
		return isVerified;
	}

	@Override
	public String getHash(String s) {
		
		String sha256hex = Hashing.sha256()
				  .hashString(s, StandardCharsets.UTF_8)
				  .toString();
		
		return sha256hex;
	}

	@Override
	public int returnAllUsers() {
		List<User> list = database.findAll(null);
		for(User u : list ) {
			System.out.println(u.toString());
		}
		return list.size();
		
	}
	
	private List<User> getAllUsers(){
		return database.findAll(null);
	}

}
