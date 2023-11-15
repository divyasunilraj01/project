package contactus;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ContactusForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textname;
	private JTextField textemail;
	private JTextArea messageArea;
	JLabel msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactusForm frame = new ContactusForm();
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
	public ContactusForm() {
		setFont(new Font("Times New Roman", Font.BOLD, 25));
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Divya\\Downloads\\75400799-contact-us-icon-contact-us-website-button-on-white-background.jpg"));
		setTitle("Contact Us");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 521);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 81, 45, 13);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblName);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(25, 154, 45, 13);
		lblemail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblemail);
		
		JLabel lblmessage = new JLabel("Message");
		lblmessage.setBounds(25, 229, 80, 13);
		lblmessage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(lblmessage);
		
		textname = new JTextField();
		textname.setBounds(115, 72, 149, 34);
		textname.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(textname);
		textname.setColumns(10);
		
		textemail = new JTextField();
		textemail.setBounds(115, 141, 149, 39);
		textemail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(textemail);
		textemail.setColumns(10);
		
		 messageArea = new JTextArea();
		 messageArea.setBounds(115, 224, 336, 92);
		messageArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		contentPane.add(messageArea);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setBounds(232, 379, 85, 21);
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					 try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");
						String query = "insert into contact values(?,?,?)";
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, textname.getText());
						ps.setString(2, textemail.getText());
						ps.setString(3, messageArea.getText());
						
						
						int i = ps.executeUpdate();
						JOptionPane.showMessageDialog(btnsubmit, i+"Sucessfully Submitted");
						messageArea.setText("");
						msg.setText("Sucessfully Submitted");
												
						ps.close();
						con.close();
						
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnsubmit);
		
	    msg = new JLabel("");
	    msg.setBounds(359, 387, 275, 63);
		contentPane.add(msg);
		
	}
}
