package com.miab.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.miab.model.User;

@Repository
public class RepositoryFacadeImpl implements RepositoryFacade{

	private static List <User> userList;
	
	public RepositoryFacadeImpl() {
		// TODO Auto-generated constructor stub
		userList = new ArrayList<>();
	}
	@Override
	public <T> void save(T obj) {
		userList.add((User)obj);
		
	}

	@Override
	public <T> List<T> findAll(Class<T> clazz) {
		// TODO Auto-generated method stub
		return (List<T>) userList;
	}

	@Override
	public <T> T findById(Long id, Class<T> clazz) {
		User u = userList.get(id.intValue());
		return (T) u;
	}

	@Override
	public void delete(Long id, Class clazz) {
		userList.remove(userList.get(id.intValue()));
		
	}

	@Override
	public <T> T findByUsername(String username) {
		for(User u: userList) {
			if(u.getUsername().equals(username))
				return (T) u;
		}
		return null;
	}

	@Override
	public void deleteByUsername(String username) {
		int index=-1;
		//im using an index not to deal with deleting an index during list traverisng 
		for(int i=0; i< userList.size();i++) {
			if(userList.get(i).getUsername().equals(username)){
				index = i;
			}
		//if index changed delete else throw something or leave it as is
		if(index!=-1) {
			userList.remove(index);
		}

		}
	}

}
