package DIVnCONQ;

import java.util.Arrays;
import java.util.Scanner;

public class _2447 {
	// ó�� char�迭�� �ʱ�ȭ ���־����� ����
	
	static char[][] matrix;

	static void solve(int y, int x, int num) {
		if (num == 1) {
			matrix[y][x] = '*';
			return;
		}
		int div = num / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1)
					continue;
				solve(y + (i * div), x + (j * div), div);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N = 3^k ( k -> [0,8) )
		matrix = new char[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(matrix[i], ' ');
		}
		solve(0, 0, N);
		for (int i = 0; i < N; i++) {
			System.out.println(matrix[i]); // �̷��������ϸ� char[]�� �ѹ��� ����
		}

		sc.close();
	}
}
