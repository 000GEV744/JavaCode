package saveFileDataIntoDb;

import java.io.*;
import java.sql.SQLException;

import comm.example.model.Employee;
import comm.example.services.EmployeeServiceImpl;

public class SaveTODb {

	void save(String source) {
		BufferedReader reader;
		
		try {
			reader=new BufferedReader(new FileReader(source));
			String line=reader.readLine();
			
			while(line!=null) {
			
				String[] words=line.split("\\s");
				for(int i =0;i<words.length;i++) {
				System.out.println(words[i]);
				
				}
				try {
					EmployeeServiceImpl e= new EmployeeServiceImpl();
					e.createEmployee(new Employee(Integer.parseInt(words[0]),words[1].toString(),words[2].toString(),words[3].toString(),Integer.parseInt(words[4])));
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
				
				 line=reader.readLine();
			}
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
