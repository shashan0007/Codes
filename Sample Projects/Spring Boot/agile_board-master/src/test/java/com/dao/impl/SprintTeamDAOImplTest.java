package com.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import com.entity.SprintTeam;
import com.util.MyCassandraTemplate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
public class SprintTeamDAOImplTest {
	
	@Mock
	private MyCassandraTemplate myCassandraTemplate;
	
	@Mock
	private SprintTeam sprintTeam;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	 @InjectMocks
	 SprintTeamDAOImpl sprintTeamDAOImpl = new SprintTeamDAOImpl();
	
	@BeforeClass
    public static void beforAllTest(){
        System.out.println("@Started Before all test ");
    }
	
	
	@Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }

	String teamName="FolksonFire";
	
	@Test
	public void testGetSprintTeam() {
		int id=10;
		Mockito.when(myCassandraTemplate.findById(id,SprintTeam.class)).thenReturn(sprintTeam);
		sprintTeamDAOImpl.getSprintTeam(id);
		
	}
	
	@After
	public  void afterGetSpringTeam() throws Exception{
		System.out.println("****Test completed successfully for GetSprintTeam function *****");
		
	}

	@Test
	public void testGetSprintTeamByName() {
		
		List<SprintTeam> list = new ArrayList();
		Mockito.when(myCassandraTemplate.findSprintNames(teamName,SprintTeam.class)).thenReturn(ResponseEntity);
		sprintTeamDAOImpl.getSprintTeamByName(teamName);
		/*List<SprintTeam> list = new ArrayList();
		Mockito.when(sprintTeamDAOImpl.getSprintTeamByName(teamname)).thenReturn(list);*/
	}
	
	@After
	public  void afterGetSprintTeamByName() throws Exception{
//		System.out.println("****Test completed successfully for testGetSprintTeamByName function *****");
		
	}
	
	@Test
	public void testUpdateSprintTeam() {
		Mockito.when(myCassandraTemplate.update(sprintTeam, SprintTeam.class)).thenReturn(sprintTeam);
		sprintTeamDAOImpl.updateSprintTeam(sprintTeam);
//		Mockito.when(sprintTeamDAOImpl.updateSprintTeam(sprintTeam));
	}
	
	@After
	public  void aftertestUpdateSprintTeam() throws Exception{
		System.out.println("****Test completed successfully for aftertestUpdateSprintTeam function *****");
		
	}

	@Test
	public void testDeleteSprintTeam() {
		int num=10;
		//Mockito.verify(myCassandraTemplate).deleteById(num,SprintTeam.class);
      	sprintTeamDAOImpl.deleteSprintTeam(num);
	//	Mockito.verify(sprintTeamDAOImpl).deleteSprintTeam(num);

//		Mockito.verify()
	}
	
	@After
	public  void aftertestDeleteSprintTeam() throws Exception{
		System.out.println("****Test completed successfully for testDeleteSprintTeam function *****");
		
	}

	@Test
	public void testGetAllSprintTeam() {
		List<SprintTeam> list = new ArrayList();
		Mockito.when(myCassandraTemplate.findAll(SprintTeam.class)).thenReturn(list);
		sprintTeamDAOImpl.getAllSprintTeam();
         
	}

	@Test
	public void testgetScrums(){
		Mockito.when(myCassandraTemplate.findAllScrum()).thenReturn(ResponseEntity);
		sprintTeamDAOImpl.getScrums();
	}
 	
	@Test
	public void testCreateSprintTeam() {
	//	String teamName="FolksonFire";
		String sprint="xyz";
		int id=5;
		Mockito.when(myCassandraTemplate.createSprintTeam(teamName, sprint)).thenReturn(ResponseEntity);
		sprintTeamDAOImpl.createSprintTeam(teamName, sprint);

	}

}
