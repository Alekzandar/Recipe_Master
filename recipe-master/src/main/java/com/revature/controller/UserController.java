package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.RecipeRepository;
import com.revature.data.UserRepository;
import com.revature.model.Recipe;
import com.revature.model.User;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:8085", "http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH})
public class UserController {
	
	private static Logger log =  Logger.getLogger(UserController.class);
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	RecipeRepository recipeRepo;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> add(@RequestBody User t) {
		return new ResponseEntity<User>(repo.save(t), HttpStatus.CREATED);

	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAll() {
		log.trace("GETTING USERS");
		return new ResponseEntity<List<User>>(repo.findAll(), HttpStatus.OK);
	}
	
	//GET /user/username
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
	
	
	//get recipe by /user/id/id
	@RequestMapping(value="/id/{id}")
	public ResponseEntity<List<Recipe>> getById(@PathVariable int id) {
		User u =  repo.findById(id);
		List<Recipe> userFaves = u.getFaveRecipes();
		if(userFaves == null || userFaves.size() < 1) {
			//no user is found.. Http status of no content 
			return new ResponseEntity<List<Recipe>>(HttpStatus.NO_CONTENT);
		}else {
			//return user with status OK
			return new ResponseEntity<List<Recipe>>(userFaves, HttpStatus.OK);
		}
	}
	
	// remove recipes requested from User
	@Transactional
	@RequestMapping(method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> deleteRecipeFromUser(@RequestBody User user) {
		//Arranging our RequestBody's data for patch
		System.out.println("USER: " +  user.getId());
		int userId = user.getId();
		Recipe toRemove = user.getFaveRecipes().get(0);
		int recipeId = toRemove.getId();
		System.out.println("WITH RECIPE ID: " +  recipeId);
		
		
		Recipe repoMatch = recipeRepo.getOne(recipeId);
		User userToUpdate = repo.getOne(userId);
		System.out.println("RETRIEVED USER with ID:" + userToUpdate.getId());
		
		//Attach to sessions
		userToUpdate.removeRecipe(repoMatch);
		
		//including declaration for clarity
		User updatedUser = repo.save(userToUpdate);
		
		return new ResponseEntity<User>(updatedUser, HttpStatus.ACCEPTED);
	}
}
