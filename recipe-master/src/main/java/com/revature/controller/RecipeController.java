package com.revature.controller;

import java.util.List;

import org.apache.log4j.Logger;
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

import com.revature.data.RecipeRepository;
import com.revature.data.UserRepository;
import com.revature.model.Recipe;
import com.revature.model.User;

@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = { "http://localhost:8085", "http://localhost:4200" }, methods = { RequestMethod.GET,
		RequestMethod.POST })
public class RecipeController {

	private static Logger log =  Logger.getLogger(RecipeController.class);
	@Autowired
	RecipeRepository recipeRepo;

	@Autowired
	UserRepository userRepo;

	// add list of recipes
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> addAll(@RequestBody List<Recipe> recipes) {
		recipes = recipeRepo.save(recipes);

		for (Recipe r : recipes) {
			log.trace("RECIPE TO ADD TO USER FAVE: " + r);
			if (r.getUser() != null) {
				int userId = r.getUser().getId();
				User updateUser = userRepo.findById(userId);
				log.trace("ADDING RECIPES TO USER: " + updateUser);
				updateUser.addRecipe(r);
				User u = userRepo.save(updateUser);
			}
		}
		
		return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.CREATED);
	}

	// get all recipes
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> getAll() {
		List<Recipe> recipes = recipeRepo.findAll();
		if (recipes.isEmpty()) {
			return new ResponseEntity<List<Recipe>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Recipe>>(recipeRepo.findAll(), HttpStatus.OK);
	}

	// get recipes by ID
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Recipe> getById(@PathVariable int id) {
		Recipe r = recipeRepo.findOne(id);
		if (r == null) {
			return new ResponseEntity<Recipe>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Recipe>(r, HttpStatus.OK);
	}

}