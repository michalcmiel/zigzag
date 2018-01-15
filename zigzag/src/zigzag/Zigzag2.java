package zigzag;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Color;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Zigzag2 {
	private static Finch myFinch = new Finch();
	
	public static void zigZag(int length, int section){
		int duration = (length * 85) / 2;
		for (int i=0; i<2; i++) {
			if (i==1) {
				myFinch.setWheelVelocities(100, -100, 750);
			}
			for (int j=0; j<section/2; j++) {
				if (i==0) {
					zig(duration);
				}else
					zag(duration);
				for (int k=0; k<1; k++) {
					if (i==0) {
						zag(duration);
					}else
						zig(duration);
				}
			}
		}
		myFinch.setWheelVelocities(-100, 100, 900);
		System.out.println("Length of the traversed path(start to end of the zigzag): "+ (length * section/2)+"cm");
		System.out.println("Straight line distance: "+ (length * section)+"cm");
	}
	
	
	private static void zig(int duration) {
		myFinch.setLED(Color.green);
		myFinch.buzz(2000, duration);
		myFinch.setWheelVelocities(100, 100, duration);
		myFinch.setWheelVelocities(-100, 100, 750);
	}
	
	private static void zag(int duration) {
		myFinch.setLED(Color.red);
		myFinch.buzz(4000, duration);
		myFinch.setWheelVelocities(100, 100, duration);
		myFinch.setWheelVelocities(100, -100, 750);
	}
	
	public static void main(String[] args) {
		int length = Inputs.length();
		int section = Inputs.section();
		zigZag(length, section);
		myFinch.quit();
		
	}
}
