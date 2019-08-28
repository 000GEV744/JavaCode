package FileReaderWriter.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class ReaderWriterFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReaderWriterFrame frame = new ReaderWriterFrame();
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
	public ReaderWriterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 76, 341, 209);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JLabel lblEnterText = new JLabel("Enter text : ");
		lblEnterText.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEnterText.setBounds(45, 27, 101, 30);
		contentPane.add(lblEnterText);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str= textArea.getText().toString();
				System.out.println(str);
				try {
					PrintWriter out = new PrintWriter(new File("outAgain.txt"));
					out.println(str);
					out.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textArea.setText("");
			}
		});
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSave.setBounds(57, 314, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnRead = new JButton("READ");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileReader in = new FileReader(new File("outAgain.txt"));
					BufferedReader br = new BufferedReader(in);
					String l;
					String out="";
					while((l=br.readLine())!= null) {
						//System.out.println(l);
						out+=(l+"\n");
					}
					System.out.println(out);
					textArea.setText(out);
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnRead.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnRead.setBounds(286, 315, 89, 23);
		contentPane.add(btnRead);
	}
}
