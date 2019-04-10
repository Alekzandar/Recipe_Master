package revature.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository repo;

}