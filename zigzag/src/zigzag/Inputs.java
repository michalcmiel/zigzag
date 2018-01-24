package zigzag;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Inputs {
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
}