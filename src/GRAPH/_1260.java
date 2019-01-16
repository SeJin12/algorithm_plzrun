package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1260 {
	
	static int N,M,V;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		boolean[][] arr = new boolean[N + 1][N + 1];
		boolean[] chD = new boolean[N + 1];
		boolean[] chB = new boolean[N + 1];

		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				arr[i][j] = false;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1][n2] = arr[n2][n1] = true;
		}
		dfs(arr, chD, V);
		System.out.println();
		bfs(arr, chB);

		br.close();
	}

	static void dfs(boolean[][] arr, boolean[] chD, int k) {
		if (chD[k])
			return;
		chD[k] = true;
		System.out.print(k + " ");
		for (int i = 1; i <= N; i++)
			if (arr[k][i])
				dfs(arr, chD, i);
	}

	static void bfs(boolean[][] arr, boolean[] chB) {
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		chB[V] = true;
		System.out.print(V + " ");
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i = 1; i <= N; i++)
				if (arr[node][i] && !chB[i]) {
					q.add(i);
					chB[i] = true;
					System.out.print(i + " ");
				}
		}
		System.out.println();
	}
}
