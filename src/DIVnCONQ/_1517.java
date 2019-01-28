package DIVnCONQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1517 {
	// ref : http://me2.do/IDY5eUJU
	// TODO: 분석하기  
	// FIXME: 기초 중급알고리즘 듣고 분석하기
	static int N, input[], tmp[];

	static long countMoves(int l, int r) {
		if (l == r)
			return 0;

		int mid = (l + r) / 2;

		long ret = countMoves(l, mid) + countMoves(mid + 1, r); // 범위를 반으로 나누어 그 반환값들을 ret에 저장
		int ti = 0, li = l, ri = mid + 1;
		// l - li - mid - ri - r 순서
		while (li <= mid || ri <= r) {
			if (li <= mid && (ri > r || input[li] <= input[ri])) {
				tmp[ti++] = input[li++]; // 정렬할 필요가 없다면 li 값을 tmp 배열에 넣는다.
			} else { // 정렬해야 한다면
				ret += mid - li + 1; // 이 부분이 정확히 이해가 안된다. 
				tmp[ti++] = input[ri++]; // 오른쪽 값이 더크기 때문에 tmp[ti]에 input[ri] 값을 넣는다.
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
