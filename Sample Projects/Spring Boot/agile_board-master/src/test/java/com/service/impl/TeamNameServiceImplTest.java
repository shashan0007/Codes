package com.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.dao.TaskDAO;
import com.dao.TeamNameDAO;
import com.entity.TeamName;
public class TeamNameServiceImplTest {
	
	@Mock
	TeamNameDAO TeamNameDAO;
	
	
	
	@Mock
	TeamName TeamName;

	@InjectMocks
	TeamNameServiceImpl teamNameServiceImpl=new TeamNameServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateteamname() {
		String teamname="scrumboard";
		Mockito.when(TeamNameDAO.createteamname(teamname)).thenReturn(TeamName);
	//	Mockito.when(TeamNameDAO.createteamname(teamname)).thenReturn(TeamName);
		teamNameServiceImpl.createteamname(teamname);
		
	}

	@Test
	public void testGetteamname() {
		String teamname="scrumboard";
		Mockito.when(TeamNameDAO.getteamname(teamname)).thenReturn(true);
		teamNameServiceImpl.getteamname(teamname);
	}

}
