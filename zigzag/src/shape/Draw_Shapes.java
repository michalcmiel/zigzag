package shape;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthScrollBarUI;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Draw_Shapes {

	static Finch myFinch = new Finch();//Finch object.
	static ArrayList<String> angleStore = new ArrayList<String>(); //I am storing the angles.
	static ArrayList<String> store = new ArrayList<String>(); // I am storing all the shapes and length of it.
	static int FreqTri = 0;//Triangle integer.
	static int FreqRect = 0;//Rectangle integer.

	public static void main(String[] args) {
		menu();//Menu Shapes method.
	}
	public static void menu() {
		Scanner key = new Scanner(System.in);
		// this is the menu.
		System.out.println("Please, select one of the following options: ");
		System.out.println("R: Draw a RECTANGLE.");
		System.out.println("T: Draw a TRIANGLE.");
		System.out.println("Q: Quit.");
		System.out.print("Please enter you choose here: ");
		// this scanner it's help me to select what I would like to do.
		String x = key.nextLine();
		x = x.toLowerCase();
		switch (x) {
		case "t":
			triangle(myFinch);//Triangle method.
			FreqTri++;//Add 1 to FreqTri integer.
			break;
		case "r":
			rectangle(myFinch);//Rectangle method.
			FreqRect++;//Add 1 to FreqRect integer.
			break;
		case "q":
			quit(myFinch);//Quit method.
			break;
		default:
			System.out.println("Invalid option. Try again.");
			break;
		}
		menu();
	}

	private static void triangle(Finch myFinch) {
		// The timeToHold's parameter 1000 is 25/28cm.
		// timeToHold 40 is 1cm.
		// wheels 128 30cm
		// timeToHold 1200 is 30cm.
		// timeToHold 3600 is 90cm.
		Triangle triangle = new Triangle();//Triangle object.
		System.out.println("Please enter the three triangle's length. The lenth must be between 30cm and 90cm.");// Insert values.
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first side: ");
		int a = 1;
		while (a != 2) {
			scan = new Scanner(System.in);//Scanner for the first edge.
			int edg = scan.nextInt();
			triangle.setT1(edg);
			if (edg < 30 || edg > 90) {//invalid values.
				System.out.println("Invalid Value.\nPlease insert the side again: ");
			} else {
				a = a + 1;//Exit from the loop and goes to the second edge.
			}
		}
		System.out.print("Enter the second side: ");
		int s = 1;
		while (s != 2) {
			scan = new Scanner(System.in);// Scanner for the second adge.
			int edg = scan.nextInt();
			triangle.setT2(edg);
			if (edg < 30 || edg > 90) {
				System.out.println("Invalid Value.\nPlease insert the side again: ");
			} else {
				s = s + 1;//Exit from the loop and goes to the third edge.
			}
		}

		System.out.print("Enter the third Side: ");
		int d = 1;
		while (d != 2) {
			scan = new Scanner(System.in);// Scanner for the third edge.
			int edg = scan.nextInt();
			triangle.setT3(edg);
			if (edg < 30 || edg > 90) {
				System.out.println("Invalid Value.\nPlease insert the side again: ");
			} else {
				d = d + 1;//Exit from the third loop and go forward.
			}
		}

		int T1 = triangle.getT1();
		int T2 = triangle.getT2();
		int T3 = triangle.getT3();
		Valid valid = new Valid(T1, T2, T3); 
		if(valid.triangleCheck(T1, T2, T3)){// Checking if the values makes a triangle.
			System.out.println("Awesome! This values make a triangle. Now I am going to find you the angles.");
		}else{
			System.out.println("These values do not make a triangle. Please try again");
			triangle(myFinch);
		}
		System.out.println(valid.getAnglesA());
		System.out.println(valid.getAnglesB());
		System.out.println(valid.getAnglesC());

		int q = 67 * T1;// I am going to convert velocity finch to cm.
		int w = 67 * T2;// I am going to convert velocity finch to cm.
		int e = 67 * T3;// I am going to convert velocity finch to cm.

		myFinch.setWheelVelocities(128, 128, q);
		myFinch.setWheelVelocities(128, -128, 750);
		myFinch.setWheelVelocities(128, 128, w);
		myFinch.setWheelVelocities(128, -128, 750);
		myFinch.setWheelVelocities(128, 128, e);
		myFinch.buzz(800, 2000);
		store.add("Triangle: " + String.valueOf(T1)+ " ," + String.valueOf(T2)+ " ,"+ String.valueOf(T3) + ".");//Store the values inside the store array list.
		angleStore.add(Integer.toString(valid.getAnglesA()) + " ," + Integer.toString(valid.getAnglesB()) + " ," + Integer.toString(valid.getAnglesC()));//Store the angles inside the array list.
	}

	private static void rectangle(Finch myFinch) {
		System.out.println("Please enter the width and height. The lenth of both must be between 30cm and 90cm.");// Insert values.
		Scanner rectkey = new Scanner(System.in);
		Rectangle rect = new Rectangle();
		System.out.println("Please insert width lenth: ");
		int q = 1;
		while (q != 2) {
			int width = rectkey.nextInt();
			rect.setRectangle1(width);
			if (width < 30 || width > 90) {
				System.out.println("Invalid Value.\nPlease insert width again: ");
			} else {
				q = q + 1;//Exit from the loop and goes to the second if statement.
			}
		}
		System.out.println("Please insert height lenth: ");
		int w = 1;
		while (w != 2) {
			int hight = rectkey.nextInt();
			rect.setRectangle2(hight);
			if (hight < 30 || hight > 90) {
				System.out.println("Invalid Value.\nPlease height again: ");
			} else {
				w = w + 1;//Exit from the loop and draw the rectangle.
			}
		}
		int R1 = 67 * rect.getRectangle1();
		int R2 = 67 * rect.getRectangle2();
		myFinch.setWheelVelocities(128, 128, R1);
		myFinch.setWheelVelocities(128, -128, 510);
		myFinch.setWheelVelocities(128, 128, R2);
		myFinch.setWheelVelocities(128, -128, 550);
		myFinch.setWheelVelocities(128, 128, R1);
		myFinch.setWheelVelocities(128, -128, 550);
		myFinch.setWheelVelocities(128, 128, R2);
		myFinch.buzz(800, 2000);
		store.add("Rectangle: " + String.valueOf(rect.getRectangle1())+ " ," + String.valueOf(rect.getRectangle2())+ ".");//Store the rectangle inside the arraylist.
	}

	private static void quit(Finch myFinch) {
		System.out.println("Quit.");
		System.out.println("List of shapes: " + store);// Print the shapes in order the were draw.
		System.out.println("List of angles: " + angleStore);//Print the angles of the triangles.
		Frequency();//The most draw shape.
		myFinch.buzzBlocking(800, 500);//Finch buzz.
		try {
			Thread.sleep(500);//Finch pause.
		} catch (InterruptedException e) {}
		myFinch.buzzBlocking(800, 500);//Finch buzz.
		myFinch.quit();//Exit from the finch.
		System.exit(0);//terminate the program.
	}

	public static void Frequency(){
		if (FreqTri > FreqRect){
			System.out.println("The most draw shape is: Triangle.");
		}else if(FreqRect>FreqTri){
			System.out.println("The most draw shape is: Rectangle.");
		}else if(FreqTri==0 && FreqRect == 0){
			System.out.println("No input inserted.");
		}else{
			System.out.println("The shapes were draw equally.");
		}
	}

}
