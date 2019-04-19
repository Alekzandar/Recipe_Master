package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name = "Recipe")
public class Recipe {

	@Id
	@Column(name = "Recipe_ID")
	private int id;

	@Column(nullable = false)
	private String title;

	@Column
	private String ingredients;

	@Column
	private String image;

	@ManyToOne(fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.REMOVE)
	@JsonBackReference
	private User user;

	public Recipe() {
	}

	 
	
	public Recipe(int id, String title, String ingredients, String image) {
		super();
		this.id = id;
		this.title = title;
		this.ingredients = ingredients;
		this.image = image;
	}
	
	public Recipe(int id, String title, String ingredients, String image, User user) {
		super();
		this.id = id;
		this.title = title;
		this.ingredients = ingredients;
		this.image = image;
		this.user = user;
	}

	public Recipe(String title, String ingredients, String image, User user) {
		super();
		this.title = title;
		this.ingredients = ingredients;
		this.image = image;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}