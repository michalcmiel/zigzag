package zigzag;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class menu {
	static int option;
	static int exit;
	
	public static void showMenu() {
		System.out.println("1. Follow light");
		System.out.println("2. Draw shape");
		System.out.println("3. Navigate");
		System.out.println("4. ZigZag");
		System.out.println("5. Follow object");
		System.out.println("6. Dance");
		System.out.println("7. Exit");
	}
	
	
	public static boolean repeat(int exit) {
			if (exit == 1) {
				return true;
			}
			return false;
	}
	
	

	public static void main(String[] args) {
		boolean valid = true;
		showMenu();
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
		        	do {
//			        	zigzag.main(args);
			        	System.out.println("press 1 to repeat, or 2 to exit");
						exit=sc1.nextInt();
						while (exit<1 || exit>2) {
				        	System.out.println("press 1 to repeat, or 2 to exit");;
							exit=sc1.nextInt();
						}
						repeat(exit);
		        	}while(repeat(exit)==true);
		    		showMenu();
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
		        	System.out.println("Numerical numbers only, enter new number from the menu:");
					valid = false;
		        }
		} while (!valid || option != 7);
		}
	}
