package CopyByFileReaderWriter;

import java.io.*;

public class CopyByFileReaderWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader in= new FileReader(new File("farrago.txt"));
		FileWriter out= new FileWriter(new File("outAgain.txt"));
		BufferedReader inputStream = new BufferedReader(in);
		PrintWriter outputStream = new PrintWriter(out);
		
		String l;
		while((l=inputStream.readLine())!= null) {
			System.out.println(l);
			outputStream.println(l);
		}
		in.close();
		out.close();
	}

}
