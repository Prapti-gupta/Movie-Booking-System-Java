package co;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmDetails extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblMovie;
    private JLabel lblMessage;

    public ConfirmDetails() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 468, 200);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(186, 85, 211));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        lblMovie = new JLabel();
        lblMovie.setHorizontalAlignment(SwingConstants.CENTER);
        lblMovie.setFont(new Font("Arial", Font.BOLD, 16));
        lblMovie.setForeground(Color.WHITE);
        contentPane.add(lblMovie, BorderLayout.NORTH);

        lblMessage = new JLabel("Movie ticket booked!");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setFont(new Font("Arial", Font.BOLD, 20));
        lblMessage.setForeground(Color.WHITE);
        contentPane.add(lblMessage, BorderLayout.CENTER);

        
    }
}
