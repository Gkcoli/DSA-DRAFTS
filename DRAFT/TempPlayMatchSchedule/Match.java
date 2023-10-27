import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Match {

	JFrame matchSchedFrame;
	JFrame playMatchFrame;
	private static JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private String g1Status;
	private JTable tableRoundStats;
	private JTable tablePlayerStats;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public Match() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		String game1 = "TEAM 1 VS. TEAM 2";
		String game2 = "TEAM 3 VS. TEAM 4";
		String game3 = "GAME 1 W VS. GAME 2 W";
		String others = "TEAM ? VS. TEAM ?";
		g1Status = "WAITING FOR TEAM...";
		String g2Status = "WAITING FOR TEAM...";
		
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
				{"1", "TEAM 1 VS. TEAM 2", "NOV. 7, 2023, 16:00 - 18:00", g1Status, "N/A"},
				{"2", "TEAM 3 VS. TEAM 4", "NOV. 11, 2023, 13:00 - 15:00", g2Status, "N/A"},
				{"3", "GAME 1 W VS. GAME 2 W", "NOV. 14, 2023, 15:00 - 17:00", "NOT STARTED", "N/A"},
				{"4", "TEAM ? VS. TEAM ?", "N/A", "COMING SOON", "N/A"},
				{"5", "TEAM ? VS. TEAM ?", "N/A", "COMING SOON", "N/A"},
			},
			new String[] {
				"GAME", "TEAMS", "DATE AND TIME", "STATUS", "WINNING TEAM"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		
		table.setRowHeight(74);
		
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setBackground(new Color(255, 251, 245));
		tableHeader.setForeground(new Color(189, 57, 68));
		tableHeader.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		
		UpdateSched matchSched = new UpdateSched();
		System.out.print(matchSched.getSched());

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jessy\\Downloads\\TELEMASTERS\\PICS\\MATCH SCHED.png"));
		lblNewLabel.setBounds(0, 0, 1066, 176);
		matchSchedFrame.getContentPane().add(lblNewLabel);
		
		JButton btnPlay = new JButton("PLAY MATCH");
		btnPlay.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnPlay.setBackground(new Color(189, 57, 68));
		btnPlay.setForeground(new Color(255, 255, 255));
		btnPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switch ((table.getValueAt(0, 3).toString())) {
				case "WAITING FOR TEAM...":
					if (table.getSelectedRow() == 0) {
					if (matchSched.getSched().isEmpty()) {
						matchSched.setSched(game1);
						matchSched.setSched(game2);
						matchSched.setSched(game3);
						System.out.print(matchSched.getSched());
					}
					else {
						matchSched.removeFirst();
						updateSched();
						matchSchedFrame.dispose();
						
						playMatchFrame = new JFrame();
						playMatchFrame.setVisible(true);
						playMatchFrame.getContentPane().setBackground(new Color(255, 251, 245));
						playMatchFrame.getContentPane().setLayout(null);
						
						JLabel lblNewLabel = new JLabel("New label");
						lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
						lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jessy\\Downloads\\TELEMASTERS\\PICS\\PLAY MATCH.png"));
						lblNewLabel.setBounds(0, 0, 1066, 123);
						playMatchFrame.getContentPane().add(lblNewLabel);
						
						JLabel lblMatch = new JLabel("MATCH");
						lblMatch.setForeground(new Color(189, 57, 68));
						lblMatch.setVerticalAlignment(SwingConstants.TOP);
						lblMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
						lblMatch.setBounds(35, 133, 80, 33);
						playMatchFrame.getContentPane().add(lblMatch);
						
						JSpinner spinnerMatch = new JSpinner();
						spinnerMatch.setFont(new Font("Spiegel", Font.PLAIN, 20));
						spinnerMatch.setModel(new SpinnerListModel(new String[] {"(Select a match)", "Match 1", "Match 2", "Match 3", "Match 4"}));
						spinnerMatch.setBounds(125, 133, 312, 33);
						playMatchFrame.getContentPane().add(spinnerMatch);
						
						JLabel lblScore = new JLabel("SCORE");
						lblScore.setHorizontalAlignment(SwingConstants.CENTER);
						lblScore.setVerticalAlignment(SwingConstants.TOP);
						lblScore.setForeground(new Color(189, 57, 68));
						lblScore.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
						lblScore.setBounds(483, 181, 80, 33);
						playMatchFrame.getContentPane().add(lblScore);
						
						JLabel lblTeam1Score = new JLabel("0");
						lblTeam1Score.setBackground(new Color(192, 192, 192));
						lblTeam1Score.setHorizontalAlignment(SwingConstants.CENTER);
						lblTeam1Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 60));
						lblTeam1Score.setBounds(432, 224, 50, 75);
						playMatchFrame.getContentPane().add(lblTeam1Score);
						
						JLabel lblTeam2Score = new JLabel("0");
						lblTeam2Score.setHorizontalAlignment(SwingConstants.CENTER);
						lblTeam2Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 60));
						lblTeam2Score.setBackground(Color.LIGHT_GRAY);
						lblTeam2Score.setBounds(562, 224, 50, 75);
						playMatchFrame.getContentPane().add(lblTeam2Score);
						
						JLabel lblScore_1 = new JLabel("-");
						lblScore_1.setVerticalAlignment(SwingConstants.TOP);
						lblScore_1.setHorizontalAlignment(SwingConstants.CENTER);
						lblScore_1.setForeground(new Color(189, 57, 68));
						lblScore_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
						lblScore_1.setBounds(483, 235, 80, 33);
						playMatchFrame.getContentPane().add(lblScore_1);
						
						JLabel lblTeam1 = new JLabel("TEAM 1 NAME");
						lblTeam1.setVerticalAlignment(SwingConstants.TOP);
						lblTeam1.setHorizontalAlignment(SwingConstants.CENTER);
						lblTeam1.setForeground(new Color(189, 57, 68));
						lblTeam1.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
						lblTeam1.setBounds(259, 245, 163, 33);
						playMatchFrame.getContentPane().add(lblTeam1);
						
						JLabel lblTeam2 = new JLabel("TEAM 2 NAME");
						lblTeam2.setVerticalAlignment(SwingConstants.TOP);
						lblTeam2.setHorizontalAlignment(SwingConstants.CENTER);
						lblTeam2.setForeground(new Color(189, 57, 68));
						lblTeam2.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
						lblTeam2.setBounds(622, 245, 163, 33);
						playMatchFrame.getContentPane().add(lblTeam2);
						
						JButton btnT1Plus = new JButton("+");
						btnT1Plus.setVerticalAlignment(SwingConstants.TOP);
						btnT1Plus.setForeground(new Color(189, 57, 68));
						btnT1Plus.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
						btnT1Plus.setBounds(432, 289, 50, 33);
						playMatchFrame.getContentPane().add(btnT1Plus);
						
						JButton btnT2Plus = new JButton("+");
						btnT2Plus.setVerticalAlignment(SwingConstants.TOP);
						btnT2Plus.setForeground(new Color(189, 57, 68));
						btnT2Plus.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
						btnT2Plus.setBounds(562, 289, 50, 33);
						playMatchFrame.getContentPane().add(btnT2Plus);
						
						JLabel lblRoundStats = new JLabel("ROUND STATISTICS");
						lblRoundStats.setVerticalAlignment(SwingConstants.TOP);
						lblRoundStats.setHorizontalAlignment(SwingConstants.LEFT);
						lblRoundStats.setForeground(new Color(189, 57, 68));
						lblRoundStats.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
						lblRoundStats.setBounds(35, 328, 368, 33);
						playMatchFrame.getContentPane().add(lblRoundStats);
						
						tableRoundStats = new JTable();
						tableRoundStats.setFillsViewportHeight(true);
						tableRoundStats.setCellSelectionEnabled(true);
						tableRoundStats.setBorder(new LineBorder(new Color(0, 0, 0)));
						tableRoundStats.setBackground(new Color(191, 151, 159));
						tableRoundStats.setModel(new DefaultTableModel(
							new Object[][] {
								{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
							},
							new String[] {
								"R1", "R2", "R3", "R4", "R5", "R6", "R7", "R8", "R9", "R10", "R11", "R12", "R13", "R14", "R15"
							}
						));
						tableRoundStats.setFont(new Font("Spiegel", Font.BOLD, 20));
						tableRoundStats.setBounds(35, 371, 981, 50);
						tableRoundStats.setRowHeight(50);
						playMatchFrame.getContentPane().add(tableRoundStats);
						
						JLabel lblPlayerStats = new JLabel("PLAYER STATISTICS");
						lblPlayerStats.setVerticalAlignment(SwingConstants.TOP);
						lblPlayerStats.setHorizontalAlignment(SwingConstants.LEFT);
						lblPlayerStats.setForeground(new Color(189, 57, 68));
						lblPlayerStats.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
						lblPlayerStats.setBounds(35, 431, 368, 33);
						playMatchFrame.getContentPane().add(lblPlayerStats);
						
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(35, 474, 981, 259);
						playMatchFrame.getContentPane().add(scrollPane);
						
						tablePlayerStats = new JTable();
						tablePlayerStats.setFont(new Font("Spiegel", Font.PLAIN, 15));
						tablePlayerStats.setCellSelectionEnabled(true);
						tablePlayerStats.setFillsViewportHeight(true);
						scrollPane.setViewportView(tablePlayerStats);
						tablePlayerStats.setBorder(new LineBorder(new Color(0, 0, 0)));
						tablePlayerStats.setBackground(new Color(255, 251, 245));
						tablePlayerStats.setRowHeight(46);
						tablePlayerStats.setModel(new DefaultTableModel(
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
							Class[] columnTypes = new Class[] {
								String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Object.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
						
						JButton btnSaveMatch = new JButton("SAVE MATCH");
						btnSaveMatch.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								playMatchFrame.dispose();
								matchSchedFrame.setVisible(true);
							}
						});
						btnSaveMatch.setVerticalAlignment(SwingConstants.BOTTOM);
						btnSaveMatch.setForeground(new Color(255, 255, 255));
						btnSaveMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
						btnSaveMatch.setBackground(new Color(189, 57, 68));
						btnSaveMatch.setBounds(449, 743, 122, 40);
						playMatchFrame.getContentPane().add(btnSaveMatch);
						
						tablePlayerStats.getColumnModel().getColumn(0).setPreferredWidth(120);
						tablePlayerStats.getColumnModel().getColumn(1).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(2).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(3).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(4).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(5).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(6).setPreferredWidth(120);
						tablePlayerStats.getColumnModel().getColumn(7).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(8).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(9).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(10).setPreferredWidth(30);
						tablePlayerStats.getColumnModel().getColumn(11).setPreferredWidth(30);
						playMatchFrame.setBounds(100, 100, 1080, 829);
						playMatchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						
						JTableHeader tableHeader = tablePlayerStats.getTableHeader();
						tableHeader.setBackground(new Color(191, 151, 159));
						tableHeader.setForeground(Color.black);
						
						System.out.println(matchSched.getSched());
						}
					}
					else {
						JOptionPane.showMessageDialog(playMatchFrame, "Previous game has not yet started");
					}
					break;
				case "FINISHED":
					if (table.getSelectedRow() == 0) {
						JOptionPane.showMessageDialog(playMatchFrame, "Game has already finished");
					}
					else if (table.getSelectedRow() == 1) {
						JOptionPane.showMessageDialog(playMatchFrame, "Waiting for the other team");
					}
					else {
						JOptionPane.showMessageDialog(playMatchFrame, "Previous game has not yet started");
					}	
				}
			}
		});
		btnPlay.setBounds(455, 551, 118, 45);
		matchSchedFrame.getContentPane().add(btnPlay);		
	}
	
	private void updateSched() {
		SwingUtilities.invokeLater(() -> {
			table.setValueAt("FINISHED", 0, 3);
		});
	}

}
