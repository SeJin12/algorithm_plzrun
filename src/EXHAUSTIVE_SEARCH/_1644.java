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
			if (sum < n) { // sum �� ��ǥ n ���� �۴ٸ�
				sum += prime2[e++]; // prime[e]�� sum�� �����ְ� e++���ش�.
				continue;
			}
			// sum >=n �� ���ൿ�� 
			if (sum == n)  
				++result;
			// ���ٸ� �� �̻� s�ε����� �� �ʿ���� s++���ְ� s�� ���� sum���� ���ش�.
			// sum�� n���� ũ�ٸ� sum�� ũ�⸦ ������ϱ� ������ s�� ���� ���ش�.
			sum -= prime2[s++];
		}
		System.out.println(result);
	}

}
