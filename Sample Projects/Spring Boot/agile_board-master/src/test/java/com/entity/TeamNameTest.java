package com.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class TeamNameTest {
	
	@InjectMocks
	TeamName teamName=new TeamName();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	String teamname="xyz";
	@Test
	public void testGetteamname() {
		teamName.getteamname();
	}

	@Test
	public void testSetteamname() {
		teamName.setteamname(teamname);
	}

}
