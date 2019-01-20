package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _1967 {

	// http://lmcoa15.tistory.com/56

	static ArrayList<ArrayList<_Node>> list;
	static int N;
	static int ans = 0; // 지름 길이
	static int end_point = 0; // 지름에 해당하는 끝점
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			list.get(Integer.parseInt(tmp[0])).add(new _Node(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
			list.get(Integer.parseInt(tmp[1])).add(new _Node(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[2])));
		}

		visited = new boolean[N + 1];
		// 어떤 정점에서 출발 해도 가장 멀리 있는 지점은 원의 지름에 해당하는 두 정점중에 하나 일 것이다.
		// 임의의 정점에서 end_point를 구할 수 있지만, 루트노드인 1에서 출발하기로 한다.(다른거 입력해도 됌)
		dfs(1, 0); // 가장 멀리 있는 정점(end_point) 구하기

		ans = 0;
		Arrays.fill(visited, false);
		dfs(end_point, 0);
		System.out.println(ans);

		br.close();
	}

	static void dfs(int point, int length) {
		if (visited[point])
			return;
		visited[point] = true;
		if (ans < length) {
			ans = length;
			end_point = point;
		}
		for (int i = 0; i < list.get(point).size(); i++) {
			dfs(list.get(point).get(i).c, length + list.get(point).get(i).w);
		}
	}

}

class _Node {
	int c; // child
	int w; // weight

	public _Node(int c, int w) {
		this.c = c;
		this.w = w;
	}
}
