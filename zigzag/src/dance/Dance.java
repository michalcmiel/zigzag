package dance;
import java.util.ArrayList;//we have to import the array list so we can use it in our program.
import java.util.Collections;// this consists entirely on static methods which are used to operate on collections like
// list,set. this will allow common operations like sorting a list or finding a element from a list easily using a collections class


import java.util.Scanner;//will allow user to input a value


import edu.cmu.ri.createlab.terk.robot.finch.Finch;//Finch package inported


public class Dance//Dance project
{
	
	private static Finch F = null;//Declaring a finch object to null

	public static void main(String args[])//Main program
	{
		F= new Finch(); 
		Scanner input = new Scanner(System.in);//this feature will allow the user to input a value into the progran
		while (true) {
			System.out.println("Enter a hexadecimal value which is length 2");// This is the question that will prompt the user to enter
			String hexadecimalInput = input.next();//the reading of the next line from the input stream.
			
			if ((inputChecker(hexadecimalInput) == true) && (hexadecimalInput.length() == 2)) {
              // This makes sure the input length is a hexadecimal input and the hexadecimal length is equal 2
				System.out.println("hexadecimal:" + hexadecimalInput);// This will outprint the hexadecimal value entered by user
				System.out.println("Decimal Equivalent :"+hexadecimalToDecimal(hexadecimalInput));//Will outprint the decimal equuivalent
				System.out.println("Binary Equivalent:" + StringArray(hexadecimalInput));// this will outprint the Binary equivalent
				System.out.println("Speed Value:" + speed(hexadecimalInput));// This will outprint the speed value
			     

				setLED(hexadecimalInput);// will link hexadecimal input to setLED
				setSpeed(hexadecimalInput);//will also link hexadecimal input to the speed
				F.quit();// Finch quit
				break;
			}

			else {
				System.out.println("Invalid Input: Please try again.");//This is an error message which will appear if the user enters a incorret value
			}
		}
		input.close();// will close the input tab

	}

	public static int hexadecimalToDecimal(String n){// Method for hexadecimal to decimal conversion
		int Decimal = 0; 
		String hexadecimal = "0123456789ABCDEF";// All the possible hexadecimal characters//intialised as a string
		n = n.toUpperCase(); // This lets the user enter a lower case value. 
		for (int i = 0; i < n.length(); i++){
			// Variable c takes the value of the char at the specified index. 
			int d = hexadecimal.indexOf(n.charAt(i));
			// Variable d takes the value of the index of variable c according to where it is found in the String hexadecimal. 
			Decimal = 16*Decimal + d;			
			// variable Decimal takes the value of the first digit of the hexadecimal value
			//Decimal will equal 16*0+d. the for loop will run through the first 
			//and second iteration. when it runs thro the first iteration  if the hexadecimal entered
			//is 1A, Decimal is set to 1 as Decimal =16*0+1.
			//when for loop runs through the second iteration d is set to 10 as the character 'A' has a index of 10
			//in string hexadecimal


		}
		return Decimal; // this will return the decimal after conversion

	}
	public static String StringArray(String hexadecimalInput){
	int[] binary = new int[decToBin(hexadecimalInput).size()]; 
	ArrayList<Integer> BinaryNumber = decToBin(hexadecimalInput); // Links binarysv value from array list to String hexadecimal input
	
		for(int i = 0; i < BinaryNumber.size(); i++){
			if(BinaryNumber.get(i) != null){//if binary number after conversion is not equal to null
				binary[i] = BinaryNumber.get(i);// then it will use binarys value
			}
		}
	
		String temporary = "";// Intialising it as string 
		for(int each : binary ){
			temporary += each;// Will link binary to our empty string
		}
		return temporary; // this will present the array list as a string
	}

	public static ArrayList<Integer> decToBin(String hexadecimalInput){// Decimal to Binary conversion
		ArrayList<Integer> BinaryNumber = new ArrayList<Integer>(); int i=0;  
		int Decimal = hexadecimalToDecimal(hexadecimalInput); 
		
		while(Decimal != 0)//if Decimal is not equal to 0
		{// then 
			BinaryNumber.add(Decimal%2);// Binary will find reminders of decimal when divided by 2.
			i++;//incremented by 1 value
			Decimal = Decimal/2;//will divide decimal by 2

		}   
		Collections.reverse(BinaryNumber);//it reserves the order of elements in a list passed as a argument
		return BinaryNumber; // this will return 
		
		//System.out.print("Equivalent Binary Number is: " + BinaryNumber);
	}


	public static boolean inputChecker(String n){// this method will test input validity
	
		String a = "([0-9]|[A-F]|[a-f])+"; //initalising string 'a' to equal a set of requirements consistent with hexadecimal values
		for(int i=0; i<2; i++){// for loops//
			if(n.charAt(0) == '0'){// if statement testing a valid input for a given hexadecimal value
				return false; // will return false if requirements are not met
			}
		}

		return n.matches(a);// Will return values from another method if conditions are satisfied  
	}

	public static void setLED(String hexadecimalInput)// this method is resposible for setting colours to finch setLED
	{
		int Decimal = hexadecimalToDecimal(hexadecimalInput); //Decimal will equal to hexadecimal input
		
		int red = Decimal;// Red value will equal to the decimal equivalent of a hexadecimal.
		System.out.println("Red:" + red);// This will print out the values for the red colour
		
		int green = (Decimal%80)+60; // Green value will equal to remainder  decimal equivalent when divided by 80.
		System.out.println("Green:" + green);// this will print out the values for the green colour
		
		int blue = (red + green)/2;// Blue will equal to the average values of Red and green
		System.out.println("Blue:" + blue);// this will print out the values for the blue colour

		F.setLED(red, green, blue);// this will display the colours on the finch
	}

	public static void setSpeed(String hexadecimalInput){// the method for the appropriate speeds
		int Decimal = hexadecimalToDecimal(hexadecimalInput); 
		ArrayList<Integer> BinaryNumber = decToBin(hexadecimalInput); // Recieving values from arraylist
		if(Decimal < 80){// if decimal is greater than 80
			Decimal = Decimal + 30;// then decimal will add 30 onto its speed
		}
		
		for(int i=0; i<BinaryNumber.size(); i++){
			//System.out.println(BinaryNumber.get(i));
			
			if(BinaryNumber.get(i) == 1){// If binary digit is equal to 1
				F.setWheelVelocities(Decimal, Decimal, 2000);//will go forward for 2 seconds if binary digit value is equal to 1
			}
			else{
				F.setWheelVelocities(-Decimal, -Decimal, 2000);// will go backwards for 2 seconds if digit isn't equal to one
			}
		}
		
	}
	
	public static int speed(String hexadecimalInput){//validation for speed
		int Decimal = hexadecimalToDecimal(hexadecimalInput); //Decimal equals to hexadecimal input
		if(Decimal < 80){//if decimal number is greater than 80, then decimal will add to 30.
			Decimal = Decimal + 30; 
		}
	
		return Decimal; // this will now return the decimal.
	}
	

}