package com.revature.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name="Recipe")
public class Recipe {
	
	@Id
	@Column(name="Recipe_ID")
	private int id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private int readyInMinutes;
	
	@Column(nullable=false)
	private int servingSize;
	
	private String imgUrl;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	
	
	public Recipe() {}
	
	public Recipe(int id, String title, int readyInMinutes, int servingSize, String imgUrl) {
		super();
		this.id = id;
		this.title = title;
		this.readyInMinutes = readyInMinutes;
		this.servingSize = servingSize;
		this.imgUrl = imgUrl;
	}


	public Recipe(String title, int readyInMinutes, int servingSize, String imgUrl) {
		super();
		this.title = title;
		this.readyInMinutes = readyInMinutes;
		this.servingSize = servingSize;
		this.imgUrl = imgUrl;
	}
	
	
	
	
	public Recipe(int id, String title, int readyInMinutes, int servingSize, String imgUrl,
			User user) {
		super();
		this.id = id;
		this.title = title;
		this.readyInMinutes = readyInMinutes;
		this.servingSize = servingSize;
		this.imgUrl = imgUrl;
		this.user = user;
	}
	
	
	public Recipe(String title, int readyInMinutes, int servingSize, String imgUrl, User user) {
		super();
		this.title = title;
		this.readyInMinutes = readyInMinutes;
		this.servingSize = servingSize;
		this.imgUrl = imgUrl;
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
	public int getReadyInMinutes() {
		return readyInMinutes;
	}
	public void setReadyInMinutes(int readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}
	public int getServingSize() {
		return servingSize;
	}
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	
	
}