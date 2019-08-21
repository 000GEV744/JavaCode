package comm.example1;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	
	static List<Employee> ls= new ArrayList<Employee>();
	static Scanner scanner=new Scanner(System.in);
	static int choice=0;

	public static void main(String[] args) throws Exception{
		
	 System.out.println("Input the number of employees : ");
	 int i=scanner.nextInt();
     for(int j=0;j<i;j++) {
    	 String name=scanner.next();
    	 String department=scanner.next();
    	 String d=scanner.next();
    	 Date date=new SimpleDateFormat("dd/MM/yyyy").parse(d);  
    	 int age=scanner.nextInt();
    	 int sal=scanner.nextInt();
    	 Employee e=new Employee(name,department,date,age,sal);
    	 ls.add(e);
     }
     do {
    	 System.out.println("1.Sort employees by salary");
    	 System.out.println("2.Sort employees by age and by date of joining");
    	 System.out.println("Enter your choice");
    	 choice=scanner.nextInt();
    	 switch(choice) {
    	 case 1:
    		 Collections.sort(ls);
    		 EmployeeBO.printEmployees(ls);
    		 break;
    	 case 2:
    		 Collections.sort(ls, new AgeComparator());
    		 EmployeeBO.printEmployees(ls);
    		 break;
    	 case 0:
				System.out.println("Bye !");
				System.exit(0);	 
				break;
				
			default:break;	 
    		 
    	 }
    	 
     }while(choice!=0);
		
	}

}
