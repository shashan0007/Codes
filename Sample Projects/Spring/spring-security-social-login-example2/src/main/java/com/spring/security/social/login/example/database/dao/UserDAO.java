package com.spring.security.social.login.example.database.dao;

import java.util.List;

import com.spring.security.social.login.example.entity.User;

/**
 * DAO interface for Employee to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface UserDAO {
    /**
     * Used to Create the User Information
     * @param user
     * @return {@link User}
     */
    public User createUser(User user);
    
    /**
     * Getting the User Information using Id
     * @param id
     * @return {@link User}
     */
    public User getUser(String id);
    
    /**
     * Used to Update the User Information
     * @param user
     * @return {@link User}
     */
    
    public User updateUser(User user);
    
    /**
     * Deleting the User Information using Id
     * @param id
     */
    public void deleteUser(String id);
   
}