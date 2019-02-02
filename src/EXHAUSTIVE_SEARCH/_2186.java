package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2186 {
	// https://fatc.club/2017/03/01/559
	// ���� DPS�� Ǯ�鼭 �ð��ʰ� , �޸��ʰ��� ����.
	// �� �ع��� DP�� �̿��Ͽ� �ð��ʰ��� �ٿ���. ���� �������� ��Ÿ����
	// 2���� �迭�� �����ʰ� 1���� �迭�� Ǫ�� ����� ���ο���.
	static int N, M, K;
	static String[] board;
	static String WORD;
	static int[][][] dp;
	static int[] dy = { -1, 0, 0, 1 }, dx = { 0, -1, 1, 0 };
	static int len;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		K = Integer.parseInt(st[2]);

		board = new String[N];
		for (int i = 0; i < N; i++)
			board[i] = br.readLine();

		WORD = br.readLine().trim();
		len = WORD.length();

		dp = new int[N][M][len];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				Arrays.fill(dp[i][j], -1);

		int ret = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (board[i].charAt(j) == WORD.charAt(0))
					ret += rec(i, j, 0);

		System.out.println(ret);
		br.close();
	}

	private static int rec(int y, int x, int c) {
		if (c == len - 1)
			return 1; // ������ ���̸�ŭ üũ�ߴٸ� ��θ� ã������ 1�� ��ȯ

		if (dp[y][x][c] != -1)
			return dp[y][x][c]; // ������ c�ε����� üũ�Ҷ� ��ǥ y,x�� �湮�ߴٸ� �� �ڴ� �̹��� �۾��̹Ƿ� ���ؾ��Ѵ�.
		dp[y][x][c] = 0; // ó�� �湮�ߴٸ� 0���� �ʱ�ȭ ���ְ�
		for (int i = 0; i < 4; i++) {
			for (int k = 1; k <= K; k++) {
				int moveY = y + k * dy[i];
				int moveX = x + k * dx[i];
				if (0 <= moveY && moveY < N && 0 <= moveX && moveX < M) {
					if (board[moveY].charAt(moveX) == WORD.charAt(c + 1)) {
						dp[y][x][c] += rec(moveY, moveX, c + 1);
					}
				}
			}
		}

		return dp[y][x][c];
	}
}
