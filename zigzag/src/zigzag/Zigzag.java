package zigzag;
import java.awt.Color;
import java.util.InputMismatchException;
import java.util.Scanner;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Zigzag {
	private static Finch myFinch = new Finch();
	private static boolean valid=true;
	private static int length=0, section=0;
	
	public static int getLength (){
		//This method will return int length when specific requirements are met
		System.out.println("Length of the zigzag?(cm) between 30 and 80");
		do {	//do loop until !valid
			try {	//exception handler
				Scanner sc1=new Scanner(System.in);
				length=sc1.nextInt();		//scans for a new int
				valid = true;
				if (length<30 || length>80) {	//valid=false if true
					System.out.println(+length + " doesnt fit the criteria");
					System.out.println("Please input a number between 30cm and 80cm");
					valid = false;
				}else valid = true;	//valid=true if false
			}
			catch(InputMismatchException E) 
			{
				System.out.println("Numerical value only!");
				System.out.println("Please enter a new number");

				valid = false;	//exception handled, valid=false, while loop executes
			}
		}while (!valid);
		return length;	//returns int length
	}
	
	public static int getSection(){
		//this method will return int section when specific requirements are met
		System.out.println("How many zigzags?");
		do {	//do loop until !valid
			try {	//exception handler
			Scanner sc2=new Scanner(System.in);
			section=sc2.nextInt();		//scans for a new int
			valid = true;
			if (section<2 || section>10) {	//valid = false when true
				System.out.println(+section + " doesnt fit the criteria");
				System.out.println("Please input number between 2 and 10");
				valid = false;
			}else if (section % 2 != 0) {	//valid = false when true
				System.out.println(+section+ " is not an even number");
				System.out.println("Please input an even number.");
				valid = false;
			}else valid = true;	//valid = true when above are false
			}
			catch(InputMismatchException E) 
			{
				System.out.println("Numerical value only!");
				System.out.println("Please enter a new number");
				valid = false;	//exception handled, valid=false, while loop executes
			}
		} while (!valid);
		return section;	//returns int section
	}
	
	public static void zigZag(int length, int section){
		int duration = (length * 85) / 2;	//duration needed to travel for length specified
		for (int i=0; i<2; i++) {	//for loop // i==0 zigzag, i==1 retrace
			if (i==1) {
				myFinch.setWheelVelocities(100, -100, 750);	//finch turns around for retrace
			}
			for (int j=0; j<section; j++) {		//for loop for each section
				if (i==0) {		//during zigzag the robot performs this
					zig(duration);
					zag(duration);
				}else		//during retrace robot performs this, to come back to original place
					zag(duration);
					zig(duration);
			}
		myFinch.setWheelVelocities(-100, 100, 900);	//turns robot around for starting position
		System.out.println("Length of the traversed path(start to end of the zigzag): "+ (length * section/2)+"cm");
		System.out.println("Straight line distance: "+ (length * section)+"cm");
		//printing out the information of what just happened
		}
	}
	
	private static void zig(int duration) {	//method for the first line
		myFinch.setLED(Color.green);
		myFinch.buzz(2000, duration);
		myFinch.setWheelVelocities(100, 100, duration);
		myFinch.setWheelVelocities(-100, 100, 750);
	}
	
	private static void zag(int duration) {	//method for the second line
		myFinch.setLED(Color.red);
		myFinch.buzz(4000, duration);
		myFinch.setWheelVelocities(100, 100, duration);
		myFinch.setWheelVelocities(100, -100, 750);
	}
	
	public static void main(String[] args) {
		length = getLength();	//int length is made by the method length
		section = getSection(); //int section is made by the method section
		zigZag(length, section); //zigzag and retrace is performed
		myFinch.quit(); 
	}
}
