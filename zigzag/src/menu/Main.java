package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static void showMenu() {
		System.out.println("1. Follow light");
		System.out.println("2. Draw shape");
		System.out.println("3. Navigate");
		System.out.println("4. ZigZag");
		System.out.println("5. Follow object");
		System.out.println("6. Dance");
		System.out.println("7. Exit");
	}
	
	private static boolean repeat(int exit) {
		boolean valid;
		do {
			try {
		    	System.out.println("Press 1 to repeat, or 2 to exit");
				Scanner sc2=new Scanner(System.in);
				exit=sc2.nextInt();
				valid=true;
				switch(exit) {
				case 1:	
					return true;
				case 2:	
					return false;
				default:
		        	valid = false;
				}
			}
	        catch(InputMismatchException E)
			{
	        	valid=false;
			}
		}while (!valid || exit ==1 && exit ==2);
		return false;
}
	
	public static void main(String[] args) {
		boolean valid = true;
		int exit = 0, option =0;
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
			        	light.FollowLight.main(args);
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 2: 
		        	do {
		        		shape.Draw_Shapes.main(args);
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 3: 
		        	do {
		        		navigate.Main.main(args);
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 4:
		        	do {
			        	zigzag.Zigzag.main(args);
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 5:
		        	do {
		        		followObject.Main.main(args);
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 6:
		        	do {
		        		dance.Dance.main(args);
		        	}while (repeat(exit)==true);
		    		showMenu();
		        	break;
		        case 7:
		        	System.out.println("Bye!");
		        	break;
		        default:
		        	showMenu();
		            System.out.println("Number "+option +" doesnt look like an option, choose a new number");
		    }
			}
		        catch(InputMismatchException E)
		        {
		    		showMenu();
		            System.out.println("This doesnt look like an option, choose a new NUMBER");
					valid = false;
		        }
		} while (!valid || option != 7);
		}
	}
