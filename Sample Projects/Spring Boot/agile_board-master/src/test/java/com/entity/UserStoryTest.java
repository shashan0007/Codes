package com.entity;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class UserStoryTest {
	
	@InjectMocks
	UserStory userStory=new UserStory();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	
	String userStoryName="userstory1";
	int userStoryID=100;
	String status="passed";
	UUID sprintTeamId;
	@Test
	public void testUserStoryIntStringIntString() {
		userStory.getUserStoryID();
	}

	@Test
	public void testGetSprintTeamId() {
		userStory.getSprintTeamId();
	}

	@Test
	public void testSetSprintTeamId() {
		userStory.setSprintTeamId(sprintTeamId);
	}

	@Test
	public void testGetUserStoryName() {
		userStory.getUserStoryName();
	}

	@Test
	public void testSetUserStoryName() {
		userStory.setUserStoryName(userStoryName);
	}

	@Test
	public void testGetUserStoryID() {
		userStory.getUserStoryID();
	}

	@Test
	public void testSetUserStoryID() {
		UUID userStoryID = null;
		userStory.setUserStoryID(userStoryID);
	}

	@Test
	public void testGetStatus() {
		userStory.getStatus();
	}

	@Test
	public void testSetStatus() {
		userStory.setStatus(status);
	}

}
