package dev.sun.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.sun.entities.User;
import dev.sun.repositories.UserRepository;

@SpringBootTest
class TheSunApplicationTests {

	@Autowired
	UserRepository ur;
	
	@Test
	void getAllUsers() {
		
		System.out.println((List<User> ) ur.findAll());
	}

}
