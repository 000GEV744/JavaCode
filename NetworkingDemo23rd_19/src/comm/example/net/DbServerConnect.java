package comm.example.net;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class DbServerConnect extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DbServerConnect frame = new DbServerConnect();
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
	public DbServerConnect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 466, 161);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblEmployeeId = new JLabel("Employee ID :");
		lblEmployeeId.setFont(new Font("Sitka Text", Font.BOLD, 14));
		lblEmployeeId.setBounds(10, 22, 105, 28);
		contentPane.add(lblEmployeeId);
		
		textField = new JTextField();
		textField.setBounds(136, 22, 86, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Socket socket = null;
			int portNumber = 1234;
			
			try {
				socket = new Socket(InetAddress.getLocalHost(), portNumber);
				System.out.println("socket is created at :"+socket);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				OutputStream clientOut= socket.getOutputStream();
				PrintWriter pw = new PrintWriter(clientOut,true);
				
				InputStream serverMsg = socket.getInputStream();
				BufferedReader readMsg = new BufferedReader(new InputStreamReader(serverMsg)); 
				
				String id = textField.getText().toString();
				pw.println(id);
				
				String str=readMsg.readLine();
			    System.out.println(str);
				Object[] colName= {"id","fname","lname","email","deptId"};
				DefaultTableModel tModel = new DefaultTableModel();
				
				Object[] splitMsg=str.split("\\s");
				for(Object a:colName) {	
					tModel.addColumn(a);							
				}
				tModel.addRow(splitMsg);
				table.setModel(tModel);
				
				pw.close();
				readMsg.close();
		        socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			}
		});
		btnShow.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnShow.setBounds(22, 82, 123, 34);
		contentPane.add(btnShow);
		
		JButton btnShowAllEmployee = new JButton("Show All Employee");
		btnShowAllEmployee.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnShowAllEmployee.setBounds(286, 22, 162, 34);
		contentPane.add(btnShowAllEmployee);
	}
}
