import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	ExcelHandler excel = new ExcelHandler();
	LinkedList<String> list;

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
		labelSelectTeam.setBounds(462, 135, 147, 33);
		frame.getContentPane().add(labelSelectTeam);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Spiegel", Font.PLAIN, 20));
		LinkedList<String> teams = new LinkedList<>();
			teams.addFirst("");
			teams.addAll(ExcelHandler.fileReader(fileDirectory + "VanguardTeams.txt"));
			
		spinner.setModel(new SpinnerListModel(teams));
		spinner.setBounds(611, 135, 226, 33);
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
				list = new LinkedList<>();
				try {
					list.addAll(ExcelHandler.readExcelFile(ExcelHandler.checkUser(spinnerValue), 0));
					txtTeamName.setText(list.get(0));
					txtField_T1M1.setText(list.get(1));
					txtField_T1M2.setText(list.get(2));
					txtField_T1M3.setText(list.get(3));
					txtField_T1M4.setText(list.get(4));
					txtField_T1M5.setText(list.get(5)); 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
			}
		}
		});
		frame.getContentPane().add(spinner);
		
		JLabel lblTeams = new JLabel("TEAMS");
		lblTeams.setVerticalAlignment(SwingConstants.TOP);
		lblTeams.setForeground(new Color(189, 57, 68));
		lblTeams.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTeams.setBounds(462, 185, 91, 33);
		frame.getContentPane().add(lblTeams);
		
		JLabel lblT1Name = new JLabel("TEAM NAME");
		lblT1Name.setVerticalAlignment(SwingConstants.TOP);
		lblT1Name.setForeground(new Color(0, 0, 0));
		lblT1Name.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT1Name.setBounds(462, 232, 114, 33);
		frame.getContentPane().add(lblT1Name);
		
		txtTeamName = new JTextField();
		txtTeamName.setEditable(false);
		txtTeamName.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtTeamName.setHorizontalAlignment(SwingConstants.LEFT);
		txtTeamName.setBounds(586, 232, 251, 33);
		frame.getContentPane().add(txtTeamName);
		txtTeamName.setColumns(10);
		
		JLabel lblT1Mem = new JLabel("TEAM MEMBERS");
		lblT1Mem.setForeground(Color.BLACK);
		lblT1Mem.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT1Mem.setBounds(462, 275, 147, 39);
		frame.getContentPane().add(lblT1Mem);
		
		txtField_T1M1 = new JTextField();
		txtField_T1M1.setEditable(false);
		txtField_T1M1.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M1.setColumns(10);
		txtField_T1M1.setBounds(586, 315, 251, 33);
		frame.getContentPane().add(txtField_T1M1);
		
		JLabel lbl1 = new JLabel("1. ");
		lbl1.setVerticalAlignment(SwingConstants.TOP);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl1.setBounds(559, 321, 28, 33);
		frame.getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("2.");
		lbl2.setVerticalAlignment(SwingConstants.TOP);
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl2.setBounds(559, 366, 17, 25);
		frame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("3.");
		lbl3.setVerticalAlignment(SwingConstants.TOP);
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl3.setBounds(558, 411, 17, 25);
		frame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("4.");
		lbl4.setVerticalAlignment(SwingConstants.TOP);
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl4.setBounds(559, 456, 21, 25);
		frame.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("5.");
		lbl5.setVerticalAlignment(SwingConstants.TOP);
		lbl5.setForeground(Color.BLACK);
		lbl5.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl5.setBounds(559, 501, 17, 25);
		frame.getContentPane().add(lbl5);
		
		txtField_T1M2 = new JTextField();
		txtField_T1M2.setEditable(false);
		txtField_T1M2.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M2.setColumns(10);
		txtField_T1M2.setBounds(586, 360, 251, 33);
		frame.getContentPane().add(txtField_T1M2);
		
		txtField_T1M3 = new JTextField();
		txtField_T1M3.setEditable(false);
		txtField_T1M3.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M3.setColumns(10);
		txtField_T1M3.setBounds(585, 405, 251, 33);
		frame.getContentPane().add(txtField_T1M3);
		
		txtField_T1M4 = new JTextField();
		txtField_T1M4.setEditable(false);
		txtField_T1M4.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M4.setColumns(10);
		txtField_T1M4.setBounds(586, 450, 251, 33);
		frame.getContentPane().add(txtField_T1M4);
		
		txtField_T1M5 = new JTextField();
		txtField_T1M5.setEditable(false);
		txtField_T1M5.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T1M5.setColumns(10);
		txtField_T1M5.setBounds(586, 495, 251, 33);
		frame.getContentPane().add(txtField_T1M5);
		
		
		JButton btnHome = new JButton("HOME");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				AdminHomePage backToAdmin = new AdminHomePage();
				backToAdmin.setVisible(true);
			}
		});
		btnHome.setVerticalAlignment(SwingConstants.BOTTOM);
		btnHome.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnHome.setForeground(new Color(255, 255, 255));
		btnHome.setBackground(new Color(189, 57, 68));
		btnHome.setBounds(885, 135, 119, 39);
		frame.getContentPane().add(btnHome);
		
		JButton btnEditTeam = new JButton("EDIT LINEUP");
		btnEditTeam.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtField_T1M1.setEditable(true);
				txtField_T1M2.setEditable(true);
				txtField_T1M3.setEditable(true);
				txtField_T1M4.setEditable(true);
				txtField_T1M5.setEditable(true);
			}
		}); 
		btnEditTeam.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEditTeam.setForeground(Color.WHITE);
		btnEditTeam.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnEditTeam.setBackground(new Color(189, 57, 68));
		btnEditTeam.setBounds(885, 195, 119, 39);
		frame.getContentPane().add(btnEditTeam);
		
		JButton btnSaveMatch = new JButton("SAVE");
		btnSaveMatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtTeamName.getText().isEmpty() || txtField_T1M1.getText().isEmpty()
						|| txtField_T1M2.getText().isEmpty() || txtField_T1M3.getText().isEmpty()
						|| txtField_T1M4.getText().isEmpty() || txtField_T1M5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnSaveMatch, "Please input all credentials!");
				} else {
					list.clear();
					list.add(txtTeamName.getText().toString());
					list.add(txtField_T1M1.getText().toString());
					list.add(txtField_T1M2.getText().toString());
					list.add(txtField_T1M3.getText().toString());
					list.add(txtField_T1M4.getText().toString());
					list.add(txtField_T1M5.getText().toString());
				
					String filePath = ExcelHandler.checkUser(spinner.getValue().toString());
					excel.writeAtSpecificColumn(filePath, 0, list);
				
					txtField_T1M1.setEditable(false);
					txtField_T1M2.setEditable(false);
					txtField_T1M3.setEditable(false);
					txtField_T1M4.setEditable(false);
					txtField_T1M5.setEditable(false);
				}
			}
		});
		btnSaveMatch.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSaveMatch.setForeground(Color.WHITE);
		btnSaveMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnSaveMatch.setBackground(new Color(189, 57, 68));
		btnSaveMatch.setBounds(885, 255, 119, 39);
		frame.getContentPane().add(btnSaveMatch);
		
		JLabel lblDareToBe = new JLabel("DARE TO BE THE");
		lblDareToBe.setForeground(new Color(189, 57, 68));
		lblDareToBe.setFont(new Font("Tungsten Bold", Font.PLAIN, 45));
		lblDareToBe.setBounds(60, 135, 204, 52);
		frame.getContentPane().add(lblDareToBe);
		
		JLabel lblDifference = new JLabel("DIFFERENCE");
		lblDifference.setFont(new Font("Tungsten Bold", Font.PLAIN, 99));
		lblDifference.setBounds(58, 179, 351, 109);
		frame.getContentPane().add(lblDifference);
		
		JButton btnPlayMatch = new JButton("PLAY MATCH");
		btnPlayMatch.setVerticalAlignment(SwingConstants.BOTTOM);
		btnPlayMatch.setForeground(Color.WHITE);
		btnPlayMatch.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnPlayMatch.setBackground(new Color(189, 57, 68));
		btnPlayMatch.setBounds(885, 315, 119, 39);
		frame.getContentPane().add(btnPlayMatch);
		
		JButton btnMatchSched = new JButton("MATCH SCHED");
		btnMatchSched.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMatchSched.setForeground(Color.WHITE);
		btnMatchSched.setFont(new Font("Tungsten Bold", Font.PLAIN, 20));
		btnMatchSched.setBackground(new Color(189, 57, 68));
		btnMatchSched.setBounds(885, 376, 119, 39);
		frame.getContentPane().add(btnMatchSched);
		
	}
}