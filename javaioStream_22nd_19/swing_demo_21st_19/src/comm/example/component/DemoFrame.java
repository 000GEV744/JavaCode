package comm.example.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import comm.example.model.Employee;
import comm.example.services.EmployeeServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DemoFrame extends JFrame  {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws SQLException{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFrame frame = new DemoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DemoFrame() throws SQLException {
		
		EmployeeServiceImpl service= new EmployeeServiceImpl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(132, 38, 169, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(132, 96, 169, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmployeeId.setBounds(24, 38, 89, 23);
		contentPane.add(lblEmployeeId);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFirstName.setBounds(24, 96, 89, 32);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblLastName.setBounds(24, 151, 89, 32);
		contentPane.add(lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setBounds(132, 151, 169, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(132, 204, 169, 32);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmail.setBounds(24, 204, 89, 32);
		contentPane.add(lblEmail);
		
		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.createEmployee(new Employee(Integer.parseInt(textField.getText().toString()),textField_1.getText().toString(),textField_2.getText().toString(),textField_3.getText().toString(),4));
				JOptionPane.showMessageDialog(contentPane, "added!");
			}
		});
		btnAddEmployee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAddEmployee.setBounds(24, 298, 155, 26);
		contentPane.add(btnAddEmployee);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnReset.setBounds(202, 298, 117, 26);
		contentPane.add(btnReset);
		
		JLabel lblDeleteEmployee = new JLabel("Delete Employee by ID");
		lblDeleteEmployee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDeleteEmployee.setBounds(365, 38, 163, 32);
		contentPane.add(lblDeleteEmployee);
		
		textField_4 = new JTextField();
		textField_4.setBounds(527, 38, 70, 23);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.deleteEmployeeById(Integer.parseInt(textField_4.getText().toString()));
				JOptionPane.showMessageDialog(contentPane, "deleted !");
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(420, 80, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblFindEmployeeBy = new JLabel("Find Employee by ID");
		lblFindEmployeeBy.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFindEmployeeBy.setBounds(365, 128, 144, 32);
		contentPane.add(lblFindEmployeeBy);
		
		textField_5 = new JTextField();
		textField_5.setBounds(527, 132, 70, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    Employee emp;
		    emp=service.getEmployeeById(Integer.parseInt(textField_5.getText().toString()));
			textField.setText(String.valueOf(emp.getId()));
			textField_1.setText(String.valueOf(emp.getfName()));
			textField_2.setText(String.valueOf(emp.getlName()));
			textField_3.setText(String.valueOf(emp.getEmail()));
			
			}
		});
		btnFind.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnFind.setBounds(420, 183, 89, 23);
		contentPane.add(btnFind);
		
		JButton btnDisplayAllEmployee = new JButton("Display All Employee");
		btnDisplayAllEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new MyFrame2();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDisplayAllEmployee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDisplayAllEmployee.setBounds(420, 301, 177, 23);
		contentPane.add(btnDisplayAllEmployee);
	}
}
