package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2186 {
	// https://fatc.club/2017/03/01/559
	// 내가 DPS를 풀면서 시간초과 , 메모리초과가 났다.
	// 이 해법은 DP를 이용하여 시간초과를 줄였다. 또한 문자판을 나타낼때
	// 2차원 배열을 쓰지않고 1차원 배열로 푸는 방법이 새로웠다.
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
			return 1; // 문자의 길이만큼 체크했다면 경로를 찾았으면 1을 반환

		if (dp[y][x][c] != -1)
			return dp[y][x][c]; // 문자의 c인덱스를 체크할때 좌표 y,x를 방문했다면 그 뒤는 이미한 작업이므로 안해야한다.
		dp[y][x][c] = 0; // 처음 방문했다면 0으로 초기화 해주고
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
