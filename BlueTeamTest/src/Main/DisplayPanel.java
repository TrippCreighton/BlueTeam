package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DisplayPanel extends JPanel implements Runnable{
	
	//SCREEN SETTINGS
	final int originalTileSize = 16; // 16 bit resolution
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;//48x48
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread displayThread;
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public DisplayPanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startDisplayThread() {
		displayThread = new Thread(this);
		displayThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		

		while(displayThread != null) {
			
			update();
			
			repaint();
			
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				if(remainingTime < 0) {
					remainingTime = 0;
				}

				Thread.sleep((long)remainingTime);
				
				nextDrawTime += drawInterval;
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	public void update() {
		
		if(keyH.upPressed) {
			playerY -= playerSpeed;
		}
		else if(keyH.downPressed) {
			playerY += playerSpeed;
		}
		else if(keyH.leftPressed) {
			playerX -= playerSpeed;
		}
		else if(keyH.rightPressed) {
			playerX += playerSpeed;
		}
	}
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		g2.dispose();
	}

}
