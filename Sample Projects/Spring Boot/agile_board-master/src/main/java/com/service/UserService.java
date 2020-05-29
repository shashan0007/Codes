package com.service;

import java.util.List;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;

import com.entity.User;

/**
 * Service interface for User to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface UserService {
    /**
     * Used to Create the User Information
     * @param User
     * @return {@link User}
     */
    public User createUser(User User);
    
    /**
     * Getting the User Information using Id
     * @param id
     * @return {@link User}
     */
    public User getUser(String email);
    
    /**
     * Used to Update the User Information
     * @param User
     * @return {@link User}
     */
    
    public User updateUser(User User);
    
    public ResponseEntity<?> findEmail(String email);
    
    public ResponseEntity<?> registeruser(String firstname,String lastname, String email, String password, String phone, String confirmpassword);
    
    public ResponseEntity<?> changepassword(String email, String password);
    
    public ResponseEntity<?> getJSONResponse() throws JSONException;

}