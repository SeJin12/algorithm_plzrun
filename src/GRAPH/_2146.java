package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _2146 {
	// ��   ���  : �޸� = 366888 KB , �ð� = 2244 ms
	// ���� ��� : �޸� = 263252 KB , �ð� =  488 ms
	// ��   ���  : �޸� = 137612 KB , �ð� =  244 ms
	
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
		
		// �Է� ���� �迭�� ������ 0,1 �̱� ������ �� ��ȣ �ο��� 2���� �Ͽ���.
		int landNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) { // �迭 ���� 1�� ���, ����ȣ�� �ο� ���� �ʾұ� ������ �ο��ϴ� �۾��� �Ѵ�.
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
		} // �� �۾��� ������ ������ ���ʴ�� 2,3,4�� ������ ��ȣ�� �ο��ȴ�. (�Է¿���)

		int ret = Integer.MAX_VALUE; // ������� �ּҰ��� ����ؾ��ϱ� ������, Math.min�� ����ϱ� ������ ���� ū������ �ʱ�ȭ ���ش�.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0) {
					boolean[][] check = new boolean[N][N]; // �� �������� �۾��� ������ ���, boolean �迭�� �ʱ�ȭ���ش�.
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
								} else if (arr[y][x] != arr[i][j]) { // ���ο� ���� ������ �� 
									ret = Math.min(ret, p.d);
									break A; // �ּ� ���� ã���� ���, �� �̻� �۾��� �� �ʿ䰡 ���⿡ while���� ������.
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
