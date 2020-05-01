package dev.sun.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dev.sun.entities.User;
import dev.sun.services.UserService;

@Controller
@Component
public class UserController {
	
	@Autowired
	UserService us;
	
	@ResponseBody
	@RequestMapping(value = "/users" , method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return us.gellAllUsers();
	}
}
