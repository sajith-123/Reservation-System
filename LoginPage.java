import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginPage extends JFrame {

    // Declare Swing controls
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;

    // Constructor
    public LoginPage() {
        // Set the title of the JFrame
        super("Reservation System");

        // Set the layout to null to allow custom component placement
        setLayout(null);

        // Set the size of the JFrame
        setSize(400, 200);

        // Create a JLabel for the background image
        JLabel backgroundLabel = new JLabel();
        // Set the path to your background image
        backgroundLabel.setIcon(new ImageIcon("background_image.png"));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        // Create and add the controls for login
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 80, 20);
        backgroundLabel.add(usernameLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(140, 30, 150, 20);
        backgroundLabel.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 60, 80, 20);
        backgroundLabel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(140, 60, 150, 20);
        backgroundLabel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 100, 80, 30);
        backgroundLabel.add(loginButton);

        // Add an action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check if the username and password are valid
                if (username.equals("admin") && password.equals("password")) {
                    // Remove the login controls
                    backgroundLabel.remove(usernameLabel);
                    backgroundLabel.remove(usernameField);
                    backgroundLabel.remove(passwordLabel);
                    backgroundLabel.remove(passwordField);
                    backgroundLabel.remove(loginButton);

                    // Add the reservation buttons
                    JButton busButton = new JButton("Bus");
                    busButton.setBounds(50, 140, 100, 30);
                    backgroundLabel.add(busButton);
                    busButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Create a File object representing the file to execute
                            File file = new File("BusReservationSystemGUI.java");
                            // Create a process to execute the file
                            ProcessBuilder pb = new ProcessBuilder("javac", file.getName());
                            pb.directory(file.getParentFile());
                            try {
                                Process p = pb.start();
                                p.waitFor();
                                pb = new ProcessBuilder("java", file.getName().replace(".java", ""));
                                pb.directory(file.getParentFile());
                                pb.redirectErrorStream(true);
                                p = pb.start();
                                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                                String line;
                                while ((line = reader.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error executing file: " + ex.getMessage());
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });

                    JButton trainButton = new JButton("Train");
                    trainButton.setBounds(250, 140, 100, 30);
                    backgroundLabel.add(trainButton);
                    trainButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // Create a File object representing the file to execute
                            File file = new File("TrainReservationSystem.java");
                            // Create a process to execute the file
                            ProcessBuilder pb = new ProcessBuilder("javac", file.getName());
                            pb.directory(file.getParentFile());
                            try {
                                Process p = pb.start();
                                p.waitFor();
                                pb = new ProcessBuilder("java", file.getName().replace(".java", ""));
                                pb.directory(file.getParentFile());
                                pb.redirectErrorStream(true);
                                p = pb.start();
                                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                                String line;
                                while ((line = reader.readLine()) != null) {
                                    System.out.println(line);
                                }
                            } catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Error executing file: " + ex.getMessage());
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });

                    // Repaint the JFrame to reflect the changes
                    revalidate();
                    repaint();
                } else {
                    // Show an error message if the login is invalid
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            }
        });

        // Set the location and close operation of the JFrame
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Main method to create and show the JFrame
    public static void main(String[] args) {
        LoginPage gui = new LoginPage();
        gui.setVisible(true);
    }
}
