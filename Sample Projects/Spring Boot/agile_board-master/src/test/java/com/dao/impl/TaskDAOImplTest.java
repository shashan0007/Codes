package com.dao.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.entity.SprintTeam;
import com.entity.Task;
import com.util.MyCassandraTemplate;

public class TaskDAOImplTest {
	
	@Mock
	private MyCassandraTemplate myCassandraTemplate;
	
	@Mock
	private SprintTeam sprintTeam;
	
	@Mock
	private Task updateTask;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	 @InjectMocks
	 TaskDAOImpl taskDAOImpl = new TaskDAOImpl();
	
	@BeforeClass
    public static void beforAllTest(){
        System.out.println("@Started Before all test ");
    }
	
	@Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }
	
	UUID UID;
//	private static int taskId = 0;
	
	int taskId = 0;
	//int UID=101;
	String description="xyz";
	String status="abc";
	String user="scrumboard";
	String taskdate="07/08/2017";
	int TID=200;
	
	@Test
	public void testCreateTask() {
		
		Mockito.when(myCassandraTemplate.createTask(UID, description, status, user)).thenReturn(ResponseEntity);
		taskDAOImpl.createTask(UID, description, taskdate, user);

	}

	@After
	public  void aftertestCreateTask() throws Exception{
		System.out.println("****Test completed successfully for testCreateTask function *****");
		
	}
	
	
	@Test
	public void testUpdateTask() {
		
		//Mockito.verify(updateTask).setUserStoryId(UID);
//		updateTask.setUserStoryId(UID);
		
		Mockito.when(myCassandraTemplate.updateTask(UID,description,user,taskdate,status)).thenReturn(ResponseEntity);
		taskDAOImpl.updateTask(UID, description,user,taskdate, status);
		

	}

	@Test
	public void testDeleteTask() {
		
		Mockito.when(myCassandraTemplate.deleteTask(UID)).thenReturn(ResponseEntity);
		taskDAOImpl.deleteTask(UID);
		
	}

}
