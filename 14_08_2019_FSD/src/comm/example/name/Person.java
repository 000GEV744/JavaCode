package comm.example.name;
import  java.io.Serializable;
import java.lang.Character;
public class Person implements Serializable {

	
	private String fName;
	private String lName;
	
	
	public Person() {
		super();
	}
	
	public Person(String fName, String lName) {
		super();
		this.fName = fName;
		this.lName = lName;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	public String getlName() {
		return lName;
	}
	
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	
	//creating person by just checking if user has entered name in correct format  
	public Person createPerson(String fname, String lname) throws NameNotValidException {
		this.fName=fname;
		this.lName=lname;
		if(!(Character.isUpperCase(fname.charAt(0)) && Character.isUpperCase(lname.charAt(0)))) {
			
			throw new NameNotValidException("first character of the Name should be in uppercase ");
		}
		System.out.println("object created");
		return new Person(fname,lname);	
	}
	
	
	//checking if user already exists 
	public void isPersonAlreadyExist(Object obj) throws NameNotValidException{
		Person newPerson = (Person)obj;
		if((this.fName.equals(newPerson.fName))&& (this.lName.contentEquals(newPerson.lName))) {
			throw new NameNotValidException("user already exists..!!");
		}
		System.out.println("new object created as user doesn't already exist");
		
	}
	
	
}
