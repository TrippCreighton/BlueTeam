package Main;

import javax.swing.*;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.awt.*;

public class Intro extends JPanel implements Runnable {
	
	private JFrame window = new JFrame();
	private String imagePath = "Intro.png";
	private int wait = 2000; // 2 seconds
	private String audioFile = "Menu_Music.wav";
	
	public Intro(){
		playAudio();
		this.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
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
		IntroManager.stream = AudioSystem.getAudioInputStream(audioPath);
		IntroManager.clip = AudioSystem.getClip();
		IntroManager.clip.open(IntroManager.stream);
		IntroManager.clip.start();
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
			Game game = new Game();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
