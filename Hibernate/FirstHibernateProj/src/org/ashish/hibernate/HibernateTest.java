package org.ashish.hibernate;

import java.util.Date;

import org.ashish.dto.Address;
import org.ashish.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();
		
		Address addressUser = new Address();
		addressUser.setCity("Moradabad");
		addressUser.setPincode("244001");
		addressUser.setState("U.P");
		addressUser.setStreet("Street No 2");
		
		Address addressUser1 = new Address();
		addressUser1.setCity("Mirjapur");
		addressUser1.setPincode("110077");
		addressUser1.setState("U.P");
		addressUser1.setStreet("Street No 3");
		
		user.setUserName("Ashish");
		user.setAddress(addressUser);
		user.setDescription("Entrepreneur");
		user.setJoinedDate(new Date());
		
		user2.setUserName("Maneesh");
		user2.setAddress(addressUser1);
		user2.setDescription("C Programmer");
		user2.setJoinedDate(new Date());
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
	}

}
