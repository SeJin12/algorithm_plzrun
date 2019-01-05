package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class dp11053 {

	static int[] lis, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		lis = new int[N];
		dp = new int[N];

		String[] s = br.readLine().split(" ");
		for (int i = 0; i < s.length; i++)
			lis[i] = Integer.parseInt(s[i]);
		
		Arrays.fill(dp, 1);
		
		int ret = -1;

		for (int i = 0; i < lis.length; i++) {
			for (int j = 0; j < i; j++) {
				if(lis[i]>lis[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			ret = Math.max(ret, dp[i]);
		}
		

		System.out.println(ret);

		br.close();
	}

}
