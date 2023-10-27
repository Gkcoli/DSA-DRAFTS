package telemasters;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
	private JTextField textCoach;
	private JTextField textMember1;
	private JTextField textMember2;
	private JTextField textMember3;
	private JTextField textMember4;
	private JTextField textMember5;
	boolean panel1Clicked = false;

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
		lblNewLabel_3.setBounds(563, 133, 106, 39);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("COACH:");
		lblNewLabel_4.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(605, 182, 64, 39);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TEAM MEMBERS:");
		lblNewLabel_5.setFont(new Font("Tungsten Bold", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(605, 233, 127, 39);
		contentPane.add(lblNewLabel_5);
		
		textTeam = new JTextField();
		textTeam.setBorder(null);
		textTeam.setBackground(new Color(217, 217, 217));
		textTeam.setBounds(688, 133, 211, 28);
		contentPane.add(textTeam);
		textTeam.setColumns(10); 
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
		
		
		textCoach = new JTextField();
		textCoach.setBorder(null);
		textCoach.setBackground(new Color(217, 217, 217));
		textCoach.setBounds(688, 182, 211, 28);
		contentPane.add(textCoach);
		textCoach.setColumns(10);
		textCoach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textCoach.setBackground(new Color(174, 174, 174));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textCoach.setBackground(new Color(217, 217, 217));
			}
		});
		
		textMember1 = new JTextField();
		textMember1.setBorder(null);
		textMember1.setBackground(new Color(217, 217, 217));
		textMember1.setBounds(688, 276, 211, 28);
		contentPane.add(textMember1);
		textMember1.setColumns(10);
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
		
		JPanel panel = 	new JPanel();
		panel.setBackground(new Color(255, 212, 212));
		panel.setBounds(118, 257, 252, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("FULL");
		lblNewLabel_9.setBounds(112, 47, 53, 21);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		
		JLabel lblNewLabel_6 = new JLabel("[TOURNAMENT 1]");
		lblNewLabel_6.setBounds(38, 10, 176, 43);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tungsten Bold", Font.PLAIN, 34));
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_9.setForeground(new Color(255, 255, 255));
				lblNewLabel_6.setForeground(new Color(255, 255, 255));
				lblNewLabel_6.setBackground(new Color(236, 73, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_9.setForeground(new Color(0, 0, 0));
				lblNewLabel_6.setForeground(new Color(0, 0, 0));
				lblNewLabel_6.setBackground(new Color(228, 195, 197));
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 212, 212));
		panel_1.setBounds(118, 352, 252, 78);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("4/5 TEAMS");
		lblNewLabel_7.setBounds(94, 47, 64, 21);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		
		JLabel lblNewLabel_10 = new JLabel("VICTORY VANGUARD");
		lblNewLabel_10.setBounds(10, 10, 232, 43);
		panel_1.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tungsten Bold", Font.PLAIN, 38));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 212, 212));
		panel_2.setBounds(118, 449, 252, 78);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("FULL");
		lblNewLabel_8.setBounds(116, 47, 22, 21);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		
		JLabel lblNewLabel_11 = new JLabel("[TOURNAMENT 3]");
		lblNewLabel_11.setBounds(38, 10, 170, 43);
		panel_2.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tungsten Bold", Font.PLAIN, 34));
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setBackground(new Color(189, 57, 68));
		panel_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 24));
		panel_3.setBounds(740, 480, 106, 52);
		contentPane.add(panel_3)
		;
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("JOIN");
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setFont(new Font("Tungsten Bold", Font.PLAIN, 24));
		lblNewLabel_12.setBounds(32, 10, 50, 32);
		panel_3.add(lblNewLabel_12);
		
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_8.setForeground(new Color(255, 255, 255));
				lblNewLabel_11.setForeground(new Color(255, 255, 255));
				lblNewLabel_11.setBackground(new Color(236, 73, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_8.setForeground(new Color(0, 0, 0));
				lblNewLabel_11.setForeground(new Color(0, 0, 0));
				lblNewLabel_11.setBackground(new Color(228, 195, 197));
			}
			
		});
		
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_7.setForeground(new Color(255, 255, 255));
				lblNewLabel_10.setForeground(new Color(255, 255, 255));
				lblNewLabel_10.setBackground(new Color(236, 73, 84));
			}
			@Override
			public void mouseExited(MouseEvent e) {
		 		lblNewLabel_7.setForeground(new Color(0, 0, 0));
				lblNewLabel_10.setForeground(new Color(0, 0, 0));
				lblNewLabel_10.setBackground(new Color(228, 195, 197));
			}
			public void mouseClicked(MouseEvent e) {
		        panel1Clicked = true;
		    }
		});
		
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_12.setForeground(new Color(0, 0, 0));
				lblNewLabel_12.setBackground(new Color(228, 195, 197));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_12.setForeground(new Color(255, 255, 255));
				lblNewLabel_12.setBackground(new Color(236, 73, 84));
			}
			@Override
		    public void mousePressed(MouseEvent e) {
		        if (!panel1Clicked) {
		            e.consume(); // Ignore mouse if panel 1 is not clicked
		        }
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panel1Clicked) {
		            dispose();
		            AdminHomePage toEditTourna = new AdminHomePage();
		            toEditTourna.setVisible(true);
				}	
			}
		});

	}
}
