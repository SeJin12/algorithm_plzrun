package DP;

import java.util.Scanner;

// �ĵ��� ����
public class dp9461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n;

		long[] pn = new long[101]; // ������ ũ�� �þ�� ������ int���� ���� ������ �ʰ��� 
		long[] init = { 1, 1, 1, 2, 2, 3, 4, 5, 7, 9 };

		System.arraycopy(init, 0, pn, 1, init.length);
		// init �迭�� index [0,init.lenth)��  pn �迭�� index 1���� init.length ��ŭ ���� ������

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
