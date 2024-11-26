package Main;

import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	public static int score = 0;
	public static int time = 0;
	
	
	public void tick() {
		time ++;
		}
	
	public void render(Graphics g) {
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("SCORE: " + score, 700, 38);
		g.drawString("TIME: " + time/120, 500, 38);
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

}
