package comm.example;

import java.io.IOException;
import java.net.*;

public class MulticastChatServer {
	static String msg;
    public static void main(String args[])
    throws Exception {
        
        // Default port number we are going to use
        int portnumber = 1236;
        MulticastSocket serverMulticastSocket=null;
        
        do { 
        	// Create a MulticastSocket
        	serverMulticastSocket = new MulticastSocket(portnumber);
            System.out.println("MulticastSocket is created...");
            
            // Determine the IP address of a host, given the host name
            InetAddress group = InetAddress.getByName("225.0.0.2");
            
            // getByName- returns IP address of given host
            serverMulticastSocket.joinGroup(group);
            System.out.println("joinGroup method is called...");
            
        // Continually receives data and prints them 
            byte buf[] = new byte[1024];
            DatagramPacket data =
                    new DatagramPacket(buf, buf.length);
            serverMulticastSocket.receive(data);
            msg = new String(data.getData()).trim();
			//get data about client in order to 
            
            System.out.println(msg);
             if(msg!=null) {
            InetAddress address = data.getAddress();
            
            int clientPort = data.getPort();
            
            System.out.println("Message received from client = "+address+ "=> " + msg);
            
            serverMulticastSocket.close();
            
            //echo the data packet received from the client 
            //create packet to send the data to other clients 
           
           try {
               
        	   serverMulticastSocket =  new MulticastSocket(portnumber);
        	   serverMulticastSocket.joinGroup(group);
        	   serverMulticastSocket.send(data);
        	   serverMulticastSocket.close();
        	   
           }
           catch(IOException ex) {
        	   System.out.println("Could not Send "+ex.getMessage());
        	   System.exit(0);
           }
             }
        }while(!msg.equalsIgnoreCase("bye"));
            serverMulticastSocket.close();
       }
        
    }

