package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Recipe;


@Repository
public interface RecipeRepository extends JpaRepository <Recipe, Integer>{

}
