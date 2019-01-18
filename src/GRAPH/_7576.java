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
		// check 값 : -2 토마토 아님, -1 익지않음, 0 부터 일 수

		Queue<Place> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) { // 가장 처음 익었을 경우 0일
					check[i][j] = 0;
					queue.add(new Place(i, j)); // 0일 토마토는 큐에 다 집어 넣는다.
				}
				if (tomato[i][j] == 0) // 익지 않은 토마토는 -1 이라고 저장
					check[i][j] = -1;
			}
		}

		if (isRipen(check, N, M) != -1) {
			System.out.println(0);
			System.exit(0);
		}

		while (!queue.isEmpty()) { // 큐가 빌때까지 돌리면서
			Place place = queue.poll();
			for (int n = 0; n < 4; n++) {
				int y = place.y + dy[n];
				int x = place.x + dx[n];
				if (0 <= y && y < N && 0 <= x && x < M && check[y][x] == -1) {
					check[y][x] = check[place.y][place.x] + 1; // 익게해주는 토마토의 일수 + 1
					queue.add(new Place(y, x));
				}
			}
		}

		int ret = isRipen(check, N, M);
		System.out.println(ret >= 0 ? ret : -1);

		br.close();
	}

	static int isRipen(int[][] check, int N, int M) { // 안 익었으면 -1 리턴, 익었으면 다 익은 일 수 리턴
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
