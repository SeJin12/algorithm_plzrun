package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _1707 {
	// 정점의 개수 V는 20000까지이다.
	// 배열로 간선을 저장한다면, 메모리 초과가 되기 때문에 ArrayList로 저장한다.
	static final int RED = 1, BLUE = -1;
	static int V, E;
	static int visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> arr;
		
		while (T-- > 0) {
			String[] tmp = br.readLine().split(" ");
			V = Integer.parseInt(tmp[0]);
			E = Integer.parseInt(tmp[1]);
			
			arr = new ArrayList<>();
			for(int i=0;i<=V;i++)
				arr.add(new ArrayList<>());
			
			visit = new int[V + 1];
			

			for (int i = 0; i < E; i++) {
				tmp = br.readLine().split(" ");
				int n1 = Integer.parseInt(tmp[0]);
				int n2 = Integer.parseInt(tmp[1]);
				arr.get(n1).add(n2);
				arr.get(n2).add(n1);
			}
			
			boolean check = true;
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i <= V; i++) {
				if (visit[i] == 0) {
					queue.offer(i);
					visit[i] = RED;
					while (!queue.isEmpty() && check) {
						int node = queue.poll();
						for (int adjNode:arr.get(node)) {
							if (visit[adjNode] == 0) {
								queue.offer(adjNode);
								visit[adjNode] = visit[node] * -1;
							} else if (visit[node] + visit[adjNode] != 0) {
								check = false;
								break;
							}
						}
					}
				}
			}
			System.out.println(check ? "YES" : "NO");
		}

		br.close();
	}

}
