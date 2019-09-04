package comm.ibm.fsd.cd_example_3rd_sep_19.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorFactory {

	static SessionFactory factory=null;
	static Session session = null;
	static {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()	;
	}
	
	public static Session getSession() {
		session = factory.openSession();
		return session;
	}
}
