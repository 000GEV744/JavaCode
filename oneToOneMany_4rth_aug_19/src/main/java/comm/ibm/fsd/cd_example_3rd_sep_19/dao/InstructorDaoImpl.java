package comm.ibm.fsd.cd_example_3rd_sep_19.dao;

import org.hibernate.Session;
import comm.ibm.fsd.cd_example_3rd_sep_19.entity.Instructor;
import comm.ibm.fsd.cd_example_3rd_sep_19.entity.InstructorDetail;
import comm.ibm.fsd.cd_example_3rd_sep_19.factory.*;


public class InstructorDaoImpl implements InstructorDao {

	Session session =null;
	
	
	
	@Override
	public String createIntructor(Instructor i,InstructorDetail InstD) {
		session = InstructorFactory.getSession();
		if(session!=null) {
			InstD.setInstructor(i);
			session.beginTransaction();
		 session.save(InstD);
		session.getTransaction().commit();
			
//		i.setInstructorDetail(InstD);
//		session.beginTransaction();
//		session.save(i);
//		session.getTransaction().commit();
		return "data saved for both instructor and intructor details";
		}else {
			return "data can't be saved";	
		}
	}

	@Override
	public Instructor getIntructorDetail(int id) {
		session = InstructorFactory.getSession();
		if(session!=null) {
			InstructorDetail instrDetail = session.get(InstructorDetail.class, id);
			System.out.println(instrDetail);
			Instructor instructor=instrDetail.getInstructor();
			return instructor;
		}
		
		else{
			return null;		
		}
	}

	@Override
	public  String deleteInstructorDetail(int id) {
		session = InstructorFactory.getSession();
		if(session!=null) {
			session.beginTransaction();
			InstructorDetail instrDetail = session.get(InstructorDetail.class, id);
			System.out.println(instrDetail.getInstructor());
			session.delete(instrDetail);
			session.getTransaction().commit();
			return "details and instructor data is deleted";
		}
		else {
			return "details and instructor can't be deleted";
		}
	}

	
	@Override
	public String deleteInstructor(int id) {
		session = InstructorFactory.getSession();
		if(session!=null) {
			session.beginTransaction();
			Instructor instructor=session.get(Instructor.class, id);
		    System.out.println(instructor);
		    session.delete(instructor);
		    session.getTransaction().commit();
		    return "details and instructor data is deleted";
		}
		else {
			return "details and instructor can't be deleted";
		}
	}

	
}
