package comm.example;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.MulticastSocket;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MulticastClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MulticastClientFrame frame = new MulticastClientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MulticastClientFrame() throws IOException {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 357);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 70, 355, 165);
		contentPane.add(scrollPane);
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					MulticastChatClient.connectWithServer();
				} catch (Exception e1) {
                   e1.printStackTrace();
				}
				String msg="";
				msg=textField.getText().toString();
				DatagramPacket data = new DatagramPacket(msg.getBytes(),msg.length(),MulticastChatClient.group,MulticastChatClient.portNumber);
				try {
					MulticastChatClient.chatMulticastSocket.send(data);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				try
				  {
				  // Receives the packet from the server
					  byte[] buf=new byte[1024];
					  DatagramPacket dataReceive =new DatagramPacket(buf,buf.length);
					  
					  MulticastChatClient.chatMulticastSocket.receive(dataReceive);
					  // display message received
		              String msgFromServer= new String(dataReceive.getData()).trim();
		              
		              textArea.append(msgFromServer+"\n");
				               
				  }
				  catch(IOException iee)
				  {
				  System.out.println("Could not receive : "+iee.getMessage() );
				  System.exit(0);
				  } 
				//close the socket
				MulticastChatClient.chatMulticastSocket.close();	  
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSend.setBounds(320, 263, 89, 23);
		contentPane.add(btnSend);
		
		textField = new JTextField();
		textField.setBounds(54, 262, 256, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		JLabel lblClient = new JLabel("CLIENT");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClient.setBounds(188, 25, 70, 34);
		contentPane.add(lblClient);
	}
	
	
}
