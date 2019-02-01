package EXHAUSTIVE_SEARCH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697 {
	// 풀이법 : 처음에 DFS로 접근했는데, StackOverflow가 계속 걸렸는데
	// BFS로 풀면 확실히 횟수를 줄일 수 있었다.
	// ref : https://zoonvivor.tistory.com/90
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈s
		int K = sc.nextInt(); // 동생s
		int[] Min = new int[100005];
		Arrays.fill(Min, -1);
		
		int nextN = N;
		int[] status = new int[3];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(nextN);
		Min[nextN] = 0;
		
		while(!q.isEmpty() && nextN != K) {
			nextN = q.poll();
			// 다음에 이동할 좌표들
			status[0] = nextN - 1;
			status[1] = nextN + 1;
			status[2] = nextN * 2;
			
			for(int i=0;i<3;i++) {
				if(0<=status[i]&&status[i]<=100000) { // 배열 범위 벗어났는지 확인
					if(Min[status[i]] == -1) { // 이전에 방문했는지
						q.add(status[i]);
						Min[status[i]] = Min[nextN] + 1;
					}
				}
			}
		}
		
		System.out.println(Min[K]);
		sc.close();
	}
}
