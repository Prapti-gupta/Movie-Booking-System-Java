package co;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class movielist extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    movielist frame = new movielist();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public movielist() {
        setTitle("Choose Movie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 387);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(55, 47, 139, 205);
        contentPane.add(label);
        ImageIcon icon = new ImageIcon("img/Black Widow.png");
        
        Image img = icon.getImage();
        Image modifiedimage = img.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(modifiedimage);
        label.setIcon(icon);

        JLabel label_1 = new JLabel();
        label_1.setBounds(262, 47, 139, 205);
        contentPane.add(label_1);
        ImageIcon icon1 = new ImageIcon("img/Thor.png");
        
        Image img1 = icon1.getImage();
        Image modifiedimage1 = img1.getScaledInstance(label_1.getWidth(), label_1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(modifiedimage1);
        label_1.setIcon(icon1);

        JButton btnNewButton = new JButton("Black Widow");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                String movieName = btnNewButton.getText();
                movie Register = new movie(movieName);
                Register.setVisible(true);
                
                
            }
        });
        btnNewButton.setBounds(75, 289, 125, 23);
        contentPane.add(btnNewButton);

        JButton btnThor = new JButton("Thor");
        btnThor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                String movieName = btnThor.getText();
                movie Register = new movie(movieName);
                Register.setVisible(true);
                
                
                
            }
        });
        btnThor.setBounds(291, 289, 89, 23);
        contentPane.add(btnThor);
    }
}
