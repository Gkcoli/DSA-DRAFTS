			import java.awt.Color;
			import java.awt.EventQueue;
			
			import javax.swing.ImageIcon;
			import javax.swing.JFrame;
			import javax.swing.JLabel;
			import javax.swing.JPanel;
			import javax.swing.SwingConstants;
			import javax.swing.border.EmptyBorder;
			import java.awt.Font;
	import java.io.IOException;
	import java.util.LinkedList;
	
	import javax.swing.JTable;
			import javax.swing.border.LineBorder;
			import javax.swing.table.DefaultTableModel;
			import javax.swing.table.JTableHeader;
			import javax.swing.JScrollPane;
			
			public class LeagueSum extends JFrame {
			
				private static final long serialVersionUID = 1L;
				private JPanel contentPane;
				private JTable tableScoreboard;
				JLabel lblTeam1, lblTeam2;
				JLabel lblT1Score, lblT2Score;
				JPanel panelMO1, panelMO2, panelMO3, panelMO4, panelMO5, panelMO6, panelMO7, panelMO8, panelMO9, panelMO10, panelMO11, panelMO12, panelMO13, panelMO14, panelMO15;
				JLabel lblMO1S, lblMO2S, lblMO3S, lblMO4S, lblMO5S, lblMO6S, lblMO7S, lblMO8S, lblMO9S, lblMO10S, lblMO11S, lblMO12S, lblMO13S, lblMO14S, lblMO15S;
				JScrollPane scrollPane;
				JTableHeader tableHeader;
				Match match;
				
				
				// Edit fileDirectory
				 String fileDirectory = "C:/Users/Ryujin/Documents/Eclipse Java/Loops/TELEMASTERS/s/src/";
				 String summaryPath = fileDirectory + "LeagueSummary.xlsx";
	
				    public class Match {
				        private String team1Name;
				        private String team2Name;
				        private int team1Score;
				        private int team2Score;
				        private int[] matchOverviewScores;
				        private int[][] scoreboard;
				        
	
				        public Match(String team1Name, String team2Name, int[] matchOverviewScores, int[][] scoreboard) {
				            this.team1Name = team1Name;
				            this.team2Name = team2Name;
				            this.matchOverviewScores = matchOverviewScores;
				            this.scoreboard = scoreboard;
				        }
	
				        // Add getters and setters for the above attributes
	
				        // Method to update the match data
				        public void updateMatchData(String team1Name, String team2Name, int team1Score, int team2Score,
				                int[] matchOverviewScores, int[][] scoreboard) {
				            this.team1Name = team1Name;
				            this.team2Name = team2Name;
				            this.team1Score = team1Score;
				            this.team2Score = team2Score;
				            this.matchOverviewScores = matchOverviewScores;
				            this.scoreboard = scoreboard;
				        }
	
				       
				        }
				    
			
				/**
				 * Launch the application.
				 */
				public static void main(String[] args) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								LeagueSum frame = new LeagueSum();
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
				public LeagueSum() {
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
					
					panelMO1 = new JPanel();
					panelMO1.setBounds(25, 275, 60, 36);
					panelMO1.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO1.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO1);
					panelMO1.setLayout(null);
					
					lblMO1S = new JLabel("13", SwingConstants.CENTER);
					lblMO1S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO1S.setBounds(0, 8, 60, 26);
					panelMO1.add(lblMO1S);
					
					panelMO2 = new JPanel();
					panelMO2.setBounds(84, 275, 60, 36);
					panelMO2.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO2.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO2);
					panelMO2.setLayout(null);
					
					lblMO2S = new JLabel("13", SwingConstants.CENTER);
					lblMO2S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO2S.setBounds(0, 8, 60, 26);
					panelMO2.add(lblMO2S);
					
					panelMO3 = new JPanel();
					panelMO3.setBounds(142, 275, 60, 36);
					panelMO3.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO3.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO3);
					panelMO3.setLayout(null);
					
					lblMO3S = new JLabel("13", SwingConstants.CENTER);
					lblMO3S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO3S.setBounds(0, 8, 60, 26);
					panelMO3.add(lblMO3S);
					
					panelMO4 = new JPanel();
					panelMO4.setBounds(201, 275, 60, 36);
					panelMO4.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO4.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO4);
					panelMO4.setLayout(null);
					
					lblMO4S = new JLabel("13", SwingConstants.CENTER);
					lblMO4S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO4S.setBounds(0, 8, 60, 26);
					panelMO4.add(lblMO4S);
					
					panelMO5 = new JPanel();
					panelMO5.setBounds(260, 275, 60, 36);
					panelMO5.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO5.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO5);
					panelMO5.setLayout(null);
					
					lblMO5S = new JLabel("13", SwingConstants.CENTER);
					lblMO5S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO5S.setBounds(0, 8, 60, 26);
					panelMO5.add(lblMO5S);
					
					panelMO6 = new JPanel();
					panelMO6.setBounds(319, 275, 60, 36);
					panelMO6.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO6.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO6);
					panelMO6.setLayout(null);
					
					lblMO6S = new JLabel("13", SwingConstants.CENTER);
					lblMO6S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO6S.setBounds(0, 8, 60, 26);
					panelMO6.add(lblMO6S);
					
					panelMO7 = new JPanel();
					panelMO7.setBounds(378, 275, 60, 36);
					panelMO7.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO7.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO7);
					panelMO7.setLayout(null);
					
					lblMO7S = new JLabel("13", SwingConstants.CENTER);
					lblMO7S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO7S.setBounds(0, 8, 60, 26);
					panelMO7.add(lblMO7S);
					
					panelMO8 = new JPanel();
					panelMO8.setBounds(437, 275, 60, 36);
					panelMO8.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO8.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO8);
					panelMO8.setLayout(null);
					
					lblMO8S = new JLabel("13", SwingConstants.CENTER);
					lblMO8S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO8S.setBounds(0, 8, 60, 26);
					panelMO8.add(lblMO8S);
					
					panelMO9 = new JPanel();
					panelMO9.setBounds(495, 275, 60, 36);
					panelMO9.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO9.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO9);
					panelMO9.setLayout(null);
					
					lblMO9S = new JLabel("13", SwingConstants.CENTER);
					lblMO9S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO9S.setBounds(0, 8, 60, 26);
					panelMO9.add(lblMO9S);
					
					panelMO10 = new JPanel();
					panelMO10.setBounds(554, 275, 60, 36);
					panelMO10.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO10.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO10);
					panelMO10.setLayout(null);
					
					lblMO10S = new JLabel("13", SwingConstants.CENTER);
					lblMO10S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO10S.setBounds(0, 8, 60, 26);
					panelMO10.add(lblMO10S);
					
					panelMO11 = new JPanel();
					panelMO11.setBounds(613, 275, 60, 36);
					panelMO11.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO11.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO11);
					panelMO11.setLayout(null);
					
					lblMO11S = new JLabel("13", SwingConstants.CENTER);
					lblMO11S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO11S.setBounds(0, 8, 60, 26);
					panelMO11.add(lblMO11S);
					
					panelMO12 = new JPanel();
					panelMO12.setBounds(671, 275, 60, 36);
					panelMO12.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO12.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO12);
					panelMO12.setLayout(null);
					
					lblMO12S = new JLabel("13", SwingConstants.CENTER);
					lblMO12S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO12S.setBounds(0, 8, 60, 26);
					panelMO12.add(lblMO12S);
					
					panelMO13 = new JPanel();
					panelMO13.setBounds(726, 275, 60, 36);
					panelMO13.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO13.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO13);
					panelMO13.setLayout(null);
					
					lblMO13S = new JLabel("13", SwingConstants.CENTER);
					lblMO13S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO13S.setBounds(0, 8, 60, 26);
					panelMO13.add(lblMO13S);
					
					panelMO14 = new JPanel();
					panelMO14.setBounds(782, 275, 60, 36);
					panelMO14.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO14.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO14);
					panelMO14.setLayout(null);
					
					lblMO14S = new JLabel("13", SwingConstants.CENTER);
					lblMO14S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO14S.setBounds(0, 8, 60, 26);
					panelMO14.add(lblMO14S);
					
					panelMO15 = new JPanel();
					panelMO15.setBounds(837, 275, 60, 36);
					panelMO15.setBorder(new LineBorder(new Color(0, 0, 0)));
					panelMO15.setBackground(new Color(191, 151, 159));
					contentPane.add(panelMO15);
					panelMO15.setLayout(null);
					
					lblMO15S = new JLabel("13", SwingConstants.CENTER);
					lblMO15S.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
					lblMO15S.setBounds(0, 8, 60, 26);
					panelMO15.add(lblMO15S);
					
					scrollPane = new JScrollPane();
					scrollPane.setBounds(25, 361, 975, 192);
					contentPane.add(scrollPane);
					
					tableScoreboard = new JTable();
					tableScoreboard.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
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
					) {
						/**
						 * 
						 */
						private static final long serialVersionUID = 1L;
						boolean[] columnEditables = new boolean[] {
							false, false, false, false, false, false, false, false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
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
					
					tableHeader = tableScoreboard.getTableHeader();
					tableHeader.setFont(new Font("Tungsten Bold", Font.PLAIN, 15));
				    tableHeader.setBackground(new Color(191, 151, 159));
				    tableHeader.setForeground(Color.black);
				    
				    updateMatchDataOnUI();
			    }
	
			    private void updateMatchDataOnUI() {
			        match = readPlayMatchData();
	
			        lblTeam1.setText(match.team1Name);
			        lblTeam2.setText(match.team2Name);
			        lblT1Score.setText(String.valueOf(match.team1Score));
			        lblT2Score.setText(String.valueOf(match.team2Score));
	
			        // Update match overview panels
			        updateMatchOverviewPanel(panelMO1, lblMO1S, match.matchOverviewScores[0]);
			        updateMatchOverviewPanel(panelMO2, lblMO2S, match.matchOverviewScores[1]);
			        // ... (similarly update other panels)
	
			        // Update scoreboard table
			        updateScoreboardTable(match.scoreboard);
			    }
	
			    private void updateMatchOverviewPanel(JPanel panel, JLabel label, int score) {
			        label.setText(String.valueOf(score));
			        // Customize the panel as needed
			    }
	
			    private void updateScoreboardTable(int[][] scoreboard) {
			        DefaultTableModel model = (DefaultTableModel) tableScoreboard.getModel();
			        model.setRowCount(0); // Clear existing rows
	
			        // Iterate through match scoreboard data and add rows to the table
			        for (int[] row : scoreboard) {
			            model.addRow(new Object[] { row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9], row[10], row[11] });
			        }
			    }
	
			    private Match readPlayMatchData() {
			        // Replace this with your code to read data from PlayMatch
			        String team1Name = "Team1.xlsx";
			        String team2Name = "Team2.xlsx";
			        int team1Score = 13;
			        int team2Score = 13;
	
			        int[] matchOverviewScores = { 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
	
			        int[][] scoreboard = {
			            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12},
			            // Add more rows as needed
			        };
	
			        return new Match(team1Name, team2Name, matchOverviewScores, scoreboard);
			    }
			}
