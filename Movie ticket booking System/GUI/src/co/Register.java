package co;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTxtname;
	private JTextField txtEmail;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setBackground(Color.ORANGE);
		setTitle("Register");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 379);
		contentPane = new JPanel();
		contentPane.setForeground(Color.DARK_GRAY);
		contentPane.setBackground(new Color(0, 139, 139));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(51, 59, 125, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Calisto MT", Font.BOLD, 20));
		lblEmail.setBounds(51, 130, 125, 70);
		contentPane.add(lblEmail);
		
		txtTxtname = new JTextField();
		txtTxtname.setForeground(new Color(0, 0, 0));
		txtTxtname.setBounds(237, 73, 161, 32);
		contentPane.add(txtTxtname);
		txtTxtname.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setBounds(237, 148, 161, 32);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setForeground(new Color(0, 0, 0));
		txtpass.setBounds(237, 223, 161, 32);
		contentPane.add(txtpass);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users", "root", "root");
					String query ="Insert into registration values(?,?,?)";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, txtTxtname.getText());
					ps.setString(2, txtEmail.getText());
					ps.setString(3, txtpass.getText());
					
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, "Registered successfully!");
					ps.close();
					con.close();
					dispose();
					Registrationform Register= new Registrationform(); 
	                Register.setVisible(true);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				}
		});
		btnNewButton.setBounds(178, 282, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBackground(new Color(255, 160, 122));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(new Color(224, 255, 255));
		lblRegister.setFont(new Font("Bookman Old Style", Font.BOLD, 22));
		lblRegister.setBounds(153, 0, 125, 62);
		contentPane.add(lblRegister);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Calisto MT", Font.BOLD, 20));
		lblPassword.setBounds(51, 211, 125, 70);
		contentPane.add(lblPassword);
	}

}
