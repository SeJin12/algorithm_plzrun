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
		if (now == dest && cnt == N) { // ������ġ==������ ����, ���� ����ŭ �湮�ߴ���
			minCost = Math.min(minCost, cost);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (W[now][i] == 0 || i == now || visit[i]) // W[now][i]==0 : ��������, ����A���� A�� ����, �湮������ ��湮����.
				continue;
			if (cost + W[now][i] >= minCost) // ���� ������������ ����� minCost ���� ũ�ٸ� �� �̻� Ȯ�� �ʿ�X(����ȭ)
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
