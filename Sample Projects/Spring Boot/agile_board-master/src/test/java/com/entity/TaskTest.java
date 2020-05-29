package com.entity;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TaskTest {
	
	@InjectMocks
	Task task=new Task();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	int USID=11;
	String status="closed";
	String taskname="junit";
	String username="binit";
    UUID uuid;
    int taskid=101;
	@Test
	public void testGetTaskId() {
		task.getTaskId();
	}

	@Test
	public void testSetTaskId() {
		task.setTaskId(taskid);
	}

	@Test
	public void testGetUserStoryId() {
		task.getUserStoryId();              
	}

	@Test
	public void testSetUserStoryId() {
		task.setUserStoryId(USID);
	}

	@Test
	public void testGetTaskStatus() {
		task.getTaskStatus();
	}

	@Test
	public void testSetTaskStatus() {
		task.setTaskStatus(status);
	}

	@Test
	public void testGetTaskName() {
		task.getTaskName();
	 }

	@Test
	public void testSetTaskname() {
		task.setTaskname(taskname);
	}

	@Test
	public void testGetTaskUser() {
		task.getTaskUser();
	}

	@Test
	public void testSetTaskUser() {
		task.setTaskUser(username);
	}

}
