package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _1261 {
	static int N, M;
	static int arr[][];
	static int dy[] = { -1, 0, 0, 1 }, dx[] = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[1]);
		M = Integer.parseInt(st[0]);
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = br.readLine().split("");
			for (int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}
		int[][] store = new int[N][M];
		for (int i = 0; i < N; i++)
			Arrays.fill(store[i], 987654321);

		Queue<AOJ> q = new LinkedList<>();
		q.add(new AOJ(0, 0, 0));
		store[0][0] = 0;
		while (!q.isEmpty()) {
			AOJ aoj = q.poll();
			for (int i = 0; i < 4; i++) {
				int y = aoj.y + dy[i], x = aoj.x + dx[i];
				if (0 <= y && y < N && 0 <= x && x < M) {
					if (arr[y][x] == 0 && aoj.cnt < store[y][x]) {
						store[y][x] = aoj.cnt;
						q.add(new AOJ(y, x, aoj.cnt));
					} else if (arr[y][x] == 1 && aoj.cnt + 1 < store[y][x]) {
						store[y][x] = aoj.cnt + 1;
						q.add(new AOJ(y, x, aoj.cnt + 1));
					}
				}
			}
		}
		System.out.println(store[N - 1][M - 1]);
		br.close();
	}

	private static class AOJ {
		int y, x, cnt;
		AOJ(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
