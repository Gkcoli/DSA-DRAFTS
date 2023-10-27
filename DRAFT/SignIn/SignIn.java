package trying;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class UserData {
    String username;
    String password;
    String teamName;
    String[] teamMembers = new String[5];

    public UserData(String username, String password, String teamName, String[] teamMembers) {
        this.username = username;
        this.password = password;
        this.teamName = teamName;
        if (teamMembers.length >= 5) {
            for (int i = 0; i < 5; i++) {
                this.teamMembers[i] = teamMembers[i];
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getTeamName() {
        return teamName;
    }

    public String[] getTeamMembers() {
        return teamMembers;
    }
}

public class SignIn extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentBG;
    private JTextField txtSignIn;
    private JTextField txtUser;
    private JPasswordField pwdField;
    private JRadioButton showPass;
    Hashtable<String, UserData> usersData;
    Hashtable<String, String> userAdmin;
    // Edit fileDirectory
 	String fileDirectory = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignIn frame = new SignIn();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SignIn() {
    	String T1FilePath = fileDirectory + "Team1.txt";
        String T2FilePath = fileDirectory + "Team2.txt";
        String T3FilePath = fileDirectory + "Team3.txt";
        String T4FilePath = fileDirectory + "Team4.txt";
         
    	FileHandler memberList = new FileHandler();
    	LinkedList <String> teamOne = new LinkedList<>();
    	teamOne.addAll(memberList.fileReader(T1FilePath));
    	
    	LinkedList <String> teamTwo = new LinkedList<>();
    	teamTwo.addAll(memberList.fileReader(T2FilePath));
    	
    	LinkedList <String> teamThree = new LinkedList<>();
    	teamThree.addAll(memberList.fileReader(T3FilePath));
    	
    	LinkedList <String> teamFour = new LinkedList<>();
    	teamFour.addAll(memberList.fileReader(T4FilePath));
 
    	
        usersData = new Hashtable<String, UserData>();
        usersData.put("User1", new UserData("User1", "Pass123", teamOne.get(0), new String[]{teamOne.get(1), teamOne.get(2), teamOne.get(3), teamOne.get(4), teamOne.get(5)}));
        usersData.put("User2", new UserData("User2", "Pass1234", teamTwo.get(0), new String[]{teamTwo.get(1), teamTwo.get(2), teamTwo.get(3), teamTwo.get(4), teamTwo.get(5)}));
        usersData.put("User3", new UserData("User3", "Pass12345", teamThree.get(0), new String[]{teamThree.get(1), teamThree.get(2), teamThree.get(3), teamThree.get(4), teamThree.get(5)}));
        usersData.put("User4", new UserData("User4", "Pass123456", teamFour.get(0), new String[]{teamFour.get(1), teamFour.get(2), teamFour.get(3), teamFour.get(4), teamFour.get(5)}));
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 673);
        contentBG = new JPanel();
        contentBG.setBackground(new Color(4, 18, 27));
        contentBG.setBorder(null);
        setContentPane(contentBG);
        contentBG.setLayout(null);

        JPanel panelSignIn = new JPanel();
        panelSignIn.setBackground(new Color(255, 255, 255));
        panelSignIn.setBounds(275, 131, 495, 372);
        contentBG.add(panelSignIn);
        panelSignIn.setLayout(null);

        showPass = new JRadioButton("");
        showPass.setHorizontalTextPosition(SwingConstants.CENTER);
        showPass.setForeground(new Color(192, 192, 192));
        showPass.setIcon(new ImageIcon("C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/eye1.png"));
        showPass.setBackground(new Color(192, 192, 192));
        showPass.setBounds(309, 179, 40, 30);
        panelSignIn.add(showPass);

        showPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    pwdField.setEchoChar((char) 0); // Show the password
                } else {
                    pwdField.setEchoChar('\u2022'); // Hide the password
                }
            }
        });

        txtSignIn = new JTextField();
        txtSignIn.setBackground(new Color(255, 255, 255));
        txtSignIn.setDisabledTextColor(new Color(255, 255, 255));
        txtSignIn.setEditable(false);
        txtSignIn.setHorizontalAlignment(SwingConstants.CENTER);
        txtSignIn.setBorder(null);
        txtSignIn.setFont(new Font("VALORANT", Font.PLAIN, 30));
        txtSignIn.setText("SIGN IN");
        txtSignIn.setBounds(162, 37, 167, 65);
        panelSignIn.add(txtSignIn);
        txtSignIn.setColumns(10);
        Color cc = new Color(253, 69, 86);
        txtSignIn.setForeground(cc);

        txtUser = new JTextField();
        txtUser.setHorizontalAlignment(SwingConstants.LEFT);
        txtUser.setFont(new Font("Tungsten Bold", Font.PLAIN, 17));
        txtUser.setText(" USERNAME");
        txtUser.setBackground(new Color(192, 192, 192));
        txtUser.setBorder(null);
        txtUser.setBounds(141, 113, 208, 35);
        panelSignIn.add(txtUser);
        txtUser.setColumns(10);
        txtUser.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUser.getText().trim().equals("USERNAME")) {
                    txtUser.setText("");
                }
            }
        });

        pwdField = new JPasswordField();
        pwdField.setFont(new Font("Tungsten Bold", Font.PLAIN, 17));
        pwdField.setBorder(null);
        pwdField.setBackground(new Color(192, 192, 192));
        pwdField.setBounds(141, 174, 208, 35);
        panelSignIn.add(pwdField);

        JLabel lblFB = new JLabel("");
        lblFB.setBounds(141, 220, 40, 30);
        lblFB.setIcon(new ImageIcon(fileDirectory + "facebook1.png"));
        panelSignIn.add(lblFB);

        JLabel lblGgl =  new JLabel("");
        lblGgl.setBounds(226, 220, 30, 30);
        lblGgl.setIcon(new ImageIcon(fileDirectory + "google.png"));
        panelSignIn.add(lblGgl);

        JLabel lblApl = new JLabel("");
        lblApl.setBounds(309, 208, 40, 53);
        lblApl.setIcon(new ImageIcon(fileDirectory + "apple11.png"));
        panelSignIn.add(lblApl);
        
        userAdmin = new Hashtable<String, String>();
        userAdmin.put("Admin1", "Admin12345");
        
        JLabel lblEnter = new JLabel("");
        lblEnter.setBorder(new CompoundBorder());
        lblEnter.setBounds(205, 274, 75, 75);
        lblEnter.setIcon(new ImageIcon(fileDirectory + "nextbutton3.png"));
        panelSignIn.add(lblEnter);
        lblEnter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String userText = txtUser.getText();
                char[] pwdText = pwdField.getPassword();
                String password = new String(pwdText);

                if (usersData.containsKey(userText)) {
                    UserData userData = usersData.get(userText);
                    String expectedPassword = userData.getPassword();
                    if (password.equals(expectedPassword)) {
                        JOptionPane.showMessageDialog(lblEnter, "Redirecting to User Home Page", "Login Successfully", 1);
                        setVisible(false);

                        UserHome userHomeFrame = new UserHome();
                        userHomeFrame.updateLabels(userData); // Update the labels with user data
                        userHomeFrame.setVisible(true);
                   
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect password for user. Please try again.");
                    }
                } else if (userAdmin.containsKey(userText)) {
                    String expectedAdminPassword = userAdmin.get(userText);

                    if (password.equals(expectedAdminPassword)) {
                        // If it's an admin, open the AdminHome window
                        AdminHomePage adminHomeFrame = new AdminHomePage();
                        adminHomeFrame.setVisible(true);
                        dispose(); // Close the current window
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect password for admin. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username. Please try again.");
                }
            }
        });
      }
}
