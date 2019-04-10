package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Shared_Recipes")
public class sharedRecipes {
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="User_ID", nullable=false)
	private User user;
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Recipe_ID", nullable=false)
	private Recipe id;
	
	
	public sharedRecipes() {}


	public sharedRecipes(User user, Recipe id) {
		super();
		this.user = user;
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Recipe getId() {
		return id;
	}


	public void setId(Recipe id) {
		this.id = id;
	}
	
	

}
