package com.service.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.dao.SprintTeamDAO;
import com.entity.SprintTeam;

public class SprintTeamServiceImplTest {
	
	@Mock
	SprintTeamDAO sprintTeamDAO;
	
	@Mock
	SprintTeam SprintTeam;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@InjectMocks
	SprintTeamServiceImpl sprintTeamServiceImpl=new SprintTeamServiceImpl();
	
	@BeforeClass
    public static void beforAllTest(){
        System.out.println("@Started Before all test ");
    }
	
	@Before
	public void setUp() throws IOException {
		MockitoAnnotations.initMocks(this);
    }
	
	String teamname="scrumboard";
	String sprint="first";
	@Test
	public void testGetSprintTeam() {
		int id=101;
		Mockito.when(sprintTeamDAO.getSprintTeam(id)).thenReturn(SprintTeam);
		sprintTeamServiceImpl.getSprintTeam(id);
	}

	@Test
	public void testGetSprintTeamByName() {
		
		List<SprintTeam> team=new ArrayList<>();
		Mockito.when(sprintTeamDAO.getSprintTeamByName(teamname)).thenReturn(ResponseEntity);
		sprintTeamServiceImpl.getSprintTeamByName(teamname);
		
	}

	@Test
	public void testUpdateSprintTeam() {
		Mockito.when(sprintTeamDAO.updateSprintTeam(SprintTeam)).thenReturn(SprintTeam);
		sprintTeamServiceImpl.updateSprintTeam(SprintTeam);
	}

	@Test
	public void testDeleteSprintTeam() {
		int id=101;
//		Mockito.when(sprintTeamDAO.deleteSprintTeam(id))
		sprintTeamServiceImpl.deleteSprintTeam(id);
	}

	@Test
	public void testGetAllSprintTeam() {
		List<SprintTeam> team=new ArrayList<>();
		Mockito.when(sprintTeamServiceImpl.getAllSprintTeam()).thenReturn(team);
		sprintTeamServiceImpl.getAllSprintTeam();
	}

	@Test
	public void testCreateSprintTeam() {
		
		Mockito.when(sprintTeamDAO.createSprintTeam(teamname,sprint)).thenReturn(ResponseEntity);
		sprintTeamServiceImpl.createSprintTeam(teamname,sprint);
	}

}
