package com.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.datastax.driver.core.Row;
import com.entity.UserStory;

/**
 * Service interface for UserStory to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
public interface UserStoryService {
    /**
     * Used to Create the UserStory Information
     * @param UserStory
     * @return {@link UserStory}
     */
    public ResponseEntity<?> createUserStory(int sprintteamid,String description);
    
    public ResponseEntity<?> deleteUserStory(int userstoryid);
    
    public ResponseEntity<?> updateUserStory(int userstoryid,int sprintteamid,String description,String status);
    
    /**
     * Used to Update the UserStory Information
     * @param UserStory
     * @return {@link UserStory}
     */
    public ResponseEntity<?> getuserstories(int id);
}