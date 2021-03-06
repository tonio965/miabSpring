package com.miab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miab.model.Grup;
import com.miab.model.User;

public interface GroupFacade extends JpaRepository<Grup,Integer>{
	
	Grup findGrupByName(String name);

}
