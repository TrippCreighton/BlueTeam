package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Main.Game.STATE;

public class Menu extends MouseAdapter {
	
	
	private Game game;
	private Handler handler;
	private HUD hud;
	
	private String image1 = "resources/Char_Select1.png";
	private String image2 = "resources/Char_Select2.png";
	private String image3 = "resources/Char_Select3.png";
	private String image4 = "resources/Char_Select4.png";
	private String image5 = "resources/Char_Select5.png";
	
	private boolean isAdapt;
	private int difficult;
	private int reqScore = 30;
	private int reqTime = 3600;
	private String sessionNum = XMLReader.readSession("UserData.xml");
	private String scoreNum = XMLReader.readScore("UserData.xml");
	
	public Menu(Game game, Handler handler, HUD hud) {
		HUD.score = 0;
		HUD.time = 0;
		calcAdaptDiff();
		Player.setChar();
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public int getDiff() {
		return difficult;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		//play button
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 335, 300, 300, 80)) {
				game.gameState = STATE.Game;
				
				Player.setChar();
				calcAdaptDiff();
				calcReqTimeReqQuest(HUD.time);
				
				HUD.time = 0;
				HUD.score = 0;
				
				HUD.maxScore = reqScore;
				HUD.maxTime = reqTime;

				AnswerBox box = new AnswerBox(100, 100, "Answer Box", handler, difficult);
				box.show();
				
				return;
			}
		}
		//try again button
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my, 335, 500, 300, 80)) {
				
				//Update Super-Score
				HUD.score = HUD.score + Integer.parseInt(XMLReader.readScore("UserData.xml"));
				XMLWriter.updateScoreXML("UserData.xml", HUD.score);
				calcReqTimeReqQuest(HUD.time);
				//reset HUD values
				HUD.time = 0;
				HUD.score = 0;
				
	
				//Updates user values before starting the next session
				Player.setChar();
				
				calcAdaptDiff();
				
				//Updates the session counter
				XMLWriter.updateSessionXML("UserData.xml", 1 + Integer.parseInt(XMLReader.readSession("UserData.xml")));
				
				//Calculates the adaptive settings
				
				
				HUD.maxTime = reqTime;
				HUD.maxScore = reqScore;
				game.gameState = STATE.Game;
				
				AnswerBox box = new AnswerBox(100, 100, "Answer Box", handler, difficult);
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
				
				sessionNum = XMLReader.readSession("UserData.xml");
				scoreNum = XMLReader.readScore("UserData.xml");
				
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
		
		//Delete data
		if(game.gameState == STATE.Options) {
			if(mouseOver(mx, my, 335, 200, 300, 80)) {
				String filePath = "UserData.xml";  // Path to the XML file

		        // Create a File object for the XML file
		        File file = new File(filePath);

		        // Check if the file exists and delete it
		        if (file.exists()) {
		            boolean deleted = file.delete();  // Try to delete the file
		            if (deleted) {
		                XMLWriter.writeXML(filePath);
		            } else {
		            }
		        } else {
		        }
				return;
			}
		}
		
		//Char selections
		if(game.gameState == STATE.Char) {
			if(mouseOver(mx, my, 50, 400, 100, 100)) {
				int Char = 1;
				XMLWriter.updateCharacterXML("UserData.xml", Char);
				Player.setChar();
				return;
			}
			else if(mouseOver(mx, my, 250, 400, 100, 100)) {
				int Char = 2;
				XMLWriter.updateCharacterXML("UserData.xml", Char);
				Player.setChar();
				return;
			}
			else if(mouseOver(mx, my, 450, 400, 100, 100)) {
				int Char = 3;
				XMLWriter.updateCharacterXML("UserData.xml", Char);
				Player.setChar();
				return;
			}
			else if(mouseOver(mx, my, 650, 400, 100, 100)) {
				int Char = 4;
				XMLWriter.updateCharacterXML("UserData.xml", Char);
				Player.setChar();
				return;
			}
			else if(mouseOver(mx, my, 850, 400, 100, 100)) {
				int Char = 5;
				XMLWriter.updateCharacterXML("UserData.xml", Char);
				Player.setChar();
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
				
				isAdapt = false;
				XMLWriter.updateAdaptXML("UserData.xml", 0);
				
				difficult = 3; //sets difficulty to easy
				XMLWriter.updateDifficultXML("UserData.xml", 3);
			}
			else if(mouseOver(mx, my, 390, 300, 200, 80)) {
				
				isAdapt = false;
				XMLWriter.updateAdaptXML("UserData.xml", 0);
				
				difficult = 6; //sets difficulty to easy normal
				XMLWriter.updateDifficultXML("UserData.xml", 6);
			}
			else if(mouseOver(mx, my, 700, 300, 200, 80)) {
				
				isAdapt = false;
				XMLWriter.updateAdaptXML("UserData.xml", 0);
				
				difficult = 9; //sets difficulty to easy hard
				XMLWriter.updateDifficultXML("UserData.xml", 9);
			}
			else if(mouseOver(mx, my, 390, 450, 200, 80)) {
				
				isAdapt = true;
				XMLWriter.updateAdaptXML("UserData.xml", 1);
			}
		}
		
		//exit button
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx, my, 335, 500, 300, 80)) {
				System.exit(1);
				return;
			}
		}
		//back button
		if(game.gameState == STATE.End) {
			if(mouseOver(mx, my, 335, 600, 300, 80)) {
				
				HUD.score = HUD.score + Integer.parseInt(XMLReader.readScore("UserData.xml"));
				XMLWriter.updateScoreXML("UserData.xml", HUD.score);
				calcReqTimeReqQuest(HUD.time);
				
				HUD.time = 0;
				HUD.score = 0;
				
				XMLWriter.updateSessionXML("UserData.xml", 1 + Integer.parseInt(XMLReader.readSession("UserData.xml")));
				
				sessionNum = XMLReader.readSession("UserData.xml");
				scoreNum = XMLReader.readScore("UserData.xml");
				
				game.gameState = STATE.Menu;
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
				return true;//making sure button is clickable within it's parameters
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
		if(difficult == 3 && !isAdapt) {
			reqScore = 30;
			reqTime = 3600;
		}
		
		if(difficult == 6 && !isAdapt) {
			reqScore = 60;
			reqTime = 2400;
		}
		
		if(difficult == 9 && !isAdapt) {
			reqScore = 100;
			reqTime = 1200;
		}
		
		
		
		
		
		if(HUD.score >= reqScore || HUD.time > reqTime) {
			
			if(isAdapt) {
				
		}
			
			AnswerBox.close();
			handler.clearGame();
			game.gameState = STATE.End;

		}
	}
	
	public void render(Graphics g) {
		if(game.gameState == STATE.Menu) {
		Font fnt = new Font("arial", 1, 120);
		Font fnt2 = new Font("arial", 1, 60);
		Font fnt3 = new Font("arial", 1, 30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("MATH", 320, 150);
		g.drawString("COACH", 260, 260);
		
		g.setFont(fnt2);
		g.drawString("PLAY", 405, 360);
		g.setColor(Color.white);
		g.drawRect(335, 300, 300, 80);
		
		g.setFont(fnt3);
		g.drawString("SUPER SCORE", 70, 360);
		g.setColor(Color.white);
		g.setFont(fnt2);
		g.drawString(scoreNum, 130, 420);
		g.setColor(Color.white);
		
		g.setFont(fnt3);
		g.drawString("CURRENT SESSION", 650, 360);
		g.setColor(Color.white);
		g.setFont(fnt2);
		g.drawString(sessionNum, 750, 420);
		g.setColor(Color.white);
		
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
			String diffy ="";
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("OPTIONS", 220, 180);
			
			g.setFont(fnt3);
			g.drawString("DIFFICULTY", 365, 355);
			g.setColor(Color.white);
			g.drawRect(335, 300, 300, 80);
			
			g.setFont(fnt3);
			g.drawString("CURRENT ", 50, 250);
			g.setColor(Color.white);
			
			g.setFont(fnt3);
			g.drawString(" DIFFICULTY:", 40, 300);
			g.setColor(Color.white);
			
			if(difficult == 3)
				diffy = "EASY";
			if(difficult == 6)
				diffy = "NORMAL";
			if(difficult == 9)
				diffy = "HARD";
			
			if(!isAdapt) {
				g.setFont(fnt3);
				g.drawString(diffy, 40, 400);
				g.setColor(Color.white);
			}
			
			if(isAdapt) {
				g.setFont(fnt3);
				g.drawString("CURRENTLY", 40, 400);
				g.setColor(Color.white);
				
				g.setFont(fnt3);
				g.drawString("ADAPTIVE", 40, 450);
				g.setColor(Color.white);
			}
			
			g.setFont(fnt3);
			g.drawString("DELETE DATA", 345, 250);
			g.setColor(Color.white);
			g.drawRect(335, 200, 300, 80);
			
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
			g.drawString("SCORE: " + hud.getScore(), 340, 390);
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
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString("ADAPTIVE", 392, 500);
			g.setColor(Color.white);
			g.drawRect(390, 450, 200, 80);
			
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
	
	private void calcReqTimeReqQuest(int timeTaken){
		if(isAdapt) {
			int superScore = Integer.parseInt(XMLReader.readScore("UserData.xml"));
			int superSession = Integer.parseInt(XMLReader.readSession("UserData.xml"));
			
			if (superScore / superSession > 20) {
				difficult = 9;
				reqScore += 5;
				reqTime -= 300;
			}
			
			else if(superScore / superSession >= 10) {
				difficult = 6;
				reqScore++;
				reqTime -= 300;
			}
			
			else {
				difficult = 3;
				reqScore--;
				reqTime += 300;
			}
			
			
			//Fail safe in case requirements get too extreme
			if(reqScore < 5)
				reqScore = 5;
			
			if(reqScore > 150)
				reqScore = 150;
			
			if(reqTime < 1000)
				reqTime = 1000;
			
			if(reqTime > 4000)
				reqTime = 4000;

		}
		
		else {
			if(difficult == 3 && !isAdapt) {
				reqScore = 30;
				reqTime = 3600;
			}
			
			if(difficult == 6 && !isAdapt) {
				reqScore = 60;
				reqTime = 2400;
			}
			
			if(difficult == 9 && !isAdapt) {
				reqScore = 100;
				reqTime = 1200;
			}
		}
	}
	
	private void calcAdaptDiff() {
		if(0 == Integer.parseInt(XMLReader.readAdapt("UserData.xml")))
			isAdapt = false;
		
		if(1 == Integer.parseInt(XMLReader.readAdapt("UserData.xml")))
			isAdapt = true;
		
		if(!isAdapt) {
		
			if(3 == Integer.parseInt(XMLReader.readDifficult("UserData.xml"))) {
				difficult = 3;
			}
		
			if(6 == Integer.parseInt(XMLReader.readDifficult("UserData.xml"))) {
				difficult = 6;
			}
		
			if(9 == Integer.parseInt(XMLReader.readDifficult("UserData.xml"))) {
				difficult = 9;
			}
		}
	}

}