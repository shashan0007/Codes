package com.dao.impl;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;

import com.entity.SprintTeam;
import com.entity.Task;
import com.entity.TeamName;
import com.util.MyCassandraTemplate;

public class TeamNameDAOImplTest {
	
	@InjectMocks
	TeamNameDAOImpl teamNameDAOImpl = new TeamNameDAOImpl();
	
	@Mock
	MyCassandraTemplate myCassandraTemplate;
	
	@Mock
	private SprintTeam sprintTeam;
	
	 @Mock
	 private TeamName teamName;
	 
	 @Mock
	 CassandraOperations cassandraTemplate;
	
	 @Before
	  public void setUp() throws IOException {
	     MockitoAnnotations.initMocks(this);
	    }
	 
	@Test
	public void testCreateteamname() {
		String teamname="scrumboard";
		
		TeamName team = new TeamName();
		team.setteamname(teamname);

//		teamName=null;
		Mockito.when(myCassandraTemplate.create(team)).thenReturn(team);
		teamNameDAOImpl.createteamname(teamname);
	
	}

	@Test
	public void testGetteamname() {
		String teamname="scrumboard";
		Mockito.when(myCassandraTemplate.findteamname(teamname,TeamName.class)).thenReturn(true);
		teamNameDAOImpl.getteamname(teamname);
		
	}

}
