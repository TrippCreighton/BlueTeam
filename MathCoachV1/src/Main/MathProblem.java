package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import Main.Game.STATE;

public class MathProblem extends GameObject {
	
	private String problem;
	private int operandOne;
	private int operandTwo;
	private String correctAnswer;
	private String userAnswer;
	private double timeTaken;
	private boolean isCorrect;
	private double startTime;
	private double endTime;
	
	public MathProblem(int x, int y, ID id) {
		super(x, y, id);
		setOperands();
		setCorrectAnswer();
		setProblem();
		
	}
	
	public void setOperands() {
		operandOne = getRandomNumber();
		operandTwo = getRandomNumber();
	}
	
	public void setProblem() {
		problem =  Integer.toString(operandOne) + " + " + Integer.toString(operandTwo) + " ="; 
		}

	private int getRandomNumber() {
		Random r = new Random();
		int num = r.nextInt((9 - 1) + 1) + 1;
		return num;
	}
	
	public void setCorrectAnswer() {
		correctAnswer = Integer.toString(operandOne + operandTwo);
	}
	
	public int getCorrectAnswer() {
		return operandOne + operandTwo;
	}
	
	public String getProblem() {
		return  Integer.toString(operandOne) + " + " + Integer.toString(operandTwo) + " ="; 
		}
	
	public void tick() {
		setOperands();
		setCorrectAnswer();
		setProblem();
		
	}

	
	public void render(Graphics g) {
	    if (Game.gameState == STATE.Game) {
	    	
	        g.setColor(Color.white);
	        g.setFont(new Font("TimesRoman", Font.PLAIN, 80));
	        g.drawString(problem, 450, 400); // Render the current problem
	    }
	}

	

}