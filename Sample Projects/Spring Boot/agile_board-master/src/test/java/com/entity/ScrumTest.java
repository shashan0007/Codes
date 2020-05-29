package com.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.controller.TeamNameController;

public class ScrumTest {

	@InjectMocks
	Scrum scrum=new Scrum();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	String scrumname="scrumboard";
	int id=101;


	@Test
	public void testGetscrumname() {
		scrum.getscrumname();
	}

	@Test
	public void testSetscrumid() {
		scrum.setscrumid(id);
	}

	@Test
	public void testGetscrumid() {
		scrum.getscrumid();
	}

	@Test
	public void testSetscrumname() {
           scrum.setscrumname(scrumname);
	}

}
