package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Recipe;

public interface RecipeRepository extends JpaRepository <Recipe, Integer>{

}
