package org.oshopadma.customer.dao;

import org.oshopadma.customer.model.User;

public interface UserDao {
	
	void save(User user);
	void update(User user);
	void delete(User user);
	User findByUsername(String username);
	User AuthenticateUser(String username, String password);
}

