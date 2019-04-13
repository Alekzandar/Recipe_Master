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

import com.revature.data.RecipeRepository;
import com.revature.model.Recipe;

@RestController
@RequestMapping("/recipe")
@CrossOrigin(origins = {"http://localhost:8085", "http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class RecipeController {
	
	@Autowired
	RecipeRepository recipeRepo;
	
	
	//add recipe
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Recipe> add(@RequestBody Recipe r){
		r = recipeRepo.save(r);
		return new ResponseEntity<Recipe>(r, HttpStatus.CREATED);
		
	}
	
	//get all recipes
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Recipe>> getAll(){
		List<Recipe> recipes = recipeRepo.findAll();
		if(recipes.isEmpty()) {
			return new ResponseEntity<List<Recipe>>( HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Recipe>>(recipeRepo.findAll(), HttpStatus.OK);
	}
	
	//get recipes by ID
	@RequestMapping(value="/{id}")
	public ResponseEntity<Recipe> getById(@PathVariable int id) {
		Recipe r = recipeRepo.findOne(id);
		if(r==null) {
			return new ResponseEntity<Recipe>( HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Recipe>(r, HttpStatus.OK);
	}

}