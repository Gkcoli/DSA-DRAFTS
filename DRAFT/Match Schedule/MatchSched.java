import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerListModel;

public class MatchSched {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatchSched window = new MatchSched();
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
	public MatchSched() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 251, 245));
		frame.getContentPane().setForeground(new Color(255, 251, 245));
		frame.setBounds(100, 100, 1080, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 251, 245));
		panel.setBounds(10, 127, 1033, 414);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1013, 394);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Tungsten Bold", Font.PLAIN, 25));
		table.setBorder(new LineBorder(new Color(83, 33, 43)));
		table.setBackground(new Color(255, 251, 245));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "TEAM 2 VS. TEAM 3", "OCT. 7, 2023, 16:00 - 18:00", "FINISHED", "TEAM 1"},
				{"2", "GAME 1 W VS. TEAM 1", "NOV. 11, 2023, 15:00 - 17:00", "WAITING FOR TEAM...", "N/A"},
				{"3", "TEAM 4 VS. TEAM 5", "NOV. 11, 2023, 13:00 - 15:00", "ONGOING", "N/A"},
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jessy\\Downloads\\TELEMASTERS\\PICS\\MATCH SCHED.png"));
		lblNewLabel.setBounds(0, 0, 1066, 176);
		frame.getContentPane().add(lblNewLabel);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer);
		
		
		
	}
}
