package shape;

public class Valid {

	private int a;
	private int b;
	private int c;
	private double a1;
	private double a2;
	private double a3;


	public Valid(int a, int b, int c) { 

		this.a = a;
		this.b = b;
		this.c = c;
	}

	public boolean triangleCheck(int a, int b, int c){
		if((a + b > c) &&(b + c > a) && (c + a > b)) {
			a1 = getAnglesA();
			return true;
		}else{
			return false;
		}
	}
	public int getAnglesA() {
		double A1 = (a*a + b*b - c*c);
		double A2 = (2*a*b);
		double A = Math.acos(A1/A2)*(180/Math.PI);
		return (int)A;
	}

	public int getAnglesB() {
		double B1 = (b*b + a*a - c*c);
		double B2 = (2*b*a);
		double B = Math.acos(B1/B2)*(180/Math.PI);
		return (int)B;
	}

	public int getAnglesC() {
		double C1 = (c*c + a*a - b*b);
		double C2 = (2*c*a);
		double C = Math.acos(C1/C2)*(180/Math.PI);
		return (int)C;
	}


}