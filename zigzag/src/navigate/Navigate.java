package navigate;

import javax.swing.JOptionPane;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;


public class Navigate {
	public static Finch finch = null;
	static FinchMovements finchMovementsObj = new FinchMovements();//Since  Commands class extends Navigate. This will come in handy for the Commands Class(its used to access methods from FinchMovements Class)
	public static String command = "";
	static String[] index;

	public static void main(String[] args) {
		Commands CommandClassObj = new Commands();//created object so that the Commands classes method can me used
		while (true) {
			command = JOptionPane.showInputDialog("Please input your command");
			index = command.split("\\s+");//String is split into different indexes
			CommandClassObj.ValidateCommand();

		}

	}

}
