package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnswerBox {
    private static JDialog dialog;
    private String userInput; // Captured user input
    private boolean isCorrect = false;
    private Handler handler;
    private int correct;
    private int diff;
    
    public AnswerBox(int width, int height, String title, Handler  hand, int diff) {
        
        dialog = new JDialog((Frame) null, title, false); 
        dialog.setSize(width, height);
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setUndecorated(true);

        this.handler = hand;
        this.diff = diff;

        createProblem();

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
                    if (answer == correct) { // Replace with problem answer
                    	isCorrect = true;
                        HUD.score += diff;
                        inputField.setText("");
                        handler.clearGame();
                        createProblem();
                        
                    } 
                    
                    else {
                        inputField.setText("");
                        HUD.score -= diff;
                        isCorrect = false;
                    }
                } 
                
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialog, "Please enter a valid number.");
                    inputField.setText("");
                }
              
            } 
        });

        //location on screen
        dialog.setLocation(Game.WIDTH/2+800, Game.HEIGHT/2+100);
    }

    public void createProblem() {
    	MathProblem problem = new MathProblem(Game.WIDTH/2-40, Game.HEIGHT/2+500, diff, ID.MathProblem);
		handler.addObject(new Player(Game.WIDTH/2-32, Game.HEIGHT/2-32, ID.Player));					//render and location of avatar on screen
		handler.addObject(problem);
		correct = problem.getCorrectAnswer();
    }
 
    public boolean getIsCorrect() {
    	return isCorrect;
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