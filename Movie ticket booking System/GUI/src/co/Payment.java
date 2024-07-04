package co;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;


public class Payment extends JFrame {
	
    
    // Method to establish database connection
    
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtCardNumber;
    private JTextField txtCardholderName;
    private JTextField txtCVV;
    private JTextField txtUPI;
    private JTextField txtNetbanking;
    private JLabel lblCardNumber;
    private JLabel lblCardholderName;
    private JLabel lblCVV;
    private JLabel lblUPI;
    private JLabel lblNetbanking;
    private JRadioButton rdbtnNewRadioButton;
    private JRadioButton rdbtnUpi;
    private JRadioButton rdbtnNewRadioButton_1_1;
    private JRadioButton rdbtnNewRadioButton_1_2;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Payment frame = new Payment();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });}
    
    public Payment() {
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 535, 339);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 0, 0));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        rdbtnNewRadioButton = new JRadioButton("Debit Card");
        rdbtnNewRadioButton.setFont(new Font("Arial", Font.PLAIN, 14));
        rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
        rdbtnNewRadioButton.setBackground(new Color(128, 0, 0));
        rdbtnNewRadioButton.setBounds(146, 31, 109, 23);
        contentPane.add(rdbtnNewRadioButton);
        
        rdbtnUpi = new JRadioButton("UPI");
        rdbtnUpi.setFont(new Font("Arial", Font.PLAIN, 14));
        rdbtnUpi.setForeground(new Color(255, 255, 255));
        rdbtnUpi.setBackground(new Color(128, 0, 0));
        rdbtnUpi.setBounds(146, 68, 109, 23);
        contentPane.add(rdbtnUpi);
        
        rdbtnNewRadioButton_1_1 = new JRadioButton("Credit Card");
        rdbtnNewRadioButton_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
        rdbtnNewRadioButton_1_1.setForeground(new Color(255, 255, 255));
        rdbtnNewRadioButton_1_1.setBackground(new Color(128, 0, 0));
        rdbtnNewRadioButton_1_1.setBounds(293, 31, 109, 23);
        contentPane.add(rdbtnNewRadioButton_1_1);
        
        rdbtnNewRadioButton_1_2 = new JRadioButton("Netbanking ");
        rdbtnNewRadioButton_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
        rdbtnNewRadioButton_1_2.setForeground(new Color(255, 255, 255));
        rdbtnNewRadioButton_1_2.setBackground(new Color(128, 0, 0));
        rdbtnNewRadioButton_1_2.setBounds(293, 68, 109, 23);
        contentPane.add(rdbtnNewRadioButton_1_2);
        
        lblCardNumber = new JLabel("Card Number:");
        lblCardNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCardNumber.setForeground(new Color(255, 255, 255));
        lblCardNumber.setBounds(20, 112, 100, 14);
        contentPane.add(lblCardNumber);
        
        txtCardNumber = new JTextField();
        txtCardNumber.setBounds(146, 110, 120, 20);
        contentPane.add(txtCardNumber);
        txtCardNumber.setColumns(10);
        
        lblCardholderName = new JLabel("Cardholder Name:");
        lblCardholderName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCardholderName.setForeground(new Color(255, 255, 255));
        lblCardholderName.setBounds(20, 154, 126, 14);
        contentPane.add(lblCardholderName);
        
        txtCardholderName = new JTextField();
        txtCardholderName.setColumns(10);
        txtCardholderName.setBounds(146, 152, 120, 20);
        contentPane.add(txtCardholderName);
        
        lblCVV = new JLabel("CVV:");
        lblCVV.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCVV.setForeground(new Color(255, 255, 255));
        lblCVV.setBounds(20, 201, 100, 14);
        contentPane.add(lblCVV);
        
        txtCVV = new JTextField();
        txtCVV.setColumns(10);
        txtCVV.setBounds(146, 199, 120, 20);
        contentPane.add(txtCVV);
        
        lblUPI = new JLabel("UPI:");
        lblUPI.setFont(new Font("Arial", Font.PLAIN, 15));
        lblUPI.setForeground(new Color(255, 255, 255));
        lblUPI.setBounds(280, 112, 100, 14);
        contentPane.add(lblUPI);
        
        txtUPI = new JTextField();
        txtUPI.setColumns(10);
        txtUPI.setBounds(362, 110, 120, 20);
        contentPane.add(txtUPI);
        
        lblNetbanking = new JLabel("Netbanking:");
        lblNetbanking.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNetbanking.setForeground(new Color(255, 255, 255));
        lblNetbanking.setBounds(280, 154, 100, 18);
        contentPane.add(lblNetbanking);
        
        txtNetbanking = new JTextField();
        txtNetbanking.setColumns(10);
        txtNetbanking.setBounds(362, 152, 120, 20);
        contentPane.add(txtNetbanking);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 98, 519, 2);
        contentPane.add(separator);
        
        JButton btnProceed = new JButton("Proceed");
        btnProceed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                JOptionPane.showMessageDialog(Payment.this, "Payment Successful!");
                dispose();
                ConfirmDetails cd=new ConfirmDetails();
                cd.setVisible(true);
            }
        });
        		
        
        btnProceed.setBounds(216, 251, 89, 23);
        contentPane.add(btnProceed);
        
        lblNewLabel = new JLabel("Payment Type: ");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(23, 47, 149, 23);
        contentPane.add(lblNewLabel);
        
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCardNumber.setVisible(true);
                lblCardNumber.setVisible(true);
                txtCardholderName.setVisible(true);
                lblCardholderName.setVisible(true);
                txtCVV.setVisible(true);
                lblCVV.setVisible(true);
                
                txtUPI.setVisible(false);
                lblUPI.setVisible(false);
                txtNetbanking.setVisible(false);
                lblNetbanking.setVisible(false);
            }
        });
        
        rdbtnUpi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtUPI.setVisible(true);
                lblUPI.setVisible(true);
                
                txtCardNumber.setVisible(false);
                lblCardNumber.setVisible(false);
                txtCardholderName.setVisible(false);
                lblCardholderName.setVisible(false);
                txtCVV.setVisible(false);
                lblCVV.setVisible(false);
                txtNetbanking.setVisible(false);
                lblNetbanking.setVisible(false);
            }
        });
        
        rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtCardNumber.setVisible(true);
                lblCardNumber.setVisible(true);
                txtCardholderName.setVisible(true);
                lblCardholderName.setVisible(true);
                txtCVV.setVisible(true);
                lblCVV.setVisible(true);
                
                txtUPI.setVisible(false);
                lblUPI.setVisible(false);
                txtNetbanking.setVisible(false);
                lblNetbanking.setVisible(false);
            }
        });
        
        rdbtnNewRadioButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNetbanking.setVisible(true);
                lblNetbanking.setVisible(true);
                
                txtCardNumber.setVisible(false);
                lblCardNumber.setVisible(false);
                txtCardholderName.setVisible(false);
                lblCardholderName.setVisible(false);
                txtCVV.setVisible(false);
                lblCVV.setVisible(false);
                txtUPI.setVisible(false);
                lblUPI.setVisible(false);
            }
        });
        
    }
	

    }


