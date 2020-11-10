package com.miab.services;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miab.model.User;
import com.miab.repository.RepositoryFacadeImpl;

@Service
public class AppplicationService {
	
	
	//fields
	private Logger LOG;
	
	Scanner stringScanner, intScanner;
	
	@Autowired
	UserServiceImpl userService;
	
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
					
					userService.createUser(username, pw, name, email);
					System.out.println("=========================");
					break;
					
				case 2:
					System.out.println("provide an username: ");
					String cred = stringScanner.nextLine();
					userService.deleteUser(cred);
					break;
					
				case 3:
					System.out.println("all users: ");
					userService.returnAllUsers();
					break;
				
				case 4:
					System.out.println("=========================");
					System.out.println("username: ");
					String usrname = stringScanner.nextLine();
					System.out.println("pw: ");
					String pswrd = stringScanner.nextLine();
					boolean verified = userService.verifyUser(usrname, pswrd);
					if(verified)
						System.out.println("user verified");
					else {
						System.out.println("user not verified");
					}
					break;
				
				case 5:
					System.out.println("=========================");
					System.out.println("username: ");
					String urname = stringScanner.nextLine();
					User u = userService.findUser(urname);
					System.out.println(u.toString());
					break;
				
			}
			
			
		}
	}


}
