package comm.example.net;
import java.io.*;
import java.net.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comm.example.model.Employee;
import comm.example.services.EmployeeServiceImpl;
public class NetworkingServer {

	public static void main(String[] args) throws IOException, SQLException {

		ServerSocket server= null;//it will wait for the request to come
		Socket client;
		int portnumber = 1234;
		
		// Create Server side socket
		try {
			server = new ServerSocket(portnumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println("ServerSocket is created " + server);
    	
    	// Wait for the data from the client and reply
    	while(true) {
    	
    		// Listens for a connection to be made to
            // this socket and accepts it. The method blocks until
            // a connection is made
    		System.out.println("Waiting for connect request...");
            client = server.accept();//A new Socket s is created  and it will return a new Socket that i am having in my client of type Socket
            System.out.println("Connect request is accepted...");
            String clientHost = client.getInetAddress().getHostAddress();//the raw ip address in string form is returned.
            int clientPort = client.getPort();
            System.out.println("Client host = " + clientHost + " Client port = " + clientPort);
            
            
         // Read data from the client
            InputStream clientIn = client.getInputStream();//returns an input stream for this socket
            BufferedReader br = new BufferedReader(new InputStreamReader(clientIn));
            String msgFromClient = br.readLine();
            int id=Integer.parseInt(msgFromClient);
            System.out.println("Message received from client = " + msgFromClient);
            
         // Send response to the client
            if (msgFromClient != null && !msgFromClient.equalsIgnoreCase("bye")) {
            	
                OutputStream clientOut = client.getOutputStream();
                PrintWriter pw = new PrintWriter(clientOut, true);
                EmployeeServiceImpl e= new EmployeeServiceImpl() ;
                if(msgFromClient=="select all") {
                	List<Employee> ls=new ArrayList<Employee>();
                	ls=e.getAllEmployees();
                	for(Employee eIterate  : ls){
                		System.out.println(eIterate.getEmail());
                	}
                }else {
               
                Employee emp =e.getEmployeeById(id);
                String ansMsg = emp.getId()+" "+emp.getfName()+" "+emp.getlName()+" "+emp.getEmail()+" "+emp.getDeptId();
                pw.println(ansMsg);
                
                }
            }
            
         // Close sockets
            if (msgFromClient != null && msgFromClient.equalsIgnoreCase("bye")) {
                server.close();
                client.close();
                break;
            }

}
}
}