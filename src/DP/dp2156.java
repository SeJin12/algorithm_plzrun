package DP;

import java.util.Scanner;

public class dp2156 {

	static int[] wine, drink;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		wine = new int[n + 1];
		for (int i = 1; i <= n; i++)
			wine[i] = sc.nextInt();

		drink = new int[n + 1];
		System.out.println(solve(n));

		sc.close();
	}

	static int solve(int n) {
		drink[1] = wine[1];
		if (n == 1)
			return drink[1];
		drink[2] = wine[1] + wine[2];
		if (n == 2)
			return drink[2];

		for (int i = 3; i <= n; i++) {
			drink[i] = drink[i - 1];
			if (drink[i] < drink[i - 2] + wine[i])
				drink[i] = drink[i - 2] + wine[i];
			if (drink[i] < drink[i - 3] + wine[i] + wine[i - 1])
				drink[i] = drink[i - 3] + wine[i] + wine[i - 1];
		}
		return drink[n];
	}

}
