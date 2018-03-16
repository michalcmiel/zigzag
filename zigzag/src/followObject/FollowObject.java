/*
 * Program for Finch to Follow Object (Task 6)
 * Program by Tyler Reece Came
 * Date: 09/03/2018
*/

package followObject;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class FollowObject
{
	//Initialising global variables
	static int totalStops = 0;
	static int totalTurns = 0;
	static int totalGo = 0;
	static long totalForward;
	static long totalIdle;
	static int averageSpeed;
	
	//Declaring main method
	public static void main(String args[])
	{
		//variable created in order to terminate the program
		boolean escape = false;
		Finch myFinch = new Finch();
		
		//while loop to keep finch checking if finch is tapped
		while (escape == false)
		{
			//if statement to check if the finch is tapped without an obstacle
			if (myFinch.isTapped() && myFinch.isObstacle() == false)
			{
				GUI.ObjError();
			}
			
			//if statement to initialise program once the finch has detected an object and has been tapped
			if (myFinch.isTapped() && myFinch.isObstacle())
			{
				//while to ensure the finch can follow the object successfully
				while(escape == false)
				{
					{
						//if statement to halt movement if the finch has an object in front of it
						if (myFinch.isObstacleLeftSide() && myFinch.isObstacleRightSide())
						{
							totalStops = totalStops + 1;
							long idleStartTime = System.currentTimeMillis();							
							while (myFinch.isObstacleLeftSide() && myFinch.isObstacleRightSide())
							{
								myFinch.setLED(200, 0, 0);
								myFinch.stopWheels();
								
								//if statement to terminate program once the finch has been tapped twice
								if (myFinch.isTapped() && myFinch.isTapped())
								{
									totalForward = totalForward / 1000;
									totalIdle = totalIdle / 1000;
									averageSpeed = ((totalTurns * 150) + (totalGo * 170)) / (totalTurns + totalGo);
									GUI.objStats(averageSpeed, totalStops, totalForward, totalIdle);
									escape = true;
									myFinch.quit();
									break;
								}
							}	
							
							//subtracting current time by start time to calculate how much time has elapsed
							totalIdle = totalIdle + (System.currentTimeMillis() - idleStartTime); 
						}
						
						else 
						{ 
							myFinch.setLED(0, 200, 0); 
							objFollow(myFinch);
						}
					}
				}
			}
		}
	}

		
	
	//method to follow an object
	private static void objFollow(Finch myFinch) 
	{
		//if statement to move towards object on left side
		if (myFinch.isObstacleLeftSide())
		{
			long initialStartTimeL = System.currentTimeMillis();
			totalTurns = totalTurns + 1; 
			while (myFinch.isObstacleLeftSide() && !myFinch.isObstacleRightSide())
			{
				myFinch.setWheelVelocities(-150, 150);
				//myFinch.buzz(10000, 100);
			}
			totalForward = totalForward + System.currentTimeMillis() - initialStartTimeL;
		} 
		//if statement to move towards object on right side
		else if (myFinch.isObstacleRightSide())
		{
			long initialStartTimeR = System.currentTimeMillis();
			totalTurns = totalTurns + 1;
			while (myFinch.isObstacleRightSide() && !myFinch.isObstacleLeftSide())
			{
				myFinch.setWheelVelocities(150, -150);
				//myFinch.buzz(10000, 100);
			}
			totalForward = totalForward + System.currentTimeMillis() - initialStartTimeR;
		}
		//if statement to move forwards
		else if (myFinch.isObstacleLeftSide() == false && myFinch.isObstacleRightSide() == false)
		{
			long initialStartTimeM = System.currentTimeMillis();
			totalGo = totalGo + 1;
			while (myFinch.isObstacleRightSide() == false && myFinch.isObstacleLeftSide() == false)
			{
				myFinch.setWheelVelocities(170, 170);
				//myFinch.buzz(10000, 100);
			}
			totalForward = totalForward + System.currentTimeMillis() - initialStartTimeM;
		} 
	} 
}


