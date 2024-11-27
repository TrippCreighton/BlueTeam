package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Main.Game.STATE;

public class Menu extends MouseAdapter {
	
	
	private Game game;
	private Handler handler;
	private HUD hud;
	
	private String image1 = "Char_Select1.png";
	private String image2 = "Char_Select2.png";
	private String image3 = "Char_Select3.png";
	private String image4 = "Char_Select4.png";
	private String image5 = "Char_Select5.png";
	
	public Menu(Game game, Handler handler, HUD hud) {
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//play button
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 335, 300, 300, 80)) {
				game.gameState = STATE.Game;

				AnswerBox box = new AnswerBox(100, 100, "Answer Box", handler);
				box.show();
				
				return;
			}
		}
		//try again button
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my, 335, 500, 300, 80)) {
				HUD.time = 0;
				HUD.score = 0;
				game.gameState = STATE.Game;

				AnswerBox box = new AnswerBox(100, 100, "Answer Box", handler);
				box.show();
				
				return;
			}
		}
		
		//options button
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 335, 400, 300, 80)) {
				game.gameState = STATE.Options;
				return;
			}
		}
			
		//back button for options
		if(game.gameState == STATE.Options) {
			if(mouseOver(mx, my, 335, 600, 300, 80)) {
				game.gameState = STATE.Menu;
				return;
			}
		}
		
		//Dif menu
		if(game.gameState == STATE.Options) {
			if(mouseOver(mx, my, 335, 300, 300, 80)) {
				game.gameState = STATE.Dif;
				return;
			}
		}
		
		//Character menu
		if(game.gameState == STATE.Options) {
			if(mouseOver(mx, my, 335, 500, 300, 80)) {
				game.gameState = STATE.Char;
				return;
			}
		}
		
		//Char selections
		if(game.gameState == STATE.Char) {
			if(mouseOver(mx, my, 50, 400, 100, 100)) {
				int Char = 1;
				Player.setChar(Char);
				return;
			}
			else if(mouseOver(mx, my, 250, 400, 100, 100)) {
				int Char = 2;
				Player.setChar(Char);
				return;
			}
			else if(mouseOver(mx, my, 450, 400, 100, 100)) {
				int Char = 3;
				Player.setChar(Char);
				return;
			}
			else if(mouseOver(mx, my, 650, 400, 100, 100)) {
				int Char = 4;
				Player.setChar(Char);
				return;
			}
			else if(mouseOver(mx, my, 850, 400, 100, 100)) {
				int Char = 5;
				Player.setChar(Char);
				return;
			}
		}
		
		//Char back button
		if(game.gameState == STATE.Char) {
			if(mouseOver(mx, my, 335, 600, 300, 80)) {
				game.gameState = STATE.Options;
				return;
			}
		}
		
		//Dif back button
		if(game.gameState == STATE.Dif) {
			if(mouseOver(mx, my, 335, 600, 300, 80)) {
				game.gameState = STATE.Options;
				return;
			}
		}
		
		//easy, normal, hard buttons
		if(game.gameState == STATE.Dif) {
			if(mouseOver(mx, my, 80, 300, 200, 80)) {
				
				//easy clicked, make speed/problem difficulty match easy
			}
			else if(mouseOver(mx, my, 390, 300, 200, 80)) {
				
				//normal clicked, make speed/problem dif. match normal
			}
			else if(mouseOver(mx, my, 700, 300, 200, 80)) {
				
				//hard clicked, make speed/problem difficulty match hard
			}
		}
		
		//exit button
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 335, 500, 300, 80)) {
				System.exit(1);
				return;
			}
		}
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my, 335, 600, 300, 80)) {
				System.exit(1);
				return;
			}
		}
		//Music menu
		if(game.gameState == STATE.Options) {
			if(mouseOver(mx, my, 335, 400, 300, 80)) {
				game.gameState = STATE.Music;
				return;
			}
		}
		//music back button
		if(game.gameState == STATE.Music) {
			if(mouseOver(mx, my, 335, 600, 300, 80)) {
				game.gameState = STATE.Options;
				return;
			}
		}
		if(game.gameState == STATE.Music) {
			if(mouseOver(mx, my, 80, 300, 200, 80)) {
				IntroManager.clip.stop();
				IntroManager.clip.close();
				Intro.playAudio2();
			}
			else if(mouseOver(mx, my, 390, 300, 200, 80)) {
				IntroManager.clip.stop();
				IntroManager.clip.close();
				Intro.playAudio3();
			}
			else if(mouseOver(mx, my, 700, 300, 200, 80)) {
				IntroManager.clip.stop();
				IntroManager.clip.close();
				Intro.playAudio4();
			}
			else if(mouseOver(mx, my, 390, 450, 200, 80)) {
				IntroManager.clip.stop();
				IntroManager.clip.close();
				Intro.playAudio();
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;															//making sure button is clickable within it's parameters
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("arial", 1, 120);
		Font fnt2 = new Font("arial", 1, 60);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("MATH", 320, 150);
		g.drawString("COACH", 260, 260);
		
		g.setFont(fnt2);
		g.drawString("PLAY", 405, 360);
		g.setColor(Color.white);
		g.drawRect(335, 300, 300, 80);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("OPTIONS", 350, 465);
		g.setColor(Color.white);
		g.drawRect(335, 400, 300, 80);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("EXIT", 415, 562);
		g.setColor(Color.white);
		g.drawRect(335, 500, 300, 80);
		
		}
		else if(game.gameState == STATE.Options) {
			Font fnt = new Font("arial", 1, 120);
			Font fnt2 = new Font("arial", 1, 60);
			Font fnt3 = new Font("arial", 1, 40);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("OPTIONS", 220, 200);
			
			g.setFont(fnt3);
			g.drawString("DIFFICULTY", 365, 355);
			g.setColor(Color.white);
			g.drawRect(335, 300, 300, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("MUSIC", 420, 455);
			g.setColor(Color.white);
			g.drawRect(335, 400, 300, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("CHARACTER", 357, 555);
			g.setColor(Color.white);
			g.drawRect(335, 500, 300, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("BACK", 425, 656);
			g.setColor(Color.white);
			g.drawRect(335, 600, 300, 80);
			
			
		}
		else if(game.gameState == STATE.End) {
			Font fnt = new Font("arial", 1, 120);
			Font fnt2 = new Font("arial", 1, 60);
			Font fnt3 = new Font("arial", 1, 40);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("GAME OVER", 100, 200);
			
			g.setFont(fnt2);
			g.drawString("SCORE: " + hud.getScore(), 340, 355);
			g.drawString("TIME: " + hud.getTime(), 370, 455);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("TRY AGAIN", 375, 555);
			g.setColor(Color.white);
			g.drawRect(335, 500, 300, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("EXIT", 440, 656);
			g.setColor(Color.white);
			g.drawRect(335, 600, 300, 80);
			
			
		}
		else if(game.gameState == STATE.Char) {
			Font fnt = new Font("arial", 1, 120);
			Font fnt2 = new Font("arial", 1, 60);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("CHARACTER",120, 150);
			g.drawString("SELECTION", 140, 260);
			
			g.setColor(Color.black);
			g.fillRect(50, 400, 100, 100);
			g.setColor(Color.white);
			g.drawRect(50, 400, 100, 100);
			g.drawImage(new ImageIcon(image1).getImage(), 70, 420, null);
			
			g.setColor(Color.black);
			g.fillRect(250, 400, 100, 100);
			g.setColor(Color.white);
			g.drawRect(250, 400, 100, 100);
			g.drawImage(new ImageIcon(image2).getImage(), 270, 420, null);
			
			g.setColor(Color.black);
			g.fillRect(450, 400, 100, 100);
			g.setColor(Color.white);
			g.drawRect(450, 400, 100, 100);
			g.drawImage(new ImageIcon(image3).getImage(), 470, 420, null);
			
			g.setColor(Color.black);
			g.fillRect(650, 400, 100, 100);
			g.setColor(Color.white);
			g.drawRect(650, 400, 100, 100);
			g.drawImage(new ImageIcon(image4).getImage(), 670, 420, null);
			
			g.setColor(Color.black);
			g.fillRect(850, 400, 100, 100);
			g.setColor(Color.white);
			g.drawRect(850, 400, 100, 100);
			g.drawImage(new ImageIcon(image5).getImage(), 870, 420, null);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("BACK", 400, 660);
			g.setColor(Color.white);
			g.drawRect(335, 600, 300, 80);
		}
		else if(game.gameState == STATE.Dif) {
			Font fnt = new Font("arial", 1, 120);
			Font fnt2 = new Font("arial", 1, 60);
			Font fnt3 = new Font("arial", 1, 40);
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("DIFFICULTY", 135, 180);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("EASY", 127, 357);
			g.setColor(Color.white);
			g.drawRect(80, 300, 200, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("NORMAL", 402, 357);
			g.setColor(Color.white);
			g.drawRect(390, 300, 200, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("HARD", 745, 357);
			g.setColor(Color.white);
			g.drawRect(700, 300, 200, 80);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("BACK", 400, 660);
			g.setColor(Color.white);
			g.drawRect(335, 600, 300, 80);
			
			
		}
		else if(game.gameState == STATE.Music) {
			Font fnt = new Font("arial", 1, 120);
			Font fnt2 = new Font("arial", 1, 60);
			Font fnt3 = new Font("arial", 1, 40);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("MUSIC", 300, 160);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString("BACK", 400, 660);
			g.setColor(Color.white);
			g.drawRect(335, 600, 300, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("ONE", 135, 357);
			g.setColor(Color.white);
			g.drawRect(80, 300, 200, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("TWO", 440, 357);
			g.setColor(Color.white);
			g.drawRect(390, 300, 200, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("THREE", 730, 357);
			g.setColor(Color.white);
			g.drawRect(700, 300, 200, 80);
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("FOUR", 430, 505);
			g.setColor(Color.white);
			g.drawRect(390, 450, 200, 80);
		}
	}

}