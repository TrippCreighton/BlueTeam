package Main;

import java.util.Scanner;

public class Session {
	
	private int speed;
	private int difficulty;
	private static int rangeHigh;
	private int adaptive;
	private double seconds;
	private double timeLeft;
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
		
		speed = 0;
		difficulty = 0;
		rangeHigh = 0;
		adaptive = 0;
		seconds = 0;
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
		inputSettings();
		setSettings();
		User user = new User();
		Boolean adaptive = user.isAdaptive();
		do {
			MathQuestion question = new MathQuestion();
			Thread timerThread = startTimer();
			if (!adaptive) {
				adaptSettings();
			}
			timerThread.start();
			question.genProblem();
			timerThread.interrupt();
			timeTaken = question.getTimeTaken();
			isCorrect = question.getIsCorrect();
			updateCounts();
			calculateAccuracy();
			calculateTimePerProblem();
			timerThread = null;
			question = null;
			user = null;
		} while (timeLeft > 0);
		
		//Print statements are for testing
		System.out.println("Problem Count: " + (int)problemCount);
		System.out.println("Correct Answers: " + (int)correctAnswerCount);
		System.out.println("Incorrect Answer: " + (int)incorrectAnswerCount);
		System.out.println("Accuracy: " + stringAccuracy + "%");
		System.out.println("Average Time: " + stringTimePerProblem + " seconds per problem");
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
	
	// A thread that will count down and print the timer as the user answers a question
	// if the user solves the question before the timer runs out then the timer is interrupted and reset
	public Thread startTimer() {
		return new Thread(() -> {
			double time = seconds;
			while (time > 0) {
				String stringTime = String.format("%.1f", time);
				System.out.println("Time Left: " + stringTime);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
				time = time - 1;
				timeLeft = time;
			}
			System.out.println("Your out of time, but solve this last question");
		});
	}
	
	// I don't know how this is going to work with the setting menu
	public void inputSettings() {
		
		User user = new User();
		System.out.println("type the number of the Difficulty you want: 1:Easy | 2:Medium | 3:Hard");
		inputDifficulty();
		user.changeUserDifficult(difficulty);
		System.out.println("type the number of the Speed you want: 1:Slow | 2:Medium | 3:Fast");
		inputSpeed();
		user.changeUserSpeed(speed);
		System.out.println("Do you want adaptive speed and difficulty: 1:Yes | 2:No");
		inputAdaptive();
		switch (adaptive) {
		case 1:
			user.setAdaptive(true);
			break;
		case 2:
			user.setAdaptive(false);
			break;
		default:
			user.setAdaptive(false);
		}
	}
	
	public void inputDifficulty() {
		Scanner scanner = new Scanner(System.in);
		try {
			difficulty = scanner.nextInt();
		} catch (Exception e ) {
			System.out.println("Please Input A Number");
			inputDifficulty();
		}
	}
	
	public void inputSpeed() {
		Scanner scanner = new Scanner(System.in);
		try {
			speed = scanner.nextInt();
		} catch (Exception e ) {
			System.out.println("Please Input A Number");
			inputSpeed();
		}
	}
	
	public void inputAdaptive() {
		Scanner scanner = new Scanner(System.in);
		try {
			adaptive = scanner.nextInt();
		} catch (Exception e ) {
			System.out.println("Please Input A Number");
			inputAdaptive();
		}
	}
	
	public void setSettings() {
		switch (speed) {
		case 1:
			seconds = 12;
			break;
		case 2:
			seconds = 8;
			break;
		case 3:
			seconds = 4;
			break;
		default:
			seconds = 8;
			break;
		}
			
		switch (difficulty) {
		case 1:
			rangeHigh = 3;
			break;
		case 2:
			rangeHigh = 6;
			break;
		case 3:
			rangeHigh = 9;
			break;
		default:
			rangeHigh = 6;
			break;
		}
	}
	
	public void adaptSettings() {
		User user = new User();
		int adaptSpeed = user.getAdaptSpeed();
		// adapt speed code goes here
		int adaptDifficulty = user.getAdaptDifficult();
		// adapt difficulty code goes here
		
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
	
	public double getTimeLeft() {
		return timeLeft;
	}
	
	public static int getRangeHigh() {
		return rangeHigh;
	}
}
