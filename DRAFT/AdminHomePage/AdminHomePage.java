import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminHomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage frame = new AdminHomePage();
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
	public AdminHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,251,245));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel adminHPTournament = new JLabel("EPISODE 1 // ACT 1 TOURNAMENTS", SwingConstants.CENTER);
		adminHPTournament.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		adminHPTournament.setForeground(new Color(189, 57, 68));
		adminHPTournament.setBounds(0, 125, 1066, 60);
		contentPane.add(adminHPTournament);
		
		JPanel panelTourna1 = new JPanel();
		panelTourna1.setBackground(new Color(228, 195, 197));
		panelTourna1.setBounds(386, 184, 308, 94);
		contentPane.add(panelTourna1);
		panelTourna1.setLayout(null);
		
		JLabel labelTourna1 = new JLabel("LEAGUE OF ACES", SwingConstants.CENTER);
		labelTourna1.setBounds(0, 10, 308, 60);
		labelTourna1.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		labelTourna1.setForeground(new Color(0, 0, 0));
		
		JLabel lblFull = new JLabel("FULL", SwingConstants.CENTER);
		lblFull.setBounds(0, 52, 308, 42);
		lblFull.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		lblFull.setForeground(new Color(0, 0, 0));
		lblFull.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFull.setForeground(new Color(255, 255, 255));
				labelTourna1.setForeground(new Color(255, 255, 255));
				panelTourna1.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				lblFull.setForeground(new Color(0, 0, 0));
				labelTourna1.setForeground(new Color(0, 0, 0));
				panelTourna1.setBackground(new Color(228, 195, 197));
			}
			
		});
		panelTourna1.add(lblFull);
		
		labelTourna1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelTourna1.setForeground(new Color(255, 255, 255));
				lblFull.setForeground(new Color(255, 255, 255));
				panelTourna1.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				labelTourna1.setForeground(new Color(0, 0, 0));
				lblFull.setForeground(new Color(0, 0, 0));
				panelTourna1.setBackground(new Color(228, 195, 197));
			}
			
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Tournament is being accessed by another admin.");
			}
			
		});
		panelTourna1.add(labelTourna1);
		
		JPanel panelTourna2 = new JPanel();
		panelTourna2.setBackground(new Color(228, 195, 197));
		panelTourna2.setBounds(386, 304, 308, 94);
		contentPane.add(panelTourna2);
		panelTourna2.setLayout(null);
		
		JLabel labelTourna2 = new JLabel("VICTORY VANGUARD", SwingConstants.CENTER);
		labelTourna2.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		labelTourna2.setBounds(0, 10, 308, 60);
		labelTourna2.setForeground(new Color(0, 0, 0));
		
		JLabel lblOnGoing = new JLabel("ONGOING", SwingConstants.CENTER);
		lblOnGoing.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		lblOnGoing.setBounds(0, 52, 308, 42);
		lblOnGoing.setForeground(new Color(0, 0, 0));
		lblOnGoing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOnGoing.setForeground(new Color(255, 255, 255));
				labelTourna2.setForeground(new Color(255, 255, 255));
				panelTourna2.setBackground(new Color(236, 73, 84));
				
			}
			
			public void mouseExited(MouseEvent e) {
				lblOnGoing.setForeground(new Color(0, 0, 0));
				labelTourna2.setForeground(new Color(0, 0, 0));
				panelTourna2.setBackground(new Color(228, 195, 197));
			}
		});
		panelTourna2.add(lblOnGoing);
		
		labelTourna2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelTourna2.setForeground(new Color(255, 255, 255));
				lblOnGoing.setForeground(new Color(255, 255, 255));
				panelTourna2.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				labelTourna2.setForeground(new Color(0, 0, 0));
				lblOnGoing.setForeground(new Color(0, 0, 0));
				panelTourna2.setBackground(new Color(228, 195, 197));
			}
			
			public void mouseClicked(MouseEvent e) {
				dispose();
				EditTourna toEditTourna = new EditTourna();
				toEditTourna.main(null);
			}
			
		});
		panelTourna2.add(labelTourna2);
		
		JPanel panelTourna3 = new JPanel();
		panelTourna3.setBackground(new Color(228, 195, 197));
		panelTourna3.setBounds(386, 425, 308, 94);
		contentPane.add(panelTourna3);
		panelTourna3.setLayout(null);
		
		JLabel labelTourna3= new JLabel("WORLD VALORANT", SwingConstants.CENTER);
		labelTourna3.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		labelTourna3.setBounds(0, 10, 308, 60);
		labelTourna3.setForeground(new Color(0, 0, 0));
		
		JLabel lblTBA = new JLabel("TBA", SwingConstants.CENTER);
		lblTBA.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		lblTBA.setBounds(0, 52, 308, 42);
		lblTBA.setForeground(new Color(0, 0, 0));
		lblTBA.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblTBA.setForeground(new Color(255, 255, 255));
				labelTourna3.setForeground(new Color(255, 255, 255));
				panelTourna3.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				lblTBA.setForeground(new Color(0, 0, 0));
				labelTourna3.setForeground(new Color(0, 0, 0));
				panelTourna3.setBackground(new Color(228, 195, 197));
			}
			
		});
		panelTourna3.add(lblTBA);
		
		labelTourna3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				labelTourna3.setForeground(new Color(255, 255, 255));
				lblTBA.setForeground(new Color(255, 255, 255));
				panelTourna3.setBackground(new Color(236, 73, 84));
			}
			
			public void mouseExited(MouseEvent e) {
				labelTourna3.setForeground(new Color(0, 0, 0));
				lblTBA.setForeground(new Color(0, 0, 0));
				panelTourna3.setBackground(new Color(228, 195, 197));
			}
			
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Tournament is not yet available for admin access.");
			}
			
		});
		panelTourna3.add(labelTourna3);
		
		JLabel lblAdminHPBanner = new JLabel("");
		lblAdminHPBanner.setBounds(0, 0, 1066, 115);
		lblAdminHPBanner.setIcon(new ImageIcon("C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/adminHP.png"));
		contentPane.add(lblAdminHPBanner);
	}
}
