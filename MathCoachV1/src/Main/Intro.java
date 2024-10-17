package Main;

import javax.swing.*;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.awt.*;

public class Intro extends JPanel implements Runnable {
	
	private JFrame window = new JFrame();
	private String imagePath = "Intro.png";
	private int wait = 2000; // 2 seconds
	private String audioFile = "bg-music.wav";
	
	public Intro(){
		playAudio();
		this.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT));
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void playAudio() {
		try {
		File audioPath = new File(audioFile);
		GameManager.stream = AudioSystem.getAudioInputStream(audioPath);
		GameManager.clip = AudioSystem.getClip();
		GameManager.clip.open(GameManager.stream);
		GameManager.clip.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g) {
		g.drawImage(new ImageIcon(imagePath).getImage(), -100, -300, null);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(wait);
			window.dispose();
			Menu menu = new Menu();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
