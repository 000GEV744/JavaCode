package objectInputOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStream {

	public static void main(String[] args) {
		Employee employee = new Employee(10,"sachin",20000,"mumbai");
		System.out.println("Employee to wirte is : "+ employee);
		
		try {
			FileOutputStream out = new FileOutputStream("employee.txt");
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(employee);
			oos.flush();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream in = new FileInputStream("employee.txt");
			ObjectInputStream ois = new ObjectInputStream(in);
			employee=(Employee)(ois.readObject());
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(employee);
		
	}
}
