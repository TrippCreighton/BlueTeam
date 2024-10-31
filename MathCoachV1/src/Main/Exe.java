package Main;

public class Exe {

	public static void main(String[] args) {
		
		Thread gameThread = new Thread(new Intro());
		gameThread.run();
	}

}
