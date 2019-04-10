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
@Table(name="Saved_Recipes")
public class savedRecipes {
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="User_ID", nullable=false)
	private User User_ID;
	
	private String favRecipe1;
	private String favRecipe2;
	private String favRecipe3;
	private String favRecipe4;
	private String favRecipe5;
	
	public savedRecipes() {}


	public savedRecipes(User user_ID, String favRecipe1, String favRecipe2, String favRecipe3, String favRecipe4,
			String favRecipe5) {
		super();
		User_ID = user_ID;
		this.favRecipe1 = favRecipe1;
		this.favRecipe2 = favRecipe2;
		this.favRecipe3 = favRecipe3;
		this.favRecipe4 = favRecipe4;
		this.favRecipe5 = favRecipe5;
	}
	
	
	public User getUser_ID() {
		return User_ID;
	}


	public void setUser_ID(User user_ID) {
		User_ID = user_ID;
	}


	public String getFavRecipe1() {
		return favRecipe1;
	}

	public void setFavRecipe1(String favRecipe1) {
		this.favRecipe1 = favRecipe1;
	}

	public String getFavRecipe2() {
		return favRecipe2;
	}

	public void setFavRecipe2(String favRecipe2) {
		this.favRecipe2 = favRecipe2;
	}

	public String getFavRecipe3() {
		return favRecipe3;
	}

	public void setFavRecipe3(String favRecipe3) {
		this.favRecipe3 = favRecipe3;
	}

	public String getFavRecipe4() {
		return favRecipe4;
	}

	public void setFavRecipe4(String favRecipe4) {
		this.favRecipe4 = favRecipe4;
	}

	public String getFavRecipe5() {
		return favRecipe5;
	}

	public void setFavRecipe5(String favRecipe5) {
		this.favRecipe5 = favRecipe5;
	}
	
	
	

}