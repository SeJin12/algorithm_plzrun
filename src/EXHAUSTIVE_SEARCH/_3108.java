package EXHAUSTIVE_SEARCH;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3108 {
	// ref : https://jaejin89.tistory.com/19
	//FIXME 분석해야함
	static int N;
	static Rec[] map;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int cnt;
	
	static boolean check(int cur,int next) {
		Rec c = map[cur]; // 현재 인덱스
		Rec n = map[next]; // 비교할 인덱스
		
		//TODO 겹치는게 없다면? 분석이 필요하다
		if((c.x1 < n.x1 && n.x2 < c.x2 && c.y1 < n.y1 && n.y2 < c.y2)
                || (c.x1 > n.x1 && n.x2 > c.x2 && c.y1 > n.y1 && n.y2 > c.y2) 
                || c.x2 < n.x1 || c.x1 > n.x2 || c.y2 < n.y1 || c.y1 > n.y2 )
			return false;
		// 직사각형이 겹치는 것이 하나라도 있다면 true를 반환 
		return true;	
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new Rec[N+1];
		visited = new boolean[N+1];
		
		map[0] = new Rec(0, 0, 0, 0);
		
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			map[i] = new Rec(x1, y1, x2, y2);
		}
		
		for(int i=0;i<=N;i++) {
			if(visited[i])
				continue;
			visited[i] = true; // 처음 방문시 방문 표시를 true
			q.add(i); // Rec[]의  index를 큐에 넣고
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int j=0;j<=N;j++) { // 
					// 다시 같은 Rec을 방문 || check()==false || 이미 방문한 곳이면 continue;
					if(cur==j|| !check(cur,j)||visited[j])
						continue;
					
					visited[j] = true;
					q.add(j);
				}
			} // while 끝
			cnt++; 
		}
		System.out.println(cnt-1);
		
		br.close();
	}


	static class Rec {
		int x1,y1,x2,y2;

		Rec(int x1,int y1,int x2,int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

}
