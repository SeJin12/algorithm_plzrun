package SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _10816 {
	// ½Ã°£ ÃÊ°ú ¶ä
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			card[i] = Integer.parseInt(tmp[i]);
		Arrays.sort(card);
		int M = Integer.parseInt(br.readLine());
		int[] check = new int[M];
		tmp = br.readLine().split(" ");
		for (int i = 0; i < M; i++)
			check[i] = Integer.parseInt(tmp[i]);

		for (int i = 0; i < M; i++) {
			int target = check[i];
			int cnt = 0;
			
			if (target < card[0] || target > card[N - 1]) {
				System.out.print(cnt + " ");
				continue;
			}

			
			int min = 0;
			int max = N - 1;
			int mid;

			while (0 <= min && min < N && 0 <= max && max < N && min <= max) {
				mid = (min + max) / 2;
				if (card[mid] < target) {
					min = mid + 1;
				} else if (card[mid] > target) {
					max = mid - 1;
				} else {
					cnt = 1;
					int cNum = mid + 1;
					while (cNum < N) {
						if (card[cNum++] == target)
							cnt++;
						else
							break;
					}
					cNum = mid - 1;
					while (cNum >= 0) {
						if (card[cNum--] == target)
							cnt++;
						else
							break;
					}
					break;
				}
			}
			System.out.print(cnt + " ");
		}

		br.close();
	}

}
