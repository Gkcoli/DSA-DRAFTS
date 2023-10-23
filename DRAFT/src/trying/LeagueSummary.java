import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;

public class LeagueSummary extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable tableScoreboard;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeagueSummary frame = new LeagueSummary();
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
	public LeagueSummary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(255,251,245));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminHPBanner = new JLabel("");
		lblAdminHPBanner.setBounds(0, 0, 1066, 115);
		lblAdminHPBanner.setIcon(new ImageIcon("C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/LEAGUE SUMMARY.png"));
		contentPane.add(lblAdminHPBanner);
		
		JLabel lblFinalScore = new JLabel("FINAL SCORE", SwingConstants.CENTER);
		lblFinalScore.setBounds(0, 125, 1066, 36);
		lblFinalScore.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblFinalScore.setForeground(new Color(189, 57, 68));
		contentPane.add(lblFinalScore);
		
		JLabel lblDash = new JLabel("-", SwingConstants.CENTER);
		lblDash.setBounds(495, 171, 75, 36);
		lblDash.setForeground(new Color(189, 57, 68));
		lblDash.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		contentPane.add(lblDash);
		
		JPanel panel = new JPanel();
		panel.setBounds(438, 158, 60, 60);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(569, 158, 60, 60);
		contentPane.add(panel_1);
		
		JLabel lblTeam1 = new JLabel("TEAM 1 NAME", SwingConstants.CENTER);
		lblTeam1.setBounds(175, 158, 263, 77);
		lblTeam1.setForeground(new Color(189, 57, 68));
		lblTeam1.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		contentPane.add(lblTeam1);
		
		JLabel lblTeam2 = new JLabel("TEAM 2 NAME", SwingConstants.CENTER);
		lblTeam2.setBounds(629, 158, 263, 77);
		lblTeam2.setForeground(new Color(189, 57, 68));
		lblTeam2.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		contentPane.add(lblTeam2);
		
		JLabel lblMatchOverview = new JLabel("MATCH OVERVIEW", SwingConstants.LEFT);
		lblMatchOverview.setBounds(25, 243, 202, 36);
		lblMatchOverview.setForeground(new Color(189, 57, 68));
		lblMatchOverview.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		contentPane.add(lblMatchOverview);
		
		JLabel lblMatchScoreboard = new JLabel("MATCH SCOREBOARD", SwingConstants.LEFT);
		lblMatchScoreboard.setBounds(25, 329, 202, 36);
		lblMatchScoreboard.setForeground(new Color(189, 57, 68));
		lblMatchScoreboard.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		contentPane.add(lblMatchScoreboard);
		
		JPanel panelMO1 = new JPanel();
		panelMO1.setBounds(25, 275, 60, 36);
		panelMO1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO1.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO1);
		
		JPanel panelMO2 = new JPanel();
		panelMO2.setBounds(84, 275, 60, 36);
		panelMO2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO2.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO2);
		
		JPanel panelMO3 = new JPanel();
		panelMO3.setBounds(142, 275, 60, 36);
		panelMO3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO3.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO3);
		
		JPanel panelMO4 = new JPanel();
		panelMO4.setBounds(201, 275, 60, 36);
		panelMO4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO4.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO4);
		
		JPanel panelMO5 = new JPanel();
		panelMO5.setBounds(260, 275, 60, 36);
		panelMO5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO5.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO5);
		
		JPanel panelMO6 = new JPanel();
		panelMO6.setBounds(319, 275, 60, 36);
		panelMO6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO6.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO6);
		
		JPanel panelMO7 = new JPanel();
		panelMO7.setBounds(378, 275, 60, 36);
		panelMO7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO7.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO7);
		
		JPanel panelMO8 = new JPanel();
		panelMO8.setBounds(437, 275, 60, 36);
		panelMO8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO8.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO8);
		
		JPanel panelMO9 = new JPanel();
		panelMO9.setBounds(495, 275, 60, 36);
		panelMO9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO9.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO9);
		
		JPanel panelMO10 = new JPanel();
		panelMO10.setBounds(554, 275, 60, 36);
		panelMO10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO10.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO10);
		
		JPanel panelMO11 = new JPanel();
		panelMO11.setBounds(613, 275, 60, 36);
		panelMO11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO11.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO11);
		
		JPanel panelMO12 = new JPanel();
		panelMO12.setBounds(671, 275, 60, 36);
		panelMO12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO12.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO12);
		
		JPanel panelMO13 = new JPanel();
		panelMO13.setBounds(726, 275, 60, 36);
		panelMO13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO13.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO13);
		
		JPanel panelMO14 = new JPanel();
		panelMO14.setBounds(782, 275, 60, 36);
		panelMO14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO14.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO14);
		
		JPanel panelMO15 = new JPanel();
		panelMO15.setBounds(837, 275, 60, 36);
		panelMO15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelMO15.setBackground(new Color(191, 151, 159));
		contentPane.add(panelMO15);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 361, 975, 192);
		contentPane.add(scrollPane);
		
		tableScoreboard = new JTable();
		tableScoreboard.setFont(new Font("Tungsten Bold", Font.PLAIN, 10));
		tableScoreboard.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(tableScoreboard);
		tableScoreboard.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"PLAYER", "K", "D", "A", "P", "DF", "PLAYER", "K", "D", "A", "P", "DF"
			}
		));
		tableScoreboard.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableScoreboard.getColumnModel().getColumn(1).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(2).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(3).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(4).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(5).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(6).setPreferredWidth(150);
		tableScoreboard.getColumnModel().getColumn(7).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(8).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(9).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(10).setPreferredWidth(24);
		tableScoreboard.getColumnModel().getColumn(11).setPreferredWidth(24);
		tableScoreboard.setRowHeight(33);
		tableScoreboard.setBackground(new Color(255,251,245));
		
		JTableHeader tableHeader = tableScoreboard.getTableHeader();
	    tableHeader.setBackground(new Color(191, 151, 159));
	    tableHeader.setForeground(Color.black);
		
	}
}
