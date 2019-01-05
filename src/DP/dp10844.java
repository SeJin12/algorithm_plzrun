package DP;

import java.util.Arrays;
import java.util.Scanner;

public class dp10844 {

	final static int MOD = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 1 <= <= 100
		int[][] arr = new int[n + 1][10];

		Arrays.fill(arr[1], 1);
		arr[1][0] = 0;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j - 1 >= 0)
					arr[i][j] += arr[i - 1][j - 1];
				if (j + 1 <= 9)
					arr[i][j] += arr[i - 1][j + 1];
				arr[i][j] %= MOD;
			}
		}
		long ret = 0;
		for (int i = 0; i <= 9; i++)
			ret += arr[n][i];
		ret %= MOD;

		System.out.println(ret);

		sc.close();
	}
}
