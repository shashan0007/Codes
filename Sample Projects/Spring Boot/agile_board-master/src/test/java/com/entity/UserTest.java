package com.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class UserTest {

	@InjectMocks
	User user=new User();

	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	String firstname="binit";
	String lastname="singh";
	String email="binit.kumar@aricent.com";
	String password="binit1234";
	String phone="8285338334";
	
	@Test
	public void testGetemail() {
		user.getemail();
	}

	@Test
	public void testSetemail() {
		user.setemail(email);
	}

	@Test
	public void testGetfirstname() {
		user.getfirstname();
	}

	@Test
	public void testSetfirstname() {
		user.setfirstname(firstname);
	}

	@Test
	public void testGetlastname() {
		user.getlastname();
	}

	@Test
	public void testSetlastname() {
		user.setlastname(lastname);
	}

	@Test
	public void testGetpassword() {
		user.getpassword();
	}

	@Test
	public void testSetpassword() {
		user.setpassword(password);
	}

	@Test
	public void testGetphone() {
		user.getphone();
	}

	@Test
	public void testSetphone() {
		user.setpassword(password);
	}

}
