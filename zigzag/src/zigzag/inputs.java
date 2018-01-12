package zigzag;

public class inputs {
	public static boolean length(int length) {
		if (length<30 || length>80) {
			System.out.println(+length + " doesnt fit the criteria");
			System.out.println("Please input a number between 30cm and 80cm");
			return true;
		}
		return false;
	}
	public static boolean sections(int section){
		if (section<2 || section>10) {
			System.out.println(+section + " doesnt fit the criteria");
			System.out.println("Number between 2 and 10");
			return true;
		}
		if (section % 2 != 0) {
			System.out.println(+section+ " is not an even number");
			System.out.println("Please input even number.");
			return true;
		}
	return false;
	}
}


