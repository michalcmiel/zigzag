package light;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.util.ArrayList;
import java.util.Scanner;

public class FollowLight {

	public static int velocity = 200; //calculates speed
	public static int travelTime = 500; // 
	public static int totalTraveltime = 0;
	public static int flashlightSwitch = 0;
	public static int stoppedCounter = 0; // Counts number of times finch has stopped.
	public static boolean stopFlashlightswitch = true;
	public static int totalStopTime = 0;
	public static int counting = 0; //This makes the finch move forward in a container so it only prints 'forward' once. Compared to each millisecond; and stops when there's another movement.
	public static int sixSeconds = 0;
	public static int numOfStops = 0; // Calculates the number of stops.
	 
	public static ArrayList<Integer> velocityArray = new ArrayList<>(); // The velocityArray returns the finch speed for each time the task is executed.
	public static int counterStop = 0;

	public static Finch mFinch = new Finch();

	public static boolean noLightpresent = false; 

	
	public static void main(String[] args){ 
		velocityArray.add(0); //Adding a value to the speed array. Initialises the list array. 
		
		while ((mFinch.isObstacle() == true || !mFinch.isRightLightSensor(160) == true && !mFinch.isLeftLightSensor(160)  == true)) {} 
		
		while(mFinch.isObstacle() == false){
			while(mFinch.isRightLightSensor(180) == true && mFinch.isLeftLightSensor(180)  == true ) {// This is an automated light checker. The greater the value the stronger the light detector. <170 is weaker.
				averageSpeed(200);
				moving(velocity,velocity); // When both light sensors detect light.

				mFinch.buzz (50,100); 
			}

			while (mFinch.isRightLightSensor(180) == true && mFinch.isLeftLightSensor(180)  == false ) {
				averageSpeed(150); // when the left light detector detects light. 200/2=100+200=300.


				moving(velocity/2,velocity); 

				mFinch.buzz (50,100); // 50,100 = frequency, this determines the sound of the buzzer.
			}

			while (mFinch.isRightLightSensor(180) == false && mFinch.isLeftLightSensor(180)  == true ) {
				averageSpeed(150); // 150 is the average because one wheel's speed is 100, and another is 200. So add both wheels and divide by 2 because there's 2 wheels. 


				moving(velocity,velocity/2); //  When the right light sensor detects the flashlight. 

				mFinch.buzz (50,100); 
			}
			while (mFinch.isObstacle() == true || mFinch.isRightLightSensor(160) == false && mFinch.isLeftLightSensor(160)  == false) {
				
				stop();
			}
		}
		
		
	}
		
	public static boolean ecncounterObstacle(){
		
		if (mFinch.isObstacle() == true || mFinch.isRightLightSensor(160) == false && mFinch.isLeftLightSensor(160)  == false) {

			counting += 1 ; // Adds 1 to the counter.

			return true; // Return true if there is no obstacle.
		}

		return false; //When an obstacle is present +1 to the counter.
	}

	public static void moving(int leftWheel, int rightWheel){
		mFinch.buzz(300, 50); // Buzzing sound not too loud.
		mFinch.setLED(0,255,0); // Finch beak LED colour GREEN.
		mFinch.setWheelVelocities(leftWheel,rightWheel,travelTime);
		totalTraveltime += travelTime;
		System.out.println("Finch following flashlight"); // when a light source is detected
		stopFlashlightswitch = true;
		flashlightSwitch++;
		sixSeconds = 0; //Finch should stop for 6 seconds once there is no light or encounters object.
	}

	public static void stop(){
	
		flashlightSwitch = 0;
		mFinch.setLED(255,0,0);
		counterStop++;
		System.out.println(sixSeconds); //Prints the 6 seconds.
		
		try {Thread.sleep(1000);} catch (InterruptedException e){}  //Stops by 1 second.
		totalStopTime ++; //Incrementing totalStopTime by 1.
		sixSeconds ++; //Incrementing sixSeconds by 1.
		if (sixSeconds > 6){ noLightpresent = true; //sixSeconds is greater or equal to 6.
		
		calculateStatistics();

		}

		// Program should wait 6 seconds.

		mFinch.stopWheels(); // Finch stops moving if it's encountered an obstacle.
		System.out.println("Finch has encountered an obstacle."); // When an obstacle is detected display this message and start stop counter.
		if(stopFlashlightswitch == true) stoppedCounter++; //stoppedCounter counts number of stops.
		stopFlashlightswitch = false;


	}
	public static void averageSpeed(int s){ //Method calculates average speed.
		if(s != velocityArray.get(velocityArray.size() -1)){ // Average speed not equal (!=) to average speed size. 
			velocityArray.add(s);
		}
	}
	public static int calculateVelocity(){ 
		int averageSpeed = 0; //averageSpeed is = 0 
		for(int i = 0; i < velocityArray.size(); i++){ // for loop, which goes through the list array and adds all the values to the variable averageSpeed
			averageSpeed += velocityArray.get(i); 
		}
		averageSpeed= averageSpeed / velocityArray.size() -1; // -1 because i initially added 0 to the list array.
		return averageSpeed;
	}
	
	public static void calculateStatistics(){
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to view the statistics?");
		String userInput = input.nextLine(); //Print next line.

		if (userInput.equalsIgnoreCase("Yes")){
			System.out.println(totalStopTime);
			System.out.println(totalTraveltime);
			System.out.println(calculateVelocity());
			System.out.println(stoppedCounter);
			System.exit(0);
		}
		else if (userInput.equalsIgnoreCase("No")){
			System.exit(0);
		}
	}
}





