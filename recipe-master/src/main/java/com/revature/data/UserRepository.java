package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.User;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsernameIgnoreCase(String username);
	
	public User findById(int id);
	
}
