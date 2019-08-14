package comm.example.name;
import java.util.Scanner;
public class PersonName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner scanner = new Scanner(System.in);
		 Person op=new Person();
		 String choice; 
		 try {
		 System.out.print("First name: ");
		 String fname=scanner.next();
		 System.out.print("last name: ");
		 String lname=scanner.next();
		 
		 op.createPerson(fname, lname);
		 }
		 catch(NameNotValidException e){
				
				System.err.println(e.getMessage());
			}
		 
		 do{
			 
			 
			 Person np=new Person();
			 try {
			 System.out.print("First name: ");
			 String fname=scanner.next();
			 System.out.print("last name: ");
			 String lname=scanner.next();
			 np.createPerson(fname, lname);
			    try {
			     np.isPersonAlreadyExist(op);
				 op= np;
			     
			     }catch(NameNotValidException e) {
				 System.err.println(e.getMessage());
			    }
			 
			 }
			 catch(NameNotValidException e) {
				 System.err.println(e.getMessage());
			 }
			 System.out.println("want to create one more object? (y/n)");
			 choice=scanner.next();
		 }while(choice.equals("y"));

	}
}
 