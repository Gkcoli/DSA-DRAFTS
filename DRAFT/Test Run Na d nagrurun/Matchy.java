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


public class Matchy {
	// Edit fileDirectory
	String fileDirectory = "C:/Users/Ryujin/Documents/Eclipse Java/Loops/TELEMASTERS/s/src/";

	JFrame matchSchedFrame, playMatchFrame;
	private static JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTable tableRoundStats, tableTeam1, tableTeam2;
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
	Stats stats = new Stats();
	ExcelHandler statsExcel = new ExcelHandler();
	UserData userData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Matchy window = new Matchy();
					window.matchSchedFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception
	 */
	public Matchy() throws Exception {
		matchSched();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception
	 */
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
		btnPlay.setBounds(352, 551, 118, 45);
		matchSchedFrame.getContentPane().add(btnPlay);	
		
		 JButton btnSummary = new JButton("SUMMARY");
		 btnSummary.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if (status1.equals("FINISHED") && table.getSelectedRow() == 0) {
		 			LeagueSum leagueSummaryFrame = new LeagueSum();
		 			leagueSummaryFrame.setVisible(true);
		 			//Method to display the results
		 		} else if (status2.equals("FINISHED") && table.getSelectedRow() == 1) {
		 			//leagueSummaryFrame.setVisible(true);
		 			//Method to display the results
		 		} else if (status3.equals("FINISHED") && table.getSelectedRow() == 2) {
		 			//leagueSummaryFrame.setVisible(true);
		 			//Method to display the results
		 		} else if (status4.equals("FINISHED") && table.getSelectedRow() == 3) {
		 			//leagueSummaryFrame.setVisible(true);
		 			//Method to display the results
		 		} else {
		 			//JOptionMessage = "Game has not yet started"
		 		}
		 	}
		 });
		 btnSummary.setForeground(Color.WHITE);
		 btnSummary.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		 btnSummary.setBackground(new Color(189, 57, 68));
		 btnSummary.setBounds(520, 551, 118, 45);
		 matchSchedFrame.getContentPane().add(btnSummary);
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

		LinkedList<String> roundStats = new LinkedList<>();
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

		LinkedList <String> playersT1 = new LinkedList<>();
		LinkedList <String> playersT2 = new LinkedList<>();

		switch (gameNum) {
			case "GAME 1":
				updateTable("Team1.xlsx", "Team2.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
			break;
			case "GAME 2":
				updateTable("Team3.xlsx", "Team4.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
			break;
			case "GAME 3":
				if (game1L.equals(team1)) {
					if (game2L.equals(team3)) {
						updateTable("Team1.xlsx", "Team3.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} else {
						updateTable("Team1.xlsx", "Team4.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} }
				else { 
					if (game2L.equals(team4)) {
						updateTable("Team2.xlsx", "Team4.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} else {
						updateTable("Team2.xlsx", "Team3.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} }
			break;
			case "GAME 4":
				if (game1W.equals(team1)) {
					if (game2W.equals(team3)) {
						updateTable("Team1.xlsx", "Team3.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} else {
						updateTable("Team1.xlsx", "Team4.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} }
				else { 
					if (game2W.equals(team4)) {
						updateTable("Team2.xlsx", "Team4.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} else {
						updateTable("Team2.xlsx", "Team3.xlsx", playersT1, playersT2, tableTeam1, tableTeam2);
					} }
			break;
			}
		
		JButton btnSaveMatch = new JButton("SAVE MATCH");
		btnSaveMatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				LinkedList<String> sched = new LinkedList<>();

				switch(gameNum) {
					case "GAME 1":
						game1W = stats.gameWinner(scoreT1,scoreT2, game1W, team1, team2);
						game1L = stats.gameLoser(game1W, team1, team2, game1L);
						status1 = "FINISHED";
						sched.add(team1);
						sched.add(team2);
						sched.add(status1);
						sched.add(game1W);
						sched.add(game1L);
						System.out.println(sched);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 0, sched);
					break;
					case "GAME 2":
						game2W = stats.gameWinner(scoreT1,scoreT2, game2W, team3, team4);
						game2L = stats.gameLoser(game2W, team3, team4, game2L);
						status2 = "FINISHED";
						sched.add(team3);
						sched.add(team4);
						sched.add(status2);
						sched.add(game2W);
						sched.add(game2L);
						System.out.println(sched);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 1, sched);
					break;
					case "GAME 3":
						game3W = stats.gameWinner(scoreT1,scoreT2, game3W, game1L, game2L);
						game3L = stats.gameLoser(game3W, game1L, game2L, game3L);
						status3 = "FINISHED";
						sched.add(game1L); 
						sched.add(game2L);
						sched.add(status3);
						sched.add(game3W);
						sched.add(game3L);
						System.out.println(sched);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 2, sched);
					break; 
					case "GAME 4":
						game4W = stats.gameWinner(scoreT1,scoreT2, game4W, game1W, game2W);
						game3L = stats.gameLoser(game4W, game1W, game2W, game4L);
						status4 = "FINISHED";
						sched.add(game1W); 
						sched.add(game2W);
						sched.add(status4);
						sched.add(game4W);
						sched.add(game4L);
						System.out.println(sched);
						ExcelHandler.writeAtSpecificRow(matchFilePath, 3, sched);
					break;
				}
				playMatchFrame.dispose();
				ExcelHandler.writeTable(team1FilePath, tableTeam1);
				ExcelHandler.writeTable(team2FilePath, tableTeam2);
				
				 LinkedList<String> leagueSummaryData = new LinkedList<>();
		            leagueSummaryData.add("Game Number: " + gameNum);
		            leagueSummaryData.add("Team 1: " + t1);
		            leagueSummaryData.add("Team 2: " + t2);
		            leagueSummaryData.add("Score Team 1: " + scoreT1);
		            leagueSummaryData.add("Score Team 2: " + scoreT2);

		            ExcelHandler.writeLeagueSummaryData(fileDirectory, leagueSummaryData);

		            
		           
		            matchSched();
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

	public void updateTable(String fileName1, String fileName2, LinkedList<String> T1, LinkedList<String> T2, JTable tableT1, JTable tableT2) throws Exception {
			team1FilePath = fileDirectory + fileName1;
			team2FilePath = fileDirectory + fileName2;

			T1 = ExcelHandler.readSpecificColumn(team1FilePath, 0);
			T2 = ExcelHandler.readSpecificColumn(team2FilePath, 0);

			for (int i = 0; i < tableT1.getRowCount(); i++) {
				tableTeam1.setValueAt(T1.get(i), i, 0); }
			for (int i = 0; i < tableT2.getRowCount(); i++) {
				tableTeam2.setValueAt(T2.get(i), i, 0);
		}
			
	}
}
