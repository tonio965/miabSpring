package com.miab.services;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miab.model.Grup;
import com.miab.model.User;
import com.miab.repository.*;

@Service
public class AppplicationService {
	
	
	//fields
	private Logger LOG;
	
	Scanner stringScanner, intScanner;
	
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	RepositoryFacade repository;
	
	@Autowired
	GroupFacade groupRepository;
	
	//constructors
	
	public AppplicationService() {
		LOG = Logger.getLogger(AppplicationService.class.getName().toString());
		stringScanner = new Scanner(System.in);
		intScanner = new Scanner(System.in);

	}
	
	
	
	
	
	//methods

	public void runApp() {
		
		LOG.log(Level.INFO, "applicationservie run started");
		
		
		for(;;) {
			
			System.out.println("1 add user");
			System.out.println("2 delete user");
			System.out.println("3 return all users");
			System.out.println("4 verify user");
			System.out.println("5 find user");
			System.out.println("6 add grup");
			System.out.println("7 find all grup");
			System.out.println("8 find all from 1 grup");
			System.out.println("8 add to grup");
			System.out.println("select option:");
			
			int decision = intScanner.nextInt();
			
			switch(decision) {
			
				case 1:
					System.out.println("=========================");
					System.out.println("username: ");
					String username = stringScanner.nextLine();
					System.out.println("pw: ");
					String pw = stringScanner.nextLine();
					System.out.println("name: ");
					String name = stringScanner.nextLine();
					System.out.println("email: ");
					String email = stringScanner.nextLine();
					User u = new User(username, pw, name, email);
					repository.save(u);
//					userService.createUser(username, pw, name, email);
					System.out.println("=========================");
					break;
					
				case 2:
					System.out.println("provide an username: ");
					String cred = stringScanner.nextLine();
					repository.deleteByUsername(cred);
					break;
					
				case 3:
					System.out.println("all users: ");
					List<User> users = repository.findAll();
					for(User usr : users) {
						System.out.println(usr.toString());
					}
					break;
				
				case 4:
					System.out.println("=========================");
					System.out.println("username: ");
					String usrname = stringScanner.nextLine();
					System.out.println("pw: ");
					String pswrd = stringScanner.nextLine();
//					boolean verified = userService.verifyUser(usrname, pswrd);
					User verified = repository.findByUsernameAndPassword(usrname, pswrd);
					if(verified!=null)
						System.out.println("user verified");
					else {
						System.out.println("user not verified");
					}
					break;
				
				case 5:
					System.out.println("=========================");
					System.out.println("username: ");
					String urname = stringScanner.nextLine();
//					User u = userService.findUser(urname);
//					System.out.println(u.toString());
					break;
					
				case 6:
					System.out.println("=========================");
					System.out.println("gname: ");
					String gname = stringScanner.nextLine();
					System.out.println("gid: ");
					int gid = intScanner.nextInt();
					Grup g = new Grup(gid,gname);
					groupRepository.save(g);
					break;
					
				case 7:
					System.out.println("all grups: ");
					List<Grup> grups = groupRepository.findAll();
					for(Grup gr : grups) {
						System.out.println(gr.toString());
					}
					break;
					
				case 8:
					System.out.println("all from group: ");
					System.out.println("gid: ");
					int gidd = intScanner.nextInt();
					List<User> usrs = repository.findByGrup(gidd);
					for(User ur : usrs) {
						System.out.println(ur.toString());
					}
					break;
				case 9:
					System.out.println("add to grup: ");
					System.out.println("usrid: ");
					int usrid = intScanner.nextInt();
					System.out.println("gid: ");
					int giddd = intScanner.nextInt();
					Optional<User> us = repository.findById((long) usrid);
					Optional<Grup> gg = groupRepository.findById((long) giddd);
//					for(User ur : usrss) {
//						System.out.println(ur.toString());
//					}
					break;
				
			}
			
			
		}
	}


}
