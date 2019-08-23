package comm.example_1;

import java.util.Date;
import java.util.Comparator;
import java.text.SimpleDateFormat;

public class AgeComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		
		if(e1.getAge()==e2.getAge()) {
			if (e1.getDateOfJoining().after(e2.getDateOfJoining())) {
				return 1;
			}
			else if (e1.getDateOfJoining().before(e2.getDateOfJoining())) {
				return -1;
			}
			else return 0;			
		}
		
		else if(e1.getAge()>e2.getAge()) {
		return 1;
		}
		else if(e1.getAge()<e2.getAge())
		{
		return -1;
		}
		else return 0;
	}	
	
}
