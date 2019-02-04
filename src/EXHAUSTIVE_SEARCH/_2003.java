package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2003 {
	static int N, M;
	static int cnt = 0;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		dp = new int[N];
		s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				dp[i] = Integer.parseInt(s[i]);
			} else {
				dp[i] = dp[i - 1] + Integer.parseInt(s[i]);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i == j && dp[i] == M) {
					cnt++;
					continue;
				}
				if (dp[j] - dp[i] == M) {
					cnt++;
				}

			}
		}

		System.out.println(cnt);
		br.close();
	}
}
