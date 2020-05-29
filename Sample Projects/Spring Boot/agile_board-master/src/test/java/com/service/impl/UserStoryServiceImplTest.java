package com.service.impl;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.dao.TaskDAO;
import com.dao.UserStoryDAO;
public class UserStoryServiceImplTest {
	
	
	@Mock
	UserStoryDAO UserStoryDAO;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@InjectMocks
	UserStoryServiceImpl userStoryServiceImpl=new UserStoryServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	int sprintteamid=1001;
	String description="xyz";
	String status="abcd";
	int id=1001;
	String scrum="first";
	String sprint="xyz";
	UUID userstoryid;
	

	@Test
	public void testCreateUserStory() {
		Mockito.when(UserStoryDAO.createUserStory(scrum,sprint,description)).thenReturn(ResponseEntity);
		userStoryServiceImpl.createUserStory(scrum,sprint,description);
	}

	@Test
	public void testDeleteUserStory() {
		Mockito.when(UserStoryDAO.deleteUserStory(userstoryid)).thenReturn(ResponseEntity);
		userStoryServiceImpl.deleteUserStory(userstoryid);
	}

	@Test
	public void testUpdateUserStory() {
		Mockito.when(UserStoryDAO.updateUserStory(userstoryid,description,status)).thenReturn(ResponseEntity);
		userStoryServiceImpl.updateUserStory(userstoryid, description, status);
	}

	@Test
	public void testGetuserstories() {
		Mockito.when(UserStoryDAO.getAllUserStory(id)).thenReturn(ResponseEntity);
		userStoryServiceImpl.getuserstories(id);
	}

}
