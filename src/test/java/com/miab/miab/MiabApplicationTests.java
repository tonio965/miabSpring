package com.miab.miab;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.miab.model.Grup;
import com.miab.model.User;
import com.miab.repository.GroupFacade;
import com.miab.repository.RepositoryFacade;
import com.miab.services.AppplicationService;
import com.miab.services.UserService;

@SpringBootTest
class MiabApplicationTests {

	@MockBean
	private AppplicationService appService;
	
	
	@Autowired
	private RepositoryFacade userService;
	
	@Autowired
	private GroupFacade groupService;
	
	@Test
	void addUserToDb() {
		int i = userService.findAll().size();
		User u = new User("tomek", "tomek", "tomek", "tomek");
		userService.save(u);
		int j = userService.findAll().size();
		assertThat(j>i).isEqualTo(true);
	}
	
	@Test
	void deletesUser() {
		int i = userService.findAll().size();
		userService.deleteByUsername("tomek");
		int j = userService.findAll().size();
		assertThat(j<i).isEqualTo(true);
	}
	
	@Test
	void createGroup() {
		int i = groupService.findAll().size();
		Grup g = new Grup(1, "gr1");
		groupService.save(g);
		int j = groupService.findAll().size();
		assertThat(j>i).isEqualTo(true);
	}
	
	
	
}
