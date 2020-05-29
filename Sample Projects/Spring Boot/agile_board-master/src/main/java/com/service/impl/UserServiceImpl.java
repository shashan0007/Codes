package com.service.impl;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.entity.User;
import com.service.UserService;

/**
 * Service Impl class for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired  
    private UserDAO UserDAO;

    /**
     * Default Constructor
     */
    public UserServiceImpl() {
        super();    
    }

    @Override   
    public User createUser(User User) {     
        return UserDAO.createUser(User);
    }

    @Override   
    public User getUser(String email) {       
        return UserDAO.getUser(email);
    }

    @Override   
    public User updateUser(User User) {     
        return UserDAO.updateUser(User);
    }
    
    @Override
    public ResponseEntity<?> findEmail(String email){
    	return UserDAO.findEmail(email);
    }
    
    @Override
    public ResponseEntity<?> registeruser(String firstname,String lastname, String email, String password, String phone, String confirmpassword){
    	return UserDAO.registeruser(firstname,lastname,email,password,phone,confirmpassword);
    }
    
    public ResponseEntity<?> changepassword(String email, String password){
    	return UserDAO.changepassword(email,password);
    }
    
    public ResponseEntity<?> getJSONResponse() throws JSONException{
    	return UserDAO.getJSONResponse();
    }
}