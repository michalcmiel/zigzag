package zigzag;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Color;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;



public class zigzag {
	static Finch myFinch = new Finch();
	static int length, section;

	public boolean length(int length) {
		if (length<30 || length>80) {
			System.out.println(+length + " doesnt fit the criteria");
			System.out.println("Please input a number between 30cm and 80cm");
			return false;
		}
		return true;
	}
	
	public static boolean sections(int section){
		if (section<2 || section>10) {
			System.out.println(+section + " doesnt fit the criteria");
			System.out.println("Number between 2 and 10");
			return false;
		}
		if (section % 2 != 0) {
			System.out.println(+section+ " is not an even number");
			System.out.println("Please input even number.");
			return false;
		}
	return true;
	}
	
	public static void zig(int duration) {
		myFinch.setLED(Color.green);
		myFinch.buzz(2000, duration);
		myFinch.setWheelVelocities(100, 100, duration);
		myFinch.setWheelVelocities(-100, 100, 750);
	}
	
	public static void zag(int duration) {
		myFinch.setLED(Color.red);
		myFinch.buzz(4000, duration);
		myFinch.setWheelVelocities(100, 100, duration);
		myFinch.setWheelVelocities(100, -100, 750);
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
			catch(InputMismatchException E) 
			{
				System.out.println("Numerical value only");
				valid = false;
			}
		}while (!valid || length(length)==false);

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
				valid = false;
			}
		} while (!valid || sections(section)==false);

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
		myFinch.quit();
		System.out.println("Straight line distance: "+ (length * section)+"cm");
	}
}
