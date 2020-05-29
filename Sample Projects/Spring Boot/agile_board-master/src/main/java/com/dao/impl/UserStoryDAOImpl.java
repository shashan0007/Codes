/**
 * 
 */
package com.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.dao.UserStoryDAO;
import com.entity.UserStory;
import com.util.MyCassandraTemplate;

/**
 * DAOImpl class for Employee to perform CRUD operation.
 * @author Shweta
 * @version 1.0
 */
@Repository
public class UserStoryDAOImpl implements UserStoryDAO {
    
	private static int UserStoryId = 1;
    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

	@Override
	public ResponseEntity<?> createUserStory(int sprintteamid,String description) {
		UserStory newUserStory = new UserStory();
		newUserStory.setStatus("New");
		newUserStory.setUserStoryName(description);
		newUserStory.setSprintTeamId(sprintteamid);
		UserStoryId++;
		newUserStory.setUserStoryID(UserStoryId);
		return myCassandraTemplate.createUserStory(newUserStory);
	}

	@Override
	public ResponseEntity<?> updateUserStory(int userstoryid,int sprintteamid,String description,String status) {
		UserStory updateUserStory = new UserStory();
		updateUserStory.setStatus(status);
		updateUserStory.setUserStoryName(description);
		updateUserStory.setSprintTeamId(sprintteamid);
		updateUserStory.setUserStoryID(userstoryid);
		return myCassandraTemplate.updateUserStory(updateUserStory);
	}

	@Override
	public ResponseEntity<?> deleteUserStory(int userstoryid) {
		return myCassandraTemplate.deleteUserStory(userstoryid,UserStory.class);
	}

	@Override
	public ResponseEntity<?> getAllUserStory(int id) {
		return myCassandraTemplate.findAllUserStory(id,UserStory.class);
	} 
}