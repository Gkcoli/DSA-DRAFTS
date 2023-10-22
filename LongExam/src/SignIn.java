import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.border.CompoundBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SignIn extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textSignIn;
    private JTextField txtUser;
    private JPasswordField passField;
    private JRadioButton showPass;

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
        txtUser.setFont(new Font("Tungsten Bold", Font.PLAIN, 17));
        txtUser.setText("USERNAME");
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

        JLabel lblGgl = new JLabel("");
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
                    if (userText.equals("Admin1") && password.equals("Pass123")) {
                        JOptionPane.showMessageDialog(lblEnter, "Redirecting to Next Page", "Login Successfully", 1);
                        setVisible(false);
                        LeagueStats leagueStatsFrame = new LeagueStats();
                        leagueStatsFrame.setVisible(true);
                    } else {
                        if (!userText.equals("Admin1")) {
                            JOptionPane.showMessageDialog(null, "Incorrect username. Please try again.");
                        } else if (!password.equals("Pass123")) {
                            JOptionPane.showMessageDialog(null, "Incorrect password. Please try again.");
                        }
                    }
                }
            }
        });
    }
}
