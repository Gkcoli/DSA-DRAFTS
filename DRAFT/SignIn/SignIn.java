package telemasters;

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
    private JPanel contentPane;
    private JTextField textSignIn;
    private JTextField txtUser;
    private JPasswordField passField;
    private JRadioButton showPass;
    Hashtable<String, UserData> usersData;

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
        usersData = new Hashtable<String, UserData>();
        usersData.put("User1", new UserData("User1", "Pass123", "TeamA", new String[]{"Member1", "Member2", "Member3", "Member4", "Member5"}));
        usersData.put("User2", new UserData("User2", "Pass1234", "TeamB", new String[]{"MemberA", "MemberB", "MemberC", "MemberD", "MemberE"}));
        usersData.put("User3", new UserData("User3", "Pass12345", "TeamC", new String[]{"MemberX", "MemberY", "MemberZ", "MemberW", "MemberV"}));
        usersData.put("User4", new UserData("User4", "Pass123456", "TeamD", new String[]{"MemberI", "MemberII", "MemberIII", "MemberIV", "MemberV"}));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 673);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(4, 18, 27));
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(275, 131, 495, 372);
        contentPane.add(panel);
        panel.setLayout(null);

        showPass = new JRadioButton("");
        showPass.setHorizontalTextPosition(SwingConstants.LEADING);
        showPass.setForeground(new Color(192, 192, 192));
        showPass.setIcon(new ImageIcon("C:\\Users\\Ryujin\\Downloads\\eye1.png"));
        showPass.setBackground(new Color(192, 192, 192));
        showPass.setBounds(309, 184, 40, 16);
        panel.add(showPass);

        showPass.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    passField.setEchoChar((char) 0); // Show the password
                } else {
                    passField.setEchoChar('\u2022'); // Hide the password
                }
            }
        });

        textSignIn = new JTextField();
        textSignIn.setBackground(new Color(255, 255, 255));
        textSignIn.setDisabledTextColor(new Color(255, 255, 255));
        textSignIn.setEditable(false);
        textSignIn.setHorizontalAlignment(SwingConstants.CENTER);
        textSignIn.setBorder(null);
        textSignIn.setFont(new Font("VALORANT", Font.PLAIN, 30));
        textSignIn.setText("SIGN IN");
        textSignIn.setBounds(162, 37, 167, 65);
        panel.add(textSignIn);
        textSignIn.setColumns(10);
        Color cc = new Color(253, 69, 86);
        textSignIn.setForeground(cc);

        txtUser = new JTextField();
        txtUser.setHorizontalAlignment(SwingConstants.LEFT);
        txtUser.setFont(new Font("Tungsten Bold", Font.PLAIN, 17));
        txtUser.setText(" USERNAME");
        txtUser.setBackground(new Color(192, 192, 192));
        txtUser.setBorder(null);
        txtUser.setBounds(141, 113, 208, 35);
        panel.add(txtUser);
        txtUser.setColumns(10);
        txtUser.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUser.getText().trim().equals("USERNAME")) {
                    txtUser.setText("");
                }
            }
        });

        passField = new JPasswordField();
        passField.setBorder(null);
        passField.setBackground(new Color(192, 192, 192));
        passField.setBounds(141, 174, 208, 35);
        panel.add(passField);

        JLabel lblFB = new JLabel("");
        lblFB.setBounds(141, 220, 40, 30);
        lblFB.setIcon(new ImageIcon("C:\\Users\\Ryujin\\Downloads\\facebook1.png"));
        panel.add(lblFB);

        JLabel lblGgl =  new JLabel("");
        lblGgl.setBounds(226, 220, 30, 30);
        lblGgl.setIcon(new ImageIcon("C:\\Users\\Ryujin\\Downloads\\google.png"));
        panel.add(lblGgl);

        JLabel lblApl = new JLabel("");
        lblApl.setBounds(309, 208, 40, 53);
        lblApl.setIcon(new ImageIcon("C:\\Users\\Ryujin\\Downloads\\apple11.png"));
        panel.add(lblApl);

        JLabel lblEnter = new JLabel("");
        lblEnter.setBorder(new CompoundBorder());
        lblEnter.setBounds(205, 274, 75, 75);
        lblEnter.setIcon(new ImageIcon("C:\\Users\\Ryujin\\Downloads\\nextbutton3.png"));
        panel.add(lblEnter);
        lblEnter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == lblEnter) {
                    String userText = txtUser.getText();
                    char[] pwdText = passField.getPassword();
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
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect username. Please try again.");
                    }
                }
            }
        });
    }
}
