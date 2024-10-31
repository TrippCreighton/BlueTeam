package Main;

import java.text.DecimalFormat;
public class Session {

	
	private long startTime;
	private long endTime;
	private long elapsedTime;
	private long seconds;
	private double problemCount;
	private double correctAnswerCount;
	private double incorrectAnswerCount;
	private double timeTaken;
	private double totalTime;
	private double accuracy;
	private double timePerProblem;
	private String stringAccuracy;
	private String stringTimePerProblem;
	private Boolean isCorrect;
	
	public Session() {
		startTime = 0;
		endTime = 0;
		elapsedTime = 0;
		seconds = 20;
		problemCount = 0.0;
		correctAnswerCount = 0.0;
		incorrectAnswerCount = 0.0;
		timeTaken = 0.0;
		totalTime = 0.0;
		accuracy = 0.0;
		timePerProblem = 0.0;
		stringAccuracy = "";
		stringTimePerProblem = "";
		isCorrect = false;
	}
	
	//The main gameplay loop
	public void play() {
		startTime = System.currentTimeMillis();
		do {
			MathQuestion question = new MathQuestion();
			question.genProblem();
			timeTaken = question.getTimeTaken();
			isCorrect = question.getIsCorrect();
			updateCounts();
			calculateAccuracy();
			calculateTimePerProblem();
			getElapsedTime();
			question = null;
		} while (elapsedTime < seconds);
		
		//Print statements are for testing
		System.out.println("Problem Count: " + (int)problemCount);
		System.out.println("Correct Answers: " + (int)correctAnswerCount);
		System.out.println("Incorrect Answer: " + (int)incorrectAnswerCount);
		System.out.println("Accuracy: " + stringAccuracy + "%");
		System.out.println("Average Time: " + stringTimePerProblem + " seconds per problem");
	}
	
	public void getElapsedTime() {
		endTime = System.currentTimeMillis();
		elapsedTime = (endTime - startTime) / 1000;
	}
	
	public void updateCounts() {
		problemCount++;
		
		if (isCorrect) {
			correctAnswerCount++;
		} else {
			incorrectAnswerCount++;
		}
	}
	
	public void calculateAccuracy() {
		accuracy = (correctAnswerCount / problemCount) * 100;
		stringAccuracy = String.format("%.1f", accuracy);
	}
	
	public void calculateTimePerProblem() {
		totalTime = totalTime + timeTaken;
		timePerProblem = totalTime/problemCount;
		stringTimePerProblem = String.format("%.1f", timePerProblem);
	}
	
	//Getters
	public double getTotalTime() {
		return totalTime;
	}
	
	public double getAccuracy() {
		return accuracy;
	}
	
	public double getProblemCount() {
		return problemCount;
	}
	
	public double getCorrectCount() {
		return correctAnswerCount;
	}
	
	public double getincorrectCount() {
		return incorrectAnswerCount;
	}
	
	public double getTimePerProblem() {
		return timePerProblem;
	}
}
