import comm.ibm.fsd.cd_example_3rd_sep_19.dao.InstructorDaoImpl;
import comm.ibm.fsd.cd_example_3rd_sep_19.entity.Instructor;
import comm.ibm.fsd.cd_example_3rd_sep_19.entity.InstructorDetail;

public class IntructorTest {

	public static void main(String[] args) {
	
		InstructorDaoImpl dao=new InstructorDaoImpl();
		 
	    String msg = dao.createIntructor(new Instructor("vikram","Singh","vikr60@gg.com"), new InstructorDetail("https://www.youtube.com/watch?v=zing4uQdR4", "Cricket"));
		System.out.println(msg);
//		Instructor i = dao.getIntructorDetail(1);
//		System.out.println(i);
	}

}
