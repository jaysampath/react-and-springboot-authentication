package com.task.reactAuth.rest;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.reactAuth.dao.UsersDao;
import com.task.reactAuth.entity.User;

@RestController
@CrossOrigin
public class UserRest {
	
	@GetMapping("/")
	public String homePage() {
		return "<h1>Welcome</h1>"+
	            "<h2>React Auth Task </h2>";
	}
	
	private UsersDao usersDao;
	
	SimpleDateFormat sdf = new SimpleDateFormat();
	
	@Autowired
	public UserRest(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	@PostMapping("/new-user")
	public ResponseMessage newUser(@RequestBody User user) {
		boolean checkIfExisting = usersDao.checkExistingUser(user);
		//System.out.println("in rest: "+checkIfExisting);
		if(checkIfExisting) {
			throw new AlreadyExistingUserException("user already exists, please login with the same email");
		}
		user.setId(0);
		usersDao.newUserRegister(user);
		ResponseMessage successMessage = new ResponseMessage(
				HttpStatus.ACCEPTED.value(),
				"user with email -"+user.getEmail()+" is successfully registered!",
				 String.valueOf(sdf.format( System.currentTimeMillis()))
				);
		return successMessage;
	}
	
	@PostMapping("/login")
	public ResponseMessage checkUserIsAuth(@RequestBody IsAuthenticated isAuth) {
		String checkIsAuth = usersDao.isUserAuthenticated(isAuth);
		
		ResponseMessage noUserPresent = new ResponseMessage(
				HttpStatus.NOT_FOUND.value(),
				"User not registered, please go to signup page",
				String.valueOf(sdf.format( System.currentTimeMillis()))
				);
		
		ResponseMessage notAuth = new ResponseMessage(
				HttpStatus.NOT_ACCEPTABLE.value(),
				"Email and Passoword combination is incorrect.",
				String.valueOf(sdf.format( System.currentTimeMillis()))
				);
		
		ResponseMessage isAuthenticated = new ResponseMessage(
				HttpStatus.ACCEPTED.value(),
				"Login Successful",
				String.valueOf(sdf.format( System.currentTimeMillis()))
				);
		
		if(checkIsAuth.equals("unregistered")) 
			return noUserPresent;
		else if(checkIsAuth.equals("correct"))
			return isAuthenticated;
		else if(checkIsAuth.equals("incorrect"))
			return notAuth;
		return null;
	}
	
	@GetMapping("/user/{email}")
	public User getUserDetails(@PathVariable String email) {
		User storedUser = usersDao.getUserByEmail(email);
		return storedUser;
	}

}
