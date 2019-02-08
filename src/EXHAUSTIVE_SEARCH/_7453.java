package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// n^4는 시간초과가 난다. => 최적화 해야 한다.
public class _7453 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[][] arr = new int[4][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		int[] plus1 = new int[n * n];
		int[] plus2 = new int[n * n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				plus1[count] = arr[0][i] + arr[1][j];
				plus2[count++] = arr[2][i] + arr[3][j];
			}
		}
		Arrays.sort(plus1);
		Arrays.sort(plus2);

		long zero = 0;
		int min = 0, max = n * n - 1;
		long count1, count2;
		int temp1, temp2;

		while (min < n * n && max >= 0) {
			if (plus1[min] + plus2[max] < 0) {
				min++;
			} else if (plus1[min] + plus2[max] == 0) {
				count1 = count2 = 0;
				temp1 = plus1[min];
				temp2 = plus2[max];
				for (; min < n * n; min++) {
					if (plus1[min] == temp1)
						count1++;
					else
						break;
				}
				for (; max >= 0; max--) {
					if (plus2[max] == temp2)
						count2++;
					else
						break;
				}
				zero += count1 * count2;
			} else if (plus1[min] + plus2[max] > 0) {
				max--;
			}
		}
		System.out.println(zero);
		br.close();
	}
}
