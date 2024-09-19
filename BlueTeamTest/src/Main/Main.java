package Main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Display Test");
		
		DisplayPanel displayPanel = new DisplayPanel();
		window.add(displayPanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
} 