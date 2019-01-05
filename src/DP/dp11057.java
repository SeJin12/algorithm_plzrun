package DP;

import java.util.Scanner;

public class dp11057 {

	static final int MOD = 10007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] arr = new int[N + 1][10];

		for (int i = 0; i <= 9; i++)
			arr[1][i] = 1;

		// cal
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					arr[i][j] += arr[i - 1][k];
				}
				arr[i][j] %= MOD;
			}
		}

		// print
		int ret = 0;
		for (int i = 0; i <= 9; i++)
			ret += arr[N][i];
		ret %= MOD;

		System.out.println(ret);

		sc.close();
	}
}
