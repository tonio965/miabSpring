package com.miab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.miab.model.*;

public interface RepositoryFacade extends JpaRepository<User,Long>{
	
    User findUserByUsername(String username);
    
    @Transactional
    Long deleteByUsername(String username);
    
    @Transactional
    User findByUsernameAndPassword(String username,String password);
    
    @Transactional
    List<User> findByGrup(int id);
}
  

