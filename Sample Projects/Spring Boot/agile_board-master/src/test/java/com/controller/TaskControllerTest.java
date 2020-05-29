package com.controller;

import static org.junit.Assert.*;

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
import com.service.TaskService;
import com.service.TeamNameService;

import java.text.ParseException;
import java.util.UUID;
public class TaskControllerTest {
	
	
	@Mock
	TeamNameService TeamNameService;
	
	@Mock
	TaskService TaskService;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	UUID UID;
	
	@InjectMocks
	TaskController taskController=new TaskController();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	//int UID=100;
	String description="xyz";
	String status="closed";
	String user="Binit";
	int TID=100;
	String taskdate="04-0802017";

	@SuppressWarnings("unchecked")
	@Test
	public void testCreate() throws ParseException {
		Mockito.when(TaskService.createTask(UID, description, taskdate, user)).thenReturn(ResponseEntity);
		taskController.create(UID, description, taskdate, user);
	}

	@Test
	public void testDelete() {
		Mockito.when(TaskService.deleteTask(UID)).thenReturn(ResponseEntity);
		taskController.delete(UID);
	}

	@Test
	public void testModify() {
		Mockito.when(TaskService.updateTask(UID, description, user, taskdate, status)).thenReturn(ResponseEntity);
		taskController.modify(UID, description, user, taskdate, status);
	}

}
