package SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2110 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int C = Integer.parseInt(tmp[1]);

		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine().trim());

		Arrays.sort(arr);

		int left = 1;// 가능한 최소 거리
		int right = arr[N - 1] - arr[0]; // 가능한 최대 거리
		int cnt, mid, std, ans = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			cnt = 1;
			std = arr[0];

			for (int i = 1; i < N; i++) {
				if (arr[i] - std >= mid) {
					cnt++;
					std = arr[i];
				}
			}

			if (cnt >= C) { // 실제 설치해야할 공유기 수 보다 더 많이 설치 -> 간격 늘려야
				ans = mid;
				left = mid + 1; // 오른쪽 파트에서 찾자
			} else {
				right = mid - 1; // 왼쪽 파트에서 찾자
			}

		}
		System.out.println(ans);

		br.close();
	}
}