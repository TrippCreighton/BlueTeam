package Main;

/**
 * User class will store complex meta data about the user
 * of the math coach program. the primary function of this 
 * class will be to calculate setting values if the user
 * selects to have adaptive questioning. This class will also 
 * store the user's settings and overall score 
 */

import java.util.ArrayList;
import java.util.List;

public class User {

	private int averScore;
	private int avatarVal;
	private int userSpeed;
	private int userDifficult;
	private int adaptSpeed;
	private int adaptDifficult;
	private int sessionNum;
	private boolean isAdaptive;
	List<MathQuestion> correctQuestion = new ArrayList<>();
	List<MathQuestion> wrongQuestion = new ArrayList<>();
	
	//Constructor
	public User() { 
		averScore = 0;
		avatarVal = 0;
		userSpeed = 0;
		sessionNum = 0;
		userDifficult = 0;
		isAdaptive = false;
	}
	
	
	public void addCorrectQuestion (MathQuestion question) {
		correctQuestion.add(question);
	}
	
	public void addWrongQuestion (MathQuestion question) {
		wrongQuestion.add(question);
	}
	
	
	//Adaptive methods
	
		//THIS METHOD IS UNFINISHED/ THIS IS A SIMPLE VERSION
		public void calAdaptDifficult() {
			List<Integer> corrOperand = new ArrayList<>();
			List<Integer> wrongOperand = new ArrayList<>();
			for (MathQuestion question : correctQuestion) {
				corrOperand.add(question.getOperandOne());
				corrOperand.add(question.getOperandTwo());
			}
			for (MathQuestion question : wrongQuestion) {
				wrongOperand.add(question.getOperandOne());
				wrongOperand.add(question.getOperandTwo());
			}
			if ((corrOperand.size() > wrongOperand.size()) && adaptDifficult < 3) {
				adaptDifficult ++;
			}
			if ((corrOperand.size() < wrongOperand.size()) && adaptDifficult > 0) {
				adaptDifficult --;
			}
		}

		//THIS METHOD IS UNFINISHED/ THIS IS A SIMPLE VERSION
		public void calAdaptSpeed() {
			int total = 0;
			int count = 0;
			for (MathQuestion question : correctQuestion) {
				total = (int) (total + question.getTimeTaken());
				count ++;
			}
			adaptSpeed = (total / count) - 1;
		}
	
	//Setters
	
	public void addScore(int change) {
		averScore = (averScore + change) / sessionNum;
		sessionNum ++;
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
	
	public void setAdaptive(boolean isAdaptive) {
		this.isAdaptive = isAdaptive;
	}
	
	//Getters
	
	public int getScore() {
		return averScore;
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

	public int getAdaptDifficult() {
		return adaptDifficult;
	}

	public int getAdaptSpeed() {
		return adaptSpeed;
	}

	public boolean isAdaptive() {
		return isAdaptive;
	}
	
	

	
	
}
