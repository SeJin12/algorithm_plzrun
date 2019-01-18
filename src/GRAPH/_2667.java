package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class _2667 {
	final static int[] dx = { -1, 0, 0, 1 };
	final static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] home = new int[N + 1][N + 1];
		int[][] check = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 1; j <= N; j++) {
				home[i][j] = Integer.parseInt(tmp[j - 1]);
			}
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (home[i][j] == 1 && check[i][j] == 0) {
					Queue<_Point> q = new LinkedList<>();
					q.add(new _Point(i, j));
					check[i][j] = list.size() + 1;
					int count = 1;
					while (!q.isEmpty()) {
						_Point p = q.poll();
						for (int a = 0; a < 4; a++) {
							int px = p.x + dy[a];
							int py = p.y + dx[a];
							if (0 < px && px <= N && 0 < py && py <= N && home[px][py] == 1 && check[px][py] == 0) {
								q.add(new _Point(px, py));
								check[px][py] = list.size() + 1;
								count++;
							}
						}
					} // while End
					list.add(count);
				}
			}
		}

		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		});

		System.out.println(list.size());
		for (int i : list)
			System.out.println(i);

		br.close();
	}

}

class _Point {
	int x, y;

	_Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
