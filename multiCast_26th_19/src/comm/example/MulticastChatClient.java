package comm.example;

import java.io.*;
import java.net.*;

public class MulticastChatClient {

	static int  portNumber=1236;
	static InetAddress group ;
	static MulticastSocket chatMulticastSocket=null;
	
	
	
	
	public static void connectWithServer() throws Exception {
		
		chatMulticastSocket = new MulticastSocket(portNumber);		
		group = InetAddress.getByName("225.0.0.2");
		chatMulticastSocket.joinGroup(group); //joining the group
	}
}
