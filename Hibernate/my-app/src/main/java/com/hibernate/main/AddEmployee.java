package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;
import com.mysql.cj.Query;

import antlr.collections.List;

public class AddEmployee {
	
	private static Employee employee;

	public static void main(String[] args) {
		
		employee = new Employee();
		employee.setEmpId(101);
		employee.setEmpName("Ashish");
		employee.setInsertDate(new Date());
		employee.setRole("SSE");
		
		Session session = HibernateUtil.buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		org.hibernate.Query query = session.createQuery("from Employee");
		List list = (List) query.list();
		System.out.println("The database entries are: " + list.toString());
		
		HibernateUtil.getSessionFactory().close();
	}

}
