package com.ibm.fsd.hibernate_javaee_integration_3rd_sep_19.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ibm.fsd.hibernate_javaee_integration_3rd_sep_19.entity.Instructor;
import com.ibm.fsd.hibernate_javaee_integration_3rd_sep_19.factory.InstructorFactory;


public class InstructorDaoImpl implements InstructorDao{
 
	private static Session session=null;
	{
		session=InstructorFactory.getMySession();
	}
	@Override
	public void createInstructor(Instructor instructor) {
		session.getTransaction().begin();
		session.persist(instructor);
		session.getTransaction().commit();
		
	}

}
