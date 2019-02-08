package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// Ȯ�ο� 
// �����Ѱžƴ�;;
class _2632 {
	/*
	 * sum: ������� ������ �� idx: ���� ������ ���� newArr: ���ӵ� ������ ���� �����ϴ� arrayList start_idx:
	 * �����ε��� -(start_idx���� ���ڸ� ��� ����) check: ��Ҵ��� ���� ����/ true�̸� �ѹ��� ���Ҵٰ� �Ǵ� S: ����
	 * ���ϴ� ����. sum�� �� �̻��̸� ����
	 */
	public static void makePizza(long S, ArrayList<Long> newArr, long[] arr, int start_idx, boolean[] check, int idx,
			long sum) {

		if (idx == arr.length)// ������ ��Ұ� ù��° �������� �Ѿ
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
			check[i] = true;// ù��° ���� ����
			makePizza(S, new_A, A, i, check, i + 1, A[i]);
		}

		for (int i = 0; i < n; i++) {
			check = new boolean[n];
			check[i] = true;
			makePizza(S, new_B, B, i, check, i + 1, B[i]);
		}

		new_A.add(new Long(0));// �ƿ� ���� �ʴ� ���
		new_B.add(new Long(0));

		Collections.sort(new_A);
		Collections.sort(new_B);

		long count = 0;
		int left = 0;
		int right = new_B.size() - 1;
		while (left < new_A.size() && right >= 0) {
			long ls = new_A.get(left);
			long rs = new_B.get(right);

			if (ls + rs == S) {// S�� ��ġ�ϸ�, �� ���� ���տ��� �ش� ���� ���ϴ� ������ ������ ��
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