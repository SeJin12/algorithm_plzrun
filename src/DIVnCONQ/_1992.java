package DIVnCONQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992 {

	static StringBuilder sb = new StringBuilder();
	static int[][] video;

	static boolean check(int n, int row, int col) {
		int tmp = video[row][col];
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (tmp != video[i][j])
					return false;
			}
		}
		return true;
	}

	static void compact(int n, int row, int col) {
		if (check(n, row, col)) {
			sb.append(video[row][col]);
		} else {

			int len = n / 2;
			sb.append("(");
			for (int i = row; i < row + n; i += len) {
				for (int j = col; j < col + n; j += len) {
					compact(len, i, j);
				}
			}
			sb.append(")");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // (0,64] 2^k

		video = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for (int j = 0; j < N; j++)
				video[i][j] = Integer.parseInt(tmp[j]);
		}
		compact(N, 0, 0);
		System.out.println(sb);

		br.close();
	}

}
