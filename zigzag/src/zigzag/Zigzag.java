package zigzag;
import java.awt.Color;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Zigzag {
	private static Finch myFinch = new Finch();
	static int straightLineSpeed = 100;
	static int buzzer1 = 2000, buzzer2=4000;
	static Color color1 = Color.green, color2 = Color.red;
	
	public static void zigZag(int length, int section){
		int duration = (length * 85);	//duration needed to travel for length specified
		for (int i=0; i<2; i++) {	//for loop // i==0 zigzag, i==1 retrace
			if (i==1) {
				myFinch.setWheelVelocities(100, -100, 750);	//finch turns around for retrace
			}
			for (int j=0; j<section/2; j++) {		//for loop for each section
				if (i==0) {		//during zigzag the robot performs this
					zig(duration);
					zag(duration);
				}else{	//during retrace robot performs this, to come back to original place
					zag(duration);
					zig(duration);
				}
				}
		}
		myFinch.setWheelVelocities(-100, 100, 900);	//turns robot around for starting position
		travPath(length, section);
		System.out.println("Straight line distance: "+ (length * section)+"cm");
		System.out.println("Length of the traversed path(start to end of the zigzag): "+travPath(length, section)+"cm");
		//printing out the information of what just happened
	}
	
	private static void zig(int duration) {	//method for the first line
		myFinch.setLED(color1);
		myFinch.buzz(buzzer1, duration);
		myFinch.setWheelVelocities(straightLineSpeed, straightLineSpeed, duration);
		myFinch.setWheelVelocities(-100, 100, 750);
	}
	
	private static void zag(int duration) {	//method for the second line
		myFinch.setLED(color2);
		myFinch.buzz(buzzer2, duration);
		myFinch.setWheelVelocities(straightLineSpeed, straightLineSpeed, duration);
		myFinch.setWheelVelocities(100, -100, 750);
	}
	
	public static double travPath (int length, int section){
		double travpath = (Math.sqrt(Math.pow(length, 2) + Math.pow(length, 2))) * section/2;
		return travpath;
	}
	
	public static void main(String[] args) {
		int length = Inputs.getLength();	//int length is made by the method length
		int section = Inputs.getSection(); //int section is made by the method section
		zigZag(length, section); //zigzag and retrace is performed
		myFinch.quit(); 
	}
}
