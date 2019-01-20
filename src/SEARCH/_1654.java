package SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1654 {
	// https://zorba91.tistory.com/entry/1654-1
	static int K, N;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		K = Integer.parseInt(tmp[0]);
		N = Integer.parseInt(tmp[1]);

		int[] arr = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		long max = arr[K - 1];
		long min = 1;
		long middle = 0;

		while (max >= min) {
			middle = (max + min) / 2;
			long allCount = 0;
			for (int j = 0; j < arr.length; j++) {
				allCount += arr[j] / middle;
			}

			if (allCount >= N)
				min = middle + 1;
			else if (allCount < N)
				max = middle - 1;

		}
		System.out.println(max);

		br.close();
	}
}
