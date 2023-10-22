package trying;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;

public class LeagueStats extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTN;
	private JTextField txtNM1;
	private JTextField txtkill1;
	private JTextField txtMK1;
	private JTextField textField;
	private JTextField txtPlants;
	private JTextField txtMostPlants;
	private JTextField textField_1;
	private JTextField txtKd;
	private JTextField txtMatchMvp;
	private JTextField textField_3;
	private JTextField txtKda;
	private JTextField txtTeamMvp;
	private JTextField textField_2;
	private JTextField txtMostDefuses;
	private JTextField txtTeamDefuses;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeagueStats frame = new LeagueStats();
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
	public LeagueStats() {
		getContentPane().setLayout(null);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,251,245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTeamDefuses = new JTextField();
		txtTeamDefuses.setText("TEAM DEFUSES");
		txtTeamDefuses.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamDefuses.setForeground(new Color(253, 69, 86));
		txtTeamDefuses.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		txtTeamDefuses.setEditable(false);
		txtTeamDefuses.setColumns(10);
		txtTeamDefuses.setBorder(null);
		txtTeamDefuses.setBackground(new Color(255, 251, 245));
		txtTeamDefuses.setBounds(784, 295, 170, 41);
		contentPane.add(txtTeamDefuses);
		
		txtTeamMvp = new JTextField();
		txtTeamMvp.setText("TEAM MVP");
		txtTeamMvp.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamMvp.setForeground(new Color(253, 69, 86));
		txtTeamMvp.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		txtTeamMvp.setEditable(false);
		txtTeamMvp.setColumns(10);
		txtTeamMvp.setBorder(null);
		txtTeamMvp.setBackground(new Color(255, 251, 245));
		txtTeamMvp.setBounds(583, 334, 160, 41);
		contentPane.add(txtTeamMvp);
		
		txtMatchMvp = new JTextField();
		txtMatchMvp.setText("MATCH MVP");
		txtMatchMvp.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatchMvp.setForeground(new Color(253, 69, 86));
		txtMatchMvp.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		txtMatchMvp.setEditable(false);
		txtMatchMvp.setColumns(10);
		txtMatchMvp.setBorder(null);
		txtMatchMvp.setBackground(new Color(255, 251, 245));
		txtMatchMvp.setBounds(398, 431, 203, 60);
		contentPane.add(txtMatchMvp);
		
		txtKd = new JTextField();
		txtKd.setText("?? K/D/A");
		txtKd.setHorizontalAlignment(SwingConstants.CENTER);
		txtKd.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		txtKd.setColumns(10);
		txtKd.setEditable(false);
		txtKd.setBorder(null);
		txtKd.setBackground(new Color(255, 251, 245));
		txtKd.setBounds(440, 393, 111, 49);
		contentPane.add(txtKd);
		
		txtMK1 = new JTextField();
		txtMK1.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		txtMK1.setHorizontalAlignment(SwingConstants.CENTER);
		txtMK1.setBorder(null);
		txtMK1.setText("MOST KILLS");
		txtMK1.setEditable(false);
		txtMK1.setBounds(41, 295, 160, 41);
		txtMK1.setBackground(new Color(255,251,245));
		contentPane.add(txtMK1);
		Color c = new Color(253, 69, 86);
	    txtMK1.setForeground(c);
		txtMK1.setColumns(10);
		
		JLabel lblTop = new JLabel("");
		lblTop.setBounds(0, -79, 1064, 258);
		lblTop.setIcon(new ImageIcon("C:\\Users\\Ryujin\\Downloads\\LEAGUE STATS.png"));
		contentPane.add(lblTop);
		
		txtTN = new JTextField();
		txtTN.setEditable(false);
		txtTN.setBorder(null);
		txtTN.setHorizontalAlignment(SwingConstants.CENTER);
		txtTN.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
		txtTN.setText("[TEAM NAME]");
		txtTN.setBackground(new Color(255,251,245));
		txtTN.setEditable(false);
		txtTN.setBounds(420, 133, 181, 80);
		contentPane.add(txtTN);
		txtTN.setColumns(10);
		
		txtNM1 = new JTextField();
		txtNM1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNM1.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		txtNM1.setText("[name]");
		txtNM1.setBorder(null);
		txtNM1.setEditable(false);
		txtNM1.setBounds(60, 246, 100, 30);
		contentPane.add(txtNM1);
		txtNM1.setBackground(new Color(255,251,245));
		txtNM1.setColumns(10);
		
		txtkill1 = new JTextField();
		txtkill1.setHorizontalAlignment(SwingConstants.CENTER);
		txtkill1.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
		txtkill1.setText("?? kills");
		txtkill1.setBorder(null);
		txtkill1.setEditable(false);
		txtkill1.setBounds(71, 270, 83, 30);
		contentPane.add(txtkill1);
		txtkill1.setBackground(new Color(255,251,245));
		txtkill1.setColumns(10);
		
		textField = new JTextField();
		textField.setText("[name]");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(255, 251, 245));
		textField.setBounds(251, 275, 100, 30);
		contentPane.add(textField);
		
		txtPlants = new JTextField();
		txtPlants.setText("?? plants");
		txtPlants.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlants.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
		txtPlants.setColumns(10);
		txtPlants.setBorder(null);
		txtPlants.setBackground(new Color(255, 251, 245));
		txtPlants.setBounds(261, 305, 83, 30);
		contentPane.add(txtPlants);
		
		txtMostPlants = new JTextField();
		txtMostPlants.setText("MOST PLANTS");
		txtMostPlants.setHorizontalAlignment(SwingConstants.CENTER);
		txtMostPlants.setForeground(new Color(253, 69, 86));
		txtMostPlants.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		txtMostPlants.setEditable(false);
		txtMostPlants.setColumns(10);
		txtMostPlants.setBorder(null);
		txtMostPlants.setBackground(new Color(255, 251, 245));
		txtMostPlants.setBounds(219, 334, 160, 41);
		contentPane.add(txtMostPlants);
		
		textField_1 = new JTextField();
		textField_1.setText("[name]");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(255, 251, 245));
		textField_1.setBounds(451, 362, 100, 41);
		contentPane.add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setText("[name]");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(255, 251, 245));
		textField_3.setBounds(603, 275, 100, 30);
		contentPane.add(textField_3);
		
		txtKda = new JTextField();
		txtKda.setText("?? K/D/A");
		txtKda.setHorizontalAlignment(SwingConstants.CENTER);
		txtKda.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
		txtKda.setColumns(10);
		txtKda.setBorder(null);
		txtKda.setBackground(new Color(255, 251, 245));
		txtKda.setBounds(610, 305, 83, 30);
		contentPane.add(txtKda);
		
		textField_2 = new JTextField();
		textField_2.setText("[name]");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(255, 251, 245));
		textField_2.setBounds(792, 246, 100, 30);
		contentPane.add(textField_2);
		
		txtMostDefuses = new JTextField();
		txtMostDefuses.setText("?? most defuses");
		txtMostDefuses.setHorizontalAlignment(SwingConstants.CENTER);
		txtMostDefuses.setFont(new Font("Tungsten Bold", Font.PLAIN, 19));
		txtMostDefuses.setColumns(10);
		txtMostDefuses.setBorder(null);
		txtMostDefuses.setBackground(new Color(255, 251, 245));
		txtMostDefuses.setBounds(812, 270, 100, 30);
		contentPane.add(txtMostDefuses);
	}
}
