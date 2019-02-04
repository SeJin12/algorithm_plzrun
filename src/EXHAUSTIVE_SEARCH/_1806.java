package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 시간복잡도 N^2을 줄이기 못하여 실패;; 시간초과 뜸
// 미친풀이 http://wookje.dance/2018/03/21/boj-1806-%EB%B6%80%EB%B6%84%ED%95%A9/
public class _1806 {
	static int n, s, r = 100000, a[] = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		s = Integer.parseInt(st[1]);

		st = br.readLine().split(" ");
		for (int i = 1, j = 0; i <= n; i++) {
			a[i] = Integer.parseInt(st[i - 1]);
			a[i] += a[i - 1];
			for (; a[i] - a[j] >= s; j++)
				r = Math.min(r, i - j);
		}
		System.out.println(r == 100000 ? 0 : r);
		br.close();
	}
}
