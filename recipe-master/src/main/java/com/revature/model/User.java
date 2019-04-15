package com.revature.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Entity
@Table(name = "USER_INFO")
public class User {
	@Id
	@Column(name = "USER_ID")
	@SequenceGenerator(name = "U_ID_GEN", sequenceName = "USER_ID", allocationSize = 1)
	@GeneratedValue(generator = "U_ID_GEN", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(unique = true)
	private String username;

	@Column
	private String password;

	@Column
	private String firstname;

	
	@Column
	private String lastname;
	
	@Column
	private String email;

	@Column
	private int age;

	@Column(nullable = true)
	private int experience;
	
	
	@OneToMany
	@JoinTable(name="USER_FAVORITE_RECIPES",
		joinColumns = {@JoinColumn(name="USER_ID")},
		inverseJoinColumns = {@JoinColumn(name="Recipe_ID")})
	private List<Recipe> faveRecipes;
	
	
	public List<Recipe> getFaveRecipes() {
		return faveRecipes;
	}

	public void setFaveRecipes(List<Recipe> faveRecipes) {
		this.faveRecipes = faveRecipes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public User(int id, String username, String password, String firstname, String lastname, String email, int age, int experience) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
		this.experience = experience;
	}
	
	

	public User(int id, String username, String password, String firstname, String lastname, String email, int age,
			int experience, List<Recipe> faveRecipes) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
		this.experience = experience;
		this.faveRecipes = faveRecipes;
	}

	public User() {
	}

}
