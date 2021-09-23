package com.task.reactAuth.dao;

import com.task.reactAuth.entity.User;
import com.task.reactAuth.rest.IsAuthenticated;

public interface UsersDao {
	
	public void newUserRegister(User user) ;
	
	public boolean checkExistingUser(User user);
	
	public String isUserAuthenticated(IsAuthenticated isAuth);
	
	public User getUserByEmail(String email);

}
