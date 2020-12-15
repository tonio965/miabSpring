package com.miab.services;

import java.util.Scanner;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.miab.model.Grup;
import com.miab.model.User;
import com.miab.repository.GroupFacade;
import com.miab.repository.RepositoryFacade;

@Controller
@Transactional
public class CrudController {
	
	
	//fields
	private Logger LOG;
	
	Scanner stringScanner, intScanner;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	RepositoryFacade repository;
	
	@Autowired
	GroupFacade groupRepository;
	
	@Autowired
	HashService hashService;
	
	
	/**
	 * 
	 * @param model
	 * @return 
	 * 
	 * PART FOR USERS CRUD AND MAIN
	 */
	@RequestMapping("/addUserForm")
	public String addForm(Model model) {
		model.addAttribute("name", "name");
		return "hello";
	}
	
	@RequestMapping("/browseUsers")
	public String browseForm(ModelMap model) {
		model.put("users", repository.findAll());
		return "browse";
	}
	
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("name", "name");
		return "main";
	}
	
	@PostMapping("/add")
	public String testRequest(User user) {
		System.out.println(user.toString());
		repository.save(user);
		return "success";
	}
	
	@RequestMapping("/delete")
	public String deleteUser(ModelMap model) {
		model.put("users", repository.findAll());
		return "delete";
	}
	
	@RequestMapping("/edit")
	public String editUser(ModelMap model) {
		model.put("users", repository.findAll());
		return "edit";
	}
	
	@RequestMapping("/editUser")
	public String editRequest(User u) {
		System.out.println("/edituser in "+ u.getId());
		User toChange = repository.findById(u.getId()).get();
		toChange=u;
		repository.save(toChange);
		
		return "success";
	}
	
	@GetMapping("/deleteUser")
	public String deleteRequest(User u) {
		System.out.println("/deleteUser in "+u.getId());
		repository.deleteById(u.getId());
		return "success";
	}
	
	
	
	
	/**
	 * 
	 * PART FOR GROUP REPOSITORY
	 * 
	 * 
	 */
	
	@RequestMapping("/browseGroups")
	public String browseGroups(ModelMap model) {
		model.put("groups", groupRepository.findAll());
		return "browseGroups";
	}
	
	@RequestMapping("/addGroup")
	public String addGroupForm(Model model) {
		return "addGroup";
	}
	
	@PostMapping("/addGrup")
	public String addGrup(Grup grup) {
		System.out.println(grup.toString());
		groupRepository.save(grup);
		return "success";
	}
	
	@RequestMapping("/removeGroup")
	public String removeGroupFrom(ModelMap model) {
		model.put("groups", groupRepository.findAll());
		return "removeGroup";
	}
	
	@PostMapping("/removeGrup")
	public String removeGrup(Grup grup) {
		groupRepository.deleteById(grup.getId());
		return "success";
	}
	
//	<a href="/addToGroup"> add user to group</a>
//	<a href="/removeFromGroup"> remove user from group</a>
	
	@RequestMapping("/addToGroup")
	public String addToGroup(ModelMap model) {
		model.put("groups", groupRepository.findAll());
		model.put("users", repository.findAll());
		return "addToGroup";
	}
	
	@PostMapping("/addToGrup")
	public String addtogrup(Grup grup, User u) {
		System.out.print("u: "+u.toString());
		System.out.print("g: "+grup.toString());
		User us = repository.findById(u.getId()).get();
		Grup gg = groupRepository.getOne(grup.getId());
		gg.getUsers().add(us);
		return "success";
	}
	
	
	
	@RequestMapping("/removeFromGroup")
	public String removeFromGroup(ModelMap model) {
		model.put("groups", groupRepository.findAll());
		model.put("users", repository.findAll());
		return "removeFromGroup";
	}
	
	@PostMapping("/removeFromGrup")
	public String removeFromGrup(Grup grup, User u) {
		System.out.print("u: "+u.toString());
		System.out.print("g: "+grup.toString());
		User us = repository.findById(u.getId()).get();
		Grup gg = groupRepository.getOne(grup.getId());
		gg.getUsers().remove(us);
		return "success";
	}
	
	
	@RequestMapping("/verifyUser")
	public String verifyUser(ModelMap model) {
		return "verifyUser";
	}
	
	
	@PostMapping("/verifyUsr")
	public String removeFromGrup(User u) {
		System.out.print("u: "+u.toString());
		User us = repository.findByUsernameAndPassword(u.getUsername(), u.getPassword());
		if(us!=null)
			return "success";
		else {
			return "fail";
		}
	}
	
	
	
	
	
	
	
	
	
	
}
