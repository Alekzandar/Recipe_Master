package revature.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.UserRepository;
import com.revature.model.User;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	

	

}