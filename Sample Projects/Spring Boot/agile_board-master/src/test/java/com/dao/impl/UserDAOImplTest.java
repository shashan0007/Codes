package com.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;

import org.json.JSONException;
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
import com.entity.User;

public class UserDAOImplTest {
	
	@Mock
	private MyCassandraTemplate myCassandraTemplate;
	
	@Mock
	private SprintTeam sprintTeam;
	
	@Mock
	private User User;
	
	@Mock
	ResponseEntity ResponseEntity;
	
	 @InjectMocks
	 UserDAOImpl userDAOImpl = new UserDAOImpl();
	
	@BeforeClass
    public static void beforAllTest(){
        System.out.println("@Started Before all test ");
    }
	
	@Before
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
    }
	String email="binit.kumar@aricent.com";
	
	@Test
	public void testCreateUser() {
		Mockito.when(myCassandraTemplate.create(User)).thenReturn(User);
		userDAOImpl.createUser(User);
	}

	@Test
	public void testGetUser() {
		
		
		Mockito.when(myCassandraTemplate.findById(email,User.class)).thenReturn(User);
		userDAOImpl.getUser(email);
//		fail("Not yet implemented");
	}
	
	@Test
	public void testGetUsers(){
		Mockito.when(myCassandraTemplate.findById(email,User.class)).thenReturn(User);
		userDAOImpl.getusers();
	}


	@Test
	public void testFindEmail() {
		
		Mockito.when(myCassandraTemplate.findEmail(email)).thenReturn(ResponseEntity);
		userDAOImpl.findEmail(email);
		
	}

	@Test
	public void testRegisteruser() {
		String firstname="Binit";
		String lastname="Kumar" ;
		String email="binit.kumar@aricent.com" ;
		String password="admin";
		String phone="8285338334";
		String confirmpassword="admin";
		ResponseEntity responseEntity = null;
//		Mockito.when(!password.equals(confirmpassword)).thenReturn(true);
		userDAOImpl.registeruser(firstname, lastname, email, password, phone, confirmpassword);

	}

	@Test
	public void testChangepassword() {
		
		ResponseEntity responseEntity = null;
		String email="binit.kumar@aricent.com";
		String password="admin";
		Mockito.when(myCassandraTemplate.findById(email,User.class)).thenReturn(User);
		Mockito.when(myCassandraTemplate.update(User,User.class)).thenReturn(User);
		Mockito.when(User.getpassword()).thenReturn(password);
		userDAOImpl.changepassword(email, password);
		
	}

	@Test
	public void testGetJSONResponse() throws JSONException {
		ResponseEntity responseEntity=null;
		String scrum="xyz";
		String sprint="first";
		Mockito.when(myCassandraTemplate.getJSONResponse(scrum, sprint)).thenReturn(responseEntity);
		userDAOImpl.getJSONResponse(scrum, sprint);
	}

}
