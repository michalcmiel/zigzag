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
		boolean valid=true;
		do {
			try {
	    	System.out.println("Press 1 to repeat, or 2 to exit");
			Scanner sc2=new Scanner(System.in);
			exit=sc2.nextInt();
			valid=true;
				while (exit<1 || exit>2) {
		        	System.out.println("press 1 to repeat, or 2 to exit, "+exit + " is a terrible option");
					exit=sc2.nextInt();
			}
				if (exit == 1) {
					return true;
			}
			}
	        catch(InputMismatchException E)
			{
	        	valid=false;
	        	System.out.println("Numerical value");
			}
		}while (!valid);
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
		        	do {
			        	System.out.println("DOES FOLLOW LIGHT");
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 2: 
		        	do {
			        	System.out.println("DOES DRAW SHAPE");
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 3: 
		        	do {
			        	System.out.println("DOES NAVIGATE");
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 4:
		        	do {
			        	System.out.println("DOES ZIGZAG");
			        	zigzag.main(args);
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 5:
		        	do {
			        	System.out.println("DOES FOLLOWOBJECT");
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 6:
		        	do {
			        	System.out.println("DOES DANCE");
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 7:
		        	System.out.println("CYA");
		        	break;
		        default:
		        	showMenu();
		            System.out.println("Number "+option +" doesnt look like an option, choose a new number");
		    }
			}
		        catch(InputMismatchException E)
		        {
		    		showMenu();
		        	System.out.println("Numerical numbers only, enter new number from the menu:");
					valid = false;
		        }
		} while (!valid || option != 7);
		}
	}
