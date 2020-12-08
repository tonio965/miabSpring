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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/addUserForm")
	public String addForm(Model model) {
		model.addAttribute("name", "name");
		return "hello";
	}
	
	@RequestMapping("/main")
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
}
