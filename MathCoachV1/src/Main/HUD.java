package Main;

import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	public static int score = 0;
	public static int time = 0;
	public static int session = Integer.parseInt(XMLReader.readSession("UserData.xml"));
	public static int maxScore = 0;
	public static int maxTime = 0;
	
	
	public void tick() {
		time ++;
		}
	
	public void render(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("SCORE: " + score + " / " + maxScore, 700, 38);
		g.drawString("TIME: " + time/120 + " / " + maxTime/120, 500, 38);
		g.drawString("SESSION: " + XMLReader.readSession("UserData.xml"), 300, 38);
	}
	
	public void score(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void time(int time) {
		this.time= time;
	}
	
	public int getTime() {
		return time/120;
	}
	
	public int getSession() {
		return session;
	}
	
	public void updateSession() {
		
	}

}
