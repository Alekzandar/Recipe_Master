package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.sharedRecipes;

@Repository
public interface SharedRecipesRepository extends JpaRepository <sharedRecipes, Integer>{

}
