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

import com.entity.SprintTeam;
import com.entity.TeamName;
import com.entity.User;
import com.service.SprintTeamService;
import com.service.TeamNameService;
import com.service.UserStoryService;

public class SprintTeamControllerTest {
	
	@Mock
	SprintTeamService sprintTeamService;
	
	@Mock
	UserStoryService userStoryService;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@Mock
	TeamName TeamName;
	
	@Mock
	SprintTeamService SprintTeamService;
	
	@Mock
	SprintTeam SprintTeam;
	
	@InjectMocks
	SprintTeamController sprintTeamController=new SprintTeamController();
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	String teamname="scrumboard";
	String sprint="first";
	int id=101;

	@Test
	public void testCreatesprint() {
		Mockito.when(sprintTeamService.createSprintTeam(teamname,sprint)).thenReturn(ResponseEntity);
		sprintTeamController.createsprint(teamname, sprint);
	}

	/*
	 * @Test public void testGetuserstory() {
	 * Mockito.when(userStoryService.getuserstories(id)).thenReturn(ResponseEntity);
	 * //sprintTeamController.getuserstory(id, teamname, sprint);
	 * sprintTeamController.getuserstory(id, teamname); }
	 */

	@Test
	public void testDelete() {
		sprintTeamController.delete(id);
	}

	@Test
	public void testFindAll() {
		List<SprintTeam> list=new ArrayList<>();
		Mockito.when(sprintTeamService.getAllSprintTeam()).thenReturn(list);
		sprintTeamController.findAll();
	}

	@Test
	public void testFindById() {
		Mockito.when(sprintTeamService.getSprintTeam(id)).thenReturn(SprintTeam);
		sprintTeamController.findById(id);
	}

	@Test
	public void testUpdate() {
		Mockito.when(sprintTeamService.updateSprintTeam(SprintTeam)).thenReturn(SprintTeam);
		sprintTeamController.update(SprintTeam);

	}

}
