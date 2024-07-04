package co;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class movie extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static final int numTickets = 0;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    movie frame = new movie("Movie Name"); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });}

    public movie(String movieName) {
        setTitle("Select your according to your comfort");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 538, 487);
        contentPane = new JPanel();
        contentPane.setForeground(new Color(248, 248, 255));
        contentPane.setBackground(new Color(128, 0, 128));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblSelectTheatre = new JLabel("Select Theatre");
        lblSelectTheatre.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectTheatre.setForeground(new Color(255, 250, 240));
        lblSelectTheatre.setFont(new Font("Beatific Margella", Font.BOLD, 20));
        lblSelectTheatre.setBounds(27, 76, 186, 61);
        contentPane.add(lblSelectTheatre);
        
        String[] theaters = {"Theater A", "Theater B", "Theater C"};
        JComboBox<String> comboBoxTheater = new JComboBox<>(theaters);
        comboBoxTheater.setBounds(341, 97, 125, 22);
        contentPane.add(comboBoxTheater);

        JLabel lblNewLabel_1_1 = new JLabel("Select Date");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setForeground(new Color(255, 250, 240));
        lblNewLabel_1_1.setFont(new Font("Beatific Margella", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(36, 138, 137, 49);
        contentPane.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("No. of Tickets");
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_1.setForeground(new Color(255, 250, 240));
        lblNewLabel_1_1_1.setFont(new Font("Beatific Margella", Font.BOLD, 20));
        lblNewLabel_1_1_1.setBounds(27, 227, 176, 49);
        contentPane.add(lblNewLabel_1_1_1);

        JLabel lblNewLabel_1 = new JLabel("Movie: " + movieName);
        lblNewLabel_1.setFont(new Font("Beatific Margella", Font.BOLD, 21));
        lblNewLabel_1.setForeground(new Color(255, 250, 250));
        lblNewLabel_1.setBounds(167, 31, 500, 25);
        contentPane.add(lblNewLabel_1);
        
        JComboBox<String> comboBoxNumTickets = new JComboBox<>();
        comboBoxNumTickets.setToolTipText("select no. of tickets");
        comboBoxNumTickets.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4"}));
        comboBoxNumTickets.setBounds(341, 243, 125, 22);
        contentPane.add(comboBoxNumTickets);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setMinSelectableDate(getStartOfWeek());
        dateChooser.setMaxSelectableDate(getEndOfWeek());
        dateChooser.setDateFormatString("ddMMyyyy");
        dateChooser.setBounds(341, 153, 125, 20);
        contentPane.add(dateChooser);
        
        JLabel lblTypeOfSeat = new JLabel("Type of Seat");
        lblTypeOfSeat.setHorizontalAlignment(SwingConstants.CENTER);
        lblTypeOfSeat.setForeground(new Color(255, 250, 240));
        lblTypeOfSeat.setFont(new Font("Beatific Margella", Font.BOLD, 20));
        lblTypeOfSeat.setBounds(27, 291, 176, 49);
        contentPane.add(lblTypeOfSeat);

        JComboBox<String> comboBoxTypeOfSeat = new JComboBox<>();
        comboBoxTypeOfSeat.setModel(new DefaultComboBoxModel<>(new String[]{"Premium", "Standard", "Economy"}));
        comboBoxTypeOfSeat.setBounds(341, 307, 120, 22);
        contentPane.add(comboBoxTypeOfSeat);
        
        JLabel lblNewLabel_1_1_2 = new JLabel("Select time");
        lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1_2.setForeground(new Color(255, 250, 240));
        lblNewLabel_1_1_2.setFont(new Font("Beatific Margella", Font.BOLD, 20));
        lblNewLabel_1_1_2.setBounds(36, 182, 137, 49);
        contentPane.add(lblNewLabel_1_1_2);
        
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"7:00 am ", "1:00 pm", "4:00 pm"}));
        comboBox.setBounds(341, 198, 125, 22);
        contentPane.add(comboBox);
        
        JButton Submit = new JButton("Submit");
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	String movieName = lblNewLabel_1.getText().substring(7); 
            	String selectedTheater = comboBoxTheater.getSelectedItem().toString();
                String selectedDate = dateChooser.getDateFormatString().toString();
                String numTickets = comboBoxNumTickets.getSelectedItem().toString();
                String selectedSeatType = comboBoxTypeOfSeat.getSelectedItem().toString();
                String selectshow=comboBox.getSelectedItem().toString();
                int cost = calculateCost(selectedSeatType, Integer.parseInt(numTickets));
                
                dispose();
                BookingDetails bookingDetails = new BookingDetails(movieName, selectedTheater, numTickets, selectedSeatType, cost);
                bookingDetails.setVisible(true);
            }
        });

        Submit.setBounds(231, 340, 89, 23);
        contentPane.add(Submit);
        
        
    }

    protected int calculateCost(String selectedSeatType, int numTickets) {
    	int costPerSeat;
		switch (selectedSeatType) {
			case "Premium":
				costPerSeat = 400;
				break;
			case "Standard":
				costPerSeat = 320;
				break;
			case "Economy":
				costPerSeat = 280;
				break;
			default:
				costPerSeat = 280;
				break;
		}
		return costPerSeat * numTickets;
	}

	private java.util.Date getStartOfWeek() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return cal.getTime();
    }

    private java.util.Date getEndOfWeek() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + 6);
        return cal.getTime();
    }
}
