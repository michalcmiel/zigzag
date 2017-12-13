package zigzag;
import java.util.Scanner;
import java.awt.Color;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
public class zigzag {
	static Finch myFinch = new Finch();
	static int y;
	static int x;
	public static boolean nrZigz(int x){
		
		
		if (x<0 || x>10) {
			System.out.println("Number between 2 and 10");
			return false;
		}
		if (x % 2 != 0) {
			System.out.println("Please input even number.");
			return false;
		}
		return true;
	}
	
	public static boolean length(int y) {
		if (y<30 || y>80) {
		System.out.println("Please input a number between 30cm and 80cm");
		return false;
		}
		return true;
	}


	public static void zigzag(int x, int y) {
		int length = y * 85;
		int sections = x / 2;

		myFinch.setWheelVelocities(100, -100, 500);
		for (int i=0; i<sections; i++) 
		{
			myFinch.setLED(Color.green);
			myFinch.setWheelVelocities(100, 100, length);
			myFinch.setWheelVelocities(-200, 100, 500);
			System.out.println("pierwszy zigzag");
			
			for (int j=0; j<1; j++) 
			{
				myFinch.setLED(Color.red);
				myFinch.setWheelVelocities(100, 100, length);
				myFinch.setWheelVelocities(100, -200, 500);
				System.out.println("drugi zigzag");
				
			}
		}
		myFinch.setWheelVelocities(100, -200, 500);
		System.out.println("Straight line distance: "+ (y * x)+"cm");
	}

	public static void zigBack(int x, int y) {
		int length = y * 85;
		int sections = x / 2;

		for (int i=0; i<sections; i++) 
		{
			myFinch.setLED(Color.green);
			myFinch.setWheelVelocities(100, 100, length);
			myFinch.setWheelVelocities(100, -200, 500);
			System.out.println("pierwszy zigzag");
			
			for (int j=0; j<1; j++) 
			{
				myFinch.setLED(Color.red);
				myFinch.setWheelVelocities(100, 100, length);
				myFinch.setWheelVelocities(-200, 100, 500);
				System.out.println("drugi zigzag");
				
			}
		}
		myFinch.setWheelVelocities(-200, 100, 500);
	}
	
	
	public static void main(String[] args) {

		do {
			System.out.println("Length of the zigzag?(cm) between 30 and 80");
			Scanner sc1=new Scanner(System.in);
			y=sc1.nextInt();
		}while (length(y)==false);

		
		
		do {
			System.out.println("How many zigzags?");
			Scanner sc2=new Scanner(System.in);
			x=sc2.nextInt();
		} while (nrZigz(x)==false);
		

		zigzag(x,y);
		zigBack(x,y);
		myFinch.quit();
	}

}
