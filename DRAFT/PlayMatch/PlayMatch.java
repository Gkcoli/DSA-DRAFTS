import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Queue;

public class PlayMatch {

	JFrame frame;
	private JTable tableRoundStats;
	private JTable tablePlayerStats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayMatch window = new PlayMatch();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PlayMatch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 251, 245));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jessy\\Downloads\\TELEMASTERS\\PICS\\PLAY MATCH.png"));
		lblNewLabel.setBounds(0, 0, 1066, 123);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblMatch = new JLabel("MATCH");
		lblMatch.setForeground(new Color(189, 57, 68));
		lblMatch.setVerticalAlignment(SwingConstants.TOP);
		lblMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblMatch.setBounds(35, 133, 80, 33);
		frame.getContentPane().add(lblMatch);
		
		JSpinner spinnerMatch = new JSpinner();
		spinnerMatch.setFont(new Font("Spiegel", Font.PLAIN, 20));
		spinnerMatch.setModel(new SpinnerListModel(new String[] {"(Select a match)", "Match 1", "Match 2", "Match 3", "Match 4"}));
		spinnerMatch.setBounds(125, 133, 312, 33);
		frame.getContentPane().add(spinnerMatch);
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setVerticalAlignment(SwingConstants.TOP);
		lblScore.setForeground(new Color(189, 57, 68));
		lblScore.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblScore.setBounds(483, 181, 80, 33);
		frame.getContentPane().add(lblScore);
		
		JLabel lblTeam1Score = new JLabel("0");
		lblTeam1Score.setBackground(new Color(192, 192, 192));
		lblTeam1Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam1Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 60));
		lblTeam1Score.setBounds(432, 224, 50, 75);
		frame.getContentPane().add(lblTeam1Score);
		
		JLabel lblTeam2Score = new JLabel("0");
		lblTeam2Score.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam2Score.setFont(new Font("Tungsten Bold", Font.PLAIN, 60));
		lblTeam2Score.setBackground(Color.LIGHT_GRAY);
		lblTeam2Score.setBounds(562, 224, 50, 75);
		frame.getContentPane().add(lblTeam2Score);
		
		JLabel lblScore_1 = new JLabel("-");
		lblScore_1.setVerticalAlignment(SwingConstants.TOP);
		lblScore_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore_1.setForeground(new Color(189, 57, 68));
		lblScore_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblScore_1.setBounds(483, 235, 80, 33);
		frame.getContentPane().add(lblScore_1);
		
		JLabel lblTeam1 = new JLabel("TEAM 1 NAME");
		lblTeam1.setVerticalAlignment(SwingConstants.TOP);
		lblTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam1.setForeground(new Color(189, 57, 68));
		lblTeam1.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTeam1.setBounds(259, 245, 163, 33);
		frame.getContentPane().add(lblTeam1);
		
		JLabel lblTeam2 = new JLabel("TEAM 2 NAME");
		lblTeam2.setVerticalAlignment(SwingConstants.TOP);
		lblTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam2.setForeground(new Color(189, 57, 68));
		lblTeam2.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTeam2.setBounds(622, 245, 163, 33);
		frame.getContentPane().add(lblTeam2);
		
		JButton btnT1Plus = new JButton("+");
		btnT1Plus.setVerticalAlignment(SwingConstants.TOP);
		btnT1Plus.setForeground(new Color(189, 57, 68));
		btnT1Plus.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		btnT1Plus.setBounds(432, 289, 50, 33);
		frame.getContentPane().add(btnT1Plus);
		
		JButton btnT2Plus = new JButton("+");
		btnT2Plus.setVerticalAlignment(SwingConstants.TOP);
		btnT2Plus.setForeground(new Color(189, 57, 68));
		btnT2Plus.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		btnT2Plus.setBounds(562, 289, 50, 33);
		frame.getContentPane().add(btnT2Plus);
		
		JLabel lblRoundStats = new JLabel("ROUND STATISTICS");
		lblRoundStats.setVerticalAlignment(SwingConstants.TOP);
		lblRoundStats.setHorizontalAlignment(SwingConstants.LEFT);
		lblRoundStats.setForeground(new Color(189, 57, 68));
		lblRoundStats.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblRoundStats.setBounds(35, 328, 368, 33);
		frame.getContentPane().add(lblRoundStats);
		
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
		frame.getContentPane().add(tableRoundStats);
		
		JLabel lblPlayerStats = new JLabel("PLAYER STATISTICS");
		lblPlayerStats.setVerticalAlignment(SwingConstants.TOP);
		lblPlayerStats.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayerStats.setForeground(new Color(189, 57, 68));
		lblPlayerStats.setFont(new Font("Tungsten Bold", Font.PLAIN, 40));
		lblPlayerStats.setBounds(35, 431, 368, 33);
		frame.getContentPane().add(lblPlayerStats);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 474, 981, 259);
		frame.getContentPane().add(scrollPane);
		
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
				// UpdateSched updatedSched = new UpdateSched();
				frame.dispose();
				MatchSched window2 = new MatchSched();
				window2.frame.setVisible(true);
			}
		});
		btnSaveMatch.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSaveMatch.setForeground(new Color(255, 255, 255));
		btnSaveMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnSaveMatch.setBackground(new Color(189, 57, 68));
		btnSaveMatch.setBounds(449, 743, 122, 40);
		frame.getContentPane().add(btnSaveMatch);
		
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
		frame.setBounds(100, 100, 1080, 829);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTableHeader tableHeader = tablePlayerStats.getTableHeader();
		tableHeader.setBackground(new Color(191, 151, 159));
		tableHeader.setForeground(Color.black);
	}
}
