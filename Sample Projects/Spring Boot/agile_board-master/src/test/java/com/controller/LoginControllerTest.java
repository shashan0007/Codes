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
import com.service.TeamNameService;
import com.service.UserService;

public class LoginControllerTest {
	
	@Mock
	UserService UserService;
	
	@Mock
	User User;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	
	@InjectMocks
	LoginController loginController=new LoginController();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	String email="binit.kumar@aricent.com";
	String  password="scrumboard";

	@Test
	public void testProcess() throws Exception {
		Mockito.when(UserService.getUser(email)).thenReturn(User);
		Mockito.when(User.getemail()).thenReturn(email);
		Mockito.when(User.getpassword()).thenReturn(password);
		loginController.process(email, password);
	}

	@Test
	public void testForgotpwd() {
		Mockito.when(UserService.findEmail(email)).thenReturn(ResponseEntity);
		loginController.forgotpwd(email);
	}

}
