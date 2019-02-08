package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
// 내가 푼거 아님 뭔소리인지 모르겠다.
// 비트마스크로 푸는 방법도 있음
public class _1208 {
	static int N, S;

	static void makePre(int[] arr, int idx, int e, int sum, ArrayList<Integer> array) {
		if (idx >= e) { // 끝까지 다 돌았다면
			array.add(sum);
			return;
		}
		makePre(arr, idx + 1, e, sum, array); // 현재 인덱스를 포함할 때
		makePre(arr, idx + 1, e, sum + arr[idx], array); // 현재 인덱스를 포함하지 않을 때
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<Integer> second = new ArrayList<>();

		makePre(arr, 0, N / 2, 0, first);
		makePre(arr, N / 2, N, 0, second);
		Collections.sort(first);
		Collections.sort(second);

		int left = 0;
		int right = second.size() - 1;
		long ans = 0;

		while (left < first.size() && right >= 0) {
			long ls = first.get(left);
			long rs = second.get(right);

			if (ls + rs == S) { // S와 일치하면, 각 분할 집합에서 해당 합을 지니는 원소의 개수를 셈
				long lc = 0;
				while (left < first.size() && first.get(left) == ls) {
					lc++;
					left++;
				}
				long rc = 0;
				while (right >= 0 && second.get(right) == rs) {
					rc++;
					right--;
				}
				ans += lc * rc;
			}
			if (ls + rs > S)
				right--;
			if (ls + rs < S)
				left++;
		}
		if (S == 0) {
			ans -= 1;
		}
		System.out.println(ans);
		br.close();
	}

}
