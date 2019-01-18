package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _7576 {

	final static int[] dy = { -1, 0, 0, 1 };
	final static int[] dx = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[1]);
		int M = Integer.parseInt(tmp[0]);

		int[][] tomato = new int[N][M];
		int[][] check = new int[N][M];

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(tmp[j]);
			}
			Arrays.fill(check[i], -2);
		}
		// check �� : -2 �丶�� �ƴ�, -1 ��������, 0 ���� �� ��

		Queue<Place> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) { // ���� ó�� �;��� ��� 0��
					check[i][j] = 0;
					queue.add(new Place(i, j)); // 0�� �丶��� ť�� �� ���� �ִ´�.
				}
				if (tomato[i][j] == 0) // ���� ���� �丶��� -1 �̶�� ����
					check[i][j] = -1;
			}
		}

		if (isRipen(check, N, M) != -1) {
			System.out.println(0);
			System.exit(0);
		}

		while (!queue.isEmpty()) { // ť�� �������� �����鼭
			Place place = queue.poll();
			for (int n = 0; n < 4; n++) {
				int y = place.y + dy[n];
				int x = place.x + dx[n];
				if (0 <= y && y < N && 0 <= x && x < M && check[y][x] == -1) {
					check[y][x] = check[place.y][place.x] + 1; // �Ͱ����ִ� �丶���� �ϼ� + 1
					queue.add(new Place(y, x));
				}
			}
		}

		int ret = isRipen(check, N, M);
		System.out.println(ret >= 0 ? ret : -1);

		br.close();
	}

	static int isRipen(int[][] check, int N, int M) { // �� �;����� -1 ����, �;����� �� ���� �� �� ����
		int date = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				date = Math.max(date, check[i][j]);
				if (check[i][j] == -1)
					return -1;
			}
		return date;
	}

}

class Place {
	int y;
	int x;

	public Place(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}
}
