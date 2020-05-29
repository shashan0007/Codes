package com.service.impl;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.dao.SprintTeamDAO;
import com.dao.TaskDAO;

public class TaskServiceImplTest {
	
	@Mock
	TaskDAO TaskDAO;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@InjectMocks
	TaskServiceImpl taskServiceImpl=new TaskServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	UUID UID;
	String description="xyz";
	String status="passed";
	String user="Binit";
	String taskdate="12/7/2017";
	@Test
	public void testCreateTask() {
		Mockito.when(TaskDAO.createTask(UID,description,status,user)).thenReturn(ResponseEntity);
		taskServiceImpl.createTask(UID, description, status, user);
	}

	@Test
	public void testUpdateTask() {
		Mockito.when(TaskDAO.updateTask(UID,description,description,status,user)).thenReturn(ResponseEntity);
		taskServiceImpl.updateTask(UID, description,user,taskdate,status);
	}

	@Test
	public void testDeleteTask() {
        Mockito.when(TaskDAO.deleteTask(UID)).thenReturn(ResponseEntity);
        taskServiceImpl.deleteTask(UID);
	}
	
	@Test
	public void testUpdateTaskStatus(){
		Mockito.when(TaskDAO.updateTaskStatus(UID,status)).thenReturn(ResponseEntity);
		TaskDAO.updateTaskStatus(UID, status);
	}

}
