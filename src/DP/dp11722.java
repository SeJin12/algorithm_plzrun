package DP;

import java.util.Arrays;
import java.util.Scanner;

public class dp11722 {
	static int[] lds,dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		lds = new int[n];
		for(int i=0;i<n;i++)
			lds[i] = sc.nextInt();
		
		dp = new int[n];
		Arrays.fill(dp, 1);
		
		int ret = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(lds[j]>lds[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			ret = Math.max(ret, dp[i]);
		}
		
		System.out.println(ret);
		
		sc.close();
	}
}
