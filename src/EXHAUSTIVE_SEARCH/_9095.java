package EXHAUSTIVE_SEARCH;

import java.util.Scanner;

public class _9095 { // 1,2,3 ¥ı«œ±‚

	static int[] dp = new int[11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i < 11; i++)
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];

		while (T-- > 0) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
		sc.close();
	}

}
