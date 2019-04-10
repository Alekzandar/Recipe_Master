package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Shared_Recipes")
public class sharedRecipes {
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="User_ID", nullable=false)
	private User User_ID;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Recipe_ID", nullable=false)
	private Recipe Recipe_ID;
	
	
	public sharedRecipes() {}


	public sharedRecipes(User user_ID, Recipe recipe_ID) {
		super();
		User_ID = user_ID;
		Recipe_ID = recipe_ID;
	}


	public User getUser_ID() {
		return User_ID;
	}


	public void setUser_ID(User user_ID) {
		User_ID = user_ID;
	}


	public Recipe getRecipe_ID() {
		return Recipe_ID;
	}


	public void setRecipe_ID(Recipe recipe_ID) {
		Recipe_ID = recipe_ID;
	}
	
	


	
	

}
