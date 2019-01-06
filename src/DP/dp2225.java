package DP;

import java.util.Arrays;
import java.util.Scanner;

// ÇÕºÐÇØ
public class dp2225 {

	static final int MOD = 1_000_000_000;
	static long[][] dp = new long[201][201];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // < = 200
		int K = sc.nextInt(); // < = 200

		Arrays.fill(dp[1], 1);
		
		// dp[k][n] = dp[k-1][0] + dp[k-1][1] + ... + dp[k-1][n]
		for (int k = 2; k <= K; k++) {
			for (int n = 0; n <= N; n++) {
				for (int l = 0; l <= n; l++)
					dp[k][n] += dp[k - 1][l];
				dp[k][n] %= MOD;
			}
		}

		System.out.println(dp[K][N]);

		sc.close();
	}

}
