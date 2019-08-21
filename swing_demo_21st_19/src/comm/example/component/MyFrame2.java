package comm.example.component;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class MyFrame2 extends JFrame {

	private JPanel contentPane;

	private RS2XMLConfig config=null;
	private JTable table;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MyFrame2() throws SQLException {
		getContentPane().setLayout(null);
		
		config = new RS2XMLConfig();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 423, 259);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnDisplayEmployee = new JButton("Display Employee");
		btnDisplayEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ResultSet rs=config.getAllEmployee();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnDisplayEmployee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDisplayEmployee.setBounds(142, 296, 160, 25);
		contentPane.add(btnDisplayEmployee);
		setVisible(true);
		
	}
}
