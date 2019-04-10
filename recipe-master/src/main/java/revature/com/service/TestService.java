package revature.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.TestRepository;


/*
 * Here we'd apply business logic through TestRepository Data Access Layer
 */
@Service
@Transactional
public class TestService {
	
	/*
	 * Utilize data retrieved through TestRepository DAO layer
	 * and apply some sort of logic on said data.
	 */
	@Autowired TestRepository testRepo;
	

}
