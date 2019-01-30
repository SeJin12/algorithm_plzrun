package GREEDY;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2873 {
	//FIXME ���� ����� ������. ���Ǹ� ��� �ٽ� �м�
	static int R, C; // [2,1000]

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		R = Integer.parseInt(st[0]); // R�� ���� odd,even�� ���� �̵��ϴ� ���� �޶�����.
		C = Integer.parseInt(st[1]);

		StringBuilder sb = new StringBuilder();
		// �迭�� �ε����� [0,R) [0,C)
		if (R % 2 == 1) { // ���ΰ� Ȧ���� ���
			for (int y = 0; y < R; y++) {
				for (int x = 0; x < C - 1; x++) {
					if (y % 2 == 0) // C-2 ��ŭ ������(R)
						sb.append("R");
					else // C-2 ��ŭ ����(L)
						sb.append("L");
				}
				if (y != R - 1) // for���� �� ���� �� �� ������ ���� �ƴϸ� ��� �Ʒ��� �������� ������ �࿡���� �����Ͽ����Ƿ� �׸�
					sb.append("D");
			}
		} else if (R % 2 == 0 && C % 2 == 1) {// ���ΰ� Ȧ���� ��� && ���ΰ� Ȧ��
			for (int x = 0; x < C; x++) {
				for (int y = 0; y < R - 1; y++) {
					if (x % 2 == 0)
						sb.append("D");
					else
						sb.append("U");
				}
				if (x != C - 1)
					sb.append("R");
			}
		} else if (R % 2 == 0 && C % 2 == 0) { // ���� ���ΰ� ¦���� ���
			// ���� ĭ�̸鼭 ������ ���ƾ� �� ����
			Pair minHappy = new Pair(0, 0);
			int minScore = Integer.MAX_VALUE;
			int[][] loc = new int[R][C];
			for (int y = 0; y < R; y++) {
				st = br.readLine().split(" ");
				for (int x = 0; x < C; x++) {
					loc[y][x] = Integer.parseInt(st[x]);
					// ���� ĭ�̰� �ּ����� ++
					if ((y + x) % 2 == 1 && minScore > loc[y][x]) {
						minScore = loc[y][x];
						minHappy.first = y;
						minHappy.second = x;
					}
				}
			}
			// ������ ���ƾ� �� ��ǥ�� ���������� ��������
			int newR = minHappy.first % 2 == 1 ? minHappy.first - 1 : minHappy.first;
			for (int y = 0; y < newR; y++) {
				for (int x = 0; x < C - 1; x++)
					if (y % 2 == 0)
						sb.append("R");
					else
						sb.append("L");
				sb.append("D");
			}
			// ������ ���ƾ� �� ��ǥ�� �밢�� �Ʒ����� �̵��ϰ� ( �� )
			int newC = minHappy.second;
			for (int x = 0; x < newC; x++)
				if (x % 2 == 0)
					sb.append("DR");
				else
					sb.append("UR");

			// ������ ���ƾ� �� ��ǥ�� �ֿ������� �̵�
			for (int x = newC; x < C - 1; x++)
				if (x % 2 == 0)
					sb.append("RD");
				else
					sb.append("RU");

			// ����������
			if (minHappy.first % 2 == 0)
				newR = R - (minHappy.first + 2);
			else
				newR = R - (minHappy.first + 1);

			for (int y = 0; y < newR; y++) {
				sb.append("D");
				for (int x = 0; x < C - 1; x++)
					if (y % 2 == 0)
						sb.append("L");
					else
						sb.append("R");
			}

		}

		System.out.println(sb);

		br.close();
	}

	private static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

}
