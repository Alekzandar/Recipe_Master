package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.savedRecipes;


@Repository
public interface SavedRecipesRepository extends JpaRepository <savedRecipes, Integer>{

}
