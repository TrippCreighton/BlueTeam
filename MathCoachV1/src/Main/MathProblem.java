package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import Main.Game.STATE;

public class MathProblem extends GameObject {
	
	public static String problem = "4 + 4 = ";						//generate problems in random order and assign the to problem variable as a string

	public MathProblem(int x, int y, ID id) {
		super(x, y, id);
		
	}
	
	public static void setProblem(String mProblem) {
		problem = mProblem;									//pass problems through here as a string to be output to screen
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Game) {
			g.setColor(Color.white);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
			g.drawString(problem, 450, 400);
		}
	}
	

}
