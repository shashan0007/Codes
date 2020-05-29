package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dao.UserStoryDAO;
import com.datastax.driver.core.Row;
import com.entity.UserStory;
import com.service.UserStoryService;

/**
 * Service Impl class for Employee to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Service
public class UserStoryServiceImpl implements UserStoryService {

    @Autowired  
    private UserStoryDAO userStoryDAO;
    
	public UserStoryServiceImpl() {
		super();
	}
	
	@Override
	public ResponseEntity<?> createUserStory(int sprintteamid,String description)
	{
		return userStoryDAO.createUserStory(sprintteamid,description);
	}
	@Override
    public ResponseEntity<?> deleteUserStory(int userstoryid){
		return userStoryDAO.deleteUserStory(userstoryid);
	}
	@Override
    public ResponseEntity<?> updateUserStory(int userstoryid,int sprintteamid,String description,String status){
		return userStoryDAO.updateUserStory(userstoryid,sprintteamid,description,status);
	}
	
	@Override
	public ResponseEntity<?> getuserstories(int id)
	{
		return userStoryDAO.getAllUserStory(id);
	}
}