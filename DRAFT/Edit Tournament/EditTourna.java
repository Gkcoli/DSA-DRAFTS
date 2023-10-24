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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditTourna {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtField_T1M1;
	private JTextField txtField_T1M2;
	private JTextField txtField_T1M3;
	private JTextField txtField_T1M4;
	private JTextField txtField_T1M5; 
	private JTextField textField_1;
	private JTextField txtField_T3M1;
	private JTextField txtField_T3M2;
	private JTextField txtField_T3M3;
	private JTextField txtField_T3M4;
	private JTextField txtField_T3M5;
	private JTextField textField_7;
	private JTextField txtField_T2M1;
	private JTextField txtField_T2M2;
	private JTextField txtField_T2M3;
	private JTextField txtField_T2M4;
	private JTextField txtField_T2M5;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

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
		frame.setBounds(100, 100, 1080, 944);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jessy\\Downloads\\TELEMASTERS\\PICS\\EDIT TOURNA.png"));
		lblNewLabel.setBounds(0, 0, 1066, 125);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTypeOfTourna = new JLabel("TYPE OF TOURNAMENT");
		lblTypeOfTourna.setVerticalAlignment(SwingConstants.TOP);
		lblTypeOfTourna.setForeground(new Color(189, 57, 68));
		lblTypeOfTourna.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTypeOfTourna.setBounds(46, 143, 225, 33);
		frame.getContentPane().add(lblTypeOfTourna);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Spiegel", Font.PLAIN, 20));
		spinner.setModel(new SpinnerListModel(new String[] {"(Select One)", "Bracketing"}));
		spinner.setBounds(281, 143, 271, 33);
		frame.getContentPane().add(spinner);
		
		JLabel lblTeams = new JLabel("TEAMS");
		lblTeams.setVerticalAlignment(SwingConstants.TOP);
		lblTeams.setForeground(new Color(189, 57, 68));
		lblTeams.setFont(new Font("Tungsten Bold", Font.PLAIN, 35));
		lblTeams.setBounds(46, 201, 225, 33);
		frame.getContentPane().add(lblTeams);
		
		JLabel lblT1Name = new JLabel("TEAM 1 NAME");
		lblT1Name.setVerticalAlignment(SwingConstants.TOP);
		lblT1Name.setForeground(new Color(0, 0, 0));
		lblT1Name.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT1Name.setBounds(46, 237, 119, 33);
		frame.getContentPane().add(lblT1Name);
		
		textField = new JTextField();
		textField.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setBounds(175, 237, 245, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblT1Mem = new JLabel("TEAM 1 MEMBERS");
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
		
		JLabel lblT3Name = new JLabel("TEAM 3 NAME");
		lblT3Name.setVerticalAlignment(SwingConstants.TOP);
		lblT3Name.setForeground(Color.BLACK);
		lblT3Name.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT3Name.setBounds(46, 534, 119, 33);
		frame.getContentPane().add(lblT3Name);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(175, 534, 245, 33);
		frame.getContentPane().add(textField_1);
		
		JLabel lblT3Mem = new JLabel("TEAM 3 MEMBERS");
		lblT3Mem.setForeground(Color.BLACK);
		lblT3Mem.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT3Mem.setBounds(46, 570, 181, 33);
		frame.getContentPane().add(lblT3Mem);
		
		JLabel lbl1_1 = new JLabel("1. ");
		lbl1_1.setVerticalAlignment(SwingConstants.TOP);
		lbl1_1.setForeground(Color.BLACK);
		lbl1_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl1_1.setBounds(108, 608, 17, 25);
		frame.getContentPane().add(lbl1_1);
		
		JLabel lbl2_1 = new JLabel("2.");
		lbl2_1.setVerticalAlignment(SwingConstants.TOP);
		lbl2_1.setForeground(Color.BLACK);
		lbl2_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl2_1.setBounds(108, 651, 17, 25);
		frame.getContentPane().add(lbl2_1);
		
		txtField_T3M1 = new JTextField();
		txtField_T3M1.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T3M1.setColumns(10);
		txtField_T3M1.setBounds(135, 600, 285, 33);
		frame.getContentPane().add(txtField_T3M1);
		
		txtField_T3M2 = new JTextField();
		txtField_T3M2.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T3M2.setColumns(10);
		txtField_T3M2.setBounds(135, 643, 285, 33);
		frame.getContentPane().add(txtField_T3M2);
		
		JLabel lbl3_1 = new JLabel("3.");
		lbl3_1.setVerticalAlignment(SwingConstants.TOP);
		lbl3_1.setForeground(Color.BLACK);
		lbl3_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl3_1.setBounds(108, 694, 17, 25);
		frame.getContentPane().add(lbl3_1);
		
		txtField_T3M3 = new JTextField();
		txtField_T3M3.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T3M3.setColumns(10);
		txtField_T3M3.setBounds(135, 686, 285, 33);
		frame.getContentPane().add(txtField_T3M3);
		
		txtField_T3M4 = new JTextField();
		txtField_T3M4.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T3M4.setColumns(10);
		txtField_T3M4.setBounds(135, 729, 285, 33);
		frame.getContentPane().add(txtField_T3M4);
		
		txtField_T3M5 = new JTextField();
		txtField_T3M5.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T3M5.setColumns(10);
		txtField_T3M5.setBounds(135, 772, 285, 33);
		frame.getContentPane().add(txtField_T3M5);
		
		JLabel lbl4_1 = new JLabel("4.");
		lbl4_1.setVerticalAlignment(SwingConstants.TOP);
		lbl4_1.setForeground(Color.BLACK);
		lbl4_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl4_1.setBounds(108, 737, 17, 25);
		frame.getContentPane().add(lbl4_1);
		
		JLabel lbl5_1 = new JLabel("5.");
		lbl5_1.setVerticalAlignment(SwingConstants.TOP);
		lbl5_1.setForeground(Color.BLACK);
		lbl5_1.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl5_1.setBounds(108, 780, 17, 25);
		frame.getContentPane().add(lbl5_1);
		
		JLabel lblT2Name = new JLabel("TEAM 2 NAME");
		lblT2Name.setVerticalAlignment(SwingConstants.TOP);
		lblT2Name.setForeground(Color.BLACK);
		lblT2Name.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT2Name.setBounds(535, 237, 119, 33);
		frame.getContentPane().add(lblT2Name);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(664, 237, 245, 33);
		frame.getContentPane().add(textField_7);
		
		JLabel lblT2Mem = new JLabel("TEAM 2 MEMBERS");
		lblT2Mem.setForeground(Color.BLACK);
		lblT2Mem.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT2Mem.setBounds(535, 273, 181, 33);
		frame.getContentPane().add(lblT2Mem);
		
		txtField_T2M1 = new JTextField();
		txtField_T2M1.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T2M1.setColumns(10);
		txtField_T2M1.setBounds(624, 300, 285, 33);
		frame.getContentPane().add(txtField_T2M1);
		
		JLabel lbl1_2 = new JLabel("1. ");
		lbl1_2.setVerticalAlignment(SwingConstants.TOP);
		lbl1_2.setForeground(Color.BLACK);
		lbl1_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl1_2.setBounds(597, 308, 17, 25);
		frame.getContentPane().add(lbl1_2);
		
		txtField_T2M2 = new JTextField();
		txtField_T2M2.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T2M2.setColumns(10);
		txtField_T2M2.setBounds(624, 343, 285, 33);
		frame.getContentPane().add(txtField_T2M2);
		
		txtField_T2M3 = new JTextField();
		txtField_T2M3.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T2M3.setColumns(10);
		txtField_T2M3.setBounds(624, 386, 285, 33);
		frame.getContentPane().add(txtField_T2M3);
		
		txtField_T2M4 = new JTextField();
		txtField_T2M4.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T2M4.setColumns(10);
		txtField_T2M4.setBounds(624, 429, 285, 33);
		frame.getContentPane().add(txtField_T2M4);
		
		txtField_T2M5 = new JTextField();
		txtField_T2M5.setFont(new Font("Spiegel", Font.PLAIN, 15));
		txtField_T2M5.setColumns(10);
		txtField_T2M5.setBounds(624, 472, 285, 33);
		frame.getContentPane().add(txtField_T2M5);
		
		textField_13 = new JTextField();
		textField_13.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_13.setColumns(10);
		textField_13.setBounds(664, 534, 245, 33);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_14.setColumns(10);
		textField_14.setBounds(624, 600, 285, 33);
		frame.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_15.setColumns(10);
		textField_15.setBounds(624, 643, 285, 33);
		frame.getContentPane().add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_16.setColumns(10);
		textField_16.setBounds(624, 686, 285, 33);
		frame.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_17.setColumns(10);
		textField_17.setBounds(624, 729, 285, 33);
		frame.getContentPane().add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setFont(new Font("Spiegel", Font.PLAIN, 15));
		textField_18.setColumns(10);
		textField_18.setBounds(624, 772, 285, 33);
		frame.getContentPane().add(textField_18);
		
		JLabel lbl2_2 = new JLabel("2.");
		lbl2_2.setVerticalAlignment(SwingConstants.TOP);
		lbl2_2.setForeground(Color.BLACK);
		lbl2_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl2_2.setBounds(597, 351, 17, 25);
		frame.getContentPane().add(lbl2_2);
		
		JLabel lbl3_2 = new JLabel("3.");
		lbl3_2.setVerticalAlignment(SwingConstants.TOP);
		lbl3_2.setForeground(Color.BLACK);
		lbl3_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl3_2.setBounds(597, 394, 17, 25);
		frame.getContentPane().add(lbl3_2);
		
		JLabel lbl4_2 = new JLabel("4.");
		lbl4_2.setVerticalAlignment(SwingConstants.TOP);
		lbl4_2.setForeground(Color.BLACK);
		lbl4_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl4_2.setBounds(597, 437, 17, 25);
		frame.getContentPane().add(lbl4_2);
		
		JLabel lbl5_2 = new JLabel("5.");
		lbl5_2.setVerticalAlignment(SwingConstants.TOP);
		lbl5_2.setForeground(Color.BLACK);
		lbl5_2.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl5_2.setBounds(597, 480, 17, 25);
		frame.getContentPane().add(lbl5_2);
		
		JLabel lbl1_3 = new JLabel("1. ");
		lbl1_3.setVerticalAlignment(SwingConstants.TOP);
		lbl1_3.setForeground(Color.BLACK);
		lbl1_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl1_3.setBounds(597, 608, 17, 25);
		frame.getContentPane().add(lbl1_3);
		
		JLabel lbl2_3 = new JLabel("2.");
		lbl2_3.setVerticalAlignment(SwingConstants.TOP);
		lbl2_3.setForeground(Color.BLACK);
		lbl2_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl2_3.setBounds(597, 651, 17, 25);
		frame.getContentPane().add(lbl2_3);
		
		JLabel lbl3_3 = new JLabel("3.");
		lbl3_3.setVerticalAlignment(SwingConstants.TOP);
		lbl3_3.setForeground(Color.BLACK);
		lbl3_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl3_3.setBounds(597, 694, 17, 25);
		frame.getContentPane().add(lbl3_3);
		
		JLabel lbl4_3 = new JLabel("4.");
		lbl4_3.setVerticalAlignment(SwingConstants.TOP);
		lbl4_3.setForeground(Color.BLACK);
		lbl4_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl4_3.setBounds(597, 737, 17, 25);
		frame.getContentPane().add(lbl4_3);
		
		JLabel lbl5_3 = new JLabel("5.");
		lbl5_3.setVerticalAlignment(SwingConstants.TOP);
		lbl5_3.setForeground(Color.BLACK);
		lbl5_3.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lbl5_3.setBounds(597, 780, 17, 25);
		frame.getContentPane().add(lbl5_3);
		
		JLabel lblT4Name = new JLabel("TEAM 4 NAME");
		lblT4Name.setVerticalAlignment(SwingConstants.TOP);
		lblT4Name.setForeground(Color.BLACK);
		lblT4Name.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT4Name.setBounds(535, 534, 119, 33);
		frame.getContentPane().add(lblT4Name);
		
		JLabel lblT4Mem = new JLabel("TEAM 4 MEMBERS");
		lblT4Mem.setForeground(Color.BLACK);
		lblT4Mem.setFont(new Font("Tungsten Bold", Font.PLAIN, 30));
		lblT4Mem.setBounds(535, 570, 181, 33);
		frame.getContentPane().add(lblT4Mem);
		
		JButton btnPlayMatch = new JButton("PLAY MATCH");
		btnPlayMatch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PlayMatch window = new PlayMatch();
				window.frame.setVisible(true);
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
