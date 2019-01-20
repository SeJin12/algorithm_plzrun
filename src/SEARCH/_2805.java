package SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2805 {
	static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);

		int[] arr = new int[N];
		tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}

		Arrays.sort(arr);
		long min = 1;
		long max = arr[N - 1];
		long mid;

		while (min <= max) {
			mid = (min + max) / 2;
			long cnt = 0;
			for (int i = 0; i < N; i++) {
				long su = arr[i] - mid;
				if (su > 0)
					cnt += su;
			}
			if (cnt >= M) {
				min = mid + 1;
			} else {
				max = mid - 1;
			}
			
		}
		System.out.println(max);

		br.close();
	}
}
