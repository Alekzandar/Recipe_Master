package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.RecipeRepository;
import com.revature.data.UserRepository;

@RestController
@RequestMapping("/savedRecipe")
public class SavedRecipesController {
	
	@Autowired
	RecipeRepository recipeRepo;
	
	@Autowired
	UserRepository repo;
	
	//saving recipeId by userId

}
