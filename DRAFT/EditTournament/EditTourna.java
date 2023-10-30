import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class EditTourna {

	private JFrame frame;
	private JTextField txtTeamName;
	private JTextField txtField_T1M1;
	private JTextField txtField_T1M2;
	private JTextField txtField_T1M3;
	private JTextField txtField_T1M4;
	private JTextField txtField_T1M5; 
	// Edit fileDirectory
	String fileDirectory = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/";
	JoinTourna teamList = new JoinTourna();
	FileHandler fileHandler = new FileHandler();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTourna window = new EditTourna();
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
	public EditTourna() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 251, 245));
		frame.setBounds(100, 100, 1080, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeader = new JLabel("New label");
		lblHeader.setVerticalAlignment(SwingConstants.TOP);
		lblHeader.setIcon(new ImageIcon(fileDirectory + "EDIT TOURNA.png"));
		lblHeader.setBounds(0, 0, 1066, 125);
		frame.getContentPane().add(lblHeader);
		
		JLabel labelSelectTeam = new JLabel("SELECT USER");
		labelSelectTeam.setVerticalAlignment(SwingConstants.TOP);
		labelSelectTeam.setForeground(new Color(189, 57, 68));
		labelSelectTeam.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		labelSelectTeam.setBounds(46, 143, 147, 33);
		frame.getContentPane().add(labelSelectTeam);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Spiegel", Font.PLAIN, 20));
		spinner.setModel(new SpinnerListModel(new String[] {"", "User1", "User2", "User3", "User4"}));
		spinner.setBounds(194, 143, 226, 33);
		spinner.addChangeListener(new ChangeListener() {
		public void stateChanged(ChangeEvent e) {
			String spinnerValue = (String) spinner.getValue();
			if (spinnerValue == "") {
				txtTeamName.setText("");
				txtField_T1M1.setText("");
				txtField_T1M2.setText("");
				txtField_T1M3.setText("");
				txtField_T1M4.setText("");
				txtField_T1M5.setText("");
			} else {
				LinkedList<String> list = new LinkedList<>();
				list.addAll(fileHandler.teamCompositionReader(fileHandler.checkUser(spinnerValue)));
				if (list.get(0) == "Team Name") {
					spinnerValue = "";
				} else {
					txtTeamName.setText(list.get(0));
					txtField_T1M1.setText(list.get(1));
					txtField_T1M2.setText(list.get(2));
					txtField_T1M3.setText(list.get(3));
					txtField_T1M4.setText(list.get(4));
					txtField_T1M5.setText(list.get(5));
				}
			}
		}
		});
		frame.getContentPane().add(spinner);
		
		JLabel lblTeams = new JLabel("TEAMS");
		lblTeams.setVerticalAlignment(SwingConstants.TOP);
		lblTeams.setForeground(new Color(189, 57, 68));
		lblTeams.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTeams.setBounds(46, 201, 225, 33);
		frame.getContentPane().add(lblTeams);
		
		JLabel lblT1Name = new JLabel("TEAM NAME");
		lblT1Name.setVerticalAlignment(SwingConstants.TOP);
		lblT1Name.setForeground(new Color(0, 0, 0));
		lblT1Name.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT1Name.setBounds(46, 237, 119, 33);
		frame.getContentPane().add(lblT1Name);
		
		txtTeamName = new JTextField();
		txtTeamName.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtTeamName.setHorizontalAlignment(SwingConstants.LEFT);
		txtTeamName.setBounds(175, 237, 245, 33);
		frame.getContentPane().add(txtTeamName);
		txtTeamName.setColumns(10);
		
		JLabel lblT1Mem = new JLabel("TEAM MEMBERS");
		lblT1Mem.setForeground(Color.BLACK);
		lblT1Mem.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT1Mem.setBounds(46, 273, 181, 33);
		frame.getContentPane().add(lblT1Mem);
		
		txtField_T1M1 = new JTextField();
		txtField_T1M1.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M1.setColumns(10);
		txtField_T1M1.setBounds(135, 300, 285, 33);
		frame.getContentPane().add(txtField_T1M1);
		
		JLabel lbl1 = new JLabel("1. ");
		lbl1.setVerticalAlignment(SwingConstants.TOP);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl1.setBounds(108, 308, 17, 25);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("2.");
		lbl2.setVerticalAlignment(SwingConstants.TOP);
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl2.setBounds(108, 351, 17, 25);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("3.");
		lbl3.setVerticalAlignment(SwingConstants.TOP);
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl3.setBounds(108, 394, 17, 25);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("4.");
		lbl4.setVerticalAlignment(SwingConstants.TOP);
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl4.setBounds(108, 437, 17, 25);
		frame.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("5.");
		lbl5.setVerticalAlignment(SwingConstants.TOP);
		lbl5.setForeground(Color.BLACK);
		lbl5.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl5.setBounds(108, 480, 17, 25);
		frame.getContentPane().add(lbl5);
		
		txtField_T1M2 = new JTextField();
		txtField_T1M2.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M2.setColumns(10);
		txtField_T1M2.setBounds(135, 343, 285, 33);
		frame.getContentPane().add(txtField_T1M2);
		
		txtField_T1M3 = new JTextField();
		txtField_T1M3.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M3.setColumns(10);
		txtField_T1M3.setBounds(135, 386, 285, 33);
		frame.getContentPane().add(txtField_T1M3);
		
		txtField_T1M4 = new JTextField();
		txtField_T1M4.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M4.setColumns(10);
		txtField_T1M4.setBounds(135, 429, 285, 33);
		frame.getContentPane().add(txtField_T1M4);
		
		txtField_T1M5 = new JTextField();
		txtField_T1M5.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M5.setColumns(10);
		txtField_T1M5.setBounds(135, 472, 285, 33);
		frame.getContentPane().add(txtField_T1M5);
		
		
		JButton btnPlayMatch = new JButton("PLAY MATCH");
		btnPlayMatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				PlayMatch window = new PlayMatch();
//				window.frame.setVisible(true);
			}
		});
		btnPlayMatch.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnPlayMatch.setForeground(new Color(255, 255, 255));
		btnPlayMatch.setBackground(new Color(189, 57, 68));
		btnPlayMatch.setBounds(881, 144, 119, 39);
		frame.getContentPane().add(btnPlayMatch);
		
	}
}
