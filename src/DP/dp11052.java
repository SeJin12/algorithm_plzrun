package DP;

import java.util.Scanner;

// 카드 구매하기
public class dp11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cards = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++)
			cards[i] = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(dp[i-j]+cards[j]>dp[i])
					dp[i] = dp[i-j] + cards[j];
			}
		}
		
		System.out.println(dp[n]);
		
		
		sc.close();
	}
}
