package EXHAUSTIVE_SEARCH;

import java.util.Scanner;

public class _1644 {
	static int prime[] = new int[400_0000 + 1];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		for (int i = 2; i <= n; i++) {
			for (int j = 2; j * i <= n; j++) {
				if (prime[i * j] == 1)
					continue;
				prime[i * j] = 1;
			}
		}

		int prime2[] = new int[n];
		int num = 0;
		for (int i = 2; i <= n; i++) {
			if (prime[i] == 0) {
				prime2[num++] = i;
			}
		}

		int s = 0, e = 0;
		int sum = 0;
		int result = 0;
		while (e <= num) {
			if (sum < n) { // sum 이 목표 n 보다 작다면
				sum += prime2[e++]; // prime[e]를 sum에 더해주고 e++해준다.
				continue;
			}
			// sum >=n 의 수행동작 
			if (sum == n)  
				++result;
			// 같다면 더 이상 s인덱스를 볼 필요없어 s++해주고 s의 값을 sum에서 빼준다.
			// sum이 n보다 크다면 sum의 크기를 낮춰야하기 때문에 s의 값을 빼준다.
			sum -= prime2[s++];
		}
		System.out.println(result);
	}

}
