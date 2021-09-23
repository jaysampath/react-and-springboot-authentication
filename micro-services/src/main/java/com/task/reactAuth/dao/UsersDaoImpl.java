package com.task.reactAuth.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.task.reactAuth.entity.User;
import com.task.reactAuth.rest.IsAuthenticated;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public UsersDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void newUserRegister(User user) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
		
	}

	@Override
	public boolean checkExistingUser(User user) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		String currEmail = user.getEmail();
		Query query = session.createQuery("from User where email='"+currEmail+"'");
		List<User> existingUser = query.getResultList();
		//System.out.println(existingUser);
		if(existingUser.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public String isUserAuthenticated(IsAuthenticated isAuth) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		String currEmail = isAuth.getEmail();
		Query query = session.createQuery("from User where email='"+currEmail+"'");
		List<User> user = query.getResultList();
		
		if(user.size()==0) {
			return "unregistered";
		}
		
		//System.out.println("isAuth: "+isAuth);
		//System.out.println("user stored: "+user.get(0));
		String storedPassword = user.get(0).getPassword();
		String givenPassword = isAuth.getPassword();
		if(storedPassword.equals(givenPassword)) {
			return "correct";
		}
		return "incorrect";
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Query query = session.createQuery("from User where email='"+email+"'");
		List<User> user = query.getResultList();
		
		return user.get(0);
	}

}
