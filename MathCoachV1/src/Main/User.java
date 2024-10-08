package Main;

public class User {

	private int score;
	private int avatarVal;
	private int userSpeed;
	private int userDifficult;
	
	//Constructor
	public User() { 
		score = 0;
		avatarVal = 0;
		userSpeed = 0;
		userDifficult = 0;
	}
	
	//Setters
	public void changeScore(int change) {
		score = score + change;
	}
	
	public void changeAvatar(int change) {
		avatarVal = change;
	}
	
	public void changeUserSpeed(int change) {
		userSpeed = change;
	}
	
	public void changeUserDifficult(int change) {
		userDifficult = change;
	}
	
	
	//Getters
	public int getScore() {
		return score;
	}
	
	public int getAvatar() {
		return avatarVal;
	}
	
	public int getUserSpeed() {
		return userSpeed;
	}
	
	public int getUserDifficult() {
		return userDifficult;
	}
}
