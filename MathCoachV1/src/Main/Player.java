package Main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import Main.Game.STATE;

public class Player extends GameObject {
	
	public static String imagePath = "resources/Character1.png";

	public Player(int x, int y, ID id) {
		super(x, y, id);
		
	}
	
	public static void setChar() {
		int Char = Integer.parseInt(XMLReader.readCharacter("UserData.xml"));
		if(Char == 2) {
			imagePath = "resources/Character2.png";
		}
		else if(Char == 3) {
			imagePath = "resources/Character3.png";
		}
		else if(Char == 4) {
			imagePath = "resources/Character4.png";
		}
		else if(Char == 5) {
			imagePath = "resources/Character5.png";
		}
		else {
			imagePath = "resources/Character1.png";
		}
	}

	
	public void tick() {
		
		
	}

	
	public void render(Graphics g) {
		if(Game.gameState == STATE.Game) {
			g.drawImage(new ImageIcon(imagePath).getImage(), -100, 150, null);								//add image path to render in player avatar
		}
	}
	

}
