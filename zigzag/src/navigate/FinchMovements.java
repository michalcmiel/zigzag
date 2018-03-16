package navigate;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FinchMovements {
	static Finch myfinch = new Finch();

	// Methods used to set the speed and duration limits
	public boolean setDurationAndsetSpeed(int duration, int speed) { //split this and incorrect methods into another class
		if ((duration <= 6 && duration > 0) && (speed <= 200 & speed > 0)) {
			return true;
		}
		return false;
	}
	
	//If speed or duratiion is incorrect this method will be run

	public void IncorrectSpeedAndDuration(int speed, int duration) {
		JOptionPane.showMessageDialog(null, "Duration or Speed was entered incorrectly. Please try again!");

	}

	// Method used for the finch to turn orthognally to the right

	public void RightMovement(int speed, int duration) {
		if (setDurationAndsetSpeed(duration, speed)) {
			myfinch.setWheelVelocities(90, -105, 1 * 1000);
			myfinch.setWheelVelocities(speed, speed, duration * 1000);
			JOptionPane.showMessageDialog(null, "The finch successfully completed the right movement");
		} else
			IncorrectSpeedAndDuration(speed, duration);
	}

	// Method used for the finch to turn orthognally to the left

	public void LeftMovement(int speed, int duration) {
		if (setDurationAndsetSpeed(duration, speed)) {
			myfinch.setWheelVelocities(-150, 90, 1 * 1000);
			myfinch.setWheelVelocities(speed, speed, duration * 1000);
			JOptionPane.showMessageDialog(null, "The finch successfully completed the left movement");
		} else
			IncorrectSpeedAndDuration(speed, duration);

	}

	// method executes when the user enters the command F, with valid integer
	// inputs for duration and speed, will also execute for the right turn
	// function
	public void ForwardMovement(int speed, int duration) {
		if (setDurationAndsetSpeed(duration, speed)) {
			myfinch.setWheelVelocities(speed, speed, duration * 1000);
			JOptionPane.showMessageDialog(null, "Finch successfully moved forwards");
		} else
			IncorrectSpeedAndDuration(speed, duration);

	}

	// method executes when the user enters the command B, with valid integer
	// inputs for duration and speed

	public void BackwardMovement(int speed, int duration) {
		if (setDurationAndsetSpeed(duration, speed)) {
			speed = speed * -1;
			myfinch.setWheelVelocities(speed, speed, duration * 1000);
			JOptionPane.showMessageDialog(null, "Finch successfully moved backwards");
		} else
			IncorrectSpeedAndDuration(speed, duration);

	}
	//Method executes when user enters Q
	public void QuitProgram(){
		JOptionPane.showMessageDialog(null, "The program will now quit");
		System.exit(0);
		myfinch.quit();

	}

}
