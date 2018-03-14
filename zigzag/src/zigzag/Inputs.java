package zigzag;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
	private static boolean valid=true;

	public static int getLength (){	//This method will return int length when specific requirements are met
		int length = 0;
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Length of the zigzag?(cm) between 30 and 80");
		do {
			try {
				length=sc1.nextInt();
			}
			catch(InputMismatchException E) 
			{
				System.out.println("Numerical value only!");
				sc1.nextInt();
			}
		}while (length<30 || length>80);
		return length;
	}
	
	public static int getSection(){ //this method will return int section when specific requirements are met
		int section = 0;
		System.out.println("How many zigzags?(even number from 2-10)");
		do {	//do loop until !valid
			try {	//exception handler
				Scanner sc2 = new Scanner(System.in);
				section=sc2.nextInt();		//scans for a new int
				valid = true;
				if (section<2 || section>10) {	//valid = false when true
					System.out.println(+section + " doesnt fit the criteria");
					valid = false;
				}else if (section % 2 != 0) {	//valid = false when true
					System.out.println(+section+ " is not an even number");
					valid = false;
				}else valid = true;	//valid = true when above are false
				}
				catch(InputMismatchException E) 
				{
					System.out.println("Numerical value only!");
					valid = false;	//exception handled, valid=false, while loop executes
				}
		}while (!valid);
		return 0;	//returns int section
	}
}