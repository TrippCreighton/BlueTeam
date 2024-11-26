package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerBox {
    private static JDialog dialog;
    private String userInput; // Captured user input

    
    public AnswerBox(int width, int height, String title, String question) {
        
        dialog = new JDialog((Frame) null, title, false); 
        dialog.setSize(width, height);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setUndecorated(true);


        JLabel questionLabel = new JLabel(question, SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dialog.add(questionLabel, BorderLayout.CENTER);

        // Input field
        JTextField inputField = new JTextField();
        dialog.add(inputField, BorderLayout.SOUTH);
        inputField.setPreferredSize(new Dimension(width, 80));
        inputField.setFont(new Font("Arial", Font.PLAIN, 60)); 


        // Listen for the "Enter" key to capture user input
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userInput = inputField.getText(); // Capture input
                try {
                    int answer = Integer.parseInt(userInput);
                    if (answer == 8) { // Replace with problem answer
                        HUD.score++;
                        inputField.setText("");
                    } else {
                        inputField.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Please enter a valid number.");
                    inputField.setText("");
                }
              
            }
        });

        //location on screen
        dialog.setLocation(1200, 375);
    }

 
    public void show() {
        dialog.setVisible(true);
    }
    public static void close() {
        if (dialog != null && dialog.isVisible()) {
            dialog.dispose();
        }
    }
}