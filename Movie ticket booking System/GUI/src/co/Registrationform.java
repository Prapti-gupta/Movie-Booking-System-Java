package co;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class Registrationform extends JFrame {
	


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTxtname;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrationform frame = new Registrationform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Registrationform() {
		setType(Type.POPUP);
		setOpacity(1.0f);
		setForeground(new Color(72, 61, 139));
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Siddhi Kadam\\Downloads\\add-user-icon-registration-illustration-sign-avatar-symbol-new-profile-logo-vector.jpg"));
		setTitle("Welcome~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 301);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 14));
		lblNewLabel.setBounds(62, 28, 113, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Calisto MT", Font.BOLD, 14));
		lblNewLabel_1.setBounds(62, 100, 87, 22);
		contentPane.add(lblNewLabel_1);
		
		txtTxtname = new JTextField();
		txtTxtname.setBounds(185, 46, 137, 28);
		contentPane.add(txtTxtname);
		txtTxtname.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(185, 99, 137, 23);
		contentPane.add(txtpass);
		
		JButton btnNewButton = new JButton("Login ");
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setBackground(new Color(248, 248, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users", "root", "root");
					String query ="SELECT * FROM registration WHERE name = '"+txtTxtname.getText()+"' AND password = '"+txtpass.getText().toString()+"'";
					PreparedStatement ps= con.prepareStatement(query);
					ResultSet rs = ps.executeQuery(query);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(btnNewButton, "Welcome!~");
                        dispose();
                        movielist Register = new movielist();
                        Register.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton, "Invalid username or password.");
                    }
                    ps.close();
                    con.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
		});

		btnNewButton.setBounds(60, 171, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up ");
		btnNewButton_1.setForeground(new Color(128, 0, 128));
		btnNewButton_1.setBackground(new Color(248, 248, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Register registerForm = new Register(); 
                registerForm.setVisible(true);
                
                
			}
		});
		btnNewButton_1.setBounds(233, 171, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewHere = new JLabel("New here?");
		lblNewHere.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblNewHere.setBounds(233, 151, 89, 28);
		contentPane.add(lblNewHere);
	}
}
