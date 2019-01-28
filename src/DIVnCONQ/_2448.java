package DIVnCONQ;

import java.util.Scanner;

public class _2448 {

	static String[] output;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // n = 3 x 2^k --> k : (0,10]
		sc.close();

		output = new String[N];
		output[0] = "  *  ";
		output[1] = " * * ";
		output[2] = "*****";

		// call method
		for (int k = 0; k < (int) baseLog(N / 3, 2); k++) {
			solution(3 * (int) Math.pow(2, k));
		}
		// result
		for (int i = 0; i < N; i++) {
			System.out.println(output[i]);
		}

	}

	static void solution(int start) {
		int spaceLen = (int) Math.ceil(output[start - 1].length() / 2.0);
		for (int i = start; i < 2 * start; i++) {
			output[i] = output[i - start] + " " + output[i - start];
		}
		String space = "";
		for (int i = 0; i < spaceLen; i++)
			space += " ";

		for (int i = 0; i < start; i++)
			output[i] = space + output[i] + space;
	}

	static double baseLog(double x, double base) {
		return Math.log10(x) / Math.log10(base);
	}

}
