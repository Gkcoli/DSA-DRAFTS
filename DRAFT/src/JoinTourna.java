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
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinTourna extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		
		JLabel lblNewLabel_7 = new JLabel("4/5 TEAMS");
		lblNewLabel_7.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(215, 411, 64, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("FULL");
		lblNewLabel_6.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(226, 306, 22, 21);
		contentPane.add(lblNewLabel_6);
		
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
		lblNewLabel_2.setBounds(108, 195, 286, 52);
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
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setBackground(new Color(217, 217, 217));
		textField.setBounds(688, 133, 211, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(null);
		textField_1.setBackground(new Color(217, 217, 217));
		textField_1.setBounds(688, 182, 211, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBorder(null);
		textField_2.setBackground(new Color(217, 217, 217));
		textField_2.setBounds(688, 276, 211, 28);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBorder(null);
		textField_3.setBackground(new Color(217, 217, 217));
		textField_3.setBounds(688, 314, 211, 28);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBorder(null);
		textField_4.setBackground(new Color(217, 217, 217));
		textField_4.setBounds(688, 352, 211, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBorder(null);
		textField_5.setBackground(new Color(217, 217, 217));
		textField_5.setBounds(688, 390, 211, 28);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBorder(null);
		textField_6.setBackground(new Color(217, 217, 217));
		textField_6.setBounds(688, 428, 211, 28);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("JOIN");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(189, 57, 68));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tungsten Bold", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(743, 492, 106, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("[TOURNAMENT 1]");
		btnNewButton_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 34));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(255, 212, 212));
		btnNewButton_1.setBounds(118, 257, 252, 78);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("VICTORY VANGUARD");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(255, 212, 212));
		btnNewButton_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 34));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(118, 360, 252, 78);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("[TOURNAMENT 3]");
		btnNewButton_3.setBackground(new Color(255, 212, 212));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 34));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_8 = new JLabel("FULL");
		lblNewLabel_8.setFont(new Font("Tungsten Bold", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(226, 508, 22, 21);
		contentPane.add(lblNewLabel_8);
		btnNewButton_3.setBounds(118, 460, 252, 78);
		contentPane.add(btnNewButton_3);
	}
}
