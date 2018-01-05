package zigzag;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import java.awt.Color;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class zigzag {
	static Finch myFinch = new Finch();
	static int length;
	static int section;
	
	public static boolean nrZigz(int section){
			if (section<2 || section>10) {
				System.out.println("Number between 2 and 10");
				return false;
			}
			if (section % 2 != 0) {
				System.out.println("Please input even number.");
				return false;
			}
		return true;
	}
	
	public static boolean length(int length) {
		if (length<30 || length>80) {
		System.out.println("Please input a number between 30cm and 80cm");
		return false;
		}
		return true;
	}

	public static void zigZag(int section, int length) {
		int length2 = (length * 85) / 2;
		
//		myFinch.setWheelVelocities(100, -100, 375);	//initial turn to the right
		for (int i=0; i<section/2; i++) 
		{
			myFinch.buzz(2000, length2);	//first buzzer
			myFinch.setLED(Color.green);	//green color
			myFinch.setWheelVelocities(100, 100, length2);	//forward length2
			myFinch.setWheelVelocities(-100, 100, 750);	//turning left
			System.out.println("pierwszy zigzag");
			
			for (int j=0; j<1; j++) 
			{
				myFinch.buzz(4000, length2);	//second buzzer
				myFinch.setLED(Color.red);	//red color
				myFinch.setWheelVelocities(100, 100, length2);	//forward lengt2
				myFinch.setWheelVelocities(100, -100, 750);		//turning right back to initial position
				System.out.println("drugi zigzag");
				
			}
		}
		System.out.println("Straight line distance: "+ (length * section)+"cm");	//displays straight line distance
		myFinch.setWheelVelocities(100, -100, 750);		//prepares the finch for retrace of movement
		
		for (int i=0; i<section/2; i++) 
		{
			myFinch.buzz(4000, length2); // tune 2
			myFinch.setLED(Color.red);
			myFinch.setWheelVelocities(100, 100, length2);
			myFinch.setWheelVelocities(100, -100, 750);
			System.out.println("pierwszy zigzag");
			
			for (int j=0; j<1; j++) 
			{
				myFinch.buzz(2000, length2);
				myFinch.setLED(Color.green);
				myFinch.setWheelVelocities(100, 100, length2);
				myFinch.setWheelVelocities(-100, 100, 750);
				System.out.println("drugi zigzag");
				
			}
		}
		myFinch.setWheelVelocities(-100, 100, 1000);
	}
	
	public static void main(String[] args) {
		boolean valid = true;
		System.out.println("Length of the zigzag?(cm) between 30 and 80");
		do {
			try {
				Scanner sc1=new Scanner(System.in);
				length=sc1.nextInt();
				valid = true;
			}
			catch(InputMismatchException E) 	//exception = valid = false.
			{
				System.out.println("Numerical value only");	
				Scanner sc1=new Scanner(System.in);
				valid = false;
			}
		}while (!valid || length(length)==false);	//first checks valid, then length method
		
		System.out.println("How many zigzags?");
		do {
			try {
			Scanner sc2=new Scanner(System.in);
			section=sc2.nextInt();
			valid = true;
			}
			catch(InputMismatchException E) 
			{
				System.out.println("Numerical value only");
				Scanner sc2=new Scanner(System.in);
				valid = false;
			}
		} while (!valid || nrZigz(section)==false);
		zigZag(section,length);
		myFinch.quit();
	}
}
