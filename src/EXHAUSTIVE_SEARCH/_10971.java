package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10971 {
	static int N, W[][];
	static int minCost = Integer.MAX_VALUE;
	static boolean[] visit;

	static void trip(int now, int dest, int cost, int cnt) {
		if (now == dest && cnt == N) { // 현재위치==도착지 인지, 도시 수만큼 방문했는지
			minCost = Math.min(minCost, cost);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (W[now][i] == 0 || i == now || visit[i]) // W[now][i]==0 : 갈수없음, 도시A에서 A로 못감, 방문했을시 재방문안함.
				continue;
			if (cost + W[now][i] >= minCost) // 다음 목적지까지의 비용이 minCost 보다 크다면 더 이상 확인 필요X(최적화)
				return;
			visit[i] = true;
			trip(i, dest, cost + W[now][i], cnt + 1);
			visit[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				W[i][j] = Integer.parseInt(st.nextToken());
		}
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			trip(i, i, 0, 0);
		}
		System.out.println(minCost);
		br.close();
	}
}
