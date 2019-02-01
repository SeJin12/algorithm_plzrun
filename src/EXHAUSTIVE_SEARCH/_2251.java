package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://mygumi.tistory.com/228
public class _2251 {
	static final int RANGE = 201; // 범위는 200 이하의 자연수
	static int a, b, c;
	static boolean[][] visit = new boolean[RANGE][RANGE];
	static boolean[] ans = new boolean[RANGE];

	static void dfs(int ca, int cb, int cc) {
		if (visit[ca][cb]) // 방문한 곳이라면 리턴 (최적화)
			return;
		if (ca == 0) // ca가 0이라면 cc를 ans 배열에 저장
			ans[cc] = true;
		visit[ca][cb] = true; // 방문했다면 true로 체크

		// a -> b
		if (ca + cb > b) // 물통 B의 총용량이 a,b에 들어있는 양보다 작다면?
			dfs((ca + cb) - b, b, cc); // a->b == b를 꽉 채우는 작업
		else // a,b의 양의 합이 B의 총용량보다 작다면?
			dfs(0, ca + cb, cc);

		// b -> a
		if (cb + ca > a)
			dfs(a, (cb + ca) - a, cc);
		else
			dfs(cb + ca, 0, cc);

		// c -> a
		if (cc + ca > a)
			dfs(a, cb, (cc + ca) - a);
		else
			dfs(cc + ca, cb, 0);

		// c -> b
		if (cc + cb > b)
			dfs(ca, b, (cc + cb) - b);
		else
			dfs(ca, cc + cb, 0);

		// b -> c, a -> c
		// a + b = c 이기 때문에, c가 넘칠 일이 없다?
		// 결국 가장 초기값들은 C의 총용량이므로 모든 것을 더한다한들 c가 넘칠일이 없다.
		dfs(ca, 0, cb + cc); // b -> c
		dfs(0, cb, ca + cc); // a -> a
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		a = Integer.parseInt(st[0]);
		b = Integer.parseInt(st[1]);
		c = Integer.parseInt(st[2]);

		dfs(0, 0, c);

		// 입력값이 자연수라서 결과값이 0을 포함해서는 안된다는 생각을 했다.
		// 물을 옮기면 C가 0일 될수도 있으므로 for문에서 i=0부터 시작해야한다.
		for (int i = 0; i <= 200; i++)
			if (ans[i])
				System.out.print(i + " ");
		System.out.println();

		br.close();
	}

}
