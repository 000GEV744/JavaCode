package comm.example.net;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NetworkingClient {

	public static void main(String[] args) throws  IOException {
		Socket client= null;
        int portNumber=1234;
        
        for(int i =0;i<10;i++) {
        	
        	String msg = "";
            
            // Create a client socket
        	client = new Socket(InetAddress.getLocalHost(), portNumber);
        	System.out.println("Client socket is created " + client);
        
     // Create an output stream of the client socket
        OutputStream clientOut = client.getOutputStream();
        PrintWriter pw = new PrintWriter(clientOut, true);
        
     // Create an input stream of the client socket
        InputStream clientIn = client.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
        
     // Create BufferedReader for a standard input
       Scanner stdIn = new Scanner(System.in);
       System.out.println("Enter your name. Type Bye to exit. ");
        
     // Read data from standard input device and write it
     // to the output stream of the client socket.
        msg = stdIn.nextLine();
        pw.println(msg);
        
        // Read data from the input stream of the client socket.
        System.out.println("Message returned from the server = " + br.readLine());
        
        pw.close();
        br.close();
        client.close();
        
        // Stop the operation
        if (msg.equalsIgnoreCase("Bye")) {
            break;
        }
        
        
        }
	}

}
