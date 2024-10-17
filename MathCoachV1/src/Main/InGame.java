package Main;

import javax.swing.*;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;

public class InGame extends JPanel implements Runnable {
	
	private JFrame window = new JFrame();
	private String imagePath = "Menu1.png";
	//private int wait = 2000; // 2 seconds
	
	public InGame(){
		this.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT));
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);

	}
	
	
	public void paint(Graphics g) {
		g.drawImage(new ImageIcon(imagePath).getImage(), -70, -300, null);
	}
	

	@Override
	public void run() {
		try {
			Thread.sleep(null);
			window.dispose();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
