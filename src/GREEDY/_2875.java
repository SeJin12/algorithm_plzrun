package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int N = Integer.parseInt(st[0]); // GIRL
		int M = Integer.parseInt(st[1]); // BOY
		int K = Integer.parseInt(st[2]);

		int cntTeam = 0;
		// ����(N)�� ����(M)�� ���� ��, 2���� ���ڸ� ���� ���ٰ� �����Ѵ�.
		// why? 1������ ���� �̷� �� �ִ� ���� ���� �����ϱ� ������
		while (K-- > 0) {
			if (N / 2 >= M)
				N--;
			else
				M--;
		}

		cntTeam = N / 2 <= M ? N / 2 : M;

		System.out.println(cntTeam);

		br.close();
	}
}
