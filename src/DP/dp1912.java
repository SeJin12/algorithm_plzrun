package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp1912 {

	static int[] A, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		A = new int[n];
		dp = new int[n];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < n; ++i)
			A[i] = Integer.parseInt(tmp[i]);

		dp[0] = A[0];
		for (int i = 1; i < n; i++) {
			dp[i] = A[i];
			if (dp[i - 1] + A[i] > dp[i])
				dp[i] = dp[i - 1] + A[i];
		}

		int ret = A[0];
		for (int i = 0; i < n; i++)
			ret = Math.max(ret, dp[i]);

		System.out.println(ret);

		br.close();
	}

}
