package dao;

import org.springframework.stereotype.Repository;

import model.UserLogin;

@Repository
public interface UserLoginDAO {
	    
	    public UserLogin getUser(String username);
	    
	    public void addUserLogin(UserLogin userLogin);
	    	    	    
}