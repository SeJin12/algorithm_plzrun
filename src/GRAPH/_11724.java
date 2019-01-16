package GRAPH;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
//TODO 한번 더 분석
public class _11724 {
	static int N, M;
	static boolean[] visit;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		visit = new boolean[N + 1];
		arr = new int[N + 1][N + 1];

		for (int i = 0; i < M; ++i) {
			tmp = br.readLine().split(" ");
			int n1 = Integer.parseInt(tmp[0]);
			int n2 = Integer.parseInt(tmp[1]);
			arr[n1][n2] = arr[n2][n1] = 1;
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				cnt++;
				dfs(i);
			}
		}
		System.out.println(cnt);
		br.close();
	}

	static void dfs(int v) {
		for (int i = 1; i <= N; i++) {
			if (arr[v][i] == 1 && !visit[i]) {
				visit[i] = true;
				dfs(i);
			}
		}
	}

}
