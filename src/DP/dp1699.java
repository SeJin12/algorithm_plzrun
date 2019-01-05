package DP;

import java.util.Scanner;

public class dp1699 {

	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			dp[i] = i;
			for (int j = 1; pow(j) <= i; j++)
				if (dp[i] > dp[i - j * j] + 1)
					dp[i] = dp[i - j * j] + 1;
		}
		
		System.out.println(dp[n]);

		sc.close();
	}

	static int pow(int a) {
		return a * a;
	}

}
