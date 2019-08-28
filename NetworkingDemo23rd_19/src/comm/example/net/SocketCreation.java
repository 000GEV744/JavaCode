package comm.example.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketCreation {

	public static Socket socketCreation() {
	Socket socket = null;
	int portNumber = 1234;
	
	try {
		socket = new Socket(InetAddress.getLocalHost(), portNumber);
		System.out.println("socket is created at :"+socket);
		return socket;
	} catch (UnknownHostException io) {
		io.printStackTrace();
	} catch (IOException ioe) {
		ioe.printStackTrace();
	}
	return socket;
	}
}
