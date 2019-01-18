package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2146 {
	// 전   방식  : 메모리 = 366888 KB , 시간 = 2244 ms
	// 개선 방식 : 메모리 = 263252 KB , 시간 =  488 ms
	// 현   방식  : 메모리 = 137612 KB , 시간 =  244 ms
	
	final static int[] dy = { -1, 0, 0, 1 };
	final static int[] dx = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] arr = new int[N][N];
		String[] tmp;

		for (int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		
		// 입력 받은 배열의 값들이 0,1 이기 때문에 섬 번호 부여를 2부터 하였다.
		int landNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) { // 배열 값이 1일 경우, 섬번호를 부여 받지 않았기 때문에 부여하는 작업을 한다.
					Queue<__Place> queue = new LinkedList<>();
					queue.add(new __Place(i, j));
					arr[i][j] = landNum;
					while (!queue.isEmpty()) {
						__Place p = queue.poll();
						for (int a = 0; a < 4; a++) {
							int y = p.y + dy[a];
							int x = p.x + dx[a];
							if (0 <= y && y < N && 0 <= x && x < N && arr[y][x] == 1) {
								queue.add(new __Place(y, x));
								arr[y][x] = landNum;
							}
						}
					}
					landNum += 1;
				}
			}
		} // 이 작업이 끝나면 섬마다 차례대로 2,3,4의 섬들의 번호가 부여된다. (입력예제)

		int ret = Integer.MAX_VALUE; // 결과값이 최소값을 출력해야하기 때문에, Math.min을 사용하기 때문에 가장 큰값으로 초기화 해준다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0) {
					boolean[][] check = new boolean[N][N]; // 한 정점에서 작업을 시작할 경우, boolean 배열을 초기화해준다.
					Queue<__Place> queue = new LinkedList<>();
					queue.add(new __Place(i, j, 0));
					check[i][j] = true;

					A:while (!queue.isEmpty()) {
						__Place p = queue.poll();
						for (int a = 0; a < 4; a++) {
							int y = p.y + dy[a];
							int x = p.x + dx[a];
							if (0 <= y && y < N && 0 <= x && x < N && !check[y][x] && arr[y][x] != arr[i][j]) {
								if (arr[y][x] == 0) {
									queue.add(new __Place(y, x, p.d + 1));
									check[y][x] = true;
								} else if (arr[y][x] != arr[i][j]) { // 새로운 섬을 만났을 때 
									ret = Math.min(ret, p.d);
									break A; // 최소 값을 찾았을 경우, 더 이상 작업을 할 필요가 없기에 while문을 끝낸다.
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ret);

		br.close();
	}

}

class __Place {
	int y;
	int x;
	int d; // distance

	public __Place(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public __Place(int y, int x, int d) {
		this.y = y;
		this.x = x;
		this.d = d;
	}
}
