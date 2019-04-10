package com.revature.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Specify queries to DataBase with Spring Data here.
 */
@Repository
public interface TestRepository extends JpaRepository<TestEntity, Integer>{

}
