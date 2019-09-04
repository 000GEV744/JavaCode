package comm.ibm.fsd.cd_example_3rd_sep_19.dao;

import comm.ibm.fsd.cd_example_3rd_sep_19.entity.Instructor;
import comm.ibm.fsd.cd_example_3rd_sep_19.entity.InstructorDetail;

public interface InstructorDao {

	public String createIntructor(Instructor i,InstructorDetail InstD);
	public Instructor getIntructorDetail(int id);
	public String deleteInstructorDetail(int id);
	public String deleteInstructor(int id);
	
}