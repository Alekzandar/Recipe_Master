package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.data.TestRepository;
import com.revature.model.TestEntity;

@RestController
@RequestMapping("/test")
public class TypeController {
	
	/*
	 * Access DAO layer and transaction context through repo.
	 */
	@Autowired
	TestRepository testRepo;
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TestEntity> add(@RequestBody TestEntity t){
		return new ResponseEntity<TestEntity>(testRepo.save(t), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TestEntity>> getAll(){
		return new ResponseEntity<List<TestEntity>>(testRepo.findAll(), HttpStatus.OK);
	}
			

}
