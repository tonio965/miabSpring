package com.miab.miab;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.miab.model.User;
import com.miab.repository.RepositoryFacade;
import com.miab.services.UserService;

public class UserServiceTest {
	
	@Autowired
	private RepositoryFacade userService;
	
	@Test
	void addUserToDb() {
		int i = userService.findAll().size();
		User u = new User("tomek", "tomek", "tomek", "tomek");
		int j = userService.findAll().size();
		assertThat(j>i).isEqualTo(true);
	}
	
	@Test
	void deletesUser() {
		int i = userService.findAll().size();
		User u = new User("test2", "test2", "test2", "test2");
		int j = userService.findAll().size();
		assertThat(j<i).isEqualTo(true);
	}
	


}
