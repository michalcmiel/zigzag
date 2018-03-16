/*
 * GUI for Follow Object (Task 6) Program
 *  Program by Tyler Reece Came
 *  Date: 09/03/2018
 */

package followObject;

import javax.swing.JOptionPane;

public class GUI

{
	//Method to return an error to the user if the finch is tapped whilst an object is not detected
	public static void ObjError()
	{
		JOptionPane.showMessageDialog (null, "Please place object in front of finch before tapping!", "Error", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Method to display a Graphical User Interface to the user
	public static void objStats(int averageSpeed, int totalStops, long totalForward, long totalIdle)
	{   
		int optionSelect = JOptionPane.showConfirmDialog(null, "Would you like to view statistics?", "Statistics", JOptionPane.YES_NO_OPTION);
		System.out.println(optionSelect);

		//optionSelect = 0 if User click Yes
		if (optionSelect == 0)
		{
			//Array to store the drop down options for the user
			String[] statistics = { "Average speed", "Number of times stopped", "Total time running", "Time spent idle", "All statistics" };
			
			//Asking the user what statistic they'd like to view
			String userInput = (String) JOptionPane.showInputDialog(null, "Which statistic would you like to view?",
					"Statistics", JOptionPane.QUESTION_MESSAGE, null, statistics, statistics[0]); 
			System.out.println(userInput);
			
			//if the user chooses average speed in the drop-down list
			if (userInput == "Average speed")
			{
				JOptionPane.showMessageDialog (null, "Average speed = " + averageSpeed , "Statistics", JOptionPane.INFORMATION_MESSAGE);
			}
			
			//if the user chooses time stopped in the drop-down list
			if (userInput == "Number of times stopped")
			{
				JOptionPane.showMessageDialog (null, "The finch stopped " + totalStops + " times" , "Statistics", JOptionPane.INFORMATION_MESSAGE);
			}
			
			//if the user chooses total time running in the drop-down list
			if (userInput == "Total time running")
			{
				JOptionPane.showMessageDialog (null, "The finch ran for " + totalForward + " seconds", "Statistics", JOptionPane.INFORMATION_MESSAGE);
			}
			
			//if the user chooses Time spent idle in the drop-down list
			if (userInput == "Time spent idle")
			{
				JOptionPane.showMessageDialog (null, "The finch spent " + totalIdle + " seconds idle", "Statistics", JOptionPane.INFORMATION_MESSAGE);
			}
			
			//if the user chooses All statistics in the drop-down list
			if (userInput == "All statistics")
			{
				JOptionPane.showMessageDialog (null,
						"        All statistics: \n\nAverage Speed:  " + averageSpeed
						+ "\nNumber of Stops:  " + totalStops
						+ "\nTime spent moving:  " + totalForward + " seconds"
						+ "\nTime spent idle:  " + totalIdle + " seconds"
						, "Statistics", JOptionPane.INFORMATION_MESSAGE);
			}
		} 
	} 
}

