package com.ibm.fsd.my_first_maven_demo.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ibm.fsd.my_first_maven_demo.model.*;;

public class MyConnectionFactory {
	
	 static SessionFactory factory = null;
	
	
	public static SessionFactory myConnectionFactory() {
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employees.class).buildSessionFactory();
		return factory;
		
	}
	
	

}
