package comm.ibm.fsd.cd_example_3rd_sep_19.dao;

import org.hibernate.Session;

import comm.ibm.fsd.cd_example_3rd_sep_19.entity.CD;
import comm.ibm.fsd.cd_example_3rd_sep_19.factory.CDFactory;

public class CDDaoImpl implements CDDao{

	Session session =null;
	
	@Override
	public String createCDDetails(CD c) {
		
		session = CDFactory.getSession();
		if(session!=null) {
			session.getTransaction().begin();
			session.save(c);
			session.getTransaction().commit();
			return "data saved";
		}
		else {
			return "couldnot save";
		}		
	}

}
