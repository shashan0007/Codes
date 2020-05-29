package com.entity;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SprintTeamTest {
	
	@InjectMocks
	SprintTeam SprintTeam=new SprintTeam();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	int sprintTeamId=1001;
	String TeamName="scrumboard";
	String sprintname="first";
	
	UUID sprintteamid;

	@Test
	public void testGetSprintTeamId() {
	//	Mockito.when(SprintTeam.getSprintTeamId()).thenReturn(sprintteamid);
		SprintTeam.getSprintTeamId();
	}

	@Test
	public void testSetSprintTeamId() {
		SprintTeam.setSprintTeamId(sprintteamid);
	}

	@Test
	public void testGetSprintName() {
		SprintTeam.getSprintName();
	}

	@Test
	public void testSetSprintName() {
		SprintTeam.setTeamName(sprintname);
	}

	@Test
	public void testGetTeamName() {
		SprintTeam.getTeamName();
	}

	@Test
	public void testSetTeamName() {
		SprintTeam.setTeamName(TeamName);
	}

}
