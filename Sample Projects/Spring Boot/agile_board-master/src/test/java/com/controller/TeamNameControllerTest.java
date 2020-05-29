package com.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.entity.User;
import com.service.SprintTeamService;
import com.service.TeamNameService;
import com.service.UserStoryService;
import com.entity.TeamName;
import com.entity.SprintTeam;

public class TeamNameControllerTest {
	
	@Mock
	TeamNameService TeamNameService;
	
	@Mock
	User User;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@Mock
	TeamName TeamName;
	
	@Mock
	SprintTeamService SprintTeamService;
	
	@Mock
	SprintTeam SprintTeam;
	
	@InjectMocks
	TeamNameController teamNameController=new TeamNameController();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	String teamname="scrumboard";

	@Test
	public void testCreate() {
		
		Mockito.when(TeamNameService.getteamname(teamname)).thenReturn(true);
		Mockito.when(TeamNameService.createteamname(teamname)).thenReturn(TeamName);
		Mockito.when(TeamName.getteamname()).thenReturn(teamname);
		teamNameController.create(teamname);
	}

	@Test
	public void testGet() {
		List<SprintTeam> SprintTeam =new ArrayList<>(); 
		Mockito.when(SprintTeamService.getSprintTeamByName(teamname)).thenReturn(ResponseEntity);
		teamNameController.get(teamname);
	}
	
	@Test
	public void testgetScrums(){
		Mockito.when(SprintTeamService.getScrums()).thenReturn(ResponseEntity);
		teamNameController.getScrums();
	}

}
