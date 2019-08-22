package simple_Encrption;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleEncryption {

	void encrypt(String source, String dest, int shiftSize) {
		BufferedReader reader;
		BufferedWriter writer;
		 
		
		try {
			
			reader= new BufferedReader(new FileReader(source));
			writer= new BufferedWriter(new FileWriter(dest));
			String line = reader.readLine();
			int data;
			while(line!=null) {
				int count=0;
				for(int i =0; i<line.length();i++) {
					data=(int)line.charAt(i)+shiftSize;
					if(line.charAt(i)=='a'||line.charAt(i)=='e'||line.charAt(i)=='i'||line.charAt(i)=='o'||line.charAt(i)=='u'||line.charAt(i)=='A'||
							line.charAt(i)=='E'||line.charAt(i)=='I'||line.charAt(i)=='O'||line.charAt(i)=='U') {
						count++;
					}
					writer.write(data);
				}
				writer.write(" \nthis line contains "+count+" numer of vovels");
				writer.write((int)'\n');
				line=reader.readLine();
			}
			reader.close();
			writer.close();
		}catch(IOException ie) {
			System.out.println("Failed encrypting the file content."); 
			
		}
		
	}
	
	public void viewFileContent(String filename) {
		BufferedReader reader;
		try {
			reader=new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while(line!=null) {
				System.out.println(line);
				line=reader.readLine();
			}
			reader.close();
		}
		catch(IOException ie) {
			System.out.println("failed to open file for reading.");
		}
	}
	
}
