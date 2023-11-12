import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class Match {
	// Edit fileDirectory
	String fileDirectory = "C:/Users/jessy/.vscode/TeleMasters Studio/";

	JFrame matchSchedFrame, playMatchFrame, leagueSummaryFrame;
	private static JTable table;
	private JScrollPane scrollPane, scrollPaneT1, scrollPaneT2;
	private JPanel panel;
	private JTable tableRoundStats, tableTeam1, tableTeam2, tableScoreboardT1, tableScoreboardT2;
	private LinkedList<String> roundStats;
	private int scoreT1, scoreT2;
	private int i = 1;

	private String gameNum, status1, status2, status3, status4, game1W, game2W, game3W, game4W, game1L, game2L, game3L, game4L;

	private	String team1 = (ExcelHandler.readSpecificCell(fileDirectory + "Team1.xlsx", 0, 0)).toUpperCase();
	private String team2 = (ExcelHandler.readSpecificCell(fileDirectory + "Team2.xlsx", 0, 0)).toUpperCase();
	private String team3 = (ExcelHandler.readSpecificCell(fileDirectory + "Team3.xlsx", 0, 0)).toUpperCase();
	private String team4 = (ExcelHandler.readSpecificCell(fileDirectory + "Team4.xlsx", 0, 0)).toUpperCase();

	String t1, t2;

	String team1FilePath, team2FilePath;
	String matchFilePath = fileDirectory + "MatchSched.xlsx";

	LinkedList <String> playersT1, playersT2;

	Stats stats = new Stats();
	ExcelHandler statsExcel = new ExcelHandler();
	UserData userData;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Match window = new Match();
					window.matchSchedFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Match() throws Exception {
		matchSched();
	}

	private void matchSched() throws Exception {
		matchSchedFrame = new JFrame();
		matchSchedFrame.getContentPane().setBackground(new Color(255, 251, 245));
		matchSchedFrame.getContentPane().setForeground(new Color(255, 251, 245));
		matchSchedFrame.setBounds(100, 100, 1080, 661);
		matchSchedFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		matchSchedFrame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 251, 245));
		panel.setBounds(10, 127, 1033, 414);
		matchSchedFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1013, 394);
		panel.add(scrollPane);
	
		status1 = ExcelHandler.readSpecificCell(matchFilePath, 0, 2);
		status2 = ExcelHandler.readSpecificCell(matchFilePath, 1, 2);
		status3 = ExcelHandler.readSpecificCell(matchFilePath, 2, 2);
		status4 = ExcelHandler.readSpecificCell(matchFilePath, 3, 2);
		game1W = ExcelHandler.readSpecificCell(matchFilePath, 0, 3);
		game2W = ExcelHandler.readSpecificCell(matchFilePath, 1, 3);
		game3W = ExcelHandler.readSpecificCell(matchFilePath, 2, 3);
		game4W = ExcelHandler.readSpecificCell(matchFilePath, 3, 3);
		game1L = ExcelHandler.readSpecificCell(matchFilePath, 0, 4);
		game2L = ExcelHandler.readSpecificCell(matchFilePath, 1, 4);

		scoreT1 = 0;
		scoreT2 = 0;
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		table.setBorder(new LineBorder(new Color(83, 33, 43)));
		table.setBackground(new Color(255, 251, 245));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new String[][] {
				{"1", team1 + " VS. " + team2, "NOV. 7, 2023, 16:00 - 18:00", status1, game1W},
				{"2", team3 + " VS. " + team4, "NOV. 11, 2023, 13:00 - 15:00", status2, game2W},
				{"3", game1L + " VS. " + game2L, "NOV. 14, 2023, 15:00 - 17:00", status3, game3W},
				{"4", game1W + " VS. " + game2W, "NOV. 17, 2023, 14:00 - 16:00", status4, game4W},
			},
			new String[] {
				"GAME", "TEAMS", "DATE AND TIME", "STATUS", "WINNING TEAM"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.setRowHeight(90);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(255, 251, 245));
		tableHeader.setForeground(new Color(189, 57, 68));
		tableHeader.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setVerticalAlignment(SwingConstants.TOP);
		lblBanner.setIcon(new ImageIcon("C:/Users/jessy/.vscode/TeleMasters Studio/MATCH SCHED.png"));
		lblBanner.setBounds(0, 0, 1066, 176);
		matchSchedFrame.getContentPane().add(lblBanner);
		
		JButton btnPlay = new JButton("PLAY MATCH");
		btnPlay.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnPlay.setBackground(new Color(189, 57, 68));
		btnPlay.setForeground(new Color(255, 255, 255));

		if(stats.getSched().isEmpty()) {
			stats.setSched();
		}

		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				if (status1.equals("WAITING FOR TEAMS") && table.getSelectedRow() == 0) { // If game 1 has not yet started
					JOptionPane.showMessageDialog(playMatchFrame, "Redirecting to Play Match");
			 		matchSchedFrame.dispose();
			 		playMatch();
					stats.removeFirst();
				} else if (status1.equals("WAITING FOR TEAMS") && table.getSelectedRow() == 1) { // If game 1 has not yet started and game 2 is selected
					JOptionPane.showMessageDialog(playMatchFrame, "Previous game has not yet started");
				} else if (status1.equals("FINISHED") && (status2.equals("WAITING FOR TEAMS") && table.getSelectedRow() == 1)) { // If game 1 has finished and game 2 is selected
					JOptionPane.showMessageDialog(playMatchFrame, "Redirecting to Play Match");
			 		matchSchedFrame.dispose();
			 		playMatch();
					stats.removeFirst();
				} else if (status2.equals("WAITING FOR TEAMS") && table.getSelectedRow() == 0) { // If game 2 has not yet started and game 3 is selected
					JOptionPane.showMessageDialog(playMatchFrame, "Previous game has not yet started");
				} else if (status2.equals("FINISHED") && (status3.equals("WAITING FOR TEAMS") && table.getSelectedRow() == 2)) { // If game 2 has finished and game 3 is selected
					JOptionPane.showMessageDialog(playMatchFrame, "Redirecting to Play Match");
			 		matchSchedFrame.dispose();
			 		playMatch();
					stats.removeFirst();
				} else if (status3.equals("WAITING FOR TEAMS") && table.getSelectedRow() == 1) { // If game 3 has not yet started and game 4 is selected
					JOptionPane.showMessageDialog(playMatchFrame, "Previous game has not yet started");
				} else if (status3.equals("FINISHED") && (status4.equals("WAITING FOR TEAMS") && table.getSelectedRow() == 3)) { // if game 3 has finished and game 4 is selected
					JOptionPane.showMessageDialog(playMatchFrame, "Redirecting to Play Match");
			 		matchSchedFrame.dispose();
			 		playMatch();
					stats.removeFirst();
				} else {
					JOptionPane.showMessageDialog(playMatchFrame, "Game has already finished");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			} }
		});
		btnPlay.setBounds(455, 558, 118, 45);
		matchSchedFrame.getContentPane().add(btnPlay);	
	}
	
	private void playMatch() throws Exception {
		playMatchFrame = new JFrame();
		playMatchFrame.getContentPane().setBackground(new Color(255, 251, 245));
		playMatchFrame.getContentPane().setLayout(null);
		playMatchFrame.setBounds(100, 100, 1080, 829);
		playMatchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playMatchFrame.setVisible(true);
						
		JLabel lblLogo = new JLabel("");
		lblLogo.setVerticalAlignment(SwingConstants.TOP);
		lblLogo.setIcon(new ImageIcon("C:/Users/jessy/.vscode/TeleMasters Studio/PLAY MATCH.png"));
		lblLogo.setBounds(0, 0, 1066, 123);
		playMatchFrame.getContentPane().add(lblLogo);
						
		JLabel lblMatch = new JLabel("MATCH:");
		lblMatch.setForeground(new Color(189, 57, 68));
		lblMatch.setVerticalAlignment(SwingConstants.TOP);
		lblMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblMatch.setBounds(35, 133, 80, 33);
		playMatchFrame.getContentPane().add(lblMatch);

		switch (table.getSelectedRow()) {
			case 0:
				gameNum = "GAME 1";
				t1 = team1;
				t2 = team2;
			break;
			case 1:
				gameNum = "GAME 2";
				t1 = team3;
				t2 = team4;
			break;
			case 2:
				gameNum = "GAME 3";
				t1 = game1L;
				t2 = game2L;
			break;
			case 3:
				gameNum = "GAME 4";
				t1 = game1W;
				t2 = game2W;
			break;
		}

		JLabel lblGameNum = new JLabel(gameNum);
		lblGameNum.setVerticalAlignment(SwingConstants.TOP);
		lblGameNum.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblGameNum.setBounds(125, 133, 185, 33);
		playMatchFrame.getContentPane().add(lblGameNum);
						
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setVerticalAlignment(SwingConstants.TOP);
		lblScore.setForeground(new Color(189, 57, 68));
		lblScore.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblScore.setBounds(483, 159, 80, 33);
		playMatchFrame.getContentPane().add(lblScore);
						
		JLabel lblTeam1Score = new JLabel("0");
		lblTeam1Score.setBackground(new Color(192, 192, 192));
		lblTeam1Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam1Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 60));
		lblTeam1Score.setBounds(432, 201, 50, 75);
		playMatchFrame.getContentPane().add(lblTeam1Score);
						
		JLabel lblTeam2Score = new JLabel("0");
		lblTeam2Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam2Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 60));
		lblTeam2Score.setBackground(Color.LIGHT_GRAY);
		lblTeam2Score.setBounds(562, 201, 50, 75);
		playMatchFrame.getContentPane().add(lblTeam2Score);
						
		JLabel lblDash = new JLabel("-");
		lblDash.setVerticalAlignment(SwingConstants.TOP);
		lblDash.setHorizontalAlignment(SwingConstants.CENTER);
		lblDash.setForeground(new Color(189, 57, 68));
		lblDash.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblDash.setBounds(483, 211, 80, 33);
		playMatchFrame.getContentPane().add(lblDash);

		JLabel lblTeam1 = new JLabel(t1);
		lblTeam1.setVerticalAlignment(SwingConstants.TOP);
		lblTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam1.setForeground(new Color(189, 57, 68));
		lblTeam1.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTeam1.setBounds(258, 222, 163, 33);
		playMatchFrame.getContentPane().add(lblTeam1);
						
		JLabel lblTeam2 = new JLabel(t2);
		lblTeam2.setVerticalAlignment(SwingConstants.TOP);
		lblTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam2.setForeground(new Color(189, 57, 68));
		lblTeam2.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTeam2.setBounds(622, 222, 163, 33);
		playMatchFrame.getContentPane().add(lblTeam2);
						
		JButton btnT1Plus = new JButton("+");
		btnT1Plus.setVerticalAlignment(SwingConstants.TOP);
		btnT1Plus.setForeground(new Color(189, 57, 68));
		btnT1Plus.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		btnT1Plus.setBounds(432, 263, 50, 33);
		btnT1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreT1 += i;	
				lblTeam1Score.setText(String.valueOf(scoreT1));
			}
		});
		playMatchFrame.getContentPane().add(btnT1Plus);
						
		JButton btnT2Plus = new JButton("+");
		btnT2Plus.setVerticalAlignment(SwingConstants.TOP);
		btnT2Plus.setForeground(new Color(189, 57, 68));
		btnT2Plus.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		btnT2Plus.setBounds(562, 263, 50, 33);
		btnT2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scoreT2 += i;	
				lblTeam2Score.setText(String.valueOf(scoreT2));
			}
		});
		playMatchFrame.getContentPane().add(btnT2Plus);
						
		JLabel lblRoundStats = new JLabel("ROUND STATISTICS");
		lblRoundStats.setVerticalAlignment(SwingConstants.TOP);
		lblRoundStats.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoundStats.setForeground(new Color(189, 57, 68));
		lblRoundStats.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblRoundStats.setBounds(35, 309, 368, 33);
		playMatchFrame.getContentPane().add(lblRoundStats);
						
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
		));

		roundStats = new LinkedList<>();
		tableRoundStats.getModel().addTableModelListener(new TableModelListener() {
			@Override
			public void tableChanged(TableModelEvent e) {
				int row = e.getFirstRow();
				int col = e.getColumn();
				TableModel roundModel = (TableModel)e.getSource();
				Object data = roundModel.getValueAt(row, col);
				stats.addToRoundStats(roundStats, data.toString());
			}
		});
		tableRoundStats.setFont(new Font("Spiegel", Font.BOLD, 20));
		tableRoundStats.setBounds(35, 350, 981, 50);
		tableRoundStats.setRowHeight(50);
		playMatchFrame.getContentPane().add(tableRoundStats);
		
		JLabel lblPlayerStats = new JLabel("PLAYER STATISTICS");
		lblPlayerStats.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerStats.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerStats.setForeground(new Color(189, 57, 68));
		lblPlayerStats.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblPlayerStats.setBounds(35, 420, 368, 33);
		playMatchFrame.getContentPane().add(lblPlayerStats);
		
		JScrollPane scrollPaneT1 = new JScrollPane();
		scrollPaneT1.setBounds(35, 463, 493, 259);
		playMatchFrame.getContentPane().add(scrollPaneT1);
		
		tableTeam1 = new JTable();
		tableTeam1.setFont(new Font("Spiegel", Font.PLAIN, 15));
		tableTeam1.setCellSelectionEnabled(true);
		tableTeam1.setFillsViewportHeight(true);
		scrollPaneT1.setViewportView(tableTeam1);
		tableTeam1.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableTeam1.setBackground(new Color(255, 251, 245));
		tableTeam1.setRowHeight(46);
		tableTeam1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"PLAYER", "K", "D", "A", "P", "DF"
			}
		));
		tableTeam1.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableTeam1.getColumnModel().getColumn(1).setPreferredWidth(30);
		tableTeam1.getColumnModel().getColumn(2).setPreferredWidth(30);
		tableTeam1.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableTeam1.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableTeam1.getColumnModel().getColumn(5).setPreferredWidth(30);

		JTableHeader tableHeaderT1 = tableTeam1.getTableHeader();
		tableHeaderT1.setBackground(new Color(191, 151, 159));
		tableHeaderT1.setForeground(Color.BLACK);
		tableHeaderT1.setFont(new Font("Tungsten Bold", Font.PLAIN, 15));
		
		JScrollPane scrollPaneT2 = new JScrollPane();
		scrollPaneT2.setBounds(538, 463, 491, 259);
		playMatchFrame.getContentPane().add(scrollPaneT2);
		
		tableTeam2 = new JTable();
		scrollPaneT2.setViewportView(tableTeam2);
		tableTeam2.setFont(new Font("Spiegel", Font.PLAIN, 15));
		tableTeam2.setCellSelectionEnabled(true);
		tableTeam2.setFillsViewportHeight(true);
		tableTeam2.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableTeam2.setBackground(new Color(255, 251, 245));
		tableTeam2.setRowHeight(46);
		tableTeam2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"PLAYER", "K", "D", "A", "P", "DF"
			}
		));
		tableTeam2.getColumnModel().getColumn(0).setPreferredWidth(150);
		tableTeam2.getColumnModel().getColumn(1).setPreferredWidth(30);
		tableTeam2.getColumnModel().getColumn(2).setPreferredWidth(30);
		tableTeam2.getColumnModel().getColumn(3).setPreferredWidth(30);
		tableTeam2.getColumnModel().getColumn(4).setPreferredWidth(30);
		tableTeam2.getColumnModel().getColumn(5).setPreferredWidth(30);

		JTableHeader tableHeaderT2 = tableTeam2.getTableHeader();
		tableHeaderT2.setBackground(new Color(191, 151, 159));
		tableHeaderT2.setForeground(Color.BLACK);
		tableHeaderT2.setFont(new Font("Tungsten Bold", Font.PLAIN, 15));

		playersT1 = new LinkedList<>();
		playersT2 = new LinkedList<>();

		switch (gameNum) {
			case "GAME 1":
				team1FilePath = fileDirectory + "Team1.xlsx";
				team2FilePath = fileDirectory + "Team2.xlsx";
			break;
			case "GAME 2":
				team1FilePath = fileDirectory + "Team3.xlsx";
				team2FilePath = fileDirectory + "Team4.xlsx";
			break;
			case "GAME 3":
				if (game1L.equals(team1)) {
					if (game2L.equals(team3)) {
						team1FilePath = fileDirectory + "Team1.xlsx";
						team2FilePath = fileDirectory + "Team3.xlsx";
					} else {
						team1FilePath = fileDirectory + "Team1.xlsx";
						team2FilePath = fileDirectory + "Team4.xlsx";
					} }
				else { 
					if (game2L.equals(team4)) {
						team1FilePath = fileDirectory + "Team2.xlsx";
						team2FilePath = fileDirectory + "Team4.xlsx";
					} else {
						team1FilePath = fileDirectory + "Team2.xlsx";
						team2FilePath = fileDirectory + "Team3.xlsx";
					} }
			break;
			case "GAME 4":
				if (game1W.equals(team1)) {
					if (game2W.equals(team3)) {
						team1FilePath = fileDirectory + "Team1.xlsx";
						team2FilePath = fileDirectory + "Team3.xlsx";
					} else {
						team1FilePath = fileDirectory + "Team1.xlsx";
						team2FilePath = fileDirectory + "Team4.xlsx";
					}}
				else { 
					if (game2W.equals(team4)) {
						team1FilePath = fileDirectory + "Team2.xlsx";
						team2FilePath = fileDirectory + "Team4.xlsx";
					} else {
						team1FilePath = fileDirectory + "Team2.xlsx";
						team2FilePath = fileDirectory + "Team3.xlsx";
					} }
			break;
			}
			updateTable(team1FilePath, team2FilePath, playersT1, playersT2, tableTeam1, tableTeam2);
			
		JButton btnSaveMatch = new JButton("SAVE MATCH");
		btnSaveMatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				LinkedList<String> sched = new LinkedList<>();
				playersT1 = new LinkedList<>();
				playersT2 = new LinkedList<>();

				switch(gameNum) {
					case "GAME 1":
						game1W = stats.gameWinner(scoreT1,scoreT2, game1W, team1, team2);
						game1L = stats.gameLoser(game1W, team1, team2, game1L);
						stats.updateSched("GAME 1", sched, team1, team2, status1, game1W, game1L);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 0, sched);
					break;
					case "GAME 2":
						game2W = stats.gameWinner(scoreT1,scoreT2, game2W, team3, team4);
						game2L = stats.gameLoser(game2W, team3, team4, game2L);
						stats.updateSched("GAME 2", sched, team3, team4, status2, game2W, game2L);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 1, sched);
					break;
					case "GAME 3":
						game3W = stats.gameWinner(scoreT1,scoreT2, game3W, game1L, game2L);
						game3L = stats.gameLoser(game3W, game1L, game2L, game3L);
						stats.updateSched("GAME 3", sched, game1L, game2L, status3, game3W, game3L);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 2, sched);
					break; 
					case "GAME 4":
						game4W = stats.gameWinner(scoreT1,scoreT2, game4W, game1W, game2W);
						game3L = stats.gameLoser(game4W, game1W, game2W, game4L);
						stats.updateSched("GAME 4", sched, game1W, game2W, status4, game4W, game4L);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 3, sched);
					break;
				}
				playMatchFrame.dispose();
				matchSched();
				leagueSummary();
		 		leagueSummaryFrame.setVisible(true);

				ExcelHandler.writeTable(team1FilePath, tableTeam1);
				ExcelHandler.writeTable(team2FilePath, tableTeam2);
				
				ExcelHandler.readTable(team1FilePath, tableScoreboardT1);
		 		ExcelHandler.readTable(team2FilePath, tableScoreboardT2);
				updateTable(team1FilePath, team2FilePath, playersT1, playersT2, tableScoreboardT1, tableScoreboardT2);

				for (int i = 0; i < roundStats.size(); i++) {
		 			tableRoundStats.setValueAt(roundStats.get(i).toString(), 0, i);
		 		}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSaveMatch.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSaveMatch.setForeground(new Color(255, 255, 255));
		btnSaveMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnSaveMatch.setBackground(new Color(189, 57, 68));
		btnSaveMatch.setBounds(475, 732, 122, 40);
		playMatchFrame.getContentPane().add(btnSaveMatch);
	}

	public void leagueSummary() throws Exception {
		leagueSummaryFrame = new JFrame();
		leagueSummaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leagueSummaryFrame.setBounds(100, 100, 1080, 680);
		leagueSummaryFrame.getContentPane().setBackground(new Color(255,251,245));
		leagueSummaryFrame.getContentPane().setLayout(null);
			
		JLabel lblAdminHPBanner = new JLabel("");
		lblAdminHPBanner.setBounds(0, 0, 1066, 115);
		lblAdminHPBanner.setIcon(new ImageIcon(fileDirectory + "LEAGUE SUMMARY.png"));
		leagueSummaryFrame.getContentPane().add(lblAdminHPBanner);
			
		JLabel lblFinalScore = new JLabel("FINAL SCORE", SwingConstants.CENTER);
		lblFinalScore.setBounds(0, 125, 1066, 36);
		lblFinalScore.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblFinalScore.setForeground(new Color(189, 57, 68));
		leagueSummaryFrame.getContentPane().add(lblFinalScore);
			
		JLabel lblDash = new JLabel("-", SwingConstants.CENTER);
		lblDash.setBounds(495, 171, 75, 36);
		lblDash.setForeground(new Color(189, 57, 68));
		lblDash.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		leagueSummaryFrame.getContentPane().add(lblDash);
			
		JPanel panel = new JPanel();
		panel.setBounds(438, 158, 60, 60);
		leagueSummaryFrame.getContentPane().add(panel);
		panel.setLayout(null);
			
		JLabel lblT1Score = new JLabel("13", SwingConstants.CENTER);
		lblT1Score.setBounds(0, 10, 60, 50);
		lblT1Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		panel.add(lblT1Score);
			
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(569, 158, 60, 60);
		leagueSummaryFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
			
		JLabel lblT2Score = new JLabel("13", SwingConstants.CENTER);
		lblT2Score.setBounds(0, 10, 60, 50);
		lblT2Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		panel_1.add(lblT2Score);
			
		JLabel lblTeam1 = new JLabel(t1, SwingConstants.CENTER);
		lblTeam1.setBounds(175, 158, 263, 77);
		lblTeam1.setForeground(new Color(189, 57, 68));
		lblTeam1.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		leagueSummaryFrame.getContentPane().add(lblTeam1);
			
		JLabel lblTeam2 = new JLabel(t2, SwingConstants.CENTER);
		lblTeam2.setBounds(629, 158, 263, 77);
		lblTeam2.setForeground(new Color(189, 57, 68));
		lblTeam2.setFont(new Font("Tungsten Bold", Font.PLAIN, 50));
		leagueSummaryFrame.getContentPane().add(lblTeam2);
			
		JLabel lblMatchOverview = new JLabel("MATCH OVERVIEW", SwingConstants.LEFT);
		lblMatchOverview.setBounds(25, 243, 202, 36);
		lblMatchOverview.setForeground(new Color(189, 57, 68));
		lblMatchOverview.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		leagueSummaryFrame.getContentPane().add(lblMatchOverview);
			
		JLabel lblMatchScoreboard = new JLabel("MATCH SCOREBOARD", SwingConstants.LEFT);
		lblMatchScoreboard.setBounds(25, 329, 202, 36);
		lblMatchScoreboard.setForeground(new Color(189, 57, 68));
		lblMatchScoreboard.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		leagueSummaryFrame.getContentPane().add(lblMatchScoreboard);
			
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
		leagueSummaryFrame.getContentPane().add(tableRoundStats);
			
		scrollPaneT1 = new JScrollPane();
		scrollPaneT1.setBounds(25, 361, 485, 192);
		leagueSummaryFrame.getContentPane().add(scrollPaneT1);
			
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
			
		JTableHeader tableHeader = tableScoreboardT1.getTableHeader();
		tableHeader.setFont(new Font("Tungsten Bold", Font.PLAIN, 15));
		tableHeader.setBackground(new Color(191, 151, 159));
		tableHeader.setForeground(Color.black);
			
		scrollPaneT2 = new JScrollPane();
		scrollPaneT2.setBounds(521, 361, 485, 192);
		leagueSummaryFrame.getContentPane().add(scrollPaneT2);
			
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

		JButton btnLeagueStats = new JButton("STATS");
        btnLeagueStats.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				// Put the League Stats window here
                // leagueSummaryFrame.dispose(); 
            }
        });
        btnLeagueStats.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLeagueStats.setForeground(new Color(255, 255, 255));
		btnLeagueStats.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnLeagueStats.setBackground(new Color(189, 57, 68));
		btnLeagueStats.setBounds(468, 574, 117, 31);
        leagueSummaryFrame.getContentPane().add(btnLeagueStats);
}

	public void updateTable(String team1FilePath, String team2FilePath, LinkedList<String> T1, LinkedList<String> T2, JTable tableT1, JTable tableT2) throws Exception {
		T1 = ExcelHandler.readSpecificColumn(team1FilePath, 0);
		T2 = ExcelHandler.readSpecificColumn(team2FilePath, 0);

		for (int i = 0; i < tableT1.getRowCount(); i++) {
			tableT1.setValueAt(T1.get(i), i, 0); }
		for (int i = 0; i < tableT2.getRowCount(); i++) {
			tableT2.setValueAt(T2.get(i), i, 0);
		}
	}
}
