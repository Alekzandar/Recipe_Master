package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

//@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
