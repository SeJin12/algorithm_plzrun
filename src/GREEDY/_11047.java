package GREEDY;

import java.util.Scanner;

public class _11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();

		int cntCoin = 0;
		int idx = N - 1;
		while (K != 0) {
			int tmpVal = K / arr[idx];
			if (tmpVal >= 1) {
				cntCoin += tmpVal;
				K %= arr[idx];
			}
			idx -= 1;
		}

		System.out.println(cntCoin);

		sc.close();
	}
}
