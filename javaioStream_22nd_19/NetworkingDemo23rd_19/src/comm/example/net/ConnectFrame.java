package comm.example.net;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.*;
import java.io.*;
import java.awt.event.ActionEvent;

public class ConnectFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectFrame frame = new ConnectFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConnectFrame() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSendYourMessage = new JLabel("Send your message:");
		lblSendYourMessage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSendYourMessage.setBounds(10, 25, 144, 33);
		contentPane.add(lblSendYourMessage);
		
		textField = new JTextField();
		textField.setBounds(192, 26, 184, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Socket client=null;
				int portNumber=1234;
				try {
					client = new Socket(InetAddress.getLocalHost(),portNumber);
					System.out.println("Client socket is created " + client);
				} catch (UnknownHostException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				try {
					
					OutputStream outClient= client.getOutputStream();
					PrintWriter pw = new PrintWriter(outClient,true);
					
					InputStream serverMsg= client.getInputStream();
					BufferedReader br=new BufferedReader(new InputStreamReader(serverMsg));
					
					//getting message from user through frame
					String msgClient=textField.getText().toString();
					pw.println(msgClient);
					textField_1.setText(br.readLine());
					
					pw.close();
			        br.close();
			        client.close();
			        
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		btnConnect.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnConnect.setBounds(135, 88, 89, 23);
		contentPane.add(btnConnect);
		
		JLabel lblMessageFromServer = new JLabel("Message from server:");
		lblMessageFromServer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblMessageFromServer.setBounds(10, 135, 144, 33);
		contentPane.add(lblMessageFromServer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(192, 135, 184, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
