package DP;

import java.util.Scanner;

// 파도반 수열
public class dp9461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n;

		long[] pn = new long[101]; // 값들이 크게 늘어나기 때문에 int형을 쓰면 범위를 초과함 
		long[] init = { 1, 1, 1, 2, 2, 3, 4, 5, 7, 9 };

		System.arraycopy(init, 0, pn, 1, init.length);
		// init 배열의 index [0,init.lenth)를  pn 배열에 index 1부터 init.length 만큼 값을 복사함

		for (int i = 11; i < 101; i++)
			pn[i] = pn[i - 2] + pn[i - 3];
		// OR : pn[i-1] + pn[i-5];

		for (int t = 1; t <= T; t++) {
			n = sc.nextInt();
			System.out.println(pn[n]);
		}

		sc.close();
	}

}
