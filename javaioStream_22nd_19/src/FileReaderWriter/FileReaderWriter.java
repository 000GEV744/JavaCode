package FileReaderWriter;

import java.io.*;

public class FileReaderWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader in = new FileReader(new File("farrago.txt"));
		FileWriter out = new FileWriter(new File("outAgain.txt"));
		
		int l;
		while((l=in.read())!=-1) {
			System.out.println((char) l);
			out.write(l);
		}
		in.close();
		out.close();
	}

}
