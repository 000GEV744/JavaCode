package FileInputOutputStream;


import java.io.*;

public class FileInputOutputStream {

	public static void main(String[] args) throws IOException{
		
		FileInputStream in = new FileInputStream(new File("farrago.txt"));
		FileOutputStream out = new FileOutputStream(new File("outAgain.txt"));
		
		int c;
		while((c=in.read())!=-1) {
			System.out.println(c);
			out.write(c);
		}
		System.out.println("FileInputStream is used to read file and FIleOutputStream is used to write into the file ");
		in.close();
		out.close();
	}
}
