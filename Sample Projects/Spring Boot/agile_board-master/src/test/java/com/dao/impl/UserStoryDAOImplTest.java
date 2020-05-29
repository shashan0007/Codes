package com.dao.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.UUID;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.entity.SprintTeam;
import com.entity.User;
import com.entity.UserStory;
import com.util.MyCassandraTemplate;

public class UserStoryDAOImplTest {
	
	@Mock
	private MyCassandraTemplate myCassandraTemplate;
	
	@Mock
	private SprintTeam sprintTeam;
	
	@Mock
	private User User;
	
	@Mock
	UserStory newUserStory;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	 @InjectMocks
	 UserStoryDAOImpl userStoryDAOImpl = new UserStoryDAOImpl();
	
	@BeforeClass
    public static void beforAllTest(){
        System.out.println("@Started Before all test ");
    }
	
	@Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }
	
	int sprintteamid=100;
	String scrum="xyz";
	String sprint="first";
	UUID userstoryid;
	String description;
	String status="passed";
	private static int UserStoryId = 1;
	
	@Test
	public void testCreateUserStory() {
		Mockito.when(myCassandraTemplate.createUserStory(scrum,sprint,description)).thenReturn(ResponseEntity);
		userStoryDAOImpl.createUserStory(scrum,sprint,description);
	}

	@Test
	public void testUpdateUserStory() {
		String description="junit test cases";
		String status="passed";
		Mockito.when(myCassandraTemplate.updateUserStory(userstoryid, description, status)).thenReturn(ResponseEntity);
		userStoryDAOImpl.updateUserStory(userstoryid, description, status);
	}

	@Test
	public void testDeleteUserStory() {
		Mockito.when(myCassandraTemplate.deleteUserStory(userstoryid,UserStory.class)).thenReturn(ResponseEntity);
		userStoryDAOImpl.deleteUserStory(userstoryid);
		
	}

	@Test
	public void testGetAllUserStory() {
		int id=1001;
		Mockito.when(myCassandraTemplate.findAllUserStory(id,UserStory.class)).thenReturn(ResponseEntity);
		userStoryDAOImpl.getAllUserStory(id);
	}

}
