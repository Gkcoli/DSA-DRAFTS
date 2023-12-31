package trying;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JProgressBar;

public class UserHome extends JFrame {

	private JPanel contentPane;
	JLabel lblNewTeam;
	JLabel lblNewMember1;
	JLabel lblNewMember2;
	JLabel lblNewMember3;
	JLabel lblNewMember4;
	JLabel lblNewMember5;
	

	    private UserData userData;

	    public UserHome(UserData userData) {
	        this.userData = userData;
	        initializeComponents();
	    }

	    private void initializeComponents() {
	        // Create a new content pane
	        contentPane = new JPanel();
	        setContentPane(contentPane);

	        // Set layout manager for the content pane
	        contentPane.setLayout(null);

	        // Set the team name and member names from the UserData
	        lblNewTeam = new JLabel(userData.getTeamName());
	        lblNewTeam.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
	        lblNewTeam.setBounds(82, 10, 400, 52);
	        contentPane.add(lblNewTeam);

	        String[] teamMembers = userData.getTeamMembers();
	        lblNewMember1 = new JLabel(teamMembers[0]);
	        lblNewMember1.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
	        lblNewMember1.setBounds(95, 61, 400, 35);
	        contentPane.add(lblNewMember1);

	        lblNewMember2 = new JLabel(teamMembers[1]);
	        lblNewMember2.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
	        lblNewMember2.setBounds(95, 101, 400, 35);
	        contentPane.add(lblNewMember2);

	        lblNewMember3 = new JLabel(teamMembers[2]);
	        lblNewMember3.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
	        lblNewMember3.setBounds(95, 141, 400, 35);
	        contentPane.add(lblNewMember3);

	        lblNewMember4 = new JLabel(teamMembers[3]);
	        lblNewMember4.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
	        lblNewMember4.setBounds(95, 181, 400, 35);
	        contentPane.add(lblNewMember4);

	        lblNewMember5 = new JLabel(teamMembers[4]);
	        lblNewMember5.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
	        lblNewMember5.setBounds(95, 221, 400, 35);
	        contentPane.add(lblNewMember5);
	    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHome frame = new UserHome();
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
	public UserHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 630);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		contentPane.setBackground(new Color(255, 251, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1067, 105);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\carlo\\OneDrive\\Desktop\\pransue\\School\\SECOND YEAR\\FIRST TERM\\DSA\\adminHP.jpg"));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(106, 198, 382, 302);
		panel.setBackground(new Color(255, 212, 212));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("RECENT TOURNA");
		lblNewLabel_1.setBounds(38, 33, 315, 83);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 68));
		
		JLabel lblNewLabel_3 = new JLabel("REGISTERED TO ANY");
		lblNewLabel_3.setBounds(83, 164, 240, 47);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JLabel lblNewLabel_2 = new JLabel("YOUR TEAM IS NOT ");
		lblNewLabel_2.setBounds(92, 126, 204, 47);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JLabel lblNewLabel_4 = new JLabel("TOURNAMENT");
		lblNewLabel_4.setBounds(116, 203, 148, 47);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 212, 212));
		panel_1.setBounds(602, 248, 328, 255);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewTeam = new JLabel("[TEAM 1 NAME]");
		lblNewTeam.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblNewTeam.setBounds(82, 10, 171, 52);
		panel_1.add(lblNewTeam);
		
		lblNewMember1 = new JLabel("[Member 1 Name]");
		lblNewMember1.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember1.setBounds(95, 61, 132, 35);
		panel_1.add(lblNewMember1);
		
		lblNewMember2 = new JLabel("[Member 2 Name]");
		lblNewMember2.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember2.setBounds(95, 101, 132, 35);
		panel_1.add(lblNewMember2);
		
		lblNewMember3 = new JLabel("[Member 3 Name]");
		lblNewMember3.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember3.setBounds(95, 141, 132, 35);
		panel_1.add(lblNewMember3);
		
		lblNewMember4 = new JLabel("[Member 4 Name]");
		lblNewMember4.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember4.setBounds(95, 181, 132, 35);
		panel_1.add(lblNewMember4);
		
		lblNewMember5 = new JLabel("[Member 5 Name]");
		lblNewMember5.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember5.setBounds(95, 221, 132, 35);
		panel_1.add(lblNewMember5);
		
		
		JLabel lblNewLabel_5 = new JLabel("DIFFERENCE");
		lblNewLabel_5.setFont(new Font("Tungsten Bold", Font.PLAIN, 99));
		lblNewLabel_5.setBounds(602, 163, 351, 109);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DARE TO BE THE");
		lblNewLabel_6.setForeground(new Color(189, 57, 68));
		lblNewLabel_6.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
		lblNewLabel_6.setBounds(602, 125, 204, 52);
		contentPane.add(lblNewLabel_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(189, 57, 68));
		panel_2.setBounds(463, 510, 147, 70);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_13 = new JLabel("JOIN NOW");
		lblNewLabel_13.setForeground(new Color(255, 251, 245));
		lblNewLabel_13.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblNewLabel_13.setBounds(30, 18, 87, 42);
		lblNewLabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_13.setForeground(new Color(255, 255, 255));
				lblNewLabel_13.setForeground(new Color(255, 255, 255));
				lblNewLabel_13.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				lblNewLabel_13.setForeground(new Color(0, 0, 0));
				lblNewLabel_13.setForeground(new Color(0, 0, 0));
				lblNewLabel_13.setBackground(new Color(228, 195, 197));
			}
			
//			public void mouseClicked(MouseEvent e) {
//				dispose();
//				JoinTourna toJoinTourna = new JoinTourna();
//				toJoinTourna.setVisible(true);
//			}
			
		});
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("EPISODE 1 // ACT 1");
		lblNewLabel_14.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
		lblNewLabel_14.setBounds(179, 136, 227, 52);
		contentPane.add(lblNewLabel_14);
	}
}
