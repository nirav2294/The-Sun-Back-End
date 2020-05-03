package dev.sun.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.sun.entities.User;
import dev.sun.repositories.UserRepository;

@Service
@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository ur;
	@Override
	public List<User> gellAllUsers() {
		return (List<User>) ur.findAll();
	}

}
