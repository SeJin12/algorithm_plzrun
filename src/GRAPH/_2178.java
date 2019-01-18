package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2178 {

	final static int[] dy = { -1, 0, 0, 1 };
	final static int[] dx = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");

		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		int[][] miro = new int[N][M];
		boolean[][] time = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				miro[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		Queue<_Place> queue = new LinkedList<>();
		queue.add(new _Place(0, 0));
		time[0][0] = true;
		while (!queue.isEmpty()) {
			_Place p = queue.poll();
			for (int n = 0; n < 4; n++) {
				int y = p.y + dy[n];
				int x = p.x + dx[n];
				if (0 <= y && 0 <= x && y < N && x < M && miro[y][x] == 1 && !time[y][x]) {
					queue.add(new _Place(y, x));
					miro[y][x] = miro[p.y][p.x] +1;
					time[y][x] = true;
				}
			}
		}

		System.out.println(miro[N - 1][M - 1]);

		br.close();
	}

}

class _Place {
	int y;
	int x;

	public _Place(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
