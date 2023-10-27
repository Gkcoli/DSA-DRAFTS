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
import javax.swing.SwingConstants;

public class UserHome extends JFrame {

	private JPanel contentBG;
	JLabel lblNewTeam;
	JLabel lblNewMember1;
	JLabel lblNewMember2;
	JLabel lblNewMember3;
	JLabel lblNewMember4;
	JLabel lblNewMember5;
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
	public void updateLabels(UserData userData) {
	    lblNewTeam.setText(userData.getTeamName());
	    lblNewMember1.setText(userData.getTeamMembers()[0]);
	    lblNewMember2.setText(userData.getTeamMembers()[1]);
	    lblNewMember3.setText(userData.getTeamMembers()[2]);
	    lblNewMember4.setText(userData.getTeamMembers()[3]);
	    lblNewMember5.setText(userData.getTeamMembers()[4]);
	}

	/**
	 * Create the frame.
	 */
	public UserHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 630);
		contentBG = new JPanel();
		contentBG.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		contentBG.setBackground(new Color(255, 251, 245));
		contentBG.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentBG);
		contentBG.setLayout(null);
		
		JLabel lblTop = new JLabel("New label");
		lblTop.setBounds(0, 0, 1067, 105);
		lblTop.setIcon(new ImageIcon("C:\\Users\\carlo\\OneDrive\\Desktop\\pransue\\School\\SECOND YEAR\\FIRST TERM\\DSA\\adminHP.jpg"));
		contentBG.add(lblTop);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 201, 382, 302);
		panel_1.setBackground(new Color(255, 212, 212));
		contentBG.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRecenTourna = new JLabel("RECENT TOURNA");
		lblRecenTourna.setBounds(38, 33, 315, 83);
		panel_1.add(lblRecenTourna);
		lblRecenTourna.setFont(new Font("Tungsten Bold", Font.PLAIN, 68));
		
		JLabel lblRty = new JLabel("REGISTERED TO ANY");
		lblRty.setBounds(83, 164, 240, 47);
		panel_1.add(lblRty);
		lblRty.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JLabel lblYtsn = new JLabel("YOUR TEAM IS NOT ");
		lblYtsn.setBounds(92, 126, 204, 47);
		panel_1.add(lblYtsn);
		lblYtsn.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JLabel lblTourna = new JLabel("TOURNAMENT");
		lblTourna.setBounds(116, 203, 148, 47);
		panel_1.add(lblTourna);
		lblTourna.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 212, 212));
		panel_3.setBounds(602, 248, 328, 255);
		contentBG.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewTeam = new JLabel("[TEAM 1 NAME]");
		lblNewTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewTeam.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblNewTeam.setBounds(60, 11, 200, 52);
		panel_3.add(lblNewTeam);
		
		lblNewMember1 = new JLabel("[Member 1 Name]");
		lblNewMember1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember1.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember1.setBounds(84, 59, 158, 35);
		panel_3.add(lblNewMember1);
		
		lblNewMember2 = new JLabel("[Member 2 Name]");
		lblNewMember2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember2.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember2.setBounds(84, 101, 158, 35);
		panel_3.add(lblNewMember2);
		
		lblNewMember3 = new JLabel("[Member 3 Name]");
		lblNewMember3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember3.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember3.setBounds(84, 141, 158, 35);
		panel_3.add(lblNewMember3);
		
		lblNewMember4 = new JLabel("[Member 4 Name]");
		lblNewMember4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember4.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember4.setBounds(84, 181, 158, 35);
		panel_3.add(lblNewMember4);
		
		lblNewMember5 = new JLabel("[Member 5 Name]");
		lblNewMember5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember5.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember5.setBounds(84, 221, 158, 35);
		panel_3.add(lblNewMember5);
		
		
		JLabel lblDifference = new JLabel("DIFFERENCE");
		lblDifference.setFont(new Font("Tungsten Bold", Font.PLAIN, 99));
		lblDifference.setBounds(602, 163, 351, 109);
		contentBG.add(lblDifference);
		
		JLabel lblDtbt = new JLabel("DARE TO BE THE");
		lblDtbt.setForeground(new Color(189, 57, 68));
		lblDtbt.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
		lblDtbt.setBounds(602, 125, 204, 52);
		contentBG.add(lblDtbt);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(189, 57, 68));
		panel_2.setBounds(463, 510, 147, 70);
		contentBG.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblJoin = new JLabel("JOIN NOW");
		lblJoin.setForeground(new Color(255, 251, 245));
		lblJoin.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblJoin.setBounds(30, 18, 87, 42);
		lblJoin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblJoin.setForeground(new Color(255, 255, 255));
				lblJoin.setForeground(new Color(255, 255, 255));
				lblJoin.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				lblJoin.setForeground(new Color(0, 0, 0));
				lblJoin.setForeground(new Color(0, 0, 0));
				lblJoin.setBackground(new Color(228, 195, 197));
			}
			
//			public void mouseClicked(MouseEvent e) {
//				dispose();
//				JoinTourna toJoinTourna = new JoinTourna();
//				toJoinTourna.setVisible(true);
			//}
			
		});
		panel_2.add(lblJoin);
		
		JLabel lblEpAct1 = new JLabel("EPISODE 1 // ACT 1");
		lblEpAct1.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
		lblEpAct1.setBounds(179, 136, 227, 52);
		contentBG.add(lblEpAct1);
		
		
		
	}
	
}
