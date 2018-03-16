package navigate;
import javax.swing.JOptionPane;
import java.util.Collections;

public class Commands extends Navigate {

	public static void ValidateCommand() {
		//conditions have to be met for each movement to be executed
		if (index[0].equalsIgnoreCase("F") && index.length == 3) {
			int duration = Integer.parseInt(index[1]);
			int speed = Integer.parseInt(index[2]);
			finchMovementsObj.ForwardMovement(speed, duration);

		}
		if (index[0].equalsIgnoreCase("B") && index.length == 3) {
			int duration = Integer.parseInt(index[1]);
			int speed = Integer.parseInt(index[2]);
			finchMovementsObj.BackwardMovement(speed, duration);

		}

		if (index[0].equalsIgnoreCase("R") && index.length == 3) {
			int duration = Integer.parseInt(index[1]);
			int speed = Integer.parseInt(index[2]);
			finchMovementsObj.RightMovement(speed, duration);

		}

		if (index[0].equalsIgnoreCase("L") && index.length == 3) {
			int duration = Integer.parseInt(index[1]);
			int speed = Integer.parseInt(index[2]);
			finchMovementsObj.LeftMovement(speed, duration);
		}

		if (index[0].equalsIgnoreCase("Q") && index.length == 1) {
			finchMovementsObj.QuitProgram();
		} else
			InvalidCommand();

	}
	
	//If command user eneters is incorrect, eg Z, C,V etc. This method will be executed

	public static void InvalidCommand() {

		if (!(index[0].equalsIgnoreCase("F") || index[0].equalsIgnoreCase("B") || index[0].equalsIgnoreCase("R") || index[0].equalsIgnoreCase("L")
				|| index[0].equalsIgnoreCase("Q"))) {
			JOptionPane.showMessageDialog(null, String.format("The command %s is incorrect. Please try again!", index[0]));

		}

	}

}
