package Main;

import java.awt.Color;
import java.awt.Dimension;

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
	
	Thread displayThread;
	
	public DisplayPanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
	
	public void startDisplayThread() {
		displayThread = new Thread(this);
		displayThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
