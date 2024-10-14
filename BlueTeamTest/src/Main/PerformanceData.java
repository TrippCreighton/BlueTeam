package Main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PerformanceData {
	//Tells and formats current date and time
	private DateTimeFormatter f_dtf;
	private LocalDateTime f_currentDateTime;
	//Game metrics from the user class
	private int f_totalTime;
	private int f_avgSpeed;
	private int f_avgAccuracy;
	private int f_lvlsCompleted;
	//compares last game session accuracy or user response time to the average accuracy or user response time 
	private int f_accuracyComp;
	private int f_responseComp;
	
	public PerformanceData() {
		setF_dtf(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		setF_currentDateTime(LocalDateTime.now());
		f_totalTime = 0;
		f_avgSpeed = 0;
		f_avgAccuracy = 0;
		f_lvlsCompleted = 0;
		f_accuracyComp = 0;
		f_responseComp = 0;
	}

	public DateTimeFormatter getF_dtf() {
		return f_dtf;
	}

	public void setF_dtf(DateTimeFormatter f_dtf) {
		this.f_dtf = f_dtf;
	}

	public LocalDateTime getF_currentDateTime() {
		return f_currentDateTime;
	}

	public void setF_currentDateTime(LocalDateTime f_currentDateTime) {
		this.f_currentDateTime = f_currentDateTime;
	}

	public int getF_totalTime() {
		return f_totalTime;
	}

	public void setF_totalTime(int f_totalTime) {
		this.f_totalTime = f_totalTime;
	}

	public int getF_avgSpeed() {
		return f_avgSpeed;
	}

	public void setF_avgSpeed(int f_avgSpeed) {
		this.f_avgSpeed = f_avgSpeed;
	}

	public int getF_avgAccuracy() {
		return f_avgAccuracy;
	}

	public void setF_avgAccuracy(int f_avgAccuracy) {
		this.f_avgAccuracy = f_avgAccuracy;
	}

	public int getF_lvlsCompleted() {
		return f_lvlsCompleted;
	}

	public void setF_lvlsCompleted(int f_lvlsCompleted) {
		this.f_lvlsCompleted = f_lvlsCompleted;
	}

	public int getF_accuracyComp() {
		return f_accuracyComp;
	}

	public void setF_accuracyComp(int f_accuracyComp) {
		this.f_accuracyComp = f_accuracyComp;
	}

	public int getF_responseComp() {
		return f_responseComp;
	}

	public void setF_responseComp(int f_responseComp) {
		this.f_responseComp = f_responseComp;
	}
	
	public void performanceFormatter() {
		System.out.printf("%s %s %s %s %s %s %s", f_dtf, f_currentDateTime, f_totalTime, f_avgSpeed, f_avgAccuracy, f_accuracyComp, f_responseComp);
	}
	
	

}
