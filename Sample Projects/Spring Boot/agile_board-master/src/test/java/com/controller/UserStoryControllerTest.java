package com.controller;

import static org.junit.Assert.*;

import java.util.UUID;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.entity.User;
import com.service.UserService;
import com.service.UserStoryService;

public class UserStoryControllerTest {
	
	@Mock
	UserStoryService userStoryService;
	
	@Mock
	User User;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@Mock
    private UserService userService;
	
	UUID userstoryid;
	
	@InjectMocks
	UserStoryController userStoryController=new UserStoryController();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	int sprintteamid=011;
	String description="folksandfire";
	String status="closed";
	String scrum="scrum";
	String sprint="2nd";
	
	@Test
	public void testCreate() {
		Mockito.when(userStoryService.createUserStory(scrum, sprint, description)).thenReturn(ResponseEntity);
		userStoryController.create(sprint, scrum, description);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testDelete() {
		Mockito.when(userStoryService.deleteUserStory(userstoryid)).thenReturn(ResponseEntity);
		userStoryController.delete(userstoryid);
	}

	@Test
	public void testUpdate() {
		Mockito.when(userStoryService.updateUserStory(userstoryid, description, status)).thenReturn(ResponseEntity);
		userStoryController.update(userstoryid, description, status);
	}
	
	@Test
	public void testGet() throws JSONException{
		Mockito.when(userService.getJSONResponse(scrum, sprint)).thenReturn(ResponseEntity);
		userStoryController.get(scrum, sprint);
	}

}
