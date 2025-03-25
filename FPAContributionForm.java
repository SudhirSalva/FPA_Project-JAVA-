import javax.swing.*;
import java.awt.event.*;

public class FPAContributionForm {  
    public static void main(String[] args) {  
        JFrame frame = new JFrame("FPA Contribution Form");  
        frame.setSize(400, 350);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.setLayout(null);  

        JLabel nameLabel = new JLabel("Name:");  
        nameLabel.setBounds(50, 30, 100, 30);  

        JLabel emailLabel = new JLabel("Email:");  
        emailLabel.setBounds(50, 70, 100, 30);  

        JLabel typeLabel = new JLabel("Contribution Type:");  
        typeLabel.setBounds(50, 110, 150, 30);  

        JLabel amountLabel = new JLabel("Amount (if any):");  
        amountLabel.setBounds(50, 150, 150, 30);  

        JTextField nameField = new JTextField();  
        nameField.setBounds(180, 30, 150, 30);  

        JTextField emailField = new JTextField();  
        emailField.setBounds(180, 70, 150, 30);  

        String[] contributionTypes = { "Funds", "Volunteering", "Resources" };  
        JComboBox<String> typeBox = new JComboBox<>(contributionTypes);  
        typeBox.setBounds(180, 110, 150, 30);  

        JTextField amountField = new JTextField();  
        amountField.setBounds(180, 150, 150, 30);  
        amountField.setEnabled(false);  

        typeBox.addActionListener(e -> {
            if (typeBox.getSelectedItem().equals("Funds")) {
                amountField.setEnabled(true);
            } else {
                amountField.setEnabled(false);
                amountField.setText("");  
            }
        });

        JButton submitButton = new JButton("Submit");  
        submitButton.setBounds(50, 200, 100, 40);  
        submitButton.addActionListener(e -> {  
            String name = nameField.getText().trim();  
            String email = emailField.getText().trim();  
            String type = (String) typeBox.getSelectedItem();  
            String amount = amountField.getText().trim();  

            if (!name.matches("[a-zA-Z ]+") || name.isEmpty()) {  
                JOptionPane.showMessageDialog(frame, "Enter a valid name!");  
                return;  
            }  

            if (!email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")) {  
                JOptionPane.showMessageDialog(frame, "Enter a valid email!");  
                return;  
            }  

            if (type.equals("Funds") && (!amount.matches("\\d+") || amount.isEmpty())) {  
                JOptionPane.showMessageDialog(frame, "Enter a valid numeric amount!");  
                return;  
            }  

            JOptionPane.showMessageDialog(frame, "Contribution Submitted!\nName: " + name + "\nEmail: " + email + "\nType: " + type + "\nAmount: " + (amount.isEmpty() ? "N/A" : amount));  
        });  

        JButton clearButton = new JButton("Clear");  
        clearButton.setBounds(180, 200, 100, 40);  
        clearButton.addActionListener(e -> {  
            nameField.setText("");  
            emailField.setText("");  
            amountField.setText("");  
            typeBox.setSelectedIndex(0);  
            amountField.setEnabled(false);  
        });  

        frame.add(nameLabel);  
        frame.add(nameField);  
        frame.add(emailLabel);  
        frame.add(emailField);  
        frame.add(typeLabel);  
        frame.add(typeBox);  
        frame.add(amountLabel);  
        frame.add(amountField);  
        frame.add(submitButton);  
        frame.add(clearButton);  

        frame.setVisible(true);  
    }  
}  
