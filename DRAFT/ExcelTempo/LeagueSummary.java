import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;

public class LeagueSummary extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableScoreboardT1, tableScoreboardT2;
	JTable tableRoundStats;
	JLabel lblTeam1, lblTeam2;
	JLabel lblT1Score, lblT2Score;
	JScrollPane scrollPaneT1, scrollPaneT2;
	JTableHeader tableHeader;
	// Edit fileDirectory
	String fileDirectory = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/";
	
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
		lblAdminHPBanner.setIcon(new ImageIcon(fileDirectory + "LEAGUE SUMMARY.png"));
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
		panel.setLayout(null);
		
		lblT1Score = new JLabel("13", SwingConstants.CENTER);
		lblT1Score.setBounds(0, 10, 60, 50);
		lblT1Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		panel.add(lblT1Score);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(569, 158, 60, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblT2Score = new JLabel("13", SwingConstants.CENTER);
		lblT2Score.setBounds(0, 10, 60, 50);
		lblT2Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		panel_1.add(lblT2Score);
		
		lblTeam1 = new JLabel("TEAM 1 NAME", SwingConstants.CENTER);
		lblTeam1.setBounds(175, 158, 263, 77);
		lblTeam1.setForeground(new Color(189, 57, 68));
		lblTeam1.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		contentPane.add(lblTeam1);
		
		lblTeam2 = new JLabel("TEAM 2 NAME", SwingConstants.CENTER);
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
		
		tableRoundStats = new JTable();
		tableRoundStats.setFillsViewportHeight(true);
		tableRoundStats.setCellSelectionEnabled(true);
		tableRoundStats.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableRoundStats.setBackground(new Color(191, 151, 159));
		
		tableRoundStats.setModel(new DefaultTableModel(
			new String[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15"
			} 
			
		){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditablesRS = new boolean[] {
				false, false, false, false, false, false};
			public boolean isCellEditable(int row, int column) {
				return columnEditablesRS[column];
			}
		});

		tableRoundStats.setFont(new Font("Spiegel", Font.BOLD, 20));
		tableRoundStats.setBounds(25, 272, 981, 50);
		tableRoundStats.setRowHeight(50);
		contentPane.add(tableRoundStats);
		
		scrollPaneT1 = new JScrollPane();
		scrollPaneT1.setBounds(25, 361, 485, 192);
		contentPane.add(scrollPaneT1);
		
		tableScoreboardT1 = new JTable();
		tableScoreboardT1.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		tableScoreboardT1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneT1.setViewportView(tableScoreboardT1);
		tableScoreboardT1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {"PLAYER", "K", "D", "A", "P", "DF"}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables1 = new boolean[] {
				false, false, false, false, false, false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables1[column];
			}
		});
		tableScoreboardT1.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableScoreboardT1.getColumnModel().getColumn(1).setPreferredWidth(24);
		tableScoreboardT1.getColumnModel().getColumn(2).setPreferredWidth(24);
		tableScoreboardT1.getColumnModel().getColumn(3).setPreferredWidth(24);
		tableScoreboardT1.getColumnModel().getColumn(4).setPreferredWidth(24);
		tableScoreboardT1.getColumnModel().getColumn(5).setPreferredWidth(24);
		tableScoreboardT1.setRowHeight(33);
		tableScoreboardT1.setBackground(new Color(255,251,245));
		
		tableHeader = tableScoreboardT1.getTableHeader();
		tableHeader.setFont(new Font("Tungsten Bold", Font.PLAIN, 15));
	    tableHeader.setBackground(new Color(191, 151, 159));
	    tableHeader.setForeground(Color.black);
		
		scrollPaneT2 = new JScrollPane();
		scrollPaneT2.setBounds(521, 361, 485, 192);
		contentPane.add(scrollPaneT2);
		
		tableScoreboardT2 = new JTable();
		tableScoreboardT2.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		tableScoreboardT2.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPaneT2.setViewportView(tableScoreboardT2);
		tableScoreboardT2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {"PLAYER", "K", "D", "A", "P", "DF"}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables2 = new boolean[] {
				false, false, false, false, false, false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables2[column];
			}
		});
		tableScoreboardT2.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableScoreboardT2.getColumnModel().getColumn(1).setPreferredWidth(24);
		tableScoreboardT2.getColumnModel().getColumn(2).setPreferredWidth(24);
		tableScoreboardT2.getColumnModel().getColumn(3).setPreferredWidth(24);
		tableScoreboardT2.getColumnModel().getColumn(4).setPreferredWidth(24);
		tableScoreboardT2.getColumnModel().getColumn(5).setPreferredWidth(24);
		tableScoreboardT2.setRowHeight(33);
		tableScoreboardT2.setBackground(new Color(255,251,245));
	    
	    tableHeader = tableScoreboardT2.getTableHeader();
		tableHeader.setFont(new Font("Tungsten Bold", Font.PLAIN, 15));
	    tableHeader.setBackground(new Color(191, 151, 159));
	    tableHeader.setForeground(Color.black);
		
	}
}
