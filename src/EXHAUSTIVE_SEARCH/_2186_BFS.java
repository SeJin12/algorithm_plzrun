package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2186_BFS {
	// 결과 : 메모리 초과
	// BFS를 사용하면 큐에 많은 정보들이 담겨서 메모리 초과가 발생한다고 생각된다.
	// DFS + DP 를 사용해서 풀어야 하는 문제인 것 같다.
	static int N, M, K;
	static String WORD;
	static int[] dy = { -1, 0, 0, 1 }, dx = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		K = Integer.parseInt(st[2]);

		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}

		WORD = br.readLine().trim();
		int CNT = 0;
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == WORD.charAt(0)) {
					q.add(new Point(i, j, 1));
					while (!q.isEmpty()) {
						Point p = q.poll();
						if (p.cnt >= WORD.length()) {
							CNT++;
							continue;
						}
						for (int a = 0; a < 4; a++) {
							for (int k = 1; k <= K; k++) {
								int moveY = p.y + k * dy[a];
								int moveX = p.x + k * dx[a];
								if (0 <= moveY && moveY < N && 0 <= moveX && moveX < M) {
									if (arr[moveY][moveX] == WORD.charAt(p.cnt)) {
										q.offer(new Point(moveY, moveX, p.cnt + 1));
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println(CNT);

		br.close();
	}

	private static class Point {
		int y, x;
		int cnt;

		Point(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
}
