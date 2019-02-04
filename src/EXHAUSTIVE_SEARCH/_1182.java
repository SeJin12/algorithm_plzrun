package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1182 {
	static int N, S;
	static int cntSeq = 0;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		arr = new int[N];
		s = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(s[i]);

		for (int i = 0; i < N; i++) {
			dfs(i, arr[i]);
		}
		System.out.println(cntSeq);
		br.close();
	}

	static void dfs(int idx, int sum) {
		if (sum == S) {
			cntSeq++;
		}
		for (int i = idx + 1; i < N; i++) {
			dfs(i, sum + arr[i]);
		}
	}

}
