package com.miab.miab;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.miab.model.User;
import com.miab.services.UserService;

public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	void addUserToDb() {
		int i = userService.returnAllUsers();
		User u = new User("test1", "test1", "test1", "test1");
		int j = userService.returnAllUsers();
		assertThat(j>i).isEqualTo(true);
	}
	
	@Test
	void deletesUser() {
		int i = userService.returnAllUsers();
		User u = new User("test2", "test2", "test2", "test2");
		int j = userService.returnAllUsers();
		assertThat(j<i).isEqualTo(true);
	}
	


}
