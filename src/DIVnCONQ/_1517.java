package DIVnCONQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1517 {
	// ref : http://me2.do/IDY5eUJU
	// TODO: �м��ϱ�  
	// FIXME: ���� �߱޾˰��� ��� �м��ϱ�
	static int N, input[], tmp[];

	static long countMoves(int l, int r) {
		if (l == r)
			return 0;

		int mid = (l + r) / 2;

		long ret = countMoves(l, mid) + countMoves(mid + 1, r); // ������ ������ ������ �� ��ȯ������ ret�� ����
		int ti = 0, li = l, ri = mid + 1;
		// l - li - mid - ri - r ����
		while (li <= mid || ri <= r) {
			if (li <= mid && (ri > r || input[li] <= input[ri])) {
				tmp[ti++] = input[li++]; // ������ �ʿ䰡 ���ٸ� li ���� tmp �迭�� �ִ´�.
			} else { // �����ؾ� �Ѵٸ�
				ret += mid - li + 1; // �� �κ��� ��Ȯ�� ���ذ� �ȵȴ�. 
				tmp[ti++] = input[ri++]; // ������ ���� ��ũ�� ������ tmp[ti]�� input[ri] ���� �ִ´�.
			}
		}

		for (int i = 0; i < r - l + 1; i++)
			input[l + i] = tmp[i];
		return ret;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = new int[N];
		tmp = new int[N];

		String[] st = br.readLine().split(" ");
		for (int i = 0; i < N; i++)
			input[i] = Integer.parseInt(st[i]);

		System.out.println(countMoves(0, N - 1));

		br.close();
	}

}
