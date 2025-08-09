package com.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserRegistrationGUI extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton registerButton;
    private JButton clearButton;
    private JLabel statusLabel;
    
    // Custom colors
    private final Color PRIMARY_COLOR = new Color(52, 152, 219);
    private final Color SUCCESS_COLOR = new Color(46, 204, 113);
    private final Color ERROR_COLOR = new Color(231, 76, 60);
    private final Color BACKGROUND_COLOR = new Color(248, 249, 250);
    private final Color CARD_COLOR = Color.WHITE;
    private final Color TEXT_COLOR = new Color(44, 62, 80);
    private final Color BORDER_COLOR = new Color(220, 221, 222);

    public UserRegistrationGUI() {
        initializeGUI();
        setupEventListeners();
        setVisible(true);
    }

    private void initializeGUI() {
        // Main frame setup
        setTitle("User Registration System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 750); // Increased height to accommodate all elements
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Set background color
        getContentPane().setBackground(BACKGROUND_COLOR);
        setLayout(new BorderLayout());

        // Create main panel
        JPanel mainPanel = createMainPanel();
        add(mainPanel, BorderLayout.CENTER);
        
        // Add footer
        add(createFooter(), BorderLayout.SOUTH);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(30, 40, 30, 40));

        // Header
        mainPanel.add(createHeader());
        mainPanel.add(Box.createVerticalStrut(30));

        // Registration form
        mainPanel.add(createRegistrationForm());
        
        return mainPanel;
    }

    private JPanel createHeader() {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(BACKGROUND_COLOR);

        // Title
        JLabel titleLabel = new JLabel("Create Account", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(TEXT_COLOR);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Subtitle
        JLabel subtitleLabel = new JLabel("Please fill in your details to register", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(127, 140, 141));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        headerPanel.add(titleLabel);
        headerPanel.add(Box.createVerticalStrut(5));
        headerPanel.add(subtitleLabel);

        return headerPanel;
    }

    private JPanel createRegistrationForm() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBackground(CARD_COLOR);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            new EmptyBorder(30, 30, 30, 30)
        ));

        // Form fields
        formPanel.add(createInputField("First Name", firstNameField = createStyledTextField()));
        formPanel.add(Box.createVerticalStrut(20));
        
        formPanel.add(createInputField("Last Name", lastNameField = createStyledTextField()));
        formPanel.add(Box.createVerticalStrut(20));
        
        formPanel.add(createInputField("Email Address", emailField = createStyledTextField()));
        formPanel.add(Box.createVerticalStrut(20));
        
        formPanel.add(createInputField("Password", passwordField = createStyledPasswordField()));
        formPanel.add(Box.createVerticalStrut(20));
        
        formPanel.add(createInputField("Confirm Password", confirmPasswordField = createStyledPasswordField()));
        formPanel.add(Box.createVerticalStrut(30));

        // Buttons
        formPanel.add(createButtonPanel());
        formPanel.add(Box.createVerticalStrut(20));

        // Status label
        statusLabel = new JLabel(" ");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(statusLabel);

        return formPanel;
    }

    private JPanel createInputField(String labelText, JComponent inputComponent) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new BoxLayout(fieldPanel, BoxLayout.Y_AXIS));
        fieldPanel.setBackground(CARD_COLOR);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(TEXT_COLOR);
        label.setBorder(new EmptyBorder(0, 0, 5, 0));

        fieldPanel.add(label);
        fieldPanel.add(inputComponent);

        return fieldPanel;
    }

    private JTextField createStyledTextField() {
        JTextField textField = new JTextField();
        styleInputComponent(textField);
        return textField;
    }

    private JPasswordField createStyledPasswordField() {
        JPasswordField passwordField = new JPasswordField();
        styleInputComponent(passwordField);
        return passwordField;
    }

    private void styleInputComponent(JComponent component) {
        component.setPreferredSize(new Dimension(350, 40));
        component.setFont(new Font("Arial", Font.PLAIN, 14));
        component.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1),
            new EmptyBorder(8, 12, 8, 12)
        ));
        component.setBackground(Color.WHITE);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(CARD_COLOR);
        buttonPanel.setPreferredSize(new Dimension(400, 60)); // Ensure enough height

        registerButton = createStyledButton("Register", PRIMARY_COLOR);
        clearButton = createStyledButton("Clear", new Color(149, 165, 166));

        buttonPanel.add(registerButton);
        buttonPanel.add(clearButton);

        return buttonPanel;
    }

    private JButton createStyledButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(130, 45)); // Slightly larger buttons
        button.setMinimumSize(new Dimension(130, 45));   // Ensure minimum size
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Better padding
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true); // Ensure background color shows
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color originalColor = backgroundColor;
            
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor.darker());
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });

        return button;
    }

    private JPanel createFooter() {
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(BACKGROUND_COLOR);
        footerPanel.setBorder(new EmptyBorder(10, 0, 20, 0));

        JLabel footerLabel = new JLabel("© 2025 User Registration System");
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(127, 140, 141));

        footerPanel.add(footerLabel);
        return footerPanel;
    }

    private void setupEventListeners() {
        registerButton.addActionListener(new RegisterButtonListener());
        clearButton.addActionListener(e -> clearForm());

        // Add focus listeners for better UX
        addFocusListeners();
    }

    private void addFocusListeners() {
        FocusAdapter focusAdapter = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                JComponent component = (JComponent) e.getSource();
                component.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(PRIMARY_COLOR, 2),
                    new EmptyBorder(7, 11, 7, 11)
                ));
            }

            @Override
            public void focusLost(FocusEvent e) {
                JComponent component = (JComponent) e.getSource();
                styleInputComponent(component);
            }
        };

        firstNameField.addFocusListener(focusAdapter);
        lastNameField.addFocusListener(focusAdapter);
        emailField.addFocusListener(focusAdapter);
        passwordField.addFocusListener(focusAdapter);
        confirmPasswordField.addFocusListener(focusAdapter);
    }

    private void clearForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        statusLabel.setText(" ");
        firstNameField.requestFocus();
    }

    private void showStatus(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setForeground(color);
    }

    private class RegisterButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                // Disable button to prevent multiple clicks
                registerButton.setEnabled(false);
                registerButton.setText("Processing...");
                
                // Get form data
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String email = emailField.getText().trim();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Validate inputs
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || 
                    password.isEmpty() || confirmPassword.isEmpty()) {
                    showStatus("All fields are required!", ERROR_COLOR);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    showStatus("Passwords do not match!", ERROR_COLOR);
                    confirmPasswordField.requestFocus();
                    return;
                }

                // Create user instance and validate
                Users user = new Users();
                
                // Validate and set data
                try {
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    
                    if (!user.isValidEmail(email)) {
                        showStatus("Please enter a valid email address!", ERROR_COLOR);
                        emailField.requestFocus();
                        return;
                    }
                    
                    if (user.isDuplicateEmail(email)) {
                        showStatus("Email already exists! Please use a different email.", ERROR_COLOR);
                        emailField.requestFocus();
                        return;
                    }
                    
                    if (!user.isValidPassword(password)) {
                        showStatus("Password must contain at least 8 characters including uppercase, lowercase, digit, and special character.", ERROR_COLOR);
                        passwordField.requestFocus();
                        return;
                    }
                    
                    user.setEmail(email);
                    user.setPassword(password);
                    
                    // Save to database
                    user.savetodatabase();
                    
                    // Show success message
                    showSuccessDialog(user);
                    clearForm();
                    
                } catch (IllegalArgumentException ex) {
                    showStatus("Invalid input: " + ex.getMessage(), ERROR_COLOR);
                } catch (Exception ex) {
                    showStatus("Registration failed: " + ex.getMessage(), ERROR_COLOR);
                }
                
            } finally {
                // Re-enable button
                registerButton.setEnabled(true);
                registerButton.setText("Register");
            }
        }
    }

    private void showSuccessDialog(Users user) {
        JDialog successDialog = new JDialog(this, "Registration Successful", true);
        successDialog.setSize(400, 300);
        successDialog.setLocationRelativeTo(this);
        successDialog.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Success icon and message
        JLabel successIcon = new JLabel("✓", SwingConstants.CENTER);
        successIcon.setFont(new Font("Arial", Font.BOLD, 48));
        successIcon.setForeground(SUCCESS_COLOR);
        successIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel successMessage = new JLabel("Registration Successful!", SwingConstants.CENTER);
        successMessage.setFont(new Font("Arial", Font.BOLD, 18));
        successMessage.setForeground(TEXT_COLOR);
        successMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        // User details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        String[] details = {
            "User ID: " + user.getUserId(),
            "Name: " + user.getFirstName() + " " + user.getLastName(),
            "Email: " + user.getEmail()
        };

        for (String detail : details) {
            JLabel detailLabel = new JLabel(detail, SwingConstants.CENTER);
            detailLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            detailLabel.setForeground(TEXT_COLOR);
            detailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            detailsPanel.add(detailLabel);
            detailsPanel.add(Box.createVerticalStrut(5));
        }

        // OK button
        JButton okButton = createStyledButton("OK", PRIMARY_COLOR);
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        okButton.addActionListener(e -> successDialog.dispose());

        contentPanel.add(successIcon);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(successMessage);
        contentPanel.add(detailsPanel);
        contentPanel.add(Box.createVerticalStrut(20));
        contentPanel.add(okButton);

        successDialog.add(contentPanel);
        successDialog.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserRegistrationGUI();
            }
        });
    }
}