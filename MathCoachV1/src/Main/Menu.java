package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private static JFrame frame;
	

	private static void setupStartButton(Container pane) {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT/5));
		button.setIcon(new ImageIcon("start.png"));
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InGame ingame = new InGame();
				JOptionPane.showMessageDialog(null, "Under Construction");
			}
		});
		
		pane.add(button, BorderLayout.PAGE_START);
	}
	
	private static void setupOptionsButton(Container pane) {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH/5, GameManager.SCREEN_HEIGHT/3));
		button.setIcon(new ImageIcon("q.png"));
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(null, "options has been pressed");
			}
		});
		
		pane.add(button, BorderLayout.LINE_END);
	}
	
	private static void setupCenterImage(Container pane) {
		JLabel label = new JLabel();
		label.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT/3));
		label.setIcon(new ImageIcon("Chalkboard-Menu.png"));
		pane.add(label, BorderLayout.CENTER);
	}
	
	private static void setupExitButton(Container pane) {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH/5, GameManager.SCREEN_HEIGHT/3));
		button.setIcon(new ImageIcon("exit.png"));
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Exit button has been pressed");
				
				try {
					GameManager.stream.close();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		pane.add(button, BorderLayout.LINE_START);
	}
	
	public static void addComponents(Container pane) {
		pane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
		setupStartButton(pane);
		setupCenterImage(pane);
		setupOptionsButton(pane);
		setupExitButton(pane);
	}
	
	private static void createFrame() {
		frame = new JFrame("MENU");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponents(frame.getContentPane());
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public Menu() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				createFrame();
			}
		});
	}
	
}
