package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5014 {
	// 런타임 에러가 났던 이유. 배열의 인덱스를 초과해서 while문의 안쪽
	// 말 그대로 구현문제, 하라는 대로 하면 되는 문제라 쉬운 문제인거 같다.
	static int F, S, G, U, D;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		// S==G 가 같은 경우
		if (S == G) {
			System.out.println(0);
		} else {
			int[] floor = new int[1_000_001];
			Arrays.fill(floor, -1);
			Queue<Integer> q = new LinkedList<>();
			q.add(S);
			floor[S] = 0;
			while (!q.isEmpty()) {
				int curloc = q.poll();
				// 밑의 조건을 바로 밑의 if문에 가장 앞에 넣어서 배열의 인덱스 범위를 벗어나는 것을 막아주었다.
				// A && B 조건은  A가  false 면 뒤에껀 보지도 않고 넘어가기 때문에 이를 이용하여 방지해 주었다.
				if (curloc - D >= 1 && floor[curloc - D] == -1 && (curloc - D) != curloc) {
					// 이쪽 부분에  if(curloc - D >= 1) 를 넣었었는데 
					q.add(curloc - D);
					floor[curloc - D] = floor[curloc] + 1;

				}
				if (curloc + U <= F && floor[curloc + U] == -1 && (curloc + U) != curloc) {
					q.add(curloc + U);
					floor[curloc + U] = floor[curloc] + 1;
				}
			}
			System.out.println(floor[G] == -1 ? "use the stairs" : floor[G]);
		}
		br.close();
	}

}
