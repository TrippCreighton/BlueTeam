package Main;

import javax.swing.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import java.io.File;
import java.awt.*;

public class Intro extends JPanel implements Runnable {
	
	private JFrame window = new JFrame();
	private String imagePath = "Intro.png";
	private int wait = 4000; // 4 seconds
	private static String audioFile = "Menu_Music.wav";
	private static String audioFile2 = "Audio_2.wav";
	private static String audioFile3 = "Audio_3.wav";
	private static String audioFile4 = "Audio_4.wav";
	
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
	
	public static void playAudio() {
	    try {
	        File audioPath = new File(audioFile);
	        IntroManager.stream = AudioSystem.getAudioInputStream(audioPath);
	        IntroManager.clip = AudioSystem.getClip();
	        IntroManager.clip.open(IntroManager.stream);

	        // Add a LineListener to restart the song when it finishes
	        IntroManager.clip.addLineListener(new LineListener() {
	            @Override
	            public void update(LineEvent event) {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    IntroManager.clip.setFramePosition(0);  // Reset to the beginning of the audio
	                    IntroManager.clip.start();              // Restart the audio
	                }
	            }
	        });

	        IntroManager.clip.start();  // Start the song

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void playAudio2() {
	    try {
	        File audioPath = new File(audioFile2);
	        IntroManager.stream = AudioSystem.getAudioInputStream(audioPath);
	        IntroManager.clip = AudioSystem.getClip();
	        IntroManager.clip.open(IntroManager.stream);

	        // Add a LineListener to restart the song when it finishes
	        IntroManager.clip.addLineListener(new LineListener() {
	            @Override
	            public void update(LineEvent event) {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    IntroManager.clip.setFramePosition(0);  // Reset to the beginning of the audio
	                    IntroManager.clip.start();              // Restart the audio
	                }
	            }
	        });

	        IntroManager.clip.start();  // Start the song

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void playAudio3() {
	    try {
	        File audioPath = new File(audioFile3);
	        IntroManager.stream = AudioSystem.getAudioInputStream(audioPath);
	        IntroManager.clip = AudioSystem.getClip();
	        IntroManager.clip.open(IntroManager.stream);

	        // Add a LineListener to restart the song when it finishes
	        IntroManager.clip.addLineListener(new LineListener() {
	            @Override
	            public void update(LineEvent event) {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    IntroManager.clip.setFramePosition(0);  // Reset to the beginning of the audio
	                    IntroManager.clip.start();              // Restart the audio
	                }
	            }
	        });

	        IntroManager.clip.start();  // Start the song

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public static void playAudio4() {
	    try {
	        File audioPath = new File(audioFile4);
	        IntroManager.stream = AudioSystem.getAudioInputStream(audioPath);
	        IntroManager.clip = AudioSystem.getClip();
	        IntroManager.clip.open(IntroManager.stream);

	        // Add a LineListener to restart the song when it finishes
	        IntroManager.clip.addLineListener(new LineListener() {
	            @Override
	            public void update(LineEvent event) {
	                if (event.getType() == LineEvent.Type.STOP) {
	                    IntroManager.clip.setFramePosition(0);  // Reset to the beginning of the audio
	                    IntroManager.clip.start();              // Restart the audio
	                }
	            }
	        });

	        IntroManager.clip.start();  // Start the song

	    } catch (Exception e) {
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
