package DP;

import java.util.Scanner;

public class dp2579 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // <= 300
		int[] stair = new int[n+1];
		for(int i=1;i<=n;i++)
			stair[i] = sc.nextInt();
		
		int[][] dp = new int[n+1][2];
		dp[1][0] = dp[1][1] = stair[1];
		
		for(int i=2;i<=n;i++) {
			dp[i][0] = Math.max(dp[i-2][0]+stair[i], dp[i-2][1]+stair[i]);
			dp[i][1] = dp[i-1][0] + stair[i]; 
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
		
		sc.close();
	}
	
}
