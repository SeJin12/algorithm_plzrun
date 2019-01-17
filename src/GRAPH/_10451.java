package GRAPH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _10451 {
	// https://www.acmicpc.net/problem/10451
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-->0) {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			arr = new int[N+1];
			visit = new boolean[N+1];
			tmp = br.readLine().split(" ");
			for(int i=0;i<N;i++)
				arr[i+1] = Integer.parseInt(tmp[i]);
			
			int cnt = 0;
			for(int i=1;i<=N;i++) {
				if(!visit[i]) {
					dfs(i);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
		

		br.close();
	}
	
	static void dfs(int node) {
		if(visit[node])
			return;
		visit[node] = true;
		dfs(arr[node]);
	}
	
}
