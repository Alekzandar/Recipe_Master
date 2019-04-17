package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


/*
 * Root Context for Server-Side App: recipe-master
 */
@Component
@Entity
@Table(name = "TEST_ENTITY ")
public class TestEntity {

	@Id
	@Column(name="TYPE_ID")
	@SequenceGenerator(name="T_ID_GEN", sequenceName="ERS_TYPE_ID", allocationSize=1)
	@GeneratedValue(generator="T_ID_GEN", strategy=GenerationType.SEQUENCE)	
	private int id;
	
	private String name;
	
	public TestEntity() {}

	
	
	public TestEntity(String name) {
		super();
		this.name = name;
	}



	public TestEntity(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
