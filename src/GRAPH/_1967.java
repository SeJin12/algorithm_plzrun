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
	static int ans = 0; // ���� ����
	static int end_point = 0; // ������ �ش��ϴ� ����
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
		// � �������� ��� �ص� ���� �ָ� �ִ� ������ ���� ������ �ش��ϴ� �� �����߿� �ϳ� �� ���̴�.
		// ������ �������� end_point�� ���� �� ������, ��Ʈ����� 1���� ����ϱ�� �Ѵ�.(�ٸ��� �Է��ص� ��)
		dfs(1, 0); // ���� �ָ� �ִ� ����(end_point) ���ϱ�

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
