package zigzag;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
	private static boolean valid=true;
	static Scanner sc1,sc2=new Scanner(System.in);
	
	public static int getLength (){
		int length = 0;
		//This method will return int length when specific requirements are met
		System.out.println("Length of the zigzag?(cm) between 30 and 80");
		do {	//do loop until !valid
			try {	//exception handler
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
		int section = 0;
		//this method will return int section when specific requirements are met
		System.out.println("How many zigzags?");
		do {	//do loop until !valid
			try {	//exception handler
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
}