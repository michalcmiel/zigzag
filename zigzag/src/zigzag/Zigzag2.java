package zigzag;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.Color;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Zigzag2 {
	private static Finch myFinch = new Finch();
	
	
	public static int length (){
		int length = 0;
		boolean valid=true;
		System.out.println("Length of the zigzag?(cm) between 30 and 80");
		do {
			try {
				Scanner sc1=new Scanner(System.in);
				length=sc1.nextInt();
				valid = true;
				if (length<30 || length>80) {
					System.out.println(+length + " doesnt fit the criteria");
					System.out.println("Please input a number between 30cm and 80cm");
					valid = false;
				}else valid = true;
			}
			catch(InputMismatchException E) 
			{
				System.out.println("Numerical value only");
				valid = false;
			}
		}while (!valid);
		return length;
	}
	
	public static int section(){
		int section = 0;
		boolean valid=true;
		System.out.println("How many zigzags?");
		do {
			try {
			Scanner sc2=new Scanner(System.in);
			section=sc2.nextInt();
			valid = true;
			if (section<2 || section>10) {
				System.out.println(+section + " doesnt fit the criteria");
				System.out.println("Please input number between 2 and 10");
				valid = false;
			}else if (section % 2 != 0) {
				System.out.println(+section+ " is not an even number");
				System.out.println("Please input even number.");
				valid = false;
			}else valid = true;
			}
			catch(InputMismatchException E) 
			{
				System.out.println("Numerical value only");
				valid = false;
			}
		} while (!valid);
		return section;
	}
	
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
		int length = length();
		int section = section();
		zigZag(length, section);
		myFinch.quit();
		
		System.out.println("Length of the traversed path(start to end of the zigzag): "+ (length * section/2)+"cm");
		System.out.println("Straight line distance: "+ (length * section)+"cm");
		
	}
}
