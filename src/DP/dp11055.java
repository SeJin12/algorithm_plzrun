package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dp11055 {
	
	static int[] lis,dp;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		lis = new int[n];
		dp = new int[n];
		
		String s[] = br.readLine().split(" ");
		for(int i=0;i<n;++i)
			lis[i] = Integer.parseInt(s[i]);
		
		int ret = 0;
		for(int i=0;i<n;++i) {
			dp[i] = lis[i];
			for(int j=0;j<i;j++) {
				if(lis[j]<lis[i]) {
					dp[i] = Math.max(dp[i], dp[j]+lis[i]);
				}
			}
			ret = Math.max(dp[i], ret);
		}
		
		System.out.println(ret);
		
		
		br.close();
	}
}
