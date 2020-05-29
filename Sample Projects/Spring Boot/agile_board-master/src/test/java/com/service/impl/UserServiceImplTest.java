package com.service.impl;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.dao.TaskDAO;
import com.dao.UserDAO;
import com.entity.User;

public class UserServiceImplTest {
	
	@Mock
	UserDAO UserDAO;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	@Mock
	User User;
	
	@InjectMocks
	UserServiceImpl userServiceImpl=new UserServiceImpl();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
	}
	
	
	String email="binit.kumar@aricent.com";
	String scrum="xyz";
	String sprint="first";
	@Test
	public void testCreateUser() {
          Mockito.when(UserDAO.createUser(User)).thenReturn(User);
          userServiceImpl.createUser(User);
	}

	@Test
	public void testGetUser() {
		
		Mockito.when(UserDAO.getUser(email)).thenReturn(User);
        userServiceImpl.getUser(email);
	}

	@Test
	public void testGetUsers() {
		Mockito.when(UserDAO.getusers()).thenReturn(ResponseEntity);
		userServiceImpl.getusers();
	}

	@Test
	public void testFindEmail() {
		Mockito.when(UserDAO.findEmail(email)).thenReturn(ResponseEntity);
		userServiceImpl.findEmail(email);
		
	}

	@Test
	public void testRegisteruser() {
		String firstname="Binit";
		String lastname="Singh";
		String password="binit37550";
		String phone="8285338334";
		String confirmpassword="binit37550";
		Mockito.when(UserDAO.registeruser(firstname,lastname,email,password,phone,confirmpassword)).thenReturn(ResponseEntity);
		userServiceImpl.registeruser(firstname, lastname, email, password, phone, confirmpassword);

	}

	@Test
	public void testChangepassword() {
		String password="binit37550";
		Mockito.when(UserDAO.changepassword(email, password)).thenReturn(ResponseEntity);
		userServiceImpl.changepassword(email, password);
	}

	@Test
	public void testGetJSONResponse() throws JSONException {
		Mockito.when(UserDAO.getJSONResponse(scrum,sprint)).thenReturn(ResponseEntity);
		userServiceImpl.getJSONResponse(scrum,sprint);
		
	}

}
