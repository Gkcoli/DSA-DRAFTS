import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
public class JoinTourna extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblUserName;
	private JPanel contentPane;
	private JTextField textTeam;
	private JTextField textMember1;
	private JTextField textMember2;
	private JTextField textMember3;
	private JTextField textMember4;
	private JTextField textMember5;
	boolean tournaIsSelected = false;
	boolean tourna2IsFull = false;
	ExcelHandler excel = new ExcelHandler();
	// Edit fileDirectory
	String fileDirectory = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/";
	LinkedList <String> teams = new LinkedList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinTourna frame = new JoinTourna();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateLabels(String user) {
		lblUserName.setText(user.toUpperCase());
	}
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public JoinTourna() {
		// Adds all content of TEAMS.txt to linkedlist
		teams.addAll(ExcelHandler.fileReader(fileDirectory + "VanguardTeams.txt"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 251, 245));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(fileDirectory + "JOIN TOURNA.png"));
		lblNewLabel.setBounds(0, 0, 1500, 105);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EPISODE 1 // ACT 1 TOURNAMENTS");
		lblNewLabel_1.setForeground(new Color(189, 57, 68));
		lblNewLabel_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 48));
		lblNewLabel_1.setBounds(25, 133, 452, 52);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SELECT A TOURNAMENT");
		lblNewLabel_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 41));
		lblNewLabel_2.setForeground(new Color(189, 57, 68));
		lblNewLabel_2.setBounds(111, 184, 286, 52);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TEAM NAME");
		lblNewLabel_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 32));
		lblNewLabel_3.setBounds(557, 192, 106, 39);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("TEAM MEMBERS:");
		lblNewLabel_5.setFont(new Font("Tungsten Bold", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(605, 233, 127, 39);
		contentPane.add(lblNewLabel_5);
		
		textTeam = new JTextField();
		textTeam.setBorder(null);
		textTeam.setBackground(new Color(217, 217, 217));
		textTeam.setBounds(688, 193, 211, 28);
		contentPane.add(textTeam);
		textTeam.setColumns(10); 
		textTeam.setEnabled(false);
		textTeam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textTeam.setBackground(new Color(174, 174, 174));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textTeam.setBackground(new Color(217, 217, 217));
			}
		});
		
		textMember1 = new JTextField();
		textMember1.setBorder(null);
		textMember1.setBackground(new Color(217, 217, 217));
		textMember1.setBounds(688, 276, 211, 28);
		contentPane.add(textMember1);
		textMember1.setColumns(10);
		textMember1.setEnabled(false);
		textMember1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textMember1.setBackground(new Color(174, 174, 174));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textMember1.setBackground(new Color(217, 217, 217));
			}
		});
		
		textMember2 = new JTextField();
		textMember2.setBorder(null);
		textMember2.setBackground(new Color(217, 217, 217));
		textMember2.setBounds(688, 314, 211, 28);
		contentPane.add(textMember2);
		textMember2.setColumns(10);
		textMember2.setEnabled(false);
		textMember2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textMember2.setBackground(new Color(174, 174, 174));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textMember2.setBackground(new Color(217, 217, 217));
			}
		});
		
		textMember3 = new JTextField();
		textMember3.setBorder(null);
		textMember3.setBackground(new Color(217, 217, 217));
		textMember3.setBounds(688, 352, 211, 28);
		contentPane.add(textMember3);
		textMember3.setColumns(10);
		textMember3.setEnabled(false);
		textMember3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textMember3.setBackground(new Color(174, 174, 174));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textMember3.setBackground(new Color(217, 217, 217));
			}
		});
		
		textMember4 = new JTextField();
		textMember4.setBorder(null);
		textMember4.setBackground(new Color(217, 217, 217));
		textMember4.setBounds(688, 390, 211, 28);
		contentPane.add(textMember4);
		textMember4.setColumns(10);
		textMember4.setEnabled(false);
		textMember4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textMember4.setBackground(new Color(174, 174, 174));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textMember4.setBackground(new Color(217, 217, 217));
			}
		});
		
		textMember5 = new JTextField();
		textMember5.setBorder(null);
		textMember5.setBackground(new Color(217, 217, 217));
		textMember5.setBounds(688, 428, 211, 28);
		contentPane.add(textMember5);
		textMember5.setColumns(10);
		textMember5.setEnabled(false);
		textMember5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textMember5.setBackground(new Color(174, 174, 174));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textMember5.setBackground(new Color(217, 217, 217));
			}
		});
		
		JPanel panelT1 = 	new JPanel();
		panelT1.setBackground(new Color(255, 212, 212));
		panelT1.setBounds(118, 257, 252, 78);
		contentPane.add(panelT1);
		panelT1.setLayout(null);
		
		JLabel lblTourna1Status = new JLabel("FULL", SwingConstants.CENTER);
		lblTourna1Status.setBounds(0, 47, 252, 21);
		panelT1.add(lblTourna1Status);
		lblTourna1Status.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		
		JLabel lblTourna1 = new JLabel("LEAGUE OF ACES", SwingConstants.CENTER);
		lblTourna1.setBounds(0, 10, 252, 43);
		panelT1.add(lblTourna1);
		lblTourna1.setFont(new Font("Tungsten Bold", Font.PLAIN, 34));
		
		JPanel panelT2 = new JPanel();
		panelT2.setBackground(new Color(255, 212, 212));
		panelT2.setBounds(118, 352, 252, 78);
		contentPane.add(panelT2);
		panelT2.setLayout(null);
		
		JLabel lblTourna2Status = new JLabel("JOIN", SwingConstants.CENTER);
		String tournaStatus = "";
		try {
			tournaStatus = ExcelHandler.readSpecificCell(fileDirectory + "MatchSched.xlsx", 3, 3);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (!(tournaStatus.equalsIgnoreCase("N/A"))) {
			lblTourna2Status.setText("FINISHED");
		}
		
		int tournaSize = teams.size();
		if (tournaSize < 4) {
			lblTourna2Status.setText(tournaSize + "/4 TEAMS");
		} else{
			lblTourna2Status.setText("FULL");
		}
		
		lblTourna2Status.setBounds(0, 47, 252, 21);
		panelT2.add(lblTourna2Status);
		lblTourna2Status.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		
		JLabel lblTourna2 = new JLabel("VICTORY VANGUARD", SwingConstants.CENTER);
		lblTourna2.setBounds(0, 10, 252, 43);
		panelT2.add(lblTourna2);
		lblTourna2.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JPanel panelT3 = new JPanel();
		panelT3.setBackground(new Color(255, 212, 212));
		panelT3.setBounds(118, 449, 252, 78);
		contentPane.add(panelT3);
		panelT3.setLayout(null);
		
		JLabel lblTourna3Status = new JLabel("TBA", SwingConstants.CENTER);
		lblTourna3Status.setBounds(0, 47, 252, 21);
		panelT3.add(lblTourna3Status);
		lblTourna3Status.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		
		JLabel lblTourna3 = new JLabel("WORLD VALORANT", SwingConstants.CENTER);
		lblTourna3.setBounds(0, 10, 252, 43);
		panelT3.add(lblTourna3);
		lblTourna3.setFont(new Font("Tungsten Bold", Font.PLAIN, 34));
		
		JPanel panelJoinButton = new JPanel();
		panelJoinButton.setForeground(new Color(255, 255, 255));
		panelJoinButton.setBackground(new Color(189, 57, 68));
		panelJoinButton.setFont(new Font("Tungsten Bold", Font.PLAIN, 24));
		panelJoinButton.setBounds(740, 480, 106, 52);
		contentPane.add(panelJoinButton)
		;
		panelJoinButton.setLayout(null);
		
		JLabel lblJoin = new JLabel("JOIN", SwingConstants.CENTER);
		lblJoin.setForeground(new Color(255, 255, 255));
		lblJoin.setFont(new Font("Tungsten Bold", Font.PLAIN, 24));
		lblJoin.setBounds(0, 10, 106, 32);
		panelJoinButton.add(lblJoin);
		
		JLabel lblGreet = new JLabel("LFG, ");
		lblGreet.setFont(new Font("Tungsten Bold", Font.PLAIN, 55));
		lblGreet.setBounds(557, 133, 80, 59);
		contentPane.add(lblGreet);
		
		lblUserName = new JLabel("USER");
		lblUserName.setFont(new Font("Tungsten Bold", Font.PLAIN, 55));
		lblUserName.setBounds(627, 133, 127, 59);
		contentPane.add(lblUserName);
		
		JLabel lblExclamationPT = new JLabel("!");
		lblExclamationPT.setFont(new Font("Tungsten Bold", Font.PLAIN, 55));
		lblExclamationPT.setBounds(739, 133, 31, 59);
		contentPane.add(lblExclamationPT);
		
		panelT1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTourna1Status.setForeground(new Color(255, 255, 255));
				lblTourna1.setForeground(new Color(255, 255, 255));
				lblTourna1.setBackground(new Color(236, 73, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTourna1Status.setForeground(new Color(0, 0, 0));
				lblTourna1.setForeground(new Color(0, 0, 0));
				lblTourna1.setBackground(new Color(228, 195, 197));
			}
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Tournament is already full!");
			}
		});
		
		panelT2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTourna2Status.setForeground(new Color(255, 255, 255));
				lblTourna2.setForeground(new Color(255, 255, 255));
				lblTourna2.setBackground(new Color(236, 73, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
		 		lblTourna2Status.setForeground(new Color(0, 0, 0));
				lblTourna2.setForeground(new Color(0, 0, 0));
				lblTourna2.setBackground(new Color(228, 195, 197));
			}
			public void mouseClicked(MouseEvent e) {
		        if (!(lblTourna2Status.getText().toString().equalsIgnoreCase("FULL") || lblTourna2Status.getText().toString().equalsIgnoreCase("FINISHED"))) {
		        	JOptionPane.showMessageDialog(null, "Please input your team name to join tournament.");
		        	tournaIsSelected = true;
		        	textTeam.setEnabled(true);
		        	textMember1.setEnabled(true);
		        	textMember2.setEnabled(true);
		        	textMember3.setEnabled(true);
		        	textMember4.setEnabled(true);
		        	textMember5.setEnabled(true);
		        } else {
		        	JOptionPane.showMessageDialog(null, "Tournament is already open!");
		        }
		    }
		});
		
		panelT3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTourna3Status.setForeground(new Color(255, 255, 255));
				lblTourna3.setForeground(new Color(255, 255, 255));
				lblTourna3.setBackground(new Color(236, 73, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblTourna3Status.setForeground(new Color(0, 0, 0));
				lblTourna3.setForeground(new Color(0, 0, 0));
				lblTourna3.setBackground(new Color(228, 195, 197));
			}
			
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Tournament is not yet open!");
			}
			
		});
		
		panelJoinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblJoin.setForeground(new Color(0, 0, 0));
				lblJoin.setBackground(new Color(228, 195, 197));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblJoin.setForeground(new Color(255, 255, 255));
				lblJoin.setBackground(new Color(236, 73, 84));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tournaIsSelected) {
					if (textTeam.getText().isEmpty() || textMember1.getText().isEmpty() || textMember2.getText().isEmpty() 
							|| textMember3.getText().isEmpty() || textMember4.getText().isEmpty() || textMember5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please input all credentials!");	
					} else {
						teams.add(lblUserName.getText().toString());
						excel.fileWriter(teams, fileDirectory + "VanguardTeams.txt");
						
						LinkedList <String> inputTeamCred = new LinkedList<>(); 
						inputTeamCred.add(textTeam.getText().toString());
						inputTeamCred.add(textMember1.getText().toString());
						inputTeamCred.add(textMember2.getText().toString());
						inputTeamCred.add(textMember3.getText().toString());
						inputTeamCred.add(textMember4.getText().toString());
						inputTeamCred.add(textMember5.getText().toString());
					
						String filePath = ExcelHandler.checkUser(lblUserName.getText().toString());
						excel.writeAtSpecificColumn(filePath, 0, inputTeamCred);
						
		            	UserHome toUserHome;
						try {
							toUserHome = new UserHome();
							toUserHome.lblUser.setText(lblUserName.getText().toString());
			            	toUserHome.lblNewTeam.setText(textTeam.getText().toString());
			            	toUserHome.lblNewMember1.setText(textMember1.getText().toString());
			            	toUserHome.lblNewMember2.setText(textMember2.getText().toString());
			            	toUserHome.lblNewMember3.setText(textMember3.getText().toString());
			            	toUserHome.lblNewMember4.setText(textMember4.getText().toString());
			            	toUserHome.lblNewMember5.setText(textMember5.getText().toString());
			            	toUserHome.setVisible(true); 
			            	dispose();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		            	
					}
				} else if (lblTourna2Status.getText() == "FULL" || lblTourna2Status.getText() == "FINISHED") {
					JOptionPane.showMessageDialog(null, "There are no open tournaments right now.");
					SignIn toSignIn;
					try {
						toSignIn = new SignIn();
						toSignIn.setVisible(true);
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please select a tournament to join!");
				}
			}
		});

	}
}
