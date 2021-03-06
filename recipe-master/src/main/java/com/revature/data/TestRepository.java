package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.TestEntity;

/*
 * Specify queries to DataBase with Spring Data here.
 */
@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer>{

}
