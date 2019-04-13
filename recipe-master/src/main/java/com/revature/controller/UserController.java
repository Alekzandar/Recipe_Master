package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.UserRepository;
import com.revature.model.User;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:8085", "http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {
	
	@Autowired
	UserRepository repo;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> add(@RequestBody User t) {
		return new ResponseEntity<User>(repo.save(t), HttpStatus.CREATED);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(repo.findAll(), HttpStatus.OK);
	}
	
	//GET /users/id
	//get user by id
	@RequestMapping(value="/{username}")
	public ResponseEntity<User> getByUsername(@PathVariable String username) {
		User u =  repo.findByUsernameIgnoreCase(username);
		if(u == null) {
			//no user is found.. Http status of no content 
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}else {
			//return user with status OK
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}
	}
}
