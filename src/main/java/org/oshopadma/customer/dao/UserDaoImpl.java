package org.oshopadma.customer.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.oshopadma.customer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(User user) {
		getsessionFactory().getCurrentSession().save(user);
	}

	@Override
	public void update(User user) {
		getsessionFactory().getCurrentSession().update(user);
	}

	@Override
	public void delete(User user) {
		getsessionFactory().getCurrentSession().delete(user);
	}

	@Override
	public User findByUsername(String username) {
		Query<?> query = getsessionFactory().getCurrentSession().createQuery("from User where username=:username");
		query.setParameter("username", username);
		return (User)query.uniqueResult();
	}
	
	@Override
	public User AuthenticateUser(String username, String password) {
		Query<?> query = getsessionFactory().getCurrentSession().createQuery("from User where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (User)query.uniqueResult();
	}
	
	private SessionFactory getsessionFactory(){
		return this.sessionFactory;
	}

}
