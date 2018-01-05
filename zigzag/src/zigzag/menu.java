package zigzag;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class testingspeeds {
	static int option;

	public static void main(String[] args) {

		boolean valid = true;
		System.out.println("1. Follow light");
		System.out.println("2. Draw shape");
		System.out.println("3. Navigate");
		System.out.println("4. ZigZag");
		System.out.println("5. Follow object");
		System.out.println("6. Dance");
		System.out.println("7. Exit");
		
		
		do {
			try {
				Scanner sc1=new Scanner(System.in);
			option=sc1.nextInt();
			valid = true;
		    switch (option)
		    {
		        case 1:
		            // do something
		            break;
		        case 2: 
		            // ..something else
		            break;
		        case 3: 
		            // .. exit program
		            break;
		        case 4:
		        	zigzag.main(args);
		        	System.out.println("Choose another option, 7 for exit.");
		        	break;
		        case 5:
		        	break;
		        case 6:
		        	break;
		        case 7:
		        	System.out.println("CYA");
		        	break;
		        default:
		            System.out.println("Wrong option");
		    }
			}
		        catch(InputMismatchException E)
		        {
		        	System.out.println("Numerical numbers only, enter new number:");
					valid = false;
		        }
		} while (!valid || option != 7);
		}
	}
