package com.revature.data;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.Recipe;


@Repository
@Transactional
public interface RecipeRepository extends JpaRepository <Recipe, Integer>{

	public Recipe findById(int id);
}
