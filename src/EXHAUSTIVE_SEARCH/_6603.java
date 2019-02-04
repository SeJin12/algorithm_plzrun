package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _6603 {

	static int k;

	static void dfs(int[] arr, int before, int cnt, String s) {
		if (cnt == 6) {
			System.out.println(s);
			return;
		}
		for (int i = before + 1; i < k; i++) {
			dfs(arr, i, cnt + 1, s + arr[i] + " ");
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] line;
		while (true) {
			line = br.readLine().split(" ");
			k = Integer.parseInt(line[0]);
			if (k == 0)
				break;
			int[] arr = new int[k];
			for (int i = 1; i <= k; i++) {
				arr[i - 1] = Integer.parseInt(line[i]);
			}

			for (int i = 0; i <= k - 6; i++) {
				dfs(arr, i, 1, arr[i] + " ");
			}
			System.out.println();
		}

		br.close();
	}
}
