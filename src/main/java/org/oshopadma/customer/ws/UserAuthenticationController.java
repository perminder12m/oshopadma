package org.oshopadma.customer.ws;

import org.oshopadma.customer.dao.UserDao;
import org.oshopadma.customer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthenticationController {
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(method = RequestMethod.GET, value="/login", headers="Accept=application/json")
	 ResponseEntity<User> login(@RequestParam String userId, @RequestParam String password) {
		User user =  userDao.AuthenticateUser(userId, password);
		if(null == user) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/register", headers="Accept=application/json")
	ResponseEntity<Boolean> register(@RequestParam String userId, @RequestParam String password){
		try {
			User user = new User(userId, password);
			user.setActive(1);
			userDao.save(user);
			return new ResponseEntity<Boolean>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
