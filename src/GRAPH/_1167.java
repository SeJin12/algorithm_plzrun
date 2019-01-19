package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class _1167 {
	
	// http://me2.do/5d1VCCqQ ���� 

	static int v, u, r;
	static ArrayList<ArrayList<A>> graph;
	static int[] dist;
	static boolean[] visited;
	static int farv, ans;
	static int V;
	
	static void DFS(int v,int dist) {
		visited[v] = true;
		
		if(dist>ans) { // ����
			ans = dist;
			farv = v;
		}
		
		// ���� v�� ����� �ٸ� ������ �߿���
		// �湮���� ���� ������ �ִٸ� �ش� ������ �湮�Ѵ�.
		for(A a:graph.get(v)) {
			if(!visited[a.v])
				DFS(a.v,dist+a.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		dist = new int[V + 1];
		visited = new boolean[V+1];
		
		for (int i = 0; i <= V; i++)
			graph.add(new ArrayList<>());

		for (int i = 1; i <= V; i++) {
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			for (int j = 1; j < tmp.length - 1; j += 2) {
				graph.get(start).add(new A(Integer.parseInt(tmp[j]), Integer.parseInt(tmp[j + 1])));
				graph.get(Integer.parseInt(tmp[j])).add(new A(start, Integer.parseInt(tmp[j + 1])));
			}
		}
		
		DFS(1, 0); // ������ �������� ���� �� �Ÿ��� �ִ� ������ ã��
		ans = 0;
		Arrays.fill(visited, false);
		DFS(farv, 0); // �ٽ� �ش� �������� ���� �� �Ÿ��� �ִ� ������ ã�´�.
		

		System.out.println(ans);

		br.close();
	}

}

class A {
	int v;
	int w; // distance

	public A(int v, int w) {
		this.v = v;
		this.w = w;
	}
}