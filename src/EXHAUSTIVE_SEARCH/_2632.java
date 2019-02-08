package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 확인용 
// 내가한거아님;;
class _2632 {
	/*
	 * sum: 현재까지 면적의 합 idx: 현재 포함할 피자 newArr: 연속된 집합의 합을 저장하는 arrayList start_idx:
	 * 시작인덱스 -(start_idx부터 피자를 담기 시작) check: 담았는지 상태 저장/ true이면 한바퀴 돌았다고 판단 S: 고객이
	 * 원하는 피자. sum이 이 이상이면 끝냄
	 */
	public static void makePizza(long S, ArrayList<Long> newArr, long[] arr, int start_idx, boolean[] check, int idx,
			long sum) {

		if (idx == arr.length)// 끝까지 담았고 첫번째 조각으로 넘어감
			idx = 0;

		newArr.add(sum);
		if (check[idx] == false && sum + arr[idx] <= S && idx != start_idx - 1) {
			check[idx] = true;
			makePizza(S, newArr, arr, start_idx, check, idx + 1, sum += arr[idx]);
		} else
			return;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long S = Long.parseLong(br.readLine());

		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(stringTokenizer.nextToken());
		int n = Integer.parseInt(stringTokenizer.nextToken());

		long[] A = new long[m];
		long[] B = new long[n];

		for (int i = 0; i < m; i++)
			A[i] = Long.parseLong(br.readLine());

		for (int i = 0; i < n; i++)
			B[i] = Long.parseLong(br.readLine());

		ArrayList<Long> new_A = new ArrayList<>();
		ArrayList<Long> new_B = new ArrayList<>();

		boolean[] check;
		for (int i = 0; i < m; i++) {
			check = new boolean[m];
			check[i] = true;// 첫번째 조각 담음
			makePizza(S, new_A, A, i, check, i + 1, A[i]);
		}

		for (int i = 0; i < n; i++) {
			check = new boolean[n];
			check[i] = true;
			makePizza(S, new_B, B, i, check, i + 1, B[i]);
		}

		new_A.add(new Long(0));// 아예 담지 않는 경우
		new_B.add(new Long(0));

		Collections.sort(new_A);
		Collections.sort(new_B);

		long count = 0;
		int left = 0;
		int right = new_B.size() - 1;
		while (left < new_A.size() && right >= 0) {
			long ls = new_A.get(left);
			long rs = new_B.get(right);

			if (ls + rs == S) {// S와 일치하면, 각 분할 집합에서 해당 합을 지니는 원소의 개수를 셈
				long lc = 0;
				while (left < new_A.size() && new_A.get(left) == ls) {
					lc++;
					left++;
				}

				long rc = 0;
				while (right >= 0 && new_B.get(right) == rs) {
					rc++;
					right--;
				}

				count += lc * rc;
			}

			if (ls + rs > S)
				right--;
			if (ls + rs < S)
				left++;

		}

		System.out.println(count);

	}

}