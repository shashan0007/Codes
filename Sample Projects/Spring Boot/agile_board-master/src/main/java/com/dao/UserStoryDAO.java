package com.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.datastax.driver.core.Row;
import com.entity.UserStory;

/**
 * DAO interface for UserStory to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface UserStoryDAO {
    /**
     * Used to Create the UserStory Information
     * @param UserStory
     * @return {@link UserStory}
     */
    public ResponseEntity<?> createUserStory(int sprintteamid,String description);
    
    /**
     * Used to Update the UserStory Information
     * @param UserStory
     * @return {@link UserStory}
     */
    
    public ResponseEntity<?> updateUserStory(int userstoryid,int sprinteamid,String description,String status);
    
    /**
     * Deleting the UserStory Information using Id
     * @param id
     */
    public ResponseEntity<?> deleteUserStory(int userstoryid);
    
    /**
     * Getting the All UserStorys information
     * @return
     */
    public ResponseEntity<?> getAllUserStory(int id);
}