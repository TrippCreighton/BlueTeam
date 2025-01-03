package Main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1285670934175365101L;
	
	private BufferedImage backgroundImage;
	public static final int WIDTH = 1000, HEIGHT = WIDTH / 12 * 9;            //game window size
	private Thread thread;													  //create thread for game to run on
	private boolean running = false;
	private Handler handler;
	private HUD hud;
	private Menu menu;
	public static XMLWriter writer = new XMLWriter();
	public static XMLReader reader = new XMLReader();
	private int speed;
	private int quests;
	
	public enum STATE{
		Menu,
		Options,
		Game,
		End,
		Char,
		Dif,
		Music,
		Question
		
	};
	
	public static STATE gameState = STATE.Menu;
	
	public Game() {
		handler = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, "Math Coach", this);
		
	      try {
	            backgroundImage = ImageIO.read(new File("resources/Background.jpg")); // Replace with image file path
	        } 
	      catch (IOException e) {
	            e.printStackTrace();
	        }
		

		
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {	//game loop
				tick();
				delta--;	
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		if(gameState == STATE.Game) {
			hud.tick();
			menu.tick();
			
		}
		else if(gameState == STATE.Menu){
			menu.tick();
		}
		else if(gameState == STATE.End){
			menu.tick();
		}
		else if(gameState == STATE.Options){
			menu.tick();
		}
		else if(gameState == STATE.Char){
			menu.tick();
		}
		else if(gameState == STATE.Dif){
			menu.tick();
		}
		else if(gameState == STATE.Music){
			menu.tick();
		}
		else if(gameState == STATE.Question){
			menu.tick();
		}
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {										//creating buffers in game
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
	    if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null); // Adjust WIDTH and HEIGHT if needed
        } else {
            // Fallback to a black background if the image fails to load
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }							//background in game window
		
		handler.render(g);
		
		if(gameState == STATE.Game) {
			hud.render(g);
		}
		else if(gameState == STATE.Question) {
			hud.render(g);
			
		}
		else if(gameState == STATE.Menu){
			menu.render(g);
		}
		else if(gameState == STATE.Options){
			menu.render(g);
		}
		else if(gameState == STATE.End){
			menu.render(g);
		}
		else if(gameState == STATE.Char){
			menu.render(g);
		}
		else if(gameState == STATE.Dif){
			menu.render(g);
		}
		else if(gameState == STATE.Music){
			menu.render(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String args[]) {
		String filePath = "UserData.xml";  // Path to XML file

        // Check if the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            // File doesn't exist, so the file is created
            XMLWriter.writeXML(filePath); 
        }
        

		Thread gameThread = new Thread(new Intro());
		gameThread.start();													//start instance of the game
	}

}