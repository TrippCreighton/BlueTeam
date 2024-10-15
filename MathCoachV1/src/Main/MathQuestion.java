package Main;

public class MathQuestion {
import java.util.Scanner;
import java.util.Random;

public class MathQuestion {
	
	private int operandOne;
	private int operandTwo;
	private String correctAnswer;
	private String userAnswer;
	private double timeTaken;
	private boolean isCorrect;
	private double startTime;
	private double endTime;
	
	//Constructor
	public MathQuestion() {
		operandOne = 0;
		operandTwo = 0;
		correctAnswer = "";
		userAnswer = "";
		timeTaken = 0.0;
		isCorrect = false;
		startTime = 0;
		endTime = 0;
	}
	
	//Print statements are for testing
	public void genProblem() {
		setOperands();
		System.out.println("Solve: " + operandOne + " + " + operandTwo);
		setCorrectAnswer();
		System.out.println("Correct Answer: " + correctAnswer);
		setUserAnswer();
		System.out.println("User Answer: " + userAnswer);
		setIsCorrect();
		System.out.println("Is Correct?: " + isCorrect);
		setTimeTaken();
		System.out.println("Time Taken: " + timeTaken);
		System.out.println();
	}
	
	//sets the two operand variables to random numbers within range
	public void setOperands() {
		operandOne = getRandomNumber();
		operandTwo = getRandomNumber();
	}
	
	//Setters
	
	//sets the correctAnswer variable to the correct answer
	public void setCorrectAnswer() {
		correctAnswer = Integer.toString(operandOne + operandTwo);
	}
	
	//sets input from user and sets userAnswer variable to the input
	public void setUserAnswer() {
		startTime = System.currentTimeMillis();
		System.out.println("Enter Answer: ");
		Scanner scanner = new Scanner(System.in);
		int answer = scanner.nextInt();
		userAnswer = Integer.toString(answer);
		endTime = System.currentTimeMillis();
	}
	
	//Finds the elapsed time, calls the format method to format it, and sets time taken to it.
	public void setTimeTaken() {
		timeTaken = formatTime(endTime - startTime);
		}
	
	//sets isCorrect based on if correctAnswer equals userAnswer
	public void setIsCorrect() {
		if (correctAnswer.equals(userAnswer)) {
			isCorrect = true;
		}
		else {
			isCorrect = false;
		}
	}
	
	//Getters
	public int getOperandOne() {
		return operandOne;
	}
	
	public int getOperandTwo() {
		return operandTwo;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	
	public String getUserAnswer() {
		return userAnswer;
	}
	
	public double getTimeTaken() {
		return timeTaken;
	}
	
	public boolean getIsCorrect() {
		return isCorrect;
	}
	
	//generates a random number from 1 to 9
	private int getRandomNumber() {
		Random r = new Random();
		int num = r.nextInt((9 - 1) + 1) + 1;
		return num;
	}
	
	//formats elapsed time into seconds
	 private double formatTime(double d) {
		double seconds = d / 1000;
		return seconds;
	}
}
