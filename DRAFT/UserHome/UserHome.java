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

	private JPanel contentPane;
	JLabel lblUser;
	JLabel lblNewTeam;
	JLabel lblNewMember1;
	JLabel lblNewMember2;
	JLabel lblNewMember3;
	JLabel lblNewMember4;
	JLabel lblNewMember5;
	// Edit fileDirectory
	String fileDirectory = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/";
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
		lblUser.setText(userData.getUsername().toUpperCase());
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
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		contentPane.setBackground(new Color(255, 251, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserHPBanner = new JLabel("New label");
		lblUserHPBanner.setBounds(0, 0, 1067, 105);
		lblUserHPBanner.setIcon(new ImageIcon(fileDirectory + "adminHP.jpg"));
		contentPane.add(lblUserHPBanner);
		
		JPanel panelRecentTourna = new JPanel();
		panelRecentTourna.setBounds(106, 201, 382, 302);
		panelRecentTourna.setBackground(new Color(255, 212, 212));
		contentPane.add(panelRecentTourna);
		panelRecentTourna.setLayout(null);
		
		JLabel lblRecentTournaBanner = new JLabel("RECENT TOURNA");
		lblRecentTournaBanner.setBounds(38, 33, 315, 83);
		panelRecentTourna.add(lblRecentTournaBanner);
		lblRecentTournaBanner.setFont(new Font("Tungsten Bold", Font.PLAIN, 68));
		
		JLabel lblNewLabel_3 = new JLabel("COMING SOON...", SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 164, 382, 47);
		panelRecentTourna.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JLabel lblVanguard = new JLabel("VICTORY VANGUARD", SwingConstants.CENTER);
		lblVanguard.setBounds(0, 107, 382, 66);
		panelRecentTourna.add(lblVanguard);
		lblVanguard.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		
		JPanel panelTeamComp = new JPanel();
		panelTeamComp.setBackground(new Color(255, 212, 212));
		panelTeamComp.setBounds(602, 248, 328, 255);
		contentPane.add(panelTeamComp);
		panelTeamComp.setLayout(null);
		
		lblNewTeam = new JLabel("[TEAM 1 NAME]");
		lblNewTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewTeam.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblNewTeam.setBounds(0, 11, 328, 52);
		panelTeamComp.add(lblNewTeam);
		
		lblNewMember1 = new JLabel("[Member 1 Name]");
		lblNewMember1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember1.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember1.setBounds(0, 59, 328, 35);
		panelTeamComp.add(lblNewMember1);
		
		lblNewMember2 = new JLabel("[Member 2 Name]");
		lblNewMember2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember2.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember2.setBounds(0, 101, 328, 35);
		panelTeamComp.add(lblNewMember2);
		
		lblNewMember3 = new JLabel("[Member 3 Name]");
		lblNewMember3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember3.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember3.setBounds(0, 141, 328, 35);
		panelTeamComp.add(lblNewMember3);
		
		lblNewMember4 = new JLabel("[Member 4 Name]");
		lblNewMember4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember4.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember4.setBounds(0, 181, 328, 35);
		panelTeamComp.add(lblNewMember4);
		
		lblNewMember5 = new JLabel("[Member 5 Name]");
		lblNewMember5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMember5.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		lblNewMember5.setBounds(0, 221, 328, 35);
		panelTeamComp.add(lblNewMember5);
		
		
		JLabel lblNewLabel_5 = new JLabel("DIFFERENCE");
		lblNewLabel_5.setFont(new Font("Tungsten Bold", Font.PLAIN, 99));
		lblNewLabel_5.setBounds(602, 163, 351, 109);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DARE TO BE THE");
		lblNewLabel_6.setForeground(new Color(189, 57, 68));
		lblNewLabel_6.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
		lblNewLabel_6.setBounds(602, 125, 204, 52);
		contentPane.add(lblNewLabel_6);
		
		JPanel panelJoinNow = new JPanel();
		panelJoinNow.setBackground(new Color(189, 57, 68));
		panelJoinNow.setBounds(463, 518, 147, 62);
		contentPane.add(panelJoinNow);
		panelJoinNow.setLayout(null);
		
		
		JLabel lblJoinNow = new JLabel("JOIN NOW", SwingConstants.CENTER);
		lblJoinNow.setForeground(new Color(255, 251, 245));
		lblJoinNow.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblJoinNow.setBounds(0, 0, 147, 62);
		lblJoinNow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblJoinNow.setForeground(new Color(255, 255, 255));
				lblJoinNow.setForeground(new Color(255, 255, 255));
				lblJoinNow.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				lblJoinNow.setForeground(new Color(0, 0, 0));
				lblJoinNow.setForeground(new Color(0, 0, 0));
				lblJoinNow.setBackground(new Color(228, 195, 197));
			}
			
			public void mouseClicked(MouseEvent e) {
				
				if (lblNewTeam.getText().toString() == "" || lblNewTeam.getText().toString() == "Team")
				dispose();
				JoinTourna toJoinTourna = new JoinTourna();
				toJoinTourna.updateLabels(lblUser.getText().toString());
				toJoinTourna.setVisible(true);
			}
			
		});
		panelJoinNow.add(lblJoinNow);
		
		JLabel lblGreetings = new JLabel("HELLO,");
		lblGreetings.setFont(new Font("Tungsten Bold", Font.PLAIN, 55));
		lblGreetings.setBounds(106, 127, 118, 76);
		contentPane.add(lblGreetings);
		
		lblUser = new JLabel("USER");
		lblUser.setFont(new Font("Tungsten Bold", Font.PLAIN, 55));
		lblUser.setBounds(217, 127, 109, 76);
		contentPane.add(lblUser);
		
		JLabel lblExclamationPt = new JLabel("!");
		lblExclamationPt.setFont(new Font("Tungsten Bold", Font.PLAIN, 55));
		lblExclamationPt.setBounds(330, 125, 27, 78);
		contentPane.add(lblExclamationPt);
		
		
		
	}
}
