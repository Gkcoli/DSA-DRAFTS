import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JoinTourna extends JFrame {

	private JPanel contentPane;
	private JTextField textTeam;
	private JTextField textMember1;
	private JTextField textMember2;
	private JTextField textMember3;
	private JTextField textMember4;
	private JTextField textMember5;
	boolean tournaIsSelected = false;
	boolean tourna2IsFull = false;

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
	
	public void updateText(UserData userData) {
		textTeam.setText(userData.getTeamName());
		textMember1.setText(userData.getTeamMembers()[0]);
		textMember2.setText(userData.getTeamMembers()[1]);
		textMember3.setText(userData.getTeamMembers()[2]);
		textMember4.setText(userData.getTeamMembers()[3]);
		textMember5.setText(userData.getTeamMembers()[4]);
	}

	/**
	 * Create the frame.
	 */
	public JoinTourna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 630);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 251, 245));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\carlo\\Downloads\\JOIN TOURNA.png"));
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
		
		JPanel panelT2 = new JPanel();
		panelT2.setBackground(new Color(255, 212, 212));
		panelT2.setBounds(118, 352, 252, 78);
		contentPane.add(panelT2);
		panelT2.setLayout(null);
		
		JLabel lblTourna2Status = new JLabel("3/4 TEAMS", SwingConstants.CENTER);
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
		        if (tourna2IsFull == false) {
		        	tournaIsSelected = true;
		        	textTeam.setEnabled(true);
		        	textMember1.setEnabled(true);
		        	textMember2.setEnabled(true);
		        	textMember3.setEnabled(true);
		        	textMember4.setEnabled(true);
		        	textMember5.setEnabled(true);
		        } else {
		        	JOptionPane.showMessageDialog(null, "Tournament is full");
		        }
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
		    public void mousePressed(MouseEvent e) {
		        if (!tournaIsSelected) {
		            e.consume(); // Ignore mouse if panel 1 is not clicked
		        }
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tournaIsSelected) {
		            dispose();
		            UserHome toUserHome = new UserHome();
		            toUserHome.setVisible(true);
				}	
			}
		});

	}
}
