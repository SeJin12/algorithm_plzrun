package DP;

import java.util.Scanner;

// 암호 코드
public class dp2011 {
	static final int MOD = 100_0000;
	static long count = 0;
	//TODO : 모르겠다 해석해야 한다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = sc.nextLine();
		// A = 1 ~ Z = 26
		int n = code.length();
		char[] s = new char[n + 1];
		for (int i = 1; i <= n; i++)
			s[i] = code.charAt(i - 1);

		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			int x = s[i] - '0';
			if (1 <= x && x <= 9)
				dp[i] = (dp[i] + dp[i - 1]) % MOD;
			if (i == 1)
				continue;
			if (s[i - 1] == '0')
				continue;
			x = (s[i - 1] - '0') * 10 + (s[i] - '0');
			if (10 <= x && x <= 26)
				dp[i] = (dp[i] + dp[i - 2]) % MOD;
		}

		System.out.println(dp[n]);
		
		sc.close();
	}

}
