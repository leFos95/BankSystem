import java.util.Scanner;

public class EasyScanner {

	public static int nextInt() {
		Scanner input = new Scanner(System.in);
		int i = input.nextInt();
		return i;
	}
	
	public static double nextDouble() {
		Scanner input = new Scanner(System.in);
		double d = input.nextDouble();
		return d;
	}
	
	public static String nextString() {
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		return s;
	}
	
	public static char nextChar() {
		Scanner input = new Scanner(System.in);
		char c = input.next().charAt(0);
		return c;
	}
}
