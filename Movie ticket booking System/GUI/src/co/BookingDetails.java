package co;

import java.awt.Color;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class BookingDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    

    public BookingDetails(String movieName, String selectedTheater, String numTickets, String selectedSeatType, int cost) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 412, 373);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 215, 0));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel_1 = new JLabel("Movie:     " + movieName);
        lblNewLabel_1.setFont(new Font("Aparajita", Font.PLAIN, 24));
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setBounds(106, 76, 200, 23);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel = new JLabel("Theatre:    "+ selectedTheater);
        lblNewLabel.setFont(new Font("Aparajita", Font.PLAIN, 24));
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(106, 114, 200, 33);
        contentPane.add(lblNewLabel);
        
        
        JLabel lblCost = new JLabel("No. of Seats:     "+ numTickets);
        lblCost.setFont(new Font("Aparajita", Font.PLAIN, 24));
        lblCost.setForeground(Color.BLACK);
        lblCost.setBounds(106, 163, 400, 23);
        contentPane.add(lblCost);
        
        JLabel lblCost_1 = new JLabel("Cost:           "+cost);
        lblCost_1.setFont(new Font("Aparajita", Font.PLAIN, 24));
        lblCost_1.setForeground(Color.BLACK);
        lblCost_1.setBounds(106, 207, 200, 23);
        contentPane.add(lblCost_1);
        
       
        
        JButton btnNewButton = new JButton("Book Ticket");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Payment pay = new Payment();
                pay.setVisible(true);
                try {
                   
                    Class.forName("com.mysql.cj.jdbc.Driver");
                  
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users", "root", "root");
                    
                    String query = "INSERT INTO booked (movie_name, theater, num_tickets, seat_type, cost, status) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    // Set the parameter values for the query
                    pstmt.setString(1, movieName);
                    pstmt.setString(2, selectedTheater);
                    pstmt.setString(3, numTickets);
                    pstmt.setString(4, selectedSeatType);
                    pstmt.setInt(5, cost);
                    pstmt.setString(6, "Booked"); 
                    pstmt.executeUpdate();
                    
                    pstmt.close();
                    con.close(); 
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnNewButton.setBounds(58, 276, 111, 23);
        contentPane.add(btnNewButton);
        
        JButton btnCancelTicket = new JButton("Cancel Ticket");
        btnCancelTicket.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users", "root", "root");
                    String query = "UPDATE booked SET status = 'Cancelled' WHERE movie_name = ? AND theater = ? AND num_tickets = ? AND seat_type = ? AND cost = ?";
                    PreparedStatement pstmt = con.prepareStatement(query);
                    pstmt.setString(1, movieName);
                    pstmt.setString(2, selectedTheater);
                    pstmt.setString(3, numTickets);
                    pstmt.setString(4, selectedSeatType);
                    pstmt.setInt(5, cost);
                    
                    int updatedRows = pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButton, "Ticket Cancelled successfully!");
                    pstmt.close();
                    con.close();
                        
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnCancelTicket.setBounds(232, 276, 111, 23);
        contentPane.add(btnCancelTicket);


        
        JLabel lblNewLabel_1_1 = new JLabel("Booking Details");
        lblNewLabel_1_1.setBackground(new Color(0, 0, 0));
        lblNewLabel_1_1.setFont(new Font("Beatific Margella", Font.PLAIN, 22));
        lblNewLabel_1_1.setVerifyInputWhenFocusTarget(false);
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setBounds(110, 25, 200, 25);
        contentPane.add(lblNewLabel_1_1);
        
        
    }
}
