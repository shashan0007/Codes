package com.controller;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.dao.TaskDAO;
import com.service.UserService;
import com.service.impl.TaskServiceImpl;
import com.entity.User;

public class UserControllerTest {
	
	
	@Mock
	UserService UserService;
	
	@Mock
	User User;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@InjectMocks
	UserController userController=new UserController();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	String firstname="Binit";
	String lastname="Singh";
	String email="binit.kumar@aricent.com";
	String password="binit2002";
	String phone="8285338334";
	String confirmpassword="binit2002";
	
	
	@Test
	public void testRegisteruser() {
		
		Mockito.when(UserService.registeruser(firstname,lastname,email,password,phone,confirmpassword)).thenReturn(ResponseEntity);
		userController.registeruser(firstname, email, password, confirmpassword, phone, lastname);
	}

	@Test
	public void testChangepassword() {
		Mockito.when(UserService.changepassword(email,password)).thenReturn(ResponseEntity);
		userController.changepassword(email, confirmpassword);
	}

	@Test
	public void testgetusers() {
		Mockito.when(UserService.getusers()).thenReturn(ResponseEntity);
		userController.getusers();
	}

}
